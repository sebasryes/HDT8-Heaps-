package com.example;
/**
 * Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Sebastian Reyes 21139
 * Clase principal Main
 */
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Vector listaPacientes = new Vector<Paciente>();

        //Se realiza la lectura del archivo txt
        Scanner read = new Scanner(System.in);
        String archivoNombre;
        System.out.println("Ingrese el nombre del archivo");
        archivoNombre = read.next();
        ArrayList<String> archivo = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(
                    Paths.get(archivoNombre + ".txt"),
                    StandardCharsets.UTF_8
            );
            lines.forEach(archivo::add);
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
        }

        for (String linea : archivo) {
            ArrayList<String> pacienteArray = new ArrayList();
            for (String info : linea.trim().split(",")) {
                pacienteArray.add(info);
            }

            listaPacientes.add(new Paciente(pacienteArray.get(0), pacienteArray.get(1), pacienteArray.get(2)));
        }

        VectorHeap colaPacientes = new VectorHeap(listaPacientes);
       
        Boolean continuar = true;

        while (continuar) {
            System.out.println(colaPacientes.remove());
            System.out.println("Mostrar siguiente paciente? s/n");
            String continuarText = read.next();
            continuar = continuarText.equals("s") && !colaPacientes.isEmpty();
        }
    }
}
