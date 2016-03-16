package fileOperation;

import employeeManager.Employee;
import employeeManager.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by Péter on 2016. 03. 16..
 */
public abstract class CSVDataReader extends DataReader {
    public static final String CSVFilePath = "data/persons.csv";
    static List<Person> persons;
    static String line = "";


     public CSVDataReader(String data) {
         BufferedReader br = null;
         try {
             br = new BufferedReader(new FileReader(CSVFilePath));
             while ((line = br.readLine()) != null) {
                 String[] persons = line.split(",");

                 //System.out.println(persons);
             }
         } catch (Exception e) {
             e.printStackTrace();
         }finally{
             try {
                 br.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
         }
     }

}
