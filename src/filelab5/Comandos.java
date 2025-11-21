package filelab5;

import java.io.File;


public class Comandos {
    private MyFile myfile = new MyFile();
    //carpeta actual
   private File directorio = new File(System.getProperty("user.dir"));
   
   public String listaComandos(String linea){
       if (linea.trim().isEmpty()) return "";
       String[] partes = linea.split(" "); //funciona para que separe el comando y el parametro
       String cmd = partes[0]; //partes[0] - el comando
       
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
