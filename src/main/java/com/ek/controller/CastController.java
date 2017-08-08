package com.ek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ek.entity.Cast;
import com.ek.service.CastService;

@Controller
public class CastController {
	
	@Autowired
	CastService carservice;
	
	@RequestMapping(value = "/addCast",method=RequestMethod.GET)
	public String addCast(){
		return "cast/addcast";
	}
	
	@RequestMapping(value = "/addCast",method=RequestMethod.POST)
	public String saveCast(Cast cast){
		carservice.create(cast);
		return "redirect:/addCast";
	}
	
	

}
