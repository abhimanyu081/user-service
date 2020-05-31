package dev.abhi.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.abhi.userservice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
