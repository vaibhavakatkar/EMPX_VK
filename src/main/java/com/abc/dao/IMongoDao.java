package com.abc.dao;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.abc.model.Employee;


public interface IMongoDao extends MongoRepository<Employee, String>{
	
	
	@Query(value="{ 'version' : ?0 }")
	public Employee findAll(String version);	
	@Query(value="{ 'uuid' : ?0 , 'version' : ?1 }")
	public Employee findOneByUuidAndVersion(String uuid, String version);
	
		
}
