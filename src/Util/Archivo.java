/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Usuarios.Cliente;
import Usuarios.JefeTaller;
import Usuarios.Supervisor;
import Usuarios.Vendedor;
import Vehiculos.Auto;
import Vehiculos.Camion;
import Vehiculos.Motocicleta;
import Vehiculos.Tractor;
import Vehiculos.Vehiculo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author kexbl
 */
public class Archivo {
    
      //leer los vehiculo en el csv
    public static void leerVehiculos(ArrayList<Vehiculo> vehiculos){
        String csvFile = "src/Vehiculos/vehiculos.csv";
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
                    
                    vehiculos.add(new Auto(data[7].charAt(0), conv, camRetro, Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                    
                } else if (data[0].equals("Camion")) {
                    vehiculos.add(new Camion(Double.parseDouble(data[7]), data[8].charAt(0), Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                } else if (data[0].equals("Tractor")){
                    boolean agri;
                    
                    if (data[7].equals("Si")){
                        agri = true;
                    } else {
                        agri = false;
                    }
                    
                    vehiculos.add(new Tractor(agri, data[8], Double.parseDouble(data[6]),data[1], data[2], data[3], data[4], data[5].charAt(0)));
                }else if (data[0].equals("Motocicleta")){
                    vehiculos.add(new Motocicleta(data[7], Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
     //Leer los usuarios del csv
    public static void leerUsuarios( ArrayList<Cliente> clientes,ArrayList<Vendedor> vendedores,ArrayList<Supervisor> supervisores, JefeTaller jefeTaller){
        String csvFile = "src/Usuarios/usuarios.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                
                if (data[0].equals("Cliente")){
                    clientes.add(new Cliente(data[5], data[6], new ArrayList<>(), new ArrayList<>(), data[1], data[2], data[3] , data[4]));  
                }
                else if (data[0].equals("Vendedor")){
                    vendedores.add(new Vendedor(new ArrayList<>(), data[1], data[2], data[3] , data[4]));  
                }
                else if (data[0].equals("Supervisor")){
                    String[] aux = data[6].split(",");
                    ArrayList cert = new ArrayList<>(Arrays.asList(aux));
                    supervisores.add(new Supervisor(new ArrayList<>(), cert, data[1], data[2], data[3] , data[4]));  
                }
                else if (data[0].equals("JefeTaller")){
                    String[] aux = data[5].split(",");
                    ArrayList cert = new ArrayList<>(Arrays.asList(aux));
                    jefeTaller = new JefeTaller(cert, new ArrayList<>(), new ArrayList<>(),new ArrayList<>(), data[1], data[2], data[3] , data[4]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
