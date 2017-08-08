package com.ek.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ek.entity.Cast;
import com.ek.service.CastService;

@Controller
public class CastController {

	@Autowired
	CastService castservice;

	@RequestMapping("/")
	public String index(Model model) {
		System.out.println(castservice.getAllCasts());
		model.addAttribute("tvcast", castservice.getAllCasts());
		return "index";
	}

	@RequestMapping(value = "/addCast", method = RequestMethod.GET)
	public String addCast() {
		return "cast/addcast";
	}

	@RequestMapping(value = "/addCast", method = RequestMethod.POST)
	public String saveCast(Cast cast) {
		castservice.create(cast);
		return "redirect:/addCast";
	}

	@RequestMapping(value = "/castList", method = RequestMethod.GET)
	public String getCastList(Model model) {
		List<Cast> castList = new ArrayList<>();
		castList = castservice.getAllCasts();
		model.addAttribute("casts", castList);
		return "cast/castList";
	}

	@RequestMapping(value = "/castEdit/{id}", method = RequestMethod.GET)
	public String getCast(@PathVariable int id, Model model) {
		model.addAttribute("cast", castservice.getCastbyId(id));
		return "cast/castDetail";
	}

	@RequestMapping(value = "/castEdit/{id}", method = RequestMethod.POST)
	public String updateCast(Cast cast, @PathVariable int id) {
		cast.setId(id);
		castservice.update(cast);
		return "redirect:/castList";
	}
	
	@RequestMapping(value="/castEdit/delete", method=RequestMethod.POST)
	public String delete(int castId) {
		castservice.delete(castId);
		return "redirect:/castList";
	}
	
}