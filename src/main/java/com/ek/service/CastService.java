package com.ek.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ek.dao.ICastDao;
import com.ek.entity.Cast;

public class CastService {
	
	@Autowired
	private  ICastDao castDao;
	
	public CastService(){
		
	}
	
	public CastService(ICastDao castDao){
		super();
		this.castDao=castDao;
	}
	
	public void create(Cast cast){
		castDao.create(cast);
		
	}
	
	public List<Cast> getAllCasts(){
		return castDao.findAll();
		
	}
	
	public void update(Cast cast){
		castDao.update(cast);
	}
	
	public Cast findCast(int id){
		return castDao.findCast(id);
	}
	
	public void delete(Cast cast){
		castDao.delete(cast);
		
	}
	

}
