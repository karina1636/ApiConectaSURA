package com.example.konectaAPI.entidades;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "signoVital")
public class SignoVital {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "unidadMedida", length = 15, nullable = false)
    private String unidadMedida;

    @Column(name = "maximoNormal", nullable = false)
    private Double maximoNormal;


    @Column(name = "minimoNormal", nullable = false)
    private Double minimoNormal;

    @Column(name = "fechaMedida", nullable = false)
    private LocalDate fechaMedida;

    public SignoVital() {
    }

    public SignoVital(Integer id, String nombre, String unidadMedida, Double maximoNormal, Double minimoNormal, LocalDate fechaMedida) {
        this.id = id;
        this.nombre = nombre;
        this.unidadMedida = unidadMedida;
        this.maximoNormal = maximoNormal;
        this.minimoNormal = minimoNormal;
        this.fechaMedida = fechaMedida;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Double getMaximoNormal() {
        return maximoNormal;
    }

    public void setMaximoNormal(Double maximoNormal) {
        this.maximoNormal = maximoNormal;
    }

    public Double getMinimoNormal() {
        return minimoNormal;
    }

    public void setMinimoNormal(Double minimoNormal) {
        this.minimoNormal = minimoNormal;
    }

    public LocalDate getFechaMedida() {
        return fechaMedida;
    }

    public void setFechaMedida(LocalDate fechaMedida) {
        this.fechaMedida = fechaMedida;
    }
}