package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Devolucion;

public interface DevolucionRepository extends JpaRepository<Devolucion, Integer> {
}
