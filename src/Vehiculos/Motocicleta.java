/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import java.util.Date;

/**
 *
 * @author Kevin Blum
 */
public class Motocicleta extends Vehiculo {
    protected String categoria;

    public Motocicleta(String categoria, Double precio, String marca, String modelo, String fabricacion, String combustible, char numLlnatas) {
        super(precio, marca, modelo, fabricacion, combustible, numLlnatas);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Motocicleta{" + "categoria=" + categoria + '}';
    }
    

}
