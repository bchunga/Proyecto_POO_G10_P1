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
public class Mantenimiento extends Solicitud{
 private float kilometrajeVeh;
    private String estadoM;
    private float costoMant;

    public Mantenimiento(float kilometrajeVeh, float costoMant, Cliente cliente, Date fecha, String estado, Vehiculo vehiculo) {
        super(cliente, fecha, vehiculo);
        this.kilometrajeVeh = kilometrajeVeh;
        this.costoMant = costoMant;
    }

    public Mantenimiento(Cliente cliente, Date fecha, Vehiculo vehiculo) {
        super(cliente, fecha, vehiculo);
    }
    
    
    public String toString(){
        return cliente.getNombre() + ", " + vehiculo.datosMant() + ", " + motivo;
    }
    
}
