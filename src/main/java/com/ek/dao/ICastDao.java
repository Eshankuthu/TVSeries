package com.ek.dao;

import java.util.List;

import com.ek.entity.Cast;

public interface ICastDao {
	
	public void create(Cast cast);
	
	public void update(Cast cast);
	
	List<Cast> findAll();
	
	public Cast findCast(int id);
	
	public void delete(int castId);
	
	public Cast getCastbyId(int castId);
	
	

}
