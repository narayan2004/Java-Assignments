package com.capgemini.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.model.Department;


public interface DeptRepo extends CrudRepository<Department, Integer>{

}
