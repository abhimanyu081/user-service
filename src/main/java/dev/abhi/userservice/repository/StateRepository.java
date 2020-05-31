package dev.abhi.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhi.userservice.model.State;

public interface StateRepository extends JpaRepository<State, Long>{

}
