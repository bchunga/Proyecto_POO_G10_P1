/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitudes;

import Usuarios.*;
import Vehiculos.*;
import java.util.Date;

/**
 *
 * @author Kevin Blum
 */
public class Cotizacion extends Solicitud {
       private Vendedor idVendedor;
    private double precio;

    public Cotizacion(Vendedor idVendedor, Cliente cliente, Date fecha, Vehiculo vehiculo) {
        super(cliente, fecha, vehiculo);
        this.idVendedor = idVendedor;
    }


   
    

    public Vendedor getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(Vendedor idVendedor) {
        this.idVendedor = idVendedor;
    }

   
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return super.toString()+ "Cotizacion{" + "idVendedor=" + idVendedor + ", precio=" + precio + '}';
    }

     

   
    
}
