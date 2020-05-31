package dev.abhi.userservice.service;

import java.util.List;

import dev.abhi.userservice.model.City;

public interface CityService {

	public List<City> getAll();

	public List<City> search(String text);
	
}
