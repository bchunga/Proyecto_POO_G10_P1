/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Principal.Principal;
import Solicitudes.Compra;
import Solicitudes.Cotizacion;
import Solicitudes.Mantenimiento;
import Usuarios.Cliente;
import Usuarios.JefeTaller;
import static Usuarios.JefeTaller.aceptarMant;
import static Usuarios.JefeTaller.rechazarMant;
import static Usuarios.JefeTaller.solicitudesMant;
import static Usuarios.JefeTaller.vMant;
import static Usuarios.JefeTaller.vPorEntregar;
import Usuarios.Supervisor;
import Usuarios.Vendedor;
import static Util.Utilitario.consultarVehiculoActivo;
import Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author kexbl
 */
public class Menu {

    public static boolean menuCliente(Cliente c, ArrayList<Vehiculo> vehiculos, Supervisor supervisor, JefeTaller jefetaller, ArrayList<Vendedor> vendedores) {
        int opc = 0;
        boolean login=false;

        do {
           
            System.out.println("---------------------------------------\n"
                    + "\tMENU CLIENTE\n"
                    + "---------------------------------------\n"
                    + "Opciones:\n"
                    + "1. Consultar Stock\n"
                    + "2. Solicitar Cotización\n"
                    + "3. Consultar Cotización\n"
                    + "4. Solicitar Compra\n"
                    + "5. Rechazar Cotización\n"
                    + "6. Solicitar Mantenimiento\n"
                    + "7. Consultar Mantenimiento\n"
                    + "8. Cerrar Sesion\n"
                    + "9. Salir\n"
                    
                    + "Ingrese un número para seleccionar opción:");

            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();
            switch (opc) {
                case 1: {
                    c.consultarStock(vehiculos);
                    System.out.println("Presione 0 para Regresar\n");
                    opc = sc.nextInt();
                    break;
                }
                case 2: {
                    System.out.println("Ingrese el Id de vehiculo a cotizar: ");
                    int idVehiculo = sc.nextInt();
                    Vehiculo vehiculo = consultarVehiculoActivo(idVehiculo, vehiculos);
                    if (vehiculo == null) {
                        System.out.println("Vehiculo no existe");
                    } else {
                        c.solicitarCotizacion(vendedores, vehiculo);
                    }
                    System.out.println("Presione 0 para Regresar\n");
                    opc = sc.nextInt();
                    break;
                }
                case 3: {
                    System.out.println("Ingrese el numero de cotizacion a consultar: ");
                    int idCotizacion = sc.nextInt();
                    Cotizacion cot = c.consultarCotizacion(idCotizacion);
                    System.out.println(cot);
                    System.out.println("Presione 0 para Regresar\n");                    
                    opc = sc.nextInt();
                    break;
                }
                case 4: {
                    System.out.println("Ingrese el numero de cotizacion a comprar: ");
                    int idCotizacionCompra = sc.nextInt();
                    Cotizacion cos = c.consultarCotizacion(idCotizacionCompra);
                    if (cos == null) {
                        System.out.println("Cotizacion no existe");
                    } else {
                        c.soliciticarCompra(supervisor, cos);
                        System.out.println("La solicitud de compra ha sido enviada exitosamente");
                    }
                   System.out.println("Presione 0 para Regresar\n"); 
                    opc = sc.nextInt();
                    break;
                }
                case 5: {
                    System.out.println("Ingrese el numero de cotizacion a rechazar: ");
                    int idCotizacionRechazar = sc.nextInt();
                    Cotizacion cosR = c.consultarCotizacion(idCotizacionRechazar);
                    if (cosR == null) {
                        System.out.println("Cotizacion no existe");
                    } else {
                        c.rechazarCotizacion(c.getSolicitudesPendientes(), cosR);
                        System.out.println("La solicitud de compra ha sido rechazada exitosamente");
                    }
                  System.out.println("Presione 0 para Regresar\n"); 
                    opc = sc.nextInt();
                    break;
                }
                case 6: {
                    System.out.println("Ingrese el id de vehículo para mantenimiento: ");
                    int idvehiculoMantenimiento = sc.nextInt();

                    Vehiculo vehiculo1 = consultarVehiculoActivo(idvehiculoMantenimiento, vehiculos);

                    if (vehiculo1 == null) {
                        System.out.println("Vehiculo no existe\n");
                    } else {
                        c.solicitarMantenimiento(jefetaller, vehiculo1);
                        System.out.println("La solicitud de mantenimiento ha sido enviaada exitosamente");
                    }
                  System.out.println("Presione 0 para Regresar\n");
                    opc = sc.nextInt();
                    break;
                }
                case 7: {
                    System.out.println("Ingrese el id de solicitud de mantenimiento: ");
                    int idsolicitudMantenimiento = sc.nextInt();

                    Mantenimiento m = c.consultarMantenimiento(jefetaller, idsolicitudMantenimiento);
                    if (m == null) {
                        System.out.println("Vehiculo no existe");
                    } else {
                        System.out.println("El estado de mantenimiento es " + m.getEstado());
                    }
                    System.out.println("Presione 0 para Regresar\n");
                    
                    opc = sc.nextInt();

                    break;
                }
                case 8:
                    login=true;
                    break;
            }
        } while (opc != 9 && opc!=8);
        
        return login;
    }

