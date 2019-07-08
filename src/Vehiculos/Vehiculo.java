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
import java.util.Random;
/**
 *
 * @author kexbl
 */
public class Vehiculo {

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the fabricacion
     */
    public String getFabricacion() {
        return fabricacion;
    }

    /**
     * @param fabricacion the fabricacion to set
     */
    public void setFabricacion(String fabricacion) {
        this.fabricacion = fabricacion;
    }

    /**
     * @return the combustible
     */
    public String getCombustible() {
        return combustible;
    }

    /**
     * @param combustible the combustible to set
     */
    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    /**
     * @return the numLlnatas
     */
    public char getNumLlnatas() {
        return numLlnatas;
    }

    /**
     * @param numLlnatas the numLlnatas to set
     */
    public void setNumLlnatas(char numLlnatas) {
        this.numLlnatas = numLlnatas;
    }

    /**
     * @return the precio
     */
    public Double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    private int idVehiculo;
    private String marca;
    private String modelo;
    private String fabricacion;
    private String combustible;
    private char numLlnatas;
    private Double precio;
    private String estado;


    
    public Vehiculo(Double precio, String marca, String modelo, String fabricacion, String combustible, char numLlnatas) {
        this.marca = marca;
        this.modelo = modelo;
        this.fabricacion = fabricacion;
        this.combustible = combustible;
        this.numLlnatas = numLlnatas;
        this.precio = precio;
        this.idVehiculo=generarId();
        this.estado="A";
    }
    
  
    //Extra mostrar los datos para la funcion extra de supervisor
    public String datosMant(){
        return "Marca: " + getMarca() + " Modelo: " + getModelo() + "Fabricacion: " + getFabricacion() + "Combustible: "  + getCombustible();
    }
    
        public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the idVehiculo
     */
    public int getIdVehiculo() {
        return idVehiculo;
    }

    /**
     * @param idVehiculo the idVehiculo to set
     */
    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }
    
        public int generarId(){
        Random r = new Random();
        int id= r.nextInt(99999);
        
        return id;
    
    }


}
