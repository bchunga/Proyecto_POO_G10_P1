/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitudes;

import java.util.Date;

/**
 *
 * @author Kevin Blum
 */
public class Solicitud {
    private int id;
    private Date fecha;
    private String estado;
    private int idVehiculo;

    public Solicitud(int id, Date fecha, String estado, int idVehiculo) {
        this.id = id;
        this.fecha = fecha;
        this.estado = estado;
        this.idVehiculo = idVehiculo;
    }
    
    
    
}
