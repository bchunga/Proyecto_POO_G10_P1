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
public class Tractor extends Vehiculo {
    protected Boolean agricola;
    protected String transmision;

    public Tractor(Boolean agricola, String transmision, Double precio, String marca, String modelo, String fabricacion, String combustible, char numLlnatas) {
        super(precio, marca, modelo, fabricacion, combustible, numLlnatas);
        this.agricola = agricola;
        this.transmision = transmision;
    }
    
}
