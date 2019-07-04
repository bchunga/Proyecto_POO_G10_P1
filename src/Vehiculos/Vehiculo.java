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
public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected Date fabricacion;
    protected String combustible;
    protected int numLlnatas;
    protected Double precio;

    public Vehiculo(Double precio, String marca, String modelo, Date fabricacion, String combustible, int numLlnatas) {
        this.marca = marca;
        this.modelo = modelo;
        this.fabricacion = fabricacion;
        this.combustible = combustible;
        this.numLlnatas = numLlnatas;
        this.precio = precio;
    }
    
}
