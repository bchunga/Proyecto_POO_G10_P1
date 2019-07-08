/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Vehiculos.Vehiculo;
import Solicitudes.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Kevin Blum
 */
public class Usuario {
    private String dni;
    private String nombre;
    private String usuario;
    private String contraseña;
    private RolUsuario rol;
    Scanner scanner = new Scanner(System.in);
    
  
    
    //Constructor
    public Usuario(String dni, String nombre, String usuario, String pw, RolUsuario rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = pw;
        this.rol=rol;
    }

    public Usuario() {
    }
    
      public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
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
