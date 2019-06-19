/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;

/**
 *
 * @author Kevin Blum
 */
public class Supervisor extends Usuario {
    private int id;
    private ArrayList solicitudesCompra;
    private ArrayList cerfificadosAcademicos;

    public Supervisor(int id, ArrayList solicitudesCompra, ArrayList cerfificadosAcademicos, String dni, String nombre, String usuario) {
        super(dni, nombre, usuario);
        this.id = id;
        this.solicitudesCompra = solicitudesCompra;
        this.cerfificadosAcademicos = cerfificadosAcademicos;
    }

    @Override
    public String toString() {
        return "Supervisor{" + "id=" + id + ", solicitudesCompra=" + solicitudesCompra + ", cerfificadosAcademicos=" + cerfificadosAcademicos + '}';
    }
    
    
}
