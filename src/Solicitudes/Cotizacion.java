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

    public Cotizacion(Cliente cliente, Date fecha, Vehiculo vehiculo, Vendedor idVendedor) {
        super(cliente, fecha, vehiculo);
        this.idVendedor= idVendedor;
    }

   
    
}
