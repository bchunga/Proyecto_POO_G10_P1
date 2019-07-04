/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
/**
 *
 * @author BRYAN
 */
public class Test {
    public static void main(String Args[]) throws FileNotFoundException{
        CSVReader archivo = new CSVReader(new FileReader ("usuarios.csv"));
        List<String[]> datos = new ArrayList();
        try{
            datos = archivo.readAll();
        }
        catch(IOException e){
            System.out.println("Archivo no encontrado");
            e.printStackTrace();
        }
    }
}
