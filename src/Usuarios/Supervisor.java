/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;
import Solicitudes.Compra;
import Vehiculos.*;
import java.util.Scanner;
import Principal.Principal;
import Solicitudes.Mantenimiento;
import static Usuarios.JefeTaller.aceptarMant;
import static Usuarios.JefeTaller.rechazarMant;
import static Usuarios.JefeTaller.solicitudesMant;
/**
 *
 * @author Kevin Blum
 */
public class Supervisor extends Usuario {
    private ArrayList<Compra> solicitudesCompra;
    private ArrayList cerfificadosAcademicos;
    
    Scanner scanner = new Scanner(System.in);
    
    public Supervisor(ArrayList solicitudesCompra, ArrayList cerfificadosAcademicos, String dni, String nombre, String usuario, String pw) {
        super(dni, nombre, usuario, pw, RolUsuario.Supervisor);
        this.solicitudesCompra = solicitudesCompra;
        this.cerfificadosAcademicos = cerfificadosAcademicos;
    }

    @Override
    public String toString() {
        return "Supervisor{" + ", solicitudesCompra=" + getSolicitudesCompra() + ", cerfificadosAcademicos=" + cerfificadosAcademicos + '}';
    }
    
    //Aprueba la solicitud de compra del cliente
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
    
    //Rechazar solicitud de compra del cliente
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
    
    
    //Extra: Registro de un nuevo vehiculo al stock
    public void nuevoVehiculo(ArrayList<Auto> autos,ArrayList<Motocicleta> motos,ArrayList<Tractor> tractores,ArrayList<Camion> camiones){
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
                
                autos.add(new Auto(asientos, conv, camRetro, precio, marca, modelo, fabricacion, combustible,'4'));
                
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
                
                motos.add(new Motocicleta(categoria, precio, marca, modelo, fabricacion, combustible,'2'));
                
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
                
                camiones.add(new Camion(capCarga, numEjes, precio, marca, modelo, fabricacion, combustible, numRuedas));
                
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
                
               tractores.add(new Tractor(agricola, transmision, precio, marca, modelo, fabricacion, combustible,'4'));
                
                break;     
        }    
       
        
    }
    
    //Extra permite ver los vehiculos en mantenimiento
    public void vehiculosMantenimiento(){
        int i = 1;
        for (Vehiculo veh: JefeTaller.vMant){
            System.out.println(i + ", " + veh.datosMant());
            i = i + 1;
        }
    }
    
    //Extra modifica datos del empleado
    public void modificarEmpleado(ArrayList<Vendedor> vendedores){
        boolean ctrl = false;
        int i = 1;
        while (!ctrl) {
            for (Vendedor vend: vendedores){
                System.out.println(1 + ".- " + vend.getNombre());
            }
            int opVend = 0;
            try{
                opVend = scanner.nextInt();
                Vendedor vendedor = vendedores.get(opVend - 1);
                System.out.println("Modificar: ");
                System.out.println("1.-Nombre");
                System.out.println("2.-Usuario");
                System.out.println("3.-Contraseña");
                int opDato = scanner.nextInt();
                switch (opDato){
                    case 1:
                        System.out.print("Nombre y Apellido: ");
                        String nom = scanner.nextLine();
                        vendedor.setNombre(nom);
                        ctrl = true;
                        break;
                    case 2:
                        System.out.println("Usuario nuevo: ");
                        String usu = scanner.nextLine();
                        vendedor.setUsuario(usu);
                        ctrl = true;
                        break;
                    case 3:
                        System.out.println("Contraseña nueva: ");
                        String pass = scanner.nextLine();
                        vendedor.setContraseña(pass);
                        ctrl = true;
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        ctrl = false;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida.");
                ctrl = false;
            }
            
        }
    }

    /**
     * @return the solicitudesCompra
     */
    public ArrayList<Compra> getSolicitudesCompra() {
        return solicitudesCompra;
    }

    /**
     * @param solicitudesCompra the solicitudesCompra to set
     */
    public void setSolicitudesCompra(ArrayList solicitudesCompra) {
        this.solicitudesCompra = solicitudesCompra;
    }
    
    public  void menuSupervisor(){
        //Mostrar slicitudes de compra
        int opc = 0;
        boolean ctrl = false;
        for (Compra compra: solicitudesCompra){
            while (!ctrl) {
                try{
                    System.out.println(compra.toString());
                    System.out.println("1.- Aprobar Solicitud");
                    System.out.println("2.- Rechazar Solicitud");
                    System.out.println("8.- Salir");
                    opc = scanner.nextInt();
                    switch (opc) {
                        case 1:
                            aprobarCompra(compra);
                            ctrl = true;
                            break;
                        case 2:
                            System.out.print("Motivo rechazo: ");
                            String motivo = scanner.nextLine();
                            rechazarCompra(compra, motivo);
                            ctrl = true;
                            break;
                        case 3:
                            ctrl = true;
                            break;
                        default:
                            System.out.println("Opcion no valida.");
                            ctrl = false;
                    }
                } catch (Exception e) {
                    System.out.println("Opcion no valida.");
                } 
            }
        }
        //Extras
        opc = 0;
        do {
            
            System.out.println("---------------------------------------\n"
                    + "\tMENU SUPERVISOR\n"
                    + "---------------------------------------\n"
                    + "Opciones:\n"
                    + "1. Registrar nuevo vehiculo\n"
                    + "2. Modificar informacion de vendedores\n"
                    + "3. Mostrar vehiculos en mantenimiento\n"
                    + "8. Salir\n"
                    + "Ingrese un número para seleccionar opción:");

            Scanner sc = new Scanner(System.in);
            try{
                opc = sc.nextInt();
                int i;
                int op = 0;
                switch (opc) {
                    case 1:
                        nuevoVehiculo(Principal.autos , Principal.motos, Principal.tractores, Principal.camiones);
                        break;
                    case 2:
                        modificarEmpleado(Principal.vendedores);
                        break;
                    case 3:
                        vehiculosMantenimiento();
                        break;
                    default:
                        System.out.println("Opcion no valida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida.");
            }
        } while (opc != 8);
    }
    
}
