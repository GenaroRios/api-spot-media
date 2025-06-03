package com.gnr.spot_media.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ContactRequest {

    @NotBlank
    private String nombre;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String celular;

    @NotBlank
    private String servicio;

    @NotBlank
    private String mensaje;

    public @NotBlank String getCelular() {
        return celular;
    }

    public void setCelular(@NotBlank String celular) {
        this.celular = celular;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank String getMensaje() {
        return mensaje;
    }

    public void setMensaje(@NotBlank String mensaje) {
        this.mensaje = mensaje;
    }

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank String getServicio() {
        return servicio;
    }

    public void setServicio(@NotBlank String servicio) {
        this.servicio = servicio;
    }
}
