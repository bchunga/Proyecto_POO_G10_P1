/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Usuarios.Cliente;
import Usuarios.JefeTaller;
import Usuarios.Supervisor;
import Usuarios.Vendedor;
import Vehiculos.Vehiculo;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author BRYAN
 */
public class Test {
    public static void menuJefeTaller() {
        int opc = 0;
      
        do {
            
            System.out.println("---------------------------------------\n"
                    + "\tMENU JEFE TALLER\n"
                    + "---------------------------------------\n"
                    + "Opciones:\n"
                    + "1. Entregar Vehiculo\n"
                    + "2. Administrar Vehiculos\n"
                    + "3. Agregar Repuesto\n"
                    + "8. Salir\n"
                    + "Ingrese un número para seleccionar opción:");

            Scanner sc = new Scanner(System.in);
            opc = sc.nextInt();
            int i;
            int op = 0;
            switch (opc) {
                case 1:
                    i = 1;
                    for (Vehiculo veh: vMant){
                        System.out.println(i + ".- " + veh.datosMant());
                    }
                     
                    try {
                        System.out.println("Seleccione Vehiculo: ");
                        op = scanner.nextInt();
                        op = op - 1;
                        entregarVehiculo(vPorEntregar(op));
                    } catch (Exception e) {
                        System.out.println("Opcion no valida.");
                    }
                    break;
                case 2:
                    i = 1;
                    for (Vehiculo veh: vMant){
                        System.out.println("Seleccione Vehiculo: ");
                        System.out.println(i + ".- " + veh.datosMant());
                    }
                    try {
                        op = scanner.nextInt();
                        op = op - 1;
                        entregarVehiculo(vMant(op));
                    } catch (Exception e) {
                        System.out.println("Opcion no valida.");
                    }
            }
        } while (opc != 8);
    }   
}
