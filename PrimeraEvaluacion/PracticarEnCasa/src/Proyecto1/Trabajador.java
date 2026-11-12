package Proyecto1;import java.time.LocalDate;

public class Trabajador {

    private String nombre;
    private String Direccion;
    private String DNI;
    private LocalDate FechaNacimiento;
    private long NumeroSS;

    public Trabajador(String nombre, String Direccion, String DNI, LocalDate FechaNacimiento, long NumeroSS) {

        this.nombre = nombre;
        this.Direccion = Direccion;
        this.DNI = DNI;
        this.FechaNacimiento = FechaNacimiento;
        this.NumeroSS = NumeroSS;
    }

    public String getnombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.Direccion;
    }

    public String getDni() {
        return this.DNI;
    }

    public LocalDate getFechaNacimiento() {
        return this.FechaNacimiento;
    }

    public long getNumeroSS() {
        return this.NumeroSS;
    }

    public String mostrarInfoTrabajador() {

        String info = "Nombre: " + this.nombre
                + ", Direccion: " + this.Direccion
                + ", DNI: " + this.DNI
                + ", Fecha nacimiento: " + this.FechaNacimiento
                + ", Numero SS: " + this.NumeroSS;

        return info;
    }
}
