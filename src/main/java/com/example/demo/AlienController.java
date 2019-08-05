package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
