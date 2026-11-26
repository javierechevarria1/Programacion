import java.time.LocalDate;
import java.time.LocalDateTime;

// Clase pelicula
public class Pelicula {
    private String cod;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;


// Constructor
public Pelicula(String cod, String titulo, Genero genero) {
    this.cod = cod;
    this.titulo = titulo;
    this.genero = genero;
    this.fechaRegistro = LocalDate.now();
    this.fechaBaja = null;
    this.fechaAlquiler = null;
    this.isAlquilada = false;
}

// Getters
public String getCod() {
    return this.cod;
}

// Setters
        public String getTitulo() {
        return this.titulo;
        }

        public Genero getGenero() {
            return this.genero;
        }

        public LocalDate getFechaRegistro() {
            return this.fechaRegistro;
        }

        public LocalDate getFechaBaja() {
            return this.fechaBaja;
        }

        public LocalDateTime getFechaAlquiler() {
            return this.fechaAlquiler;
        }

        public boolean isAlquilada() {
            return this.isAlquilada;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public void setGenero(Genero genero) {
            this.genero = genero;
        }

        public void setFechaBaja(LocalDate fechaBaja) {
            this.fechaBaja = fechaBaja;
        }

        public void setFechaAlquiler(LocalDateTime fechaAlquiler) {
            this.fechaAlquiler = fechaAlquiler;
        }

        public void setAlquilada(boolean alquilada) {
            this.isAlquilada = alquilada;
        }

// Metodo mostrarInfoPelicula
public void mostrarInfoPelicula() {
    System.out.println("Codigo: " + this.cod);
    System.out.println("Titulo: " + this.titulo);
    System.out.println("Genero: " + this.genero);
    System.out.println("Fecha de registro: " + this.fechaRegistro);
    System.out.println("Fecha de baja: " + this.fechaBaja);
    System.out.println("Fecha de alquiler: " + this.fechaAlquiler);
    System.out.println("Alquilada: " + this.isAlquilada);
}
}