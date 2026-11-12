package model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movimiento {
    // Contador estático para dar un número único a cada movimiento
    private static int contadorTotal = 1;

    // Atributos de cada movimiento
    private final int id;
    private String fecha;
    private String tipo;
    private double cantidad;

    // Constructor
    public Movimiento(String tipo, double cantidad) {
        this.id = contadorTotal;
        contadorTotal++;

        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.fecha = hoy.format(formato);

        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    // Consultar los datos
    public int getId() {
        return this.id;
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getTipo() {
        return this.tipo;
    }

    public double getCantidad() {
        return this.cantidad;
    }

    // Metodo mostrarInfoMovimiento() para mostrar toda la información de ese movimiento
    public String mostrarInfoMovimiento() {
        String infoMovimiento = "";
        infoMovimiento += "ID: " + this.id + "\n";
        infoMovimiento += "Fecha: " + this.fecha + "\n";
        infoMovimiento += "Tipo: " + this.tipo + "\n";
        infoMovimiento += "Cantidad: " + this.cantidad + " €\n";

        return infoMovimiento;
    }
}
