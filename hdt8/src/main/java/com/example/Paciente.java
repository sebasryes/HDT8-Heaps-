package com.example;
/**
 * Universidad Del Valle de Guatemala
 * @author Aaron Beltrán 21092
 * @author Sebastian Reyes 21139
 * Clase publica paciente
 */
public class Paciente implements Comparable<Paciente> {
    String nombre;
    String sintoma;
    String codigo; //A a D

    Paciente (String nombre, String sintoma, String codigo) {
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.codigo = codigo;
    }

    @Override
    public int compareTo(Paciente paciente) {
        return codigo.compareToIgnoreCase(paciente.codigo);
    }

    @Override
    public String toString() {
        return nombre + " " + sintoma + " " + codigo;
    }
}
