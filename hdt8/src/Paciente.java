public class Paciente implements Comparable<Paciente> {
    String nombre;
    String sintoma;
    String codigo; //A a E

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
