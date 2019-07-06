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
public class Auto extends Vehiculo {
    protected char numAsientos;
    protected Boolean convertible;
    protected Boolean camaraRetro;

    public Auto(char numAsientos, Boolean convertible, Boolean camaraRetro, Double precio, String marca, String modelo, String fabricacion, String combustible, char numLlnatas) {
        super(precio, marca, modelo, fabricacion, combustible, numLlnatas);
        this.numAsientos = numAsientos;
        this.convertible = convertible;
        this.camaraRetro = camaraRetro;
    }
    
}
