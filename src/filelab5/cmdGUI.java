package filelab5;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class cmdGUI extends JFrame {

    private JTextPane pantalla;
    private StyledDocument doc;
    private Comandos comandos = new Comandos();

    private String prompt;
    private int promptPosition;
    private boolean modoEscritura = false;
    private String archivoActual = null;

    public cmdGUI() {

        setTitle("Command Prompt");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pantalla = new JTextPane();
        pantalla.setBackground(Color.BLACK);
        pantalla.setForeground(Color.WHITE);
        pantalla.setFont(new Font("Consolas", Font.PLAIN, 16));

        pantalla.setEditable(true);
        pantalla.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                try {

                    int pos = pantalla.getCaretPosition();

                    // evitar borrar el prompt
                    if (pos < promptPosition && e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                        e.consume();
                        return;
                    }

                    // ENTER → ejecutar comando
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        e.consume();
                        ejecutarComando();
                    }

                } catch (Exception ex) {}
            }
        });

        doc = pantalla.getStyledDocument();

        JScrollPane scroll = new JScrollPane(pantalla);
        add(scroll);

        mostrarPrompt();

        setVisible(true);
    }

    private void mostrarPrompt() {
        try {
            prompt = comandos.getDirectorio() + "> ";
            doc.insertString(doc.getLength(), prompt, null);
            promptPosition = doc.getLength();
        } catch (BadLocationException e) {}
    }

    private void ejecutarComando() {

        try {
            int len = doc.getLength();
            String input = doc.getText(promptPosition, len - promptPosition).trim();

            doc.insertString(doc.getLength(), "\n", null);

            // WR
            if (modoEscritura) {
                boolean ok = comandos.escribirDirecto(archivoActual, input);
                doc.insertString(doc.getLength(), ok ? "Escrito.\n\n" : "Error.\n\n", null);
                modoEscritura = false;
                archivoActual = null;
                mostrarPrompt();
                return;
            }

            // activar WR
            if (input.startsWith("wr ")) {
                String[] p = input.split(" ");
                if (p.length >= 2) {
                    archivoActual = p[1];
                    modoEscritura = true;
                    doc.insertString(doc.getLength(), "Modo escritura activo.\n", null);
                    mostrarPrompt();
                    return;
                }
            }

            // ejecutar comando normal
            String out = comandos.listaComandos(input);
            doc.insertString(doc.getLength(), out + "\n\n", null);

            mostrarPrompt();

        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        new cmdGUI();
    }
}


