package com.abc.service;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.model.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


@Service
public class RegisterService {

	@Autowired
	private EmployeeServiceimpl employeeServiceImpl;

	public String getlinechart(String type) throws JsonProcessingException {
		String result = null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		if (type != null && !type.isEmpty()) {

			type = type.toLowerCase();
			switch (type) {
			case "employee":
				result = ow.writeValueAsString(employeeServiceImpl.getlinechartdata());
				break;
			}
		}
		return result;
	}
	
	public String getDataList(String type) throws JsonProcessingException {
		String result = null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		if (type != null && !type.isEmpty()) {

			type = type.toLowerCase();
			switch (type) {
			case "employee":
				result = ow.writeValueAsString(employeeServiceImpl.findAll());
				break;
			}
		}

		return result;
	}
	
	public String save(Map<String, Object> operator, String type) {
		//Session session=sessionServiceImpl.findOneById(sessionId);
		//String uuid=session.getUserInfo().getRef().getUuid();

		String Id = "";
		if (type != null && !type.isEmpty()) {
			ObjectMapper mapper = new ObjectMapper();
			type = type.toLowerCase();
			switch (type) {
		
			case "employee":
				Employee employee = mapper.convertValue(operator, Employee.class);
				Id = employeeServiceImpl.Save(employee).getId();
				break;
			case "mongo_db":
				 employee = mapper.convertValue(operator, Employee.class);
				Id = employeeServiceImpl.Save(employee).getId();
				break;
			case "mysql":
				 employee = mapper.convertValue(operator, Employee.class);
				Id = employeeServiceImpl.Save(employee).getId();
				break;
			case "hive":
				 employee = mapper.convertValue(operator, Employee.class);
				Id = employeeServiceImpl.Save(employee).getId();
				break;
			case "impala":
				 employee = mapper.convertValue(operator, Employee.class);
				Id = employeeServiceImpl.Save(employee).getId();
				break;
		
		}

		}
		return Id;

}
	public String getOneByUuidAndVersion(String uuid, String version, String type) throws JsonProcessingException {
		String result = null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		if (type != null && !type.isEmpty()) {
			type = type.toLowerCase();
			switch (type) {
			
			case "employee":
				result = ow.writeValueAsString(employeeServiceImpl.findOneByUuidAndVersion(uuid, version));
				break;
	
			}
		}
		return result;
	}
}
