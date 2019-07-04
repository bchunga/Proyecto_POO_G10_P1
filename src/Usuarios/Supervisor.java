/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import Solicitudes.Compra;
import Usuarios.*;
/**
 *
 * @author Kevin Blum
 */
public class Supervisor extends Usuario {
    private ArrayList solicitudesCompra;
    private ArrayList cerfificadosAcademicos;

    public Supervisor(ArrayList solicitudesCompra, ArrayList cerfificadosAcademicos, String dni, String nombre, String usuario) {
        super(dni, nombre, usuario);
        this.solicitudesCompra = solicitudesCompra;
        this.cerfificadosAcademicos = cerfificadosAcademicos;
    }

    @Override
    public String toString() {
        return "Supervisor{" + ", solicitudesCompra=" + solicitudesCompra + ", cerfificadosAcademicos=" + cerfificadosAcademicos + '}';
    }
    
    public void aprobarCompra(Compra compra){
        compra.setEstado("Aprobada");
        Cliente cliente=compra.getCliente();
        
        ArrayList pendCliente=cliente.getSolicitudesPendientes();
        pendCliente.remove(compra);
        cliente.setSolicitudesPendientes(pendCliente);
        
        ArrayList solCliente=cliente.getSolicitudesRespondidas();
        solCliente.add(compra);
        cliente.setSolicitudesRespondidas(solCliente);
    }
    
    public void rechazarCompra(Compra compra, String motivo){
        compra.setEstado("Rechazada: "+motivo );
        Cliente cliente=compra.getCliente();
        
        ArrayList pendCliente=cliente.getSolicitudesPendientes();
        pendCliente.remove(compra);
        cliente.setSolicitudesPendientes(pendCliente);
        
        ArrayList solCliente=cliente.getSolicitudesRespondidas();
        solCliente.add(compra);
        cliente.setSolicitudesRespondidas(solCliente);
    }
    
}
