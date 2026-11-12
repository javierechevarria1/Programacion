package Proyecto2;
import java.time.LocalDate;

public class CentroDeportivo {

    private String nombreCentro;
    private String cif;
    private LocalDate fechaApertura;
    private int maxSocios;

    private Socio[] socios;
    private int nSociosActuales;

    public CentroDeportivo(String nombreCentro, String cif, int maxSocios) {

        this.nombreCentro = nombreCentro;
        this.cif = cif;
        this.fechaApertura = LocalDate.now();
        this.maxSocios = maxSocios;

        this.socios = new Socio[maxSocios];
        this.nSociosActuales = 0;
    }

    public String getNombreCentro() {
        return this.nombreCentro;
    }

    public String getCif() {
        return this.cif;
    }

    public LocalDate getFechaApertura() {
        return this.fechaApertura;
    }

    public int getMaxSocios() {
        return this.maxSocios;
    }

    public int getNumeroSocios() {
        return this.nSociosActuales;
    }

    // Buscar socio
    public boolean buscarSocio(String dni) {

        boolean encontrado = false;

        for (int i = 0; i < this.nSociosActuales; i++) {

            if (this.socios[i].getDni().equalsIgnoreCase(dni)) {
                encontrado = true;
                break;
            }
        }

        return encontrado;
    }

    // Registrar socio
    public boolean registrarSocio(Socio s) {

        boolean registrado = false;

        if (s != null && this.nSociosActuales < this.socios.length) {

            if (!buscarSocio(s.getDni())) {

                this.socios[this.nSociosActuales] = s;
                this.nSociosActuales++;

                registrado = true;
            }
        }

        return registrado;
    }

    // Eliminar socio
    public boolean eliminarSocio(String dni) {

        boolean eliminado = false;
        int posicion = -1;

        for (int i = 0; i < this.nSociosActuales; i++) {

            if (this.socios[i].getDni().equalsIgnoreCase(dni)) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {

            for (int i = posicion; i < this.nSociosActuales - 1; i++) {
                this.socios[i] = this.socios[i + 1];
            }

            this.nSociosActuales--;
            this.socios[this.nSociosActuales] = null;

            eliminado = true;
        }

        return eliminado;
    }

    // Mostrar socios
    public String mostrarSocios() {

        String resultado = "";

        if (this.nSociosActuales > 0) {

            for (int i = 0; i < this.nSociosActuales; i++) {
                resultado += this.socios[i].mostrarInfoSocio() + "\n";
            }

        } else {
            resultado = "No hay socios registrados";
        }

        return resultado;
    }

    // Mostrar informacion del centro
    public String mostrarInfoCentro() {

        String info = "Nombre: " + this.nombreCentro
                + " \nCIF: " + this.cif
                + " \nFecha apertura: " + this.fechaApertura
                + " \nMaximo socios: " + this.maxSocios
                + " \nSocios actuales: " + this.nSociosActuales;

        return info;
    }

    // Calcular ingresos
    public double calcularIngresosMensuales() {

        double total = 0;

        for (int i = 0; i < this.nSociosActuales; i++) {
            total += this.socios[i].getCuotaMensual();
        }

        return total;
    }
}

