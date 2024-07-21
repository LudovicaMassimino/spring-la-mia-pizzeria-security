package it.ludo.pizzeria.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.ludo.pizzeria.model.UserMod;

public interface UserRepo extends JpaRepository<UserMod, Integer> {

    Optional<UserMod> findByUsername(String username);
}
