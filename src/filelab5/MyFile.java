package filelab5;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;



public class MyFile {
    
    private File file=null;
    
    boolean crearFile()throws IOException{
        return file.createNewFile();
    }
    
    boolean crearFolder(){
        return file.mkdirs();
    }
    
    boolean borrarC(File archivos){
        if(archivos.isDirectory()){
            for(File hijo:archivos.listFiles()){
                borrarC(hijo);
            }
        }
        return file.delete();
    }  
    
    boolean borrar(){
        if(file==null){
            return false;
        }else{
            return borrarC(file);
        }
    }
    
    String hora(){
        Date horaActual= new Date();
        SimpleDateFormat horaFormato= new SimpleDateFormat("HH:mm:ss");
        String hora= horaFormato.format(horaActual);
        return hora;
    }
    
    String fecha(){
        Date fechActual= new Date();
        SimpleDateFormat fechaFormato= new SimpleDateFormat("MM/dd/yy");
        String fecha= fechaFormato.format(fechActual);
        return fecha;        
    }
    
}
