package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "medicamentos")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_medicamento;

    private String nombre;

    private String tipo;

    private Integer stock;

    private LocalDateTime fecha_registro;
}
