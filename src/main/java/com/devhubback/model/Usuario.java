package com.devhubback.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull(message = "El nombre de usuario no puede ser nulo")
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 4,max = 20,message = "El nombre de usuario debe de ser de mas de 4 caracteres")
    @Column(name = "nickname",nullable = false,length = 30)
    private String nombreUsuario;

    @NotNull
    @NotBlank(message = "El correo electronico es obligatorio")
    @Size(min = 10,message = "El email debe ser de almenos 10 caracteres")
    @Email(message = "El email tiene un formato no valido")
    @Column(nullable = false,length = 70)
    private String email;

    @Column(nullable = false,length = 15)
    private String contraseña;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
