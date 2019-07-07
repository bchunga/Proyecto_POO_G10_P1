/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import Solicitudes.Compra;
import Usuarios.*;
import Vehiculos.*;
import java.util.Scanner;
/**
 *
 * @author Kevin Blum
 */
public class Supervisor extends Usuario {
    private ArrayList solicitudesCompra;
    private ArrayList cerfificadosAcademicos;
    
    Scanner scanner = new Scanner(System.in);
    
    public Supervisor(ArrayList solicitudesCompra, ArrayList cerfificadosAcademicos, String dni, String nombre, String usuario, String pw) {
        super(dni, nombre, usuario, pw);
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
    
    
    //Opcional: Registro de un nuevo vehiculo al stock
    public void nuevoVehiculo(){
        boolean ctrl = false;
        int op=0;
        while(!ctrl){
            System.out.println("*Tipo de vehiculo*");
            System.out.println("1.- Auto");
            System.out.println("2.- Motocicleta");
            System.out.println("3.- Camion");
            System.out.println("4.- Tractor");
            try{
                op = scanner.nextInt();
                if ((op >= 1)&&(op <= 4)){
                    ctrl = true;
                } else {
                    ctrl = false;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida.");
                ctrl = false;
            }
        }
        String marca;
        String modelo;
        double precio;
        String fabricacion;
        String combustible;
        char numLlantas;
        
        switch (op){
            case 1:
                System.out.print("Marca: ");
                marca = scanner.nextLine();
                System.out.print("Modelo: ");
                modelo = scanner.nextLine();
                ctrl = false;
                fabricacion = "";
                while (!ctrl){
                    System.out.print("Año fabricacion: ");
                    fabricacion = scanner.nextLine();
                    try{
                        double yearAux = Double.parseDouble(fabricacion);
                        if ((yearAux>1950)&&(yearAux<2021)){
                            ctrl = true;
                        } else {
                            System.out.println("Año fuera de rango");
                            ctrl = false;
                        }
                    } catch(Exception e){
                        System.out.println("Tipo de dato no valido");
                        ctrl = false;
                    }
                }
                combustible = "";
                ctrl = false;
                while (!ctrl){
                    int opComb = 0;
                    System.out.println("Tipo de combustible: ");
                    System.out.println("1.-Gasolina");
                    System.out.println("2.-Diesel");
                    System.out.print("Seleccione tipo de combustible: ");
                    
                    try{
                        opComb = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("Opcion no valida.");
                        ctrl= false;
                    }
                    switch (opComb){
                        case 1:
                            combustible = "Gasolina";
                            ctrl = true;
                            break;
                        case 2:
                            combustible = "Diesel";
                            ctrl = true;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            ctrl = false;
                    }
                }
                precio = 0;
                ctrl = false;
                while (!ctrl){
                    System.out.print("Precio: ");
                    try{
                        precio = scanner.nextDouble();
                        ctrl = true;
                    } catch (Exception e) {
                        System.out.println("Dato no valido.");
                    }
                }
                
                char asientos = ' ';
                ctrl=false;
                while (!ctrl){
                    System.out.print("Precio: ");
                    try{
                        int asiAux = scanner.nextInt();
                        if (asiAux < 8){
                            asientos = (char) asiAux;
                            ctrl = true; 
                        } else {
                            System.out.println("Fuera de rango.");
                            ctrl = false;
                        }
                        
                    } catch (Exception e) {
                        System.out.println("Dato no valido.");
                        ctrl = false;
                    }
                }
                boolean conv = false;
                ctrl = false;
                while (!ctrl) {
                    System.out.println("Convetible:");
                    System.out.println("1.-Si");
                    System.out.println("2.-No");
                    System.out.println("Seleccione opcion: ");
                    try{
                        int opConv = scanner.nextInt();
                        switch (opConv){
                            case 1:
                                conv = true;
                                ctrl = true;
                                break;
                            case 2:
                                conv = false;
                                ctrl = true;
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                                ctrl = false;
                        }
                    }catch (Exception e) {
                        System.out.println("Opcion no valida.");
                        ctrl = false;
                    }
                }
                boolean camRetro = false;
                ctrl = false;
                while (!ctrl) {
                    System.out.println("Camara Retro:");
                    System.out.println("1.-Si");
                    System.out.println("2.-No");
                    System.out.println("Seleccione opcion: ");
                    try{
                        int opCamRetro = scanner.nextInt();
                        switch (opCamRetro){
                            case 1:
                                camRetro = true;
                                ctrl = true;
                                break;
                            case 2:
                                camRetro = false;
                                ctrl = true;
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                                ctrl = false;
                        }
                    }catch (Exception e) {
                        System.out.println("Opcion no valida.");
                        ctrl = false;
                    }
                }
                
                Vehiculo.autos.add(new Auto(asientos, conv, camRetro, precio, marca, modelo, fabricacion, combustible,'4'));
                
                break;
            //Moto
            case 2:
                System.out.print("Marca: ");
                marca = scanner.nextLine();
                System.out.print("Modelo: ");
                modelo = scanner.nextLine();
                ctrl = false;
                fabricacion = "";
                while (!ctrl){
                    System.out.print("Año fabricacion: ");
                    fabricacion = scanner.nextLine();
                    try{
                        double yearAux = Double.parseDouble(fabricacion);
                        if ((yearAux>1950)&&(yearAux<2021)){
                            ctrl = true;
                        } else {
                            System.out.println("Año fuera de rango");
                            ctrl = false;
                        }
                    } catch(Exception e){
                        System.out.println("Tipo de dato no valido");
                        ctrl = false;
                    }
                }
                combustible = "";
                ctrl = false;
                while (!ctrl){
                    int opComb = 0;
                    System.out.println("Tipo de combustible: ");
                    System.out.println("1.-Gasolina");
                    System.out.println("2.-Diesel");
                    System.out.print("Seleccione tipo de combustible: ");
                    
                    try{
                        opComb = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("Opcion no valida.");
                        ctrl= false;
                    }
                    switch (opComb){
                        case 1:
                            combustible = "Gasolina";
                            ctrl = true;
                            break;
                        case 2:
                            combustible = "Diesel";
                            ctrl = true;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            ctrl = false;
                    }
                }
                precio = 0;
                ctrl = false;
                while (!ctrl){
                    System.out.print("Precio: ");
                    try{
                        precio = scanner.nextDouble();
                        ctrl = true;
                    } catch (Exception e) {
                        System.out.println("Dato no valido.");
                    }
                }
                String categoria = "";
                ctrl = false;
                while (!ctrl){
                    int opCat = 0;
                    System.out.println("Categoria: ");
                    System.out.println("1.-Deportiva");
                    System.out.println("2.-Scooter");
                    System.out.println("3.-TodoTerreno");
                    System.out.print("Seleccione tipo de combustible: ");
                    
                    try{
                        opCat = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("Opcion no valida.");
                        ctrl= false;
                    }
                    switch (opCat){
                        case 1:
                            categoria = "Deportiva";
                            ctrl = true;
                            break;
                        case 2:
                            categoria = "Scooter";
                            ctrl = true;
                            break;
                        case 3:
                            categoria = "Todo Terreno";
                            ctrl = true;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            ctrl = false;
                    }
                }
                
                Vehiculos.Vehiculo.motos.add(new Motocicleta(categoria, precio, marca, modelo, fabricacion, combustible,'2'));
                
                break;
            
            //camion
            case 3:
                System.out.print("Marca: ");
                marca = scanner.nextLine();
                System.out.print("Modelo: ");
                modelo = scanner.nextLine();
                ctrl = false;
                fabricacion = "";
                while (!ctrl){
                    System.out.print("Año fabricacion: ");
                    fabricacion = scanner.nextLine();
                    try{
                        double yearAux = Double.parseDouble(fabricacion);
                        if ((yearAux>1950)&&(yearAux<2021)){
                            ctrl = true;
                        } else {
                            System.out.println("Año fuera de rango");
                            ctrl = false;
                        }
                    } catch(Exception e){
                        System.out.println("Tipo de dato no valido");
                        ctrl = false;
                    }
                }
                combustible = "";
                ctrl = false;
                while (!ctrl){
                    int opComb = 0;
                    System.out.println("Tipo de combustible: ");
                    System.out.println("1.-Gasolina");
                    System.out.println("2.-Diesel");
                    System.out.print("Seleccione tipo de combustible: ");
                    
                    try{
                        opComb = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("Opcion no valida.");
                        ctrl= false;
                    }
                    switch (opComb){
                        case 1:
                            combustible = "Gasolina";
                            ctrl = true;
                            break;
                        case 2:
                            combustible = "Diesel";
                            ctrl = true;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            ctrl = false;
                    }
                }
                precio = 0;
                ctrl = false;
                while (!ctrl){
                    System.out.print("Precio: ");
                    try{
                        precio = scanner.nextDouble();
                        ctrl = true;
                    } catch (Exception e) {
                        System.out.println("Dato no valido.");
                    }
                }
                double capCarga = 0;
                ctrl = false;
                while (!ctrl){
                    System.out.print("Capacidad de Carga: ");
                    try{
                        capCarga = scanner.nextDouble();
                        ctrl = true;
                    } catch (Exception e) {
                        System.out.println("Dato no valido.");
                    }
                }
                char numRuedas = 0;
                char numEjes = 0;
                while (!ctrl){
                    int opRuedas = 0;
                    System.out.println("Categoria: ");
                    System.out.println("1.- 4 llantas, 2 ejes");
                    System.out.println("2.- 6 llantas, 3 ejes");
                    System.out.println("3.- 8 llantas, 4 ejes");
                    System.out.print("Seleccione tipo de combustible: ");
                    
                    try{
                        opRuedas = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("Opcion no valida.");
                        ctrl= false;
                    }
                    switch (opRuedas){
                        case 1:
                            numRuedas = '4';
                            numEjes = '2';
                            ctrl = true;
                            break;
                        case 2:
                            numRuedas = '6';
                            numEjes = '3';
                            ctrl = true;
                            break;
                        case 3:
                            numRuedas = '8';
                            numEjes = '4';
                            ctrl = true;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            ctrl = false;
                    }
                }
                
                Vehiculos.Vehiculo.camiones.add(new Camion(capCarga, numEjes, precio, marca, modelo, fabricacion, combustible, numRuedas));
                
                break;
            
            //tractor
            case 4:
                System.out.print("Marca: ");
                marca = scanner.nextLine();
                System.out.print("Modelo: ");
                modelo = scanner.nextLine();
                ctrl = false;
                fabricacion = "";
                while (!ctrl){
                    System.out.print("Año fabricacion: ");
                    fabricacion = scanner.nextLine();
                    try{
                        double yearAux = Double.parseDouble(fabricacion);
                        if ((yearAux>1950)&&(yearAux<2021)){
                            ctrl = true;
                        } else {
                            System.out.println("Año fuera de rango");
                            ctrl = false;
                        }
                    } catch(Exception e){
                        System.out.println("Tipo de dato no valido");
                        ctrl = false;
                    }
                }
                combustible = "Diesel";
                precio = 0;
                ctrl = false;
                while (!ctrl){
                    System.out.print("Precio: ");
                    try{
                        precio = scanner.nextDouble();
                        ctrl = true;
                    } catch (Exception e) {
                        System.out.println("Dato no valido.");
                    }
                }
                boolean agricola = false;
                ctrl = false;
                while (!ctrl) {
                    System.out.println("Uso Agricola:");
                    System.out.println("1.-Si");
                    System.out.println("2.-No");
                    System.out.println("Seleccione opcion: ");
                    try{
                        int opAgricola = scanner.nextInt();
                        switch (opAgricola){
                            case 1:
                                agricola = true;
                                ctrl = true;
                                break;
                            case 2:
                                agricola = false;
                                ctrl = true;
                                break;
                            default:
                                System.out.println("Opcion no valida.");
                                ctrl = false;
                        }
                    }catch (Exception e) {
                        System.out.println("Opcion no valida.");
                        ctrl = false;
                    }
                }
                String transmision = "";
                ctrl = false;
                while (!ctrl){
                    int opTrans = 0;
                    System.out.println("Tipo de transmision: ");
                    System.out.println("1.-Hidraulica");
                    System.out.println("2.-Mecanica");
                    System.out.print("Seleccione tipo de combustible: ");
                    
                    try{
                        opTrans = scanner.nextInt();
                    } catch (Exception e){
                        System.out.println("Opcion no valida.");
                        ctrl= false;
                    }
                    switch (opTrans){
                        case 1:
                            transmision = "Hidraulica";
                            ctrl = true;
                            break;
                        case 2:
                            transmision = "Mecanica";
                            ctrl = true;
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            ctrl = false;
                    }
                }
                
                Vehiculos.Vehiculo.tractores.add(new Tractor(agricola, transmision, precio, marca, modelo, fabricacion, combustible,'4'));
                
                break;     
        }    
       
        
    }
    
    public void vehiculosMantenimiento(){
        int i = 1;
        for (Vehiculo veh: JefeTaller.vMant){
            System.out.println(i + ", " + veh.datosMant());
            i = i + 1;
        }
    }
    
}
