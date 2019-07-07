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
    public static ArrayList<Vehiculo> vMant;
    private ArrayList<Vehiculo> vPorEntregar;
    public ArrayList<ArrayList> repuestosUsados;

    public JefeTaller(ArrayList certificadosTecnicos, ArrayList solicitudesMant, ArrayList vMant, ArrayList vPorEntregar, String dni, String nombre, String usuario, String pw) {
        super(dni, nombre, usuario, pw);
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
    
    public void agregarRepuesto(){
        ArrayList aux = new ArrayList();
        int i = 1;
        for (Vehiculo veh: JefeTaller.vMant){
            System.out.println(i + ", " + veh.datosMant());
            i = i + 1;
        }
        boolean ctrl = false;
        int opVeh = 0;
        while (!ctrl){
            System.out.print("Vehiculo: ");
            try{
                opVeh = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Opcion no valida.");
            }
        }
        aux.add(vMant.get(opVeh));
        System.out.print("Codigo de repuesto: ");
        String codigo = scanner.nextLine();
        aux.add(codigo);
        ctrl = false;
        double precio = 0;
        while (!ctrl){
           System.out.print("Precio");
           try {
             precio = scanner.nextDouble(); 
             ctrl = true;
           } catch (Exception e) {
               System.out.println("Dato no valido");
               ctrl = false;
           }
        }
        aux.add(precio);
        System.out.print("Descripcion: ");
        String desc = scanner.nextLine();
        aux.add(desc);
        
        repuestosUsados.add(aux);
    }
    
}
