/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filelab5;

import java.util.Scanner;

/**
 *
 * @author Gabriel
 */
public class FuncionEscribir_Leer {
    
        public void escribirArchivo(String nombreArchivo) {
        Archivo archivoEncontrado = null;

        // Buscar archivo por nombre
        for (Archivo a : carpetaActual.archivos) {
            if (a.getNombre().equals(nombreArchivo)) {
                archivoEncontrado = a;
                break;
            }
        }

        if (archivoEncontrado == null) {
            System.out.println("El archivo no existe.");
            return;
        }

        Scanner input = new Scanner(System.in);
        input.useDelimiter("\n");
        System.out.println("Escriba el texto que desea guardar en " + nombreArchivo + ":");
        String texto = input.next();

        archivoEncontrado.setContenido(texto);

        System.out.println("Texto guardado.");
    }
}
