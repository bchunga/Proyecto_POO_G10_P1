/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehiculos;

import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author kexbl
 */
public class Vehiculo {
    protected String marca;
    protected String modelo;
    protected String fabricacion;
    protected String combustible;
    protected char numLlnatas;
    protected Double precio;
    
    public static ArrayList<Auto> autos = new ArrayList<Auto>();
    public static ArrayList<Camion> camiones = new ArrayList<Camion>();
    public static ArrayList<Motocicleta> motos = new ArrayList<Motocicleta>();
    public static ArrayList<Tractor> tractores = new ArrayList<Tractor>();
    
    public Vehiculo(Double precio, String marca, String modelo, String fabricacion, String combustible, char numLlnatas) {
        this.marca = marca;
        this.modelo = modelo;
        this.fabricacion = fabricacion;
        this.combustible = combustible;
        this.numLlnatas = numLlnatas;
        this.precio = precio;
    }
    
    public void leerVehiculos(){
        String csvFile = "src/Usuraios/vehiculos.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                    
                System.out.println(line);
                
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
                    
                    autos.add(new Auto(data[7].charAt(0), conv, camRetro, Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                    
                } else if (data[0].equals("Camion")) {
                    camiones.add(new Camion(Double.parseDouble(data[7]), data[8].charAt(0), Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                } else if (data[0].equals("Tractor")){
                    boolean agri;
                    
                    if (data[7].equals("Si")){
                        agri = true;
                    } else {
                        agri = false;
                    }
                    
                    tractores.add(new Tractor(agri, data[8], Double.parseDouble(data[6]),data[1], data[2], data[3], data[4], data[5].charAt(0)));
                }else if (data[0].equals("Motocicleta")){
                    motos.add(new Motocicleta(data[7], Double.parseDouble(data[6]), data[1], data[2], data[3], data[4], data[5].charAt(0)));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String datosMant(){
        return "Marca: " + marca + " Modelo: " + modelo + "Fabricacion: " + fabricacion + "Combustible: "  + combustible;
    }
    
}
