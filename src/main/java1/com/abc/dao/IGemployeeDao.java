package com.abc.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.abc.model.Employee;
import com.abc.model.Gemployee;


public interface IGemployeeDao extends MongoRepository<Gemployee, String>{
	
	
	@Query(value="{ 'version' : ?0 }")
	public Gemployee findAll(String version);	
	@Query(value="{ 'uuid' : ?0 , 'version' : ?1 }")
	public Gemployee findOneByUuidAndVersion(String uuid, String version);
	
		
}
