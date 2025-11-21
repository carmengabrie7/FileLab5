package filelab5;

import java.io.File;


public class Comandos {
     MyFile archivo= new MyFile();
    //carpeta actual
   private File directorio = new File(System.getProperty("user.dir"));
   
   public String listaComandos(String linea){
       if (linea.trim().isEmpty()) return "";
       String[] partes = linea.split(" "); 
       String cmd = partes[0]; 
       
       if (cmd.equalsIgnoreCase("mkdir")){
           
       }
       if (cmd.equalsIgnoreCase("mfile")){
           
       }
       if (cmd.equalsIgnoreCase("rm")){
           
       }
       if (cmd.equalsIgnoreCase("cd")){
           
       }
       if (cmd.equalsIgnoreCase("dir")){
           
       }
       if (cmd.equalsIgnoreCase("date")){
           
       }
       if (cmd.equalsIgnoreCase("time")){
           
       }
       if (cmd.equalsIgnoreCase("...")){
           
       }
      return "Comando no valido"+cmd;  
   }
}
