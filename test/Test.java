/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        String csvFile = "test/usuarios.csv";
        String line = "";
        String cvsSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                System.out.println(line);
                //System.out.println(data[0].equals("Cliente"));
                if (data[0].equals("Cliente")){
                    //Usuario.usuarios.add(data);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
