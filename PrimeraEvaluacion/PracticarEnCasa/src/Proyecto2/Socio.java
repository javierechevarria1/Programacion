
package Proyecto2;

import java.time.LocalDate;

public class Socio {

    private String nombre;
    private String dni;
    private String direccion;
    private LocalDate fechaNacimiento;
    private long telefono;
    private double cuotaMensual;

    // Constructor para crear una persona
    public Socio(String nombre, String dni, String direccion, LocalDate fechaNacimiento) {

        this(nombre, dni, direccion, fechaNacimiento, 0, 0);
    }

    // Constructor para crear un socio
    public Socio(String nombre, String dni, String direccion, LocalDate fechaNacimiento, long telefono, double cuotaMensual) {

        this.nombre = nombre;
        this.dni = dni;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.cuotaMensual = cuotaMensual;
    }

    // Getters
    public String getNombre() {
        return this.nombre;
    }

    public String getDni() {
        return this.dni;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public LocalDate getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public long getTelefono() {
        return this.telefono;
    }

    public double getCuotaMensual() {
        return this.cuotaMensual;
    }

    // Mostrar informacion del socio
    public String mostrarInfoSocio() {

        String info = "Nombre: " + this.nombre
                + "\nDNI: " + this.dni
                + "\nDireccion: " + this.direccion
                + "\nFecha nacimiento: " + this.fechaNacimiento
                + "\nTelefono: " + this.telefono
                + "\nCuota mensual: " + this.cuotaMensual;

        return info;
    }
}
