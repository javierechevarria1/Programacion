package Proyecto1;
import java.time.LocalDate;

public class Empresa {

    private String NombreEmpresa;
    private String CIF;
    private LocalDate FechaFundacion;
    private int MaxTrabajadores;

    private Trabajador[] trabajador;
    private int nElementosActuales;

    public Empresa(String tipo, String cif, int Cantidad) {

        this.NombreEmpresa = tipo;
        this.CIF = cif;
        this.FechaFundacion = LocalDate.now();
        this.MaxTrabajadores = Cantidad;

        this.trabajador = new Trabajador[Cantidad];
        this.nElementosActuales = 0;
    }

    public String getNombreEmpresa() {
        return this.NombreEmpresa;
    }

    public String getCif() {
        return this.CIF;
    }

    public LocalDate getFechaFuncion() {
        return this.FechaFundacion;
    }

    public int getMaxTrabajadores() {
        return this.MaxTrabajadores;
    }

    public int getNumeroTrabajadores() {
        return this.nElementosActuales;
    }

    // Buscar trabajador por DNI
    public boolean buscarTrabajador(String dni) {

        boolean encontrado = false;

        for (int i = 0; i < this.nElementosActuales; i++) {

            if (this.trabajador[i].getDni().equalsIgnoreCase(dni)) {
                encontrado = true;
                break;
            }
        }

        return encontrado;
    }

    // Registrar trabajador en la empresa
    public boolean RegistrarTrabajador(Trabajador t1) {

        boolean isAdd = false;

        if (t1 != null && this.nElementosActuales < this.trabajador.length) {

            if (!buscarTrabajador(t1.getDni())) {

                this.trabajador[nElementosActuales] = t1;
                this.nElementosActuales++;

                isAdd = true;
            }
        }

        return isAdd;
    }

    // Eliminar trabajador por DNI
    public boolean eliminarTrabajador(String dni) {

        boolean isRemoved = false;
        int posicion = -1;

        for (int i = 0; i < this.nElementosActuales; i++) {

            if (this.trabajador[i].getDni().equalsIgnoreCase(dni)) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {

            for (int i = posicion; i < this.nElementosActuales - 1; i++) {
                this.trabajador[i] = this.trabajador[i + 1];
            }

            this.nElementosActuales--;
            this.trabajador[this.nElementosActuales] = null;

            isRemoved = true;
        }

        return isRemoved;
    }

    // Mostrar todos los trabajadores
    public String mostrarInfoTrabajador() {

        String result = "";

        if (this.nElementosActuales > 0) {

            for (int i = 0; i < this.nElementosActuales; i++) {
                result += this.trabajador[i].mostrarInfoTrabajador() + "\n";
            }

        } else {
            result = "No hay trabajadores registrados";
        }

        return result;
    }

    // Mostrar informacion de la empresa
    public String mostrarInfoEmpresa() {

        String info = "Empresa: " + this.NombreEmpresa
                + "\nCIF: " + this.CIF
                + "\nFecha fundacion: " + this.FechaFundacion
                + "\nMaximo trabajadores: " + this.MaxTrabajadores
                + "\nTrabajadores actuales: " + this.nElementosActuales;

        return info;
    }
}
