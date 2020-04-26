package com.capgemini.dao;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.model.Emp;


public interface EmpRepo extends CrudRepository<Emp, Integer> {
	

}
