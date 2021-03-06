/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Solicitudes;
import Usuarios.*;
import Vehiculos.*;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Kevin Blum
 */
abstract class Solicitud {
    private int idSolicitud;
    public Cliente cliente;
    private Date fecha;
    private String estado;
    public Vehiculo vehiculo;
    public String motivo;
    
    public Solicitud( Cliente cliente, Date fecha, Vehiculo vehiculo) {
        this.idSolicitud= generarId();
        this.cliente = cliente;
        this.fecha = fecha;
        this.estado = "Pendiente";
        this.vehiculo = vehiculo;
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public int getIdSolicitud() {
        
        return idSolicitud;
    }
    
    public int generarId(){
        Random r = new Random();
        int id= r.nextInt(99999);
        
        return id;
    
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    @Override
    public String toString() {
        String sol= "Solicitud:" + "idSolicitud=" + idSolicitud +  ", fecha=" + fecha + ", estado=" + estado;
        if(estado.equals("Rechazado"))
            sol+= "motivo=" + motivo;
        return sol;
    }

    /**
     * @return the motivo
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * @param motivo the motivo to set
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


    
    
}
