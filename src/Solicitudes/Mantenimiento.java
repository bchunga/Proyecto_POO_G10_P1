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
public class Mantenimiento extends Solicitud{
    private float kilometrajeVeh;
    private String estadoM;
    private float costoMant;

    public Mantenimiento(float kilometrajeVeh, String estadoM, float costoMant, int id, Date fecha, String estado, int idVehiculo) {
        super(id, fecha, estado, idVehiculo);
        this.kilometrajeVeh = kilometrajeVeh;
        this.estadoM = estadoM;
        this.costoMant = costoMant;
    }


}
