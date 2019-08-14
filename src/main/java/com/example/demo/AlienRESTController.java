package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@PutMapping(path="/alien")
	public Alien updateAliens(@RequestBody Alien alien)
	{
		al.save(alien);
		
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable("aid") int id)
	{
		Alien a = al.getOne(id);
		
		al.delete(a);
		return "deleted";
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
