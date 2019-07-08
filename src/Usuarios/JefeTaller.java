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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 *
 * @author Kevin Blum
 */
public class JefeTaller extends Usuario{
    
    Scanner scanner = new Scanner(System.in);
    
    private ArrayList certificadosTecnicos;
    private ArrayList solicitudesMant;
    public static ArrayList<Vehiculo> vMant;
    public static ArrayList<Vehiculo> vPorEntregar;
    public static ArrayList<ArrayList> repuestosUsados;

    public JefeTaller(ArrayList certificadosTecnicos, ArrayList solicitudesMant, ArrayList vMant, ArrayList vPorEntregar, String dni, String nombre, String usuario, String pw) {
        super(dni, nombre, usuario, pw, RolUsuario.JefeTaller);
        this.certificadosTecnicos = certificadosTecnicos;
        this.solicitudesMant = solicitudesMant;
        this.vMant = vMant;
        this.vPorEntregar = vPorEntregar;
    }
    
    //Aprovar solicitud de mantenimiento del vehiculo
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
    
    //Rechazar solicitud de mantenimiento del vehiculo
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
    
    //Actualizar estado del vehiculo
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
    
    //Entrega del vehiculo
    public void entregarVehiculo(Mantenimiento mant, Vehiculo vehiculo){
        mant.setEstado("Entregado");
        this.solicitudesMant.remove(mant);
        this.vPorEntregar.remove(vehiculo);
    }
    
    //Extra permite registrar repuestos usados
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
                opVeh = opVeh - 1;
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
      public ArrayList<Mantenimiento> getSolicitudesMant() {
        return solicitudesMant;
    }

    public void setSolicitudesCompra(ArrayList<Mantenimiento> solicitudesMant) {
        this.solicitudesMant = solicitudesMant;
    }
    
    //agregar vehiculos en mantenimiento
    public static void leerVehiculosMantenimiento(ArrayList<Vehiculo> vehiculos){
        String csvFile = "src/Usuarios/VehMantenimiento.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                    
                
                if (data[0].equals("Auto")){
                    boolean conv ;
                    boolean camRetro;
                    
                    if (data[8].equals("Si")){
                        conv = true;
                    } else {
                        conv = false;
                    }
                    
                    if (data[9].equals("Si")){
                        camRetro = true;
                    } else {
                        camRetro = false;
                    }
                    
                    vMant.add(new Auto(data[7].charAt(0), conv, camRetro, Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                    
                } else if (data[0].equals("Camion")) {
                    vMant.add(new Camion(Double.parseDouble(data[7]), data[8].charAt(0), Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                } else if (data[0].equals("Tractor")){
                    boolean agri;
                    
                    if (data[7].equals("Si")){
                        agri = true;
                    } else {
                        agri = false;
                    }
                    
                    vMant.add(new Tractor(agri, data[8], Double.parseDouble(data[6]),data[1], data[2], data[3], data[4], data[5].charAt(0)));
                }else if (data[0].equals("Motocicleta")){
                    vMant.add(new Motocicleta(data[7], Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //agregar vehiculos por entregar
    public static void leerVehiculosPorEntregar(ArrayList<Vehiculo> vehiculos){
        String csvFile = "src/Usuarios/PorEntregar.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                    
                
                if (data[0].equals("Auto")){
                    boolean conv ;
                    boolean camRetro;
                    
                    if (data[8].equals("Si")){
                        conv = true;
                    } else {
                        conv = false;
                    }
                    
                    if (data[9].equals("Si")){
                        camRetro = true;
                    } else {
                        camRetro = false;
                    }
                    
                    vPorEntregar.add(new Auto(data[7].charAt(0), conv, camRetro, Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                    
                } else if (data[0].equals("Camion")) {
                    vPorEntregar.add(new Camion(Double.parseDouble(data[7]), data[8].charAt(0), Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                } else if (data[0].equals("Tractor")){
                    boolean agri;
                    
                    if (data[7].equals("Si")){
                        agri = true;
                    } else {
                        agri = false;
                    }
                    
                    vPorEntregar.add(new Tractor(agri, data[8], Double.parseDouble(data[6]),data[1], data[2], data[3], data[4], data[5].charAt(0)));
                }else if (data[0].equals("Motocicleta")){
                    vPorEntregar.add(new Motocicleta(data[7], Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
