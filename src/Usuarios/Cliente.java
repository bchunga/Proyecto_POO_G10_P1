/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;

/**
 *
 * @author Kevin Blum
 */
public class Cliente extends Usuario {
    private String ocupacion;
    private String ingresosMensuales;
    private ArrayList solicitudesPendientes;
    private ArrayList solicitudesRespondidas;

    public Cliente(String ocupacion, String ingresosMensuales, ArrayList solicitudesPendientes, ArrayList solicitudesRespondidas, String dni, String nombre, String usuario) {
        super(dni, nombre, usuario);
        this.ocupacion = ocupacion;
        this.ingresosMensuales = ingresosMensuales;
        this.solicitudesPendientes = solicitudesPendientes;
        this.solicitudesRespondidas = solicitudesRespondidas;
    }

    
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(String ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public ArrayList getSolicitudesPendientes() {
        return solicitudesPendientes;
    }

    public void setSolicitudesPendientes(ArrayList solicitudesPendientes) {
        this.solicitudesPendientes = solicitudesPendientes;
    }

    public ArrayList getSolicitudesRespondidas() {
        return solicitudesRespondidas;
    }

    public void setSolicitudesRespondidas(ArrayList solicitudesRespondidas) {
        this.solicitudesRespondidas = solicitudesRespondidas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "ocupacion=" + ocupacion + ", ingresosMensuales=" + ingresosMensuales + ", solicitudesPendientes=" + solicitudesPendientes + ", solicitudesRespondidas=" + solicitudesRespondidas + '}';
    }
    
    
    
}
