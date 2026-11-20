import java.time.LocalDate;

public class Cliente {
    private String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula[] peliculasAlquiladas;


// Constructor
public Cliente(String dni, String nombre, String numSocio,
               String direccion, LocalDate fechaNacimiento) {

    this.dni = dni;
    this.nombre = nombre;
    this.numSocio = numSocio;
    this.direccion = direccion;
    this.fechaNacimiento = fechaNacimiento;
    this.fechaBaja = null;
    this.peliculasAlquiladas = new Pelicula[100];
}

// Getters
public String getDni() {
    return this.dni;
}

public String getNombre() {
    return this.nombre;
}

public String getNumSocio() {
    return this.numSocio;
}

public String getDireccion() {
    return this.direccion;
}

public LocalDate getFechaNacimiento() {
    return this.fechaNacimiento;
}

public LocalDate getFechaBaja() {
    return this.fechaBaja;
}

public Pelicula[] getPeliculasAlquiladas() {
    return this.peliculasAlquiladas;
}

// Setters
public void setNombre(String nombre) {
    this.nombre = nombre;
}

public void setDireccion(String direccion) {
    this.direccion = direccion;
}

public void setFechaBaja(LocalDate fechaBaja) {
    this.fechaBaja = fechaBaja;
}

// Metodo mostrarInfoCliente
public void mostrarInfoCliente() {
    System.out.println("DNI: " + this.dni);
    System.out.println("Nombre: " + this.nombre);
    System.out.println("Numero de socio: " + this.numSocio);
    System.out.println("Direccion: " + this.direccion);
    System.out.println("Fecha de nacimiento: " + this.fechaNacimiento);
    System.out.println("Fecha de baja: " + this.fechaBaja);
}

//Metodo mostrarPeliculasAlquiladas
public void mostrarPeliculasAlquiladas() {
    for (int i = 0; i < this.peliculasAlquiladas.length; i++) {
        if (this.peliculasAlquiladas[i] != null) {
            this.peliculasAlquiladas[i].mostrarInfoPelicula();
        }
    }
}

// Metodo validarDni
public static boolean validarDni(String dni) {
    if (dni == null || !dni.matches("[0-9]{8}[A-Z]")) {
        return false;
    }

    String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    int numero = Integer.parseInt(dni.substring(0, 8));
    char letra = letras.charAt(numero % 23);

    return dni.charAt(8) == letra;
}

// Metodo esMayorDeEdad
public static boolean esMayorDeEdad(LocalDate fechaNacimiento) {
    return fechaNacimiento != null &&
            !fechaNacimiento.plusYears(18).isAfter(LocalDate.now());
}

// Metodo registrarPeliculaAlquilada
public boolean registrarPeliculaAlquilada(Pelicula p) {
    for (int i = 0; i < this.peliculasAlquiladas.length; i++) {
        if (this.peliculasAlquiladas[i] == null) {
            this.peliculasAlquiladas[i] = p;
            return true;
        }
    }
    return false;
}
}