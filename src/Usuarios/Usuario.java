/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import Vehiculos.Vehiculo;
import Solicitudes.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Kevin Blum
 */
public class Usuario {
    private String dni;
    private String nombre;
    private String usuario;
    private String contraseña;
    
    Scanner scanner = new Scanner(System.in);
    
    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    public static ArrayList<Supervisor> supervisores = new ArrayList<Supervisor>();
    
    //Constructor
    public Usuario(String dni, String nombre, String usuario, String pw) {
        this.dni = dni;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contraseña = pw;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Usuario{" + "dni=" + dni + ", nombre=" + nombre + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    //Leer los usuarios del csv
    public void leerUsuarios(){
        String csvFile = "src/Usuraios/usuarios.csv";
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
                    JefeTaller jt = new JefeTaller(cert, new ArrayList<>(), new ArrayList<>(),new ArrayList<>(), data[1], data[2], data[3] , data[4]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
}
