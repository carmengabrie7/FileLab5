package filelab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class MyFile {
    
    private File file = null;


    void setFile(String ruta){
        file = new File(ruta);
    }

    File getFile(){
        return file;
    }

    boolean crearFile()throws IOException {
        return file.createNewFile();
    }

    boolean crearFolder() {
        return file.mkdirs();
    }

    boolean borrarC(File archivos) {
        if (archivos.isDirectory()) {
            for (File hijo : archivos.listFiles()) {
                borrarC(hijo);
            }
        }
        return archivos.delete();
    }

    boolean borrar() {
        if (file == null) {
            return false;
        } else {
            return borrarC(file);
        }
    }

    String hora() {
        Date horaActual = new Date();
        SimpleDateFormat horaFormato = new SimpleDateFormat("HH:mm:ss");
        return horaFormato.format(horaActual);
    }

    String fecha() {
        Date fechaActual = new Date();
        SimpleDateFormat fechaFormato = new SimpleDateFormat("MM/dd/yy");
        return fechaFormato.format(fechaActual);
    }

    void dir() {

        if (file == null || !file.exists() || !file.isDirectory()) {
            System.out.println("Directorio no válido.");
            return;
        }

        File[] lista = file.listFiles();

        if (lista == null || lista.length == 0) {
            System.out.println("Carpeta vacía.");
            return;
        }

        SimpleDateFormat fFecha = new SimpleDateFormat("MM/dd/yy");
        SimpleDateFormat fHora = new SimpleDateFormat("HH:mm");

        for (File f : lista) {

            String fecha = fFecha.format(new Date(f.lastModified()));
            String hora = fHora.format(new Date(f.lastModified()));

            if (f.isDirectory()) {
                System.out.println(fecha + " " + hora + "   <DIR>  " + f.getName());
            } else {
                System.out.println(fecha + " " + hora + "   " + f.length() + " bytes  " + f.getName());
            }
        }
    }
    
    boolean escribir(String texto) {
        if (file == null || !file.exists()) return false;
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(texto + "\n");
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    //rd
    String leer() {
        if (file == null || !file.exists()) return null;
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            return null;
        }
        return contenido.toString();
    }
}
