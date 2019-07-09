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
    public static ArrayList<JefeTaller> jefeTaller = new ArrayList<JefeTaller>();
    
    public static ArrayList<Auto> autos = new ArrayList<Auto>();
    public static ArrayList<Motocicleta> motos = new ArrayList<Motocicleta>();
    public static ArrayList<Camion> camiones = new ArrayList<Camion>();
    public static ArrayList<Tractor> tractores = new ArrayList<Tractor>();
    //public static JefeTaller jefeTaller;

    public static ArrayList<Vehiculo> stock = new ArrayList<Vehiculo>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Carga de datos
        Archivo.leerUsuarios(clientes, vendedores, supervisores,jefeTaller);
        Archivo.leerVehiculos(stock);
        JefeTaller.leerVehiculosMantenimiento(JefeTaller.vMant);
        JefeTaller.leerVehiculosPorEntregar(JefeTaller.vPorEntregar);
        
        Random r = new Random();
        
        boolean login=false;

        do{
        System.out.println("---------------------------------------\n"
                + "\tSISTEMA CONCESIONARIA\n"
                + "---------------------------------------\n");
        Scanner sc = new Scanner(System.in);
        System.out.println("Usuario: ");
        String usuario = sc.next();
        System.out.println("Contraseña: ");
        String contraseña = sc.next();

        Usuario user = Utilitario.loginUsuario(clientes, vendedores, supervisores, jefeTaller, usuario, contraseña);

        if (user == null) {
            System.out.println("Usuario no Existe");

        } else {
            System.out.println("Bienvenido  " + user.getNombre());
            switch (user.getRol().toString()) {
                case "Cliente":
                    login=Menu.menuCliente((Cliente) user, stock, supervisores.get(r.nextInt(2)), jefeTaller.get(0), vendedores);
                    break;
                case "Vendedor":
                    login=Menu.menuVendedor((Vendedor) user, stock);
                case "Supervisor":
                    login= Menu.menuSupervisor((Supervisor)user);
                case "JefeTaller":
                     login=Menu.menuJefeTaller((JefeTaller)user);
    
            }
        }
        }while(login==true);
          System.out.println(
                "Fin del programa");
    }

}
