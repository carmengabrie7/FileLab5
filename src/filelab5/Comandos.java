package filelab5;
import java.io.File;
import java.io.IOException;


public class Comandos {

   private MyFile file = new MyFile();
   
    //carpeta actual
   private File directorio = new File(System.getProperty("user.dir"));
   
   public String listaComandos(String linea){
       if (linea.trim().isEmpty()) return "";
       
       String[] partes = linea.split(" "); //funciona para que separe el comando y el parametro
       String cmd = partes[0]; //parte 0 -> comando, parte 1 -> parametro


       //crear carpeta
       if (cmd.equalsIgnoreCase("mkdir")){
         if (partes.length <2){
               return "Falta el nombre de la carpeta.";}
              
         String nombreCarpeta = partes[1]; 
         String ruta = directorio.getAbsolutePath() + "\\" + nombreCarpeta;
         
         file.setFile(ruta);
         
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
          
          file.setFile(ruta);
          
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
          
          file.setFile(ruta);
          
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
           
           String destino = partes[1];
           
           if (destino.equals("..")){
               directorio = directorio.getParentFile();
               return "Ahora estas en: "+directorio.getAbsolutePath();
           }
           
           File nueva = new File(directorio,destino);
           if (nueva.exists()&& nueva.isDirectory()){
               directorio = nueva;
               return "Ahora estas en: "+directorio.getAbsolutePath();
           }
           
           return "La carpeta no existe.";
       }
       
       //listar todas las carpetas y archivos en la carpeta actual
       if (cmd.equalsIgnoreCase("dir")){
           StringBuilder sb=new StringBuilder();
           File[] lista = directorio.listFiles();
           
           sb.append("Directorio actual: ").append(directorio.getAbsolutePath()).append("\n\n");
           if (lista == null || lista.length ==0){
               return "Carpeta vacia.";
           }
           
           for (File f : lista){
               if (f.isDirectory()){
                   sb.append("<DIR> ").append(f.getName()).append("\n");
               }else {
                   sb.append("    ").append(f.getName()).append("\n");
               }
               
               return sb.toString();
           }
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
          directorio = directorio.getParentFile();
          return "Regresaste a:"+directorio.getAbsolutePath();
       }
       
       if (cmd.equalsIgnoreCase("wr")){
           if (partes.length<2){
               return "Debe seleccionar un archivo para escribir.";
           }
           
           String  nombre = partes[1];
           String ruta = directorio.getAbsolutePath()+"\\"+nombre;
           
           file.setFile(ruta);
           
           if (!file.getFile().exists()){
               return "El archivo no existe.";
           }
           return "Modo escritura activado. Ingrese el texto para escribir en: "+nombre;
       }
       
       if (cmd.equalsIgnoreCase("rd")){
           if (partes.length < 2){
               return "Debe seleccionar un archivo.";
           }
           
           String nombre = partes[1];
           String ruta = directorio.getAbsolutePath()+"\\"+nombre;
           
           file.setFile(ruta);
           
           String contenido = file.leer();
           
           if (contenido ==null){
               return "No se pudo leer el archivo.";
           }
           
           return contenido;
           
       }
       
  
       //default
      return "Comando no valido"+cmd;  
   }

}
