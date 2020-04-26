package com.capgemini.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.DeptRepo;


@Service
public class EmpServiceImpl implements EmpService{
	
	@Autowired DeptRepo deprepo;
	
	@Override
	public HashMap<Integer, String> getDeptList() {
		// TODO Auto-generated method stub
		HashMap<Integer, String> deptList = new HashMap<Integer, String>();
		deprepo.findAll().forEach(dep->deptList.put(dep.getDepartmentId(),dep.getDeptName()));
		return deptList;
		
	}
	

}
