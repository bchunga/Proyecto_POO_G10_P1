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
public class JefeTaller extends Usuario{
    private int id;
    private ArrayList certificadosTecnicos;
    private ArrayList solicitudesMant;
    private ArrayList vMant;
    private ArrayList vPorEntregar;

    public JefeTaller(int id, ArrayList certificadosTecnicos, ArrayList solicitudesMant, ArrayList vMant, ArrayList vPorEntregar, String dni, String nombre, String usuario) {
        super(dni, nombre, usuario);
        this.id = id;
        this.certificadosTecnicos = certificadosTecnicos;
        this.solicitudesMant = solicitudesMant;
        this.vMant = vMant;
        this.vPorEntregar = vPorEntregar;
    }
    
    
}
