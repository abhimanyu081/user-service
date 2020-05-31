package dev.abhi.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.abhi.userservice.model.State;
import dev.abhi.userservice.repository.StateRepository;

@Service
public class StateServiceImpl implements StateService{
	
	@Autowired
	private StateRepository stateRepo;

	@Override
	public List<State> getAll() {
		return stateRepo.findAll();
	}

}
