package com.example.heroesbackend.respository;

import com.example.heroesbackend.model.EmpleadosTEST;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmpleadoRepository extends JpaRepository<EmpleadosTEST, Long> {

    Optional<EmpleadosTEST> findByEmail(String email);
}
