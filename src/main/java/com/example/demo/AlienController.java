package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Alien;
import com.example.demo.model.dao.AlienDao;

@Controller
public class AlienController {
	@Autowired
	AlienDao al;

	@RequestMapping("/")
	public String home() {
		System.out.println("killer");
		return "home.jsp";

	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		al.save(alien);
		return "home.jsp";

	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int aid) {

		ModelAndView mv = new ModelAndView("shwoAlien.jsp");
		Alien alien = al.findById(aid).orElse(new Alien());
		mv.addObject(alien);
		return mv;

	}

	@RequestMapping("/deleteAlien")
	public ModelAndView deleteAlien(@RequestParam int aid) {

		ModelAndView mv = new ModelAndView("resultAlien.jsp");
		al.deleteById(aid);
		List<Alien> aliens = new ArrayList<>();
		al.findAll().forEach(aliens::add);
		mv.addObject(aliens);
		return mv;

	}
}
