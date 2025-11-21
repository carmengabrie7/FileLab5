package filelab5;

import java.io.File;
import java.io.IOException;



public class MyFile {
    
     private File mifile=null;
    
 boolean crearFile()throws IOException{
     return mifile.createNewFile();
    }
    
    boolean crearFolder(){
        return mifile.mkdirs();
    }
    
    boolean borrarAux(File mf){
        if(mf.isDirectory()){
            for(File child:mf.listFiles()){
                borrarAux(child);
            }
        }
        return mifile.delete();
    }  
    
    boolean borrar(){
        if(mifile==null){
            return false;
        }else{
            return borrarAux(mifile);
        }
    }
    
}
