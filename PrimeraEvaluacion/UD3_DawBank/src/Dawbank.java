import java.util.Scanner;
import model.CuentaBancaria;

public class Dawbank {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String iban = "";
        String titular = "";
        boolean datosValidos = false;

        System.out.println("BIENVENIDO A DAWBANK");

        // Pedir datos hasta que sean válidos para crear la cuenta
        do {
            System.out.println("Introduce el IBAN (2 letras y 22 numeros):");
            iban = scan.nextLine();

            System.out.println("Introduce el nombre del titular:");
            titular = scan.nextLine();

            if (CuentaBancaria.validarIban(iban) && titular != null && !titular.isEmpty()) {
                datosValidos = true;
            } else {
                System.out.println("Error: IBAN incorrecto o titular vacio. Intentalo de nuevo.");
            }
        } while (!datosValidos);

        // Creamos el objeto CuentaBancaria una vez validados los datos
        CuentaBancaria cuenta = new CuentaBancaria(iban, titular);
        System.out.println("Cuenta bancaria creada con exito.");

        int menu = 0;

        // Menú principal
        do {
            System.out.println("1. Datos de la cuenta");
            System.out.println("2. IBAN");
            System.out.println("3. Titular");
            System.out.println("4. Saldo");
            System.out.println("5. Ingreso");
            System.out.println("6. Retirada");
            System.out.println("7. Movimientos");
            System.out.println("8. Salir");
            System.out.println("Elige una opcion:");

            menu = scan.nextInt();
            scan.nextLine();

            switch (menu) {
                case 1:
                    System.out.println(cuenta.infoCuentaBancaria());
                    break;

                case 2:
                    System.out.println("IBAN: " + cuenta.getIban());
                    break;

                case 3:
                    System.out.println("Titular: " + cuenta.getTitular());
                    break;

                case 4:
                    System.out.println("Saldo disponible: " + cuenta.getSaldo() + " €");
                    break;

                case 5:
                    System.out.println("Introduce la cantidad a ingresar:");
                    double ingreso = scan.nextDouble();
                    scan.nextLine();
                    if (cuenta.ingresar(ingreso)) {
                        System.out.println("Ingreso realizado correctamente.");
                    } else {
                        System.out.println("Error: La cantidad a ingresar debe ser mayor que 0.");
                    }
                    break;

                case 6:
                    System.out.println("Introduce la cantidad a retirar:");
                    double retirada = scan.nextDouble();
                    scan.nextLine();
                    if (cuenta.retirar(retirada)) {
                        System.out.println("Retirada realizada correctamente.");
                    } else {
                        System.out.println("Error: Cantidad invalida o saldo inferior a -50 €.");
                    }
                    break;

                case 7:
                    System.out.println("HISTORIAL DE MOVIMIENTOS");
                    System.out.println(cuenta.infoMovimientosCuenta());
                    break;

                case 8:
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Opcion no valida.");
                    break;
            }

        } while (menu != 8);

        scan.close();
    }
}

