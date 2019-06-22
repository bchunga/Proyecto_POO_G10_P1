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
public class Compra extends Solicitud {
    private Supervisor idSupervisor;

    public Compra(Cliente cliente, Date fecha, Vehiculo vehiculo, Supervisor idSupervisor) {
        super(cliente, fecha, vehiculo);
        this.idSupervisor= idSupervisor;
    }
    
}
