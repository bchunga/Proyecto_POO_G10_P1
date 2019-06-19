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
    private int id;
    private ArrayList solicitudesCotizacion;

    public Vendedor(int id, ArrayList solicitudesCotizacion, String dni, String nombre, String usuario) {
        super(dni, nombre, usuario);
        this.id = id;
        this.solicitudesCotizacion = solicitudesCotizacion;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "id=" + id + ", solicitudesCotizacion=" + solicitudesCotizacion + '}';
    }
    
    
}
