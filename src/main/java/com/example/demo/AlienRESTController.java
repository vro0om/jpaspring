package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alien;
import com.example.demo.model.dao.AlienDao;
@RestController
public class AlienRESTController {

	@Autowired
	AlienDao al;
	
	@PostMapping(path="/alien")
	public Alien getAliens(@RequestBody Alien alien)
	{
		al.save(alien);
		
		return alien;
	}
	@GetMapping(path="/aliens")
	public List<Alien> getAliens()
	{
		return al.findAll();
	}
	
	@GetMapping("/aliens/{pid}")
	public Optional<Alien> getAlienById(@PathVariable("pid")int id)
	{
		
		return al.findById(id);
	}
}
