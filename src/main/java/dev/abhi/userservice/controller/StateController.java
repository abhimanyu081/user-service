package dev.abhi.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.abhi.userservice.model.State;
import dev.abhi.userservice.service.StateService;

@RestController
@RequestMapping("/states")
public class StateController {

	@Autowired
	private StateService stateService;

	@GetMapping
	public List<State> getAllStates() {
		return stateService.getAll();
	}

}
