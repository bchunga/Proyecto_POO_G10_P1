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
public class Vendedor extends Usuario{
    private ArrayList solicitudesCotizacion;

    public Vendedor( ArrayList solicitudesCotizacion, String dni, String nombre, String usuario) {
        super(dni, nombre, usuario);
        this.solicitudesCotizacion = solicitudesCotizacion;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "solicitudesCotizacion=" + solicitudesCotizacion + '}';
    }
    
    
}
