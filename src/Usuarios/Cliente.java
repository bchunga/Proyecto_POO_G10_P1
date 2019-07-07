/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Solicitudes.Compra;
import Solicitudes.Cotizacion;
import Solicitudes.Mantenimiento;
import Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Kevin Blum
 */
public class Cliente extends Usuario {
    private String ocupacion;
    private String ingresosMensuales;
    private ArrayList<Cotizacion> solicitudesPendientes;
    private ArrayList<Cotizacion> solicitudesRespondidas;
    
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public Cliente(String ocupacion, String ingresosMensuales, ArrayList solicitudesPendientes, ArrayList solicitudesRespondidas, String dni, String nombre, String usuario, String pw) {
        super(dni, nombre, usuario, pw);
        this.ocupacion = ocupacion;
        this.ingresosMensuales = ingresosMensuales;
        this.solicitudesPendientes = solicitudesPendientes;
        this.solicitudesRespondidas = solicitudesRespondidas;
    }

    
    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getIngresosMensuales() {
        return ingresosMensuales;
    }

    public void setIngresosMensuales(String ingresosMensuales) {
        this.ingresosMensuales = ingresosMensuales;
    }

    public ArrayList getSolicitudesPendientes() {
        return solicitudesPendientes;
    }

    public void setSolicitudesPendientes(ArrayList solicitudesPendientes) {
        this.solicitudesPendientes = solicitudesPendientes;
    }

    public ArrayList getSolicitudesRespondidas() {
        return solicitudesRespondidas;
    }

    public void setSolicitudesRespondidas(ArrayList solicitudesRespondidas) {
        this.solicitudesRespondidas = solicitudesRespondidas;
    }

    public Cotizacion solicitarCotizacion( ArrayList<Vendedor> vendedores,Vehiculo vehiculo) {
        Random r = new Random();
        int vendedorAleatorio = r.nextInt(vendedores.size());

        Cotizacion c = new Cotizacion(vendedores.get(vendedorAleatorio), this, new Date(), vehiculo);
        solicitudesPendientes.add(c);
        System.out.println("Se generó una cotización exsitosamente con Codigo " + c.getIdSolicitud());
        return c;
    }

    public void consultarStock(ArrayList<Vehiculo> arrV) {
        System.out.println("idVehiculo" + "\tMarca" + "\tModelo" + "\tAño de Fabricación");

        for (Vehiculo v : arrV) {
            if (v.getEstado().equals("A")) {

                System.out.println(v.getIdVehiculo() + "\t" + v.getMarca() + "\t" + v.getModelo() + "\t" + v.getFabricacion());

            }
        }
    }

    public Cotizacion consultarCotizacion(int idCotizacion) {
        for (Cotizacion c : solicitudesRespondidas) {
            if (idCotizacion == c.getIdSolicitud()) {
                return c;
            }
        }
        return null;

    }

    public void rechazarCotizacion(ArrayList<Cotizacion> arrC, Cotizacion cotizacion) {
        arrC.remove(cotizacion);

    }

    public void soliciticarCompra(Supervisor s, Cotizacion co) {
        Compra c = new Compra(s, this, new Date(), co.getVehiculo());
        s.getSolicitudesCompra().add(c);
        c.getVehiculo().setEstado("S");//s Solicitado

    }

    public Mantenimiento solicitarMantenimiento(JefeTaller j, Vehiculo v) {
        Mantenimiento m = new Mantenimiento(this, new Date(), v);
        j.getSolicitudesMant().add(m);
        return m;
    }

    public Mantenimiento consultarMantenimiento(JefeTaller jf,int idMantenimiento) {
        for (Mantenimiento m : jf.getSolicitudesMant()) {
            if(m.getIdSolicitud()==idMantenimiento)
            return m;

        }

        return null;

    }

    @Override
    public String toString() {
        return "Cliente{" + "ocupacion=" + ocupacion + ", ingresosMensuales=" + ingresosMensuales + ", solicitudesPendientes=" + solicitudesPendientes + ", solicitudesRespondidas=" + solicitudesRespondidas + '}';
    }
    
    
    
}
