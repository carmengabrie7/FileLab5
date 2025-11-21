package filelab5;
import java.io.File;
import java.io.IOException;


public class Comandos {
<<<<<<< HEAD
   private MyFile file = new MyFile();
=======
     MyFile archivo= new MyFile();
>>>>>>> 5afa124421cbb5364f53043ac8c113598a50bbb3
    //carpeta actual
   private File directorio = new File(System.getProperty("user.dir"));
   
   public String listaComandos(String linea){
       if (linea.trim().isEmpty()) return "";
<<<<<<< HEAD
       String[] partes = linea.split(" "); //funciona para que separe el comando y el parametro
       String cmd = partes[0]; //parte 0 -> comando, parte 1 -> parametro
=======
       String[] partes = linea.split(" "); 
       String cmd = partes[0]; 
>>>>>>> 5afa124421cbb5364f53043ac8c113598a50bbb3
       
       //crear carpeta
       if (cmd.equalsIgnoreCase("mkdir")){
         if (partes.length <2){
               return "Falta el nombre de la carpeta.";}
              
         String nombreCarpeta = partes[1]; 
         String ruta = directorio.getAbsolutePath() + "\\" + nombreCarpeta;
         
         if (file.crearFolder()){
             return "Carpeta creada: "+nombreCarpeta;
         }else {
             return "No se pudo crear la carpeta.";
         }
       }
       
       //crear archivo
       if (cmd.equalsIgnoreCase("mfile")){
          if (partes.length<2){
              return "Falta el nombre del archivo.";
          }
          
          String nombreArchivo = partes[1];
          String ruta = directorio.getAbsolutePath()+"\\"+nombreArchivo;
          
          try{
              if (file.crearFile())
                  return "Archivo creado: "+nombreArchivo;
              else
                  return "No se pudo crear el archivo.";
              }catch (IOException e ){
                      return "Error creando archivo: "+e.getMessage();
                      }
          }
       
       //Eliminar carpeta o/y archivo
       if (cmd.equalsIgnoreCase("rm")){
          if (partes.length<2){
              return "Falta el nombre del archivo o carpeta a borrar.";
          } 
          
          String nombre = partes[1];
          String ruta = directorio.getAbsolutePath()+"\\"+nombre;
          
          if (file.borrar()){
              return "Eliminado "+nombre;
          } else {
              return "No se pudo eliminar.";
          }      
       }
       
       //cambiar de carpeta actual
       if (cmd.equalsIgnoreCase("cd")){
           if (partes.length<2){
              return "Debe proporcionar un nombre de carpeta.";  
           }
           
       }
       
       //listar todas las carpetas y archivos en la carpeta actual
       if (cmd.equalsIgnoreCase("dir")){
           
       }
       
       //fecha actual
       if (cmd.equalsIgnoreCase("date")){
          return file.fecha();
       }
       
       //hora actual
       if (cmd.equalsIgnoreCase("time")){
           return file.hora();
       }
       
       //regresar de carpeta
       if (cmd.equalsIgnoreCase("...")){
           
       }
       //default
      return "Comando no valido"+cmd;  
   }

}
