package com.example.konectaAPI.servicios.utilidades;

public enum Mensaje {

    REGISTROS("Error al registrar"),
    REGISTRO_EXITOSO("Registro exitoso");
    private String Mensaje;
    Mensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }
}
