package com.abc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.abc.dao.IEmployeeDao;
import com.abc.dao.IGemployeeDao;
import com.abc.dao.ILoginDetailsDao;
import com.abc.model.Employee;
import com.abc.model.Gemployee;
import com.abc.model.LoginDetails;
import com.mongodb.AggregationOutput;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class EmployeeServiceimpl {

	@Autowired
	IEmployeeDao iemployeeDao;
	

	@Autowired
	IGemployeeDao igemployeeDao ;
	

	@Autowired
	ILoginDetailsDao iLoginDetailsDao ;
	
	public List<Employee> findAll() {
		return iemployeeDao.findAll();
	}
	public List<Gemployee> findAllGemp() {

		return igemployeeDao.findAll();
	}
	public List<LoginDetails>  findLoginDetailByName(String name) {
		return  iLoginDetailsDao.findLoginDetailByName(name);
	}
	
	public Employee Save(Employee emp) {
		emp.exportBaseProperty();
		return iemployeeDao.save(emp);
	}
	public Gemployee Save(Gemployee gemp) {
		gemp.exportBaseProperty();
		return igemployeeDao.save(gemp);
	}
	public LoginDetails Save(LoginDetails loginDetails) {
		loginDetails.exportBaseProperty();
		return iLoginDetailsDao.save(loginDetails);
	}
	public Employee findOneByUuidAndVersion(String uuid, String version) {
		return iemployeeDao.findOneByUuidAndVersion(uuid, version);
	}
	public Gemployee findGempByName(String name) {
		return igemployeeDao.findGempByName(name);
	}
	/*public LoginDetails findLoginDetailByName(String name) {
		return iLoginDetailsDao.findLoginDetailByName(name);
	}*/
	
	public String getlinechartdata() {
		String data=null;
		 final MongoClient mongoClient = new MongoClient();
		    final DB db = mongoClient.getDB("emp1234");
		    final DBCollection collection = db.getCollection("Employee");

		    final DBObject groupIdFields = new BasicDBObject("_id", "$joindate");

		    groupIdFields.put("count", new BasicDBObject("$sum", 1));
		    final DBObject group = new BasicDBObject("$group", groupIdFields);

		    final DBObject projectFields = new BasicDBObject("_id", 0);
		    projectFields.put("name", "$_id");
		    projectFields.put("count", 1);
		    final DBObject project = new BasicDBObject("$project", projectFields);

		    final AggregationOutput aggregate = collection.aggregate(group, project);
		
		    return  aggregate.toString();
	}
	
	
}
