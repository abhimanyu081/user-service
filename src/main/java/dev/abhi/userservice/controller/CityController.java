package dev.abhi.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.abhi.userservice.model.City;
import dev.abhi.userservice.service.CityService;

@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityService cityService;

	@GetMapping
	public List<City> getAllCities() {
		return cityService.getAll();
	}

	 @RequestMapping(value="/search", method=RequestMethod.GET)
	public List<City> search(@RequestParam(name = "q") String searchText) {
		return cityService.search(searchText);
	}

}
