/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Usuarios.Cliente;
import Usuarios.JefeTaller;
import Usuarios.Supervisor;
import Usuarios.Usuario;
import Usuarios.Vendedor;
import Vehiculos.Vehiculo;
import java.util.ArrayList;

/**
 *
 * @author Kevin Blum
 */
public class Utilitario {

    public static Usuario loginUsuario(ArrayList<Cliente> clientes,ArrayList<Vendedor> vendedores,ArrayList<Supervisor> supervisores,JefeTaller jefeTaller, String nombre, String contraseña) {
        ArrayList<Usuario> users=new ArrayList<>();
        users.addAll(clientes);
        users.addAll(vendedores);
        users.addAll(supervisores);
        users.add(jefeTaller);
        Usuario usuario = null;
        try {
            for (Usuario u : users) {
                if (u.getUsuario().equalsIgnoreCase(nombre) && u.getContraseña().equals(contraseña)) {
                    usuario = u;
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Error en el metodo " + e);
        }
        return usuario;

    }

   
   
    public static Vehiculo consultarVehiculoActivo(int idVehiculo, ArrayList<Vehiculo> arrV) {
        for (Vehiculo v : arrV) {
            if (v.getEstado().equals("A") && v.getIdVehiculo() == idVehiculo) {
                return v;
            }
        }
        return null;
    }

}
