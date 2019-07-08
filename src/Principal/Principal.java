/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Usuarios.Cliente;
import Usuarios.JefeTaller;
import Usuarios.Supervisor;
import Usuarios.Usuario;
import Usuarios.Vendedor;
import Util.Archivo;
import Util.Menu;
import Util.Utilitario;
import Vehiculos.Auto;
import Vehiculos.Camion;
import Vehiculos.Motocicleta;
import Vehiculos.Tractor;
import Vehiculos.Vehiculo;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kevin Blum
 */
public class Principal {

    public static ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    public static ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
    public static ArrayList<Supervisor> supervisores = new ArrayList<Supervisor>();
    public static JefeTaller jefeTaller;
 
    public static ArrayList<Vehiculo> stock = new ArrayList<Vehiculo>();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Carga de datos
        Archivo.leerUsuarios(clientes, vendedores,supervisores,jefeTaller);
        Archivo.leerVehiculos(stock);
       Random r = new Random();
        
        
         System.out.println("---------------------------------------\n"
                + "\tSISTEMA CONCESIONARIA\n"
                + "---------------------------------------\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Usuario: ");
        String usuario = sc.next();
        System.out.println("Contraseña: ");
        String contraseña = sc.next();

       Usuario user= Utilitario.loginUsuario(clientes, vendedores,supervisores,jefeTaller, usuario, contraseña);
       
       if(user==null){
           System.out.println("Usuario no Existe");
       
       }else{
           System.out.println("Bienvenido  " + user);
           switch (user.getRol().toString()){
               case "Cliente":
                   Menu.menuCliente((Cliente)user, stock, supervisores.get(r.nextInt(2)), jefeTaller, vendedores);
                   
                   
        }
            }
    
    }
    
}
