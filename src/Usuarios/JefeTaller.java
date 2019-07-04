/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import java.util.Scanner;
import Solicitudes.Mantenimiento;
import Vehiculos.*;
/**
 *
 * @author Kevin Blum
 */
public class JefeTaller extends Usuario{
    
    Scanner scanner = new Scanner(System.in);
    
    private ArrayList certificadosTecnicos;
    private ArrayList solicitudesMant;
    private ArrayList vMant;
    private ArrayList vPorEntregar;

    public JefeTaller(ArrayList certificadosTecnicos, ArrayList solicitudesMant, ArrayList vMant, ArrayList vPorEntregar, String dni, String nombre, String usuario) {
        super(dni, nombre, usuario);
        this.certificadosTecnicos = certificadosTecnicos;
        this.solicitudesMant = solicitudesMant;
        this.vMant = vMant;
        this.vPorEntregar = vPorEntregar;
    }
    
    public void aceptarMant(Mantenimiento mant){
        mant.setEstado("Adminito");
        Cliente cliente=mant.getCliente();
        
        ArrayList pendCliente=cliente.getSolicitudesPendientes();
        pendCliente.remove(mant);
        cliente.setSolicitudesPendientes(pendCliente);
        
        ArrayList solCliente=cliente.getSolicitudesRespondidas();
        solCliente.add(mant);
        cliente.setSolicitudesRespondidas(solCliente);
    }
    
    public void rechazarMant(Mantenimiento mant, String motivo){
        mant.setEstado("Rechazado: "+motivo );
        Cliente cliente=mant.getCliente();
        
        ArrayList pendCliente=cliente.getSolicitudesPendientes();
        pendCliente.remove(mant);
        cliente.setSolicitudesPendientes(pendCliente);
        
        ArrayList solCliente=cliente.getSolicitudesRespondidas();
        solCliente.add(mant);
        cliente.setSolicitudesRespondidas(solCliente);
    }
    
    public void estadoVehiculo(Mantenimiento mant){
        Vehiculo vehiculo = mant.getVehiculo();
        Cliente cliente = mant.getCliente();
        Boolean ctrl=false;
        while (ctrl){
            try{
                System.out.println("Seleccionar estado a actualizar de "+vehiculo+": ");
                System.out.println("1.-En reparacion");
                System.out.println("2.-En etapa de prueba");
                System.out.println("3.-Por etregar");
                int op=scanner.nextInt();
                switch (op){
                    case 1:
                        mant.setEstado("En reparacion");
                        ctrl=true;
                        break;

                    case 2:
                        mant.setEstado("En etapa de Prueba");
                        ctrl=true;
                        break;

                    case 3:
                        mant.setEstado("Por entregar");
                        this.vMant.remove(vehiculo);
                        this.vPorEntregar.remove(vehiculo);
                        ctrl=true;
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        ctrl=false;
                        break;
                } 
            }
            catch(Exception e){
                System.out.println("Opcion no valida");
                ctrl=false;
            }
        }
    } 
    
    public void entregarVehiculo(Mantenimiento mant, Vehiculo vehiculo){
        mant.setEstado("Entregado");
        this.solicitudesMant.remove(mant);
        this.vPorEntregar.remove(vehiculo);
    }
}
