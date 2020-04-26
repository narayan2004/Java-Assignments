package com.capgemini.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.dao.EmpRepo;
import com.capgemini.model.Emp;
import com.capgemini.service.EmpService;


@Controller
public class EmpController {
	
	@Autowired EmpService es;
	@Autowired EmpRepo repo;
	
	
	@RequestMapping("/")
	public String home()
	{
		return "home";
	}
	
	@RequestMapping("/empform")
	public String showform(Model m)
	{
		m.addAttribute("deptList",es.getDeptList());
		m.addAttribute("command", new Emp());
		return "empForm";
	}
	
    @RequestMapping(value="/addEmp",method = RequestMethod.POST)  
    public String save(@ModelAttribute("emp") Emp emp){
    	repo.save(emp);
    	return "redirect:/viewemp";//will redirect to viewemp request mapping  
    }
    
    @RequestMapping("/viewemp")  
    public ModelAndView viewemp(){
    	ModelAndView mv=new ModelAndView("viewemp");
        mv.addObject("list", repo.findAll());
        return mv;  
    }
    
    @RequestMapping(value="/editemp/{id}")  
    public String edit(@PathVariable int id, Model m){
        Emp emp=repo.findById(id).orElse(new Emp());
        m.addAttribute("deptList",es.getDeptList());
        m.addAttribute("command",emp);
        return "empeditform";  
    } 
    
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("emp") Emp emp){
    	repo.save(emp);
    	return "redirect:/viewemp";//will redirect to viewemp request mapping 
    }
    
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteemp/{id}")  
    public String delete(@PathVariable int id){
        repo.deleteById(id);
        return "redirect:/viewemp";
    } 
}
