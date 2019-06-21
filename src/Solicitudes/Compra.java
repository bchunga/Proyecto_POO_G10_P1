/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitudes;

import Usuarios.Supervisor;
import java.util.Date;

/**
 *
 * @author Kevin Blum
 */
public class Compra extends Solicitud {
    private Supervisor idSupervisor;

    public Compra(int id, Date fecha, String estado, int idVehiculo, Supervisor idSupervisor) {
        super(id, fecha, estado, idVehiculo);
        this.idSupervisor= idSupervisor;
    }
    
}
