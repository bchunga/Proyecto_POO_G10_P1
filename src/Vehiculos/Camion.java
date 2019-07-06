/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import java.util.Date;

/**
 *
 * @author kexbl
 */
public class Camion extends Vehiculo {
    protected double capCarga;
    protected char numEjes;

    public Camion(double capCarga, char numEjes, Double precio, String marca, String modelo, String fabricacion, String combustible, char numLlnatas) {
        super(precio, marca, modelo, fabricacion, combustible, numLlnatas);
        this.capCarga = capCarga;
        this.numEjes = numEjes;
    }
    
}