    public static boolean menuVendedor( Vendedor v,ArrayList<Vehiculo> vehiculos) {
        int opc = 0;
        boolean login=false;
        do {

            System.out.println("---------------------------------------\n"
                    + "\tMENU VENDEDOR\n"
                    + "---------------------------------------\n"
                    + "Opciones:\n"
                    + "1. Consultar Cotizaciones\n"
                    + "2. Aprobar Cotización\n"
                    + "3. Rechazar Cotización\n"
                    + "4. Consultar vehiculo\n"
                    + "5. Cerrar Sesión\n"
                    + "6. Salir\n"
                    + "Ingrese un número para seleccionar opción:");

            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();
            switch (opc) {
                case 1: {
                    System.out.println("Id Cotizacion" + "\tFecha" + "\tCliente" + "\tVehiculo");

                    for (Cotizacion cos : v.getSolicitudesCotizacion()) {

                        System.out.println(cos.getIdSolicitud() + "\t" + cos.getFecha() + "\t" + cos.getCliente().getNombre() + "\t" + cos.getVehiculo().toString());

                    }

                    System.out.println("Presione 0 para Regresar\n");
                    opc = sc.nextInt();

                    break;
                }
                case 2: {
                    System.out.println("Ingrese el Id de cotizacion a aprobar: ");
                    int idCotizacionAprobar = sc.nextInt();
                    Cotizacion cot1= v.aprobarCotizacion(idCotizacionAprobar);
                    if (cot1 == null) {
                        System.out.println("Cotizacion no existe");
                    } else {
                        System.out.println("Solicitud de cotizacion ha sido aprobada");
                    }
                    
                    System.out.println("Presione 0 para Regresar\n");
                    opc = sc.nextInt();
                    break;
                }
                case 3: {
                    System.out.println("Ingrese el Id de cotizacion a rechazar: ");
                    int idCotizacionrechazar = sc.nextInt();
                    System.out.println("Ingrese el motivo de rechazo: ");
                    String motivo = sc.next();
                    
                    Cotizacion cot2= v.rechazarCotizacion( idCotizacionrechazar, motivo);
                    if (cot2 == null) {
                        System.out.println("Cotizacion no existe");
                    } else {
                        System.out.println("Solicitud de cotizacion ha sido rechazada");
                    }
                   System.out.println("Presione 0 para Regresar\n");
                    opc = sc.nextInt();
                    break;
                }
                case 4: {
                    v.consultarVehiculo(vehiculos);
                     System.out.println("Presione 0 para Regresar\n");
                    opc = sc.nextInt();
                    break;
                }
                
                case 5:
                    login=true;
                    break;            }

        } while (opc
                != 5 && opc!=6);
      return login;
    }

    
    public static boolean  menuSupervisor(Supervisor s){
        //Mostrar slicitudes de compra
        
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        boolean ctrl = false;
        for (Compra compra: s.getSolicitudesCompra()){
            while (!ctrl) {
                try{
                    System.out.println(compra.toString());
                    System.out.println("1.- Aprobar Solicitud");
                    System.out.println("2.- Rechazar Solicitud");
                    System.out.println("8.- Salir");
                    opc = scanner.nextInt();
                    switch (opc) {
                        case 1:
                            s.aprobarCompra(compra);
                            ctrl = true;
                            break;
                        case 2:
                            System.out.print("Motivo rechazo: ");
                            String motivo = scanner.nextLine();
                            s.rechazarCompra(compra, motivo);
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
         boolean login=false;
        do {
           
            System.out.println("---------------------------------------\n"
                    + "\tMENU SUPERVISOR\n"
                    + "---------------------------------------\n"
                    + "Opciones:\n"
                    + "1. Registrar nuevo vehiculo\n"
                    + "2. Modificar informacion de vendedores\n"
                    + "3. Mostrar vehiculos en mantenimiento\n"
                    + "4. Cerrar Sesión\n"
                    + "Ingrese un número para seleccionar opción:");

            Scanner sc = new Scanner(System.in);
            try{
                opc = sc.nextInt();
                int i;
                int op = 0;
                switch (opc) {
                    case 1:
                        s.nuevoVehiculo(Principal.autos , Principal.motos, Principal.tractores, Principal.camiones);
                        break;
                    case 2:
                        s.modificarEmpleado(Principal.vendedores);
                        break;
                    case 3:
                        s.vehiculosMantenimiento();
                        break;
                    case 4:
                        login=true;
                        break;            

                    default:
                        System.out.println("Opcion no valida.");
                        break;
                
                }
            } catch (Exception e) {
                System.out.println("Opcion no valida.");
            }
        } while (opc != 4 & opc != 5);
    return login;
    }
    
    public static boolean menuJefeTaller(JefeTaller j) {
        Scanner scanner = new Scanner(System.in);
        int opc = 0;
        boolean ctrl = false;
        for (Mantenimiento mant: j.getSolicitudesMant()){
            while (!ctrl) {
                try{
                    System.out.println(mant.toString());
                    System.out.println("1.- Aprobar Solicitud");
                    System.out.println("2.- Rechazar Solicitud");
                    System.out.println("3.- Salir");
                    opc = scanner.nextInt();
                    switch (opc) {
                        case 1:
                            JefeTaller.aceptarMant(mant);
                            ctrl = true;
                            break;
                        case 2:
                            System.out.print("Motivo rechazo: ");
                            String motivo = scanner.nextLine();
                            JefeTaller.rechazarMant(mant, motivo);
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
        
        opc = 0;
        boolean login = false;
        do {
            
            System.out.println("---------------------------------------\n"
                    + "\tMENU JEFE TALLER\n"
                    + "---------------------------------------\n"
                    + "Opciones:\n"
                    + "1. Entregar Vehiculo\n"
                    + "2. Administrar Vehiculos\n"
                    + "3. Agregar Repuesto\n"
                    + "4. Cerrar Sesión\n"
                    + "5. Salir\n"
                    + "Ingrese un número para seleccionar opción:");

            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();
            int i;
            int op = 0;
            switch (opc) {
                case 1:
                    i = 1;
                    for (Vehiculo veh: JefeTaller.vMant){
                        System.out.println(i + ".- " + veh.datosMant());
                    }
                     
                    try {
                        System.out.println("Seleccione Vehiculo: ");
                        op = scanner.nextInt();
                        op = op - 1;
                        j.entregarVehiculo(JefeTaller.vPorEntregar.get(op));
                    } catch (Exception e) {
                        System.out.println("Opcion no valida.");
                    }
                    break;
                case 2:
                    i = 1;
                    for (Vehiculo veh: JefeTaller.vMant){
                        System.out.println("Seleccione Vehiculo: ");
                        System.out.println(i + ".- " + veh.datosMant());
                    }
                    try {
                        op = scanner.nextInt();
                        op = op - 1;
                        j.estadoVehiculo(JefeTaller.vMant.get(op));
                    } catch (Exception e) {
                        System.out.println("Opcion no valida.");
                    }
                    break;
                case 3:
                    j.agregarRepuesto();
                    break;
                case 4:
                    login= true;
                    break;    
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opc != 4 & opc != 5);
    return login;
    }
}
