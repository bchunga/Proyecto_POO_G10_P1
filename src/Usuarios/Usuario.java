/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author Kevin Blum
 */
abstract class Usuario {
    private String dni;
    private String nombre;
    private String usuario;
    private String contraseña;

    public Usuario(String dni, String nombre, String usuario) {
        this.dni = dni;
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", nombre=" + nombre + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    
    
 }
