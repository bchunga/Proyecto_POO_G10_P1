/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitudes;

import Usuarios.Vendedor;
import java.util.Date;

/**
 *
 * @author Kevin Blum
 */
public class Cotizacion extends Solicitud {
    private Vendedor idVendedor;

    public Cotizacion(int id, Date fecha, String estado, int idVehiculo, Vendedor idVendedor) {
        super(id, fecha, estado, idVehiculo);
        this.idVendedor= idVendedor;
    }

   
    
}
