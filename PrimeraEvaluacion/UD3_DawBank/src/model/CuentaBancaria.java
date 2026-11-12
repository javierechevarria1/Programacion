package model;

public class CuentaBancaria {
    // Constantes estáticas
    private static final double SALDO_MINIMO = -50.0;
    private static final double LIMITE_HACIENDA = 3000.0;

    // Atributos de la cuenta, iban y titular no pueden cambiar nunca
    private final String iban;
    private final String titular;
    private double saldo;

    // Atributos de la colección de movimientos
    private Movimiento[] movimientos;
    private int nMovimientosActuales;
    private final int dimensionInicial = 100;

    // Constructor
    public CuentaBancaria(String iban, String titular) {
        this.iban = iban.toUpperCase();
        this.titular = titular;
        this.saldo = 0.0;

        this.movimientos = new Movimiento[this.dimensionInicial];
        this.nMovimientosActuales = 0;
    }

    // Getters porque titular e iban son final
    public String getIban() {
        return this.iban;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getnMovimientosActuales() {
        return this.nMovimientosActuales;
    }

    // Validar el IBAN con 2 letras y 22 numeros
    public static boolean validarIban(String iban) {
        boolean resultado = false;

        if (iban != null && iban.length() == 24) {
            iban = iban.toUpperCase();
            boolean letrasCorrectas = true;
            boolean numerosCorrectos = true;

            // Comprobar que las 2 primeras posiciones son letras
            for (int i = 0; i < 2; i++) {
                char letra = iban.charAt(i);
                if (letra < 'A' || letra > 'Z') {
                    letrasCorrectas = false;
                    break;
                }
            }

            // Comprobar que las 22 siguientes posiciones son números
            for (int i = 2; i < 24; i++) {
                char numero = iban.charAt(i);
                if (numero < '0' || numero > '9') {
                    numerosCorrectos = false;
                    break;
                }
            }

            if (letrasCorrectas && numerosCorrectos) {
                resultado = true;
            }
        }

        return resultado;
    }


    // Ingresar
    public boolean ingresar(double cantidad) {
        boolean resultado = false;

        if (cantidad > 0) {
            this.saldo = this.saldo + cantidad;
            Movimiento mov = new Movimiento("Ingreso", cantidad);
            this.insertarMovimiento(mov);
            resultado = true;

            if (cantidad > LIMITE_HACIENDA) {
                System.out.println("AVISO: Notificar a hacienda");
            }
        }

        return resultado;
    }
    // Retirar
    public boolean retirar(double cantidad) {
        boolean resultado = false;

        if (cantidad > 0 && (this.saldo - cantidad) >= SALDO_MINIMO) {
            this.saldo = this.saldo - cantidad;
            Movimiento mov = new Movimiento("Retirada", cantidad);
            this.insertarMovimiento(mov);
            resultado = true;

            if (this.saldo < 0) {
                System.out.println("AVISO: Saldo negativo");
            }
            if (cantidad > LIMITE_HACIENDA) {
                System.out.println("AVISO: Notificar a hacienda");
            }
        }

        return resultado;
    }

    // Guardar el movimiento en el array hasta 100 y ampliarlo si pasa de 100
    private boolean insertarMovimiento(Movimiento mov) {
        boolean resultado = false;

        if (mov != null) {
            if (this.nMovimientosActuales < this.movimientos.length) {
                this.movimientos[this.nMovimientosActuales] = mov;
                this.nMovimientosActuales++;
                resultado = true;
            } else {
                this.ampliarDimensionMovimientos();
                this.movimientos[this.nMovimientosActuales] = mov;
                this.nMovimientosActuales++;
                resultado = true;
            }
        }

        return resultado;
    }

    // Ampliar el array si se superan los 100 movimientos iniciales
    private void ampliarDimensionMovimientos() {
        Movimiento[] movimientosAux = new Movimiento[this.movimientos.length + this.dimensionInicial];
        for (int i = 0; i < this.movimientos.length; i++) {
            movimientosAux[i] = this.movimientos[i];
        }
        this.movimientos = movimientosAux;
    }

    // Devolver los datos de la cuenta en un String
    public String infoCuentaBancaria() {
        String infoCuenta = "";
        infoCuenta += "IBAN: " + this.iban + "\n";
        infoCuenta += "Titular: " + this.titular + "\n";
        infoCuenta += "Saldo: " + this.saldo + " €\n";

        return infoCuenta;
    }

    // Devolver el historial de movimientos en un String
    public String infoMovimientosCuenta() {
        String infoMovs = "";

        if (this.nMovimientosActuales == 0) {
            infoMovs = "No hay movimientos registrados.\n";
        } else {
            for (int i = 0; i < this.nMovimientosActuales; i++) {
                infoMovs += this.movimientos[i].mostrarInfoMovimiento() + "\n";
            }
        }

        return infoMovs;
    }
}