package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Alien;
import com.example.demo.model.dao.AlienDao;
@Controller
public class AlienRESTController {

	@Autowired
	AlienDao al;
	
	@RequestMapping("/aliens")
	@ResponseBody
	public List<Alien> getAliens()
	{
		return al.findAll();
	}
	
	@RequestMapping("/aliens/{pid}")
	@ResponseBody
	public Optional<Alien> getAlienById(@PathVariable("pid")int id)
	{
		
		return al.findById(id);
	}
}
