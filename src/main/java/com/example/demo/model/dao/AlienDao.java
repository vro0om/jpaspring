package com.example.demo.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Alien;

public interface AlienDao extends JpaRepository<Alien, Integer>{
List<Alien> findByTech(String tech);

List<Alien> findByAidGreaterThan(int i);

@Query("from Alien where tech=?1 order by name")
List<Alien> findByCustom(String tech);

}
