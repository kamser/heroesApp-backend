package com.example.heroesbackend.respository;


import com.example.heroesbackend.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Long> {
}
