package com.abc.dao;

import org.springframework.data.repository.CrudRepository;

import com.abc.model.Employee;

public interface IMysqlDao extends CrudRepository<Employee, String>{

}
