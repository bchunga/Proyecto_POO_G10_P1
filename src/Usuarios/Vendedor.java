/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Solicitudes.Cotizacion;
import Vehiculos.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Kevin Blum
 */
public class Vendedor extends Usuario {

    private ArrayList<Cotizacion> solicitudesCotizacion;
    
    public Vendedor(ArrayList solicitudesCotizacion, String dni, String nombre, String usuario, String pw) {
        super(dni, nombre, usuario, pw, RolUsuario.Vendedor);
        this.solicitudesCotizacion = solicitudesCotizacion;
        solicitudesCotizacion = new ArrayList();
    }
    
    public ArrayList<Cotizacion> getSolicitudesCotizacion() {
        return solicitudesCotizacion;
    }
    
    public void setSolicitudesCotizacion(ArrayList<Cotizacion> solicitudesCotizacion) {
        this.solicitudesCotizacion = solicitudesCotizacion;
    }
    
    public Cotizacion aprobarCotizacion(int idCotizacion) {
        for (Cotizacion c : this.getSolicitudesCotizacion()) {
            if (c.getIdSolicitud() == idCotizacion) {
                c.getCliente().getSolicitudesPendientes().remove(c);
                c.setPrecio(c.getVehiculo().getPrecio());
                c.setEstado("Aprobado");
                c.getCliente().getSolicitudesRespondidas().add(c);
                
                return c;
            }
            
        }
        return null;
    }
    
    public Cotizacion rechazarCotizacion(int idCotizacion, String motivo) {
        for (Cotizacion c : this.getSolicitudesCotizacion()) {
            if (c.getIdSolicitud() == idCotizacion) {
                c.getCliente().getSolicitudesPendientes().remove(c);
                c.setMotivo(motivo);
                c.setEstado("Rechazado");
                this.getSolicitudesCotizacion().remove(c);
                return c;
            }
            
        }
        return null;
    }
    
    public void consultarVehiculo(ArrayList<Vehiculo> arrV) {
        System.out.println("idVehiculo" + "\tMarca" + "\tModelo" + "\tAño de Fabricación");
        
        for (Vehiculo v : arrV) {
            
            System.out.println(v.getIdVehiculo() + "\t" + v.getMarca() + "\t" + v.getModelo() + "\t" + v.getFabricacion());
            
        }
    }
    
    
    
    @Override
    public String toString() {
        return super.getDni() + " Nombre: " + super.getNombre();
        
    }
}
