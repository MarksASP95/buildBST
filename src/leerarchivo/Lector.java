package leerarchivo;

import java.io.File;
import java.util.Scanner;

public class Lector {
    private Scanner s;
    private String lectura;
    
    public String leer(File archivo){
        lectura = "";
        try{
            s = new Scanner(archivo);
            lectura = s.next();
        }
        catch(Exception e){
            System.out.println("Error al cargar archivo");
        }
        
        return lectura;
    }

}
