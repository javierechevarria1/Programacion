import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Duration;

public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula[] peliculasRegistradas;
    private Cliente[] clientesRegistrados;


// Constructor
public VideoDaw(String cif, String direccion) {
    this.cif = cif;
    this.direccion = direccion;
    this.fechaAlta = LocalDate.now();
    this.peliculasRegistradas = new Pelicula[100];
    this.clientesRegistrados = new Cliente[100];
}

// Getters
public String getCif() {
    return this.cif;
}

public String getDireccion() {
    return this.direccion;
}

public LocalDate getFechaAlta() {
    return this.fechaAlta;
}

public Pelicula[] getPeliculasRegistradas() {
    return this.peliculasRegistradas;
}

public Cliente[] getClientesRegistrados() {
    return this.clientesRegistrados;
}

// Setters
public void setDireccion(String direccion) {
    this.direccion = direccion;
}

// Metodo mostrarInfoVideoClub
public void mostrarInfoVideoClub() {
    System.out.println("CIF: " + this.cif);
    System.out.println("Direccion: " + this.direccion);
    System.out.println("Fecha de alta: " + this.fechaAlta);
}

// Metodo mostrarPeliculasRegistradas
public void mostrarPeliculasRegistradas() {
    for (int i = 0; i < this.peliculasRegistradas.length; i++) {
        if (this.peliculasRegistradas[i] != null &&
                this.peliculasRegistradas[i].getFechaBaja() == null) {

            this.peliculasRegistradas[i].mostrarInfoPelicula();
        }
    }
}

// Metodo mostrarClientesRegistrados
public void mostrarClientesRegistrados() {
    for (int i = 0; i < this.clientesRegistrados.length; i++) {
        if (this.clientesRegistrados[i] != null &&
                this.clientesRegistrados[i].getFechaBaja() == null) {

            this.clientesRegistrados[i].mostrarInfoCliente();
        }
    }
}

// Metodo registrarPelicula
public boolean registrarPelicula(Pelicula p) {

    for (int i = 0; i < this.peliculasRegistradas.length; i++) {
        if (this.peliculasRegistradas[i] != null &&
                this.peliculasRegistradas[i].getCod().equals(p.getCod())) {
            return false;
        }
    }

    for (int i = 0; i < this.peliculasRegistradas.length; i++) {
        if (this.peliculasRegistradas[i] == null) {
            this.peliculasRegistradas[i] = p;
            return true;
        }
    }

    return false;
}

// Metodo registrarCliente
public boolean registrarCliente(Cliente c) {

    if (!Cliente.validarDni(c.getDni()) ||
            !Cliente.esMayorDeEdad(c.getFechaNacimiento())) {
        return false;
    }

    for (int i = 0; i < this.clientesRegistrados.length; i++) {
        if (this.clientesRegistrados[i] != null &&
                (this.clientesRegistrados[i].getDni().equals(c.getDni()) ||
                        this.clientesRegistrados[i].getNumSocio().equals(c.getNumSocio()))) {
            return false;
        }
    }

    for (int i = 0; i < this.clientesRegistrados.length; i++) {
        if (this.clientesRegistrados[i] == null) {
            this.clientesRegistrados[i] = c;
            return true;
        }
    }

    return false;
}

// Metodo alquilarPelicula
public boolean alquilarPelicula(Pelicula p, Cliente c) {

    if (p == null || c == null) {
        return false;
    }

    if (p.isAlquilada() || p.getFechaBaja() != null ||
            c.getFechaBaja() != null) {
        return false;
    }

    if (c.registrarPeliculaAlquilada(p)) {
        p.setAlquilada(true);
        p.setFechaAlquiler(LocalDateTime.now());
        return true;
    }

    return false;
}

// Metodo devolverPelicula
public boolean devolverPelicula(Pelicula p, Cliente c) {

    if (p == null || c == null || !p.isAlquilada()) {
        return false;
    }

    boolean encontrada = false;

    for (int i = 0; i < c.getPeliculasAlquiladas().length; i++) {
        if (c.getPeliculasAlquiladas()[i] == p) {
            encontrada = true;
        }
    }

    if (!encontrada) {
        return false;
    }

    Duration tiempo = Duration.between(
            p.getFechaAlquiler(), LocalDateTime.now()
    );

    if (tiempo.compareTo(Duration.ofHours(48)) > 0) {
        System.out.println("Advertencia: has superado las 48 horas.");
    }

    p.setAlquilada(false);
    p.setFechaAlquiler(null);

    return true;
}

// Metodo darBajaCliente
public boolean darBajaCliente(Cliente c) {

    if (c == null || c.getFechaBaja() != null) {
        return false;
    }

    c.setFechaBaja(LocalDate.now());

    return true;
}
}