package dev.abhi.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhi.userservice.model.City;

public interface CityRepository extends JpaRepository<City, Long>{

}
