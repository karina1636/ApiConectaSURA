package com.example.konectaAPI.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Examen")
public class Examen {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombres", length = 50, nullable = false)
    private String nombreExamen;

    @Column(name = "fechaExamen",  nullable = false)

    private LocalDate fechaExamen;
    @Column(name = "diagnostico", length = 50, nullable = false)

    private String diagnostico;
    @Column(name = "imagenExamen", length = 50, nullable = false)

    private String imagenExamen;

    public Examen() {
    }

    public Examen(Integer id, String nombreExamen, LocalDate fechaExamen, String diagnostico, String imagenExamen) {
        this.id = id;
        this.nombreExamen = nombreExamen;
        this.fechaExamen = fechaExamen;
        this.diagnostico = diagnostico;
        this.imagenExamen = imagenExamen;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreExamen() {
        return nombreExamen;
    }

    public void setNombreExamen(String nombreExamen) {
        this.nombreExamen = nombreExamen;
    }

    public LocalDate getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(LocalDate fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getImagenExamen() {
        return imagenExamen;
    }

    public void setImagenExamen(String imagenExamen) {
        this.imagenExamen = imagenExamen;
    }
}
