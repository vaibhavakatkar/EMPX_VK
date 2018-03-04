package com.abc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.abc.model.LoginDetails;

public interface ILoginDetailsDao extends MongoRepository<LoginDetails, String>{

	
	

	@Query(value="{ 'uuid' : ?0 }")
	public LoginDetails findAll(String version);	


	@Query(value="{ 'uuid' : ?0 , 'version' : ?1 }")
	public LoginDetails findOneByUuidAndVersion(String uuid, String version);

	@Query(value="{ 'userName' : ?0 }")
	public List<LoginDetails> findLoginDetailByName(String name);
	
		
}
