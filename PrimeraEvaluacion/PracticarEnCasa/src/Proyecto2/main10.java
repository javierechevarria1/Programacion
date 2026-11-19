
package Proyecto2;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class main10 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el nombre del centro:");
        String nombreCentro = entrada.nextLine();

        String cif = leerPatron(entrada, "Introduce el CIF:", "[A-Z][0-9]{10}");

        LocalDate fechaApertura = leerFecha(entrada, "Introduce la fecha de apertura (dd/MM/aaaa):");

        int maxSocios;

        do {
            System.out.println("Introduce el numero maximo de socios:");
            maxSocios = Integer.parseInt(leerPatron(entrada, "", "[0-9]{1,9}"));

            if (maxSocios <= 0) {
                System.out.println("La cantidad debe ser mayor que 0");
            }

        } while (maxSocios <= 0);

        CentroDeportivo centro = new CentroDeportivo(nombreCentro, cif, fechaApertura, maxSocios);

        // Personas pendientes de registrar
        Socio[] personas = new Socio[maxSocios];
        int nPersonas = 0;

        String opcion;

        do {

            System.out.println("\nMENU CENTRO DEPORTIVO");
            System.out.println("1. Crear persona");
            System.out.println("2. Registrar socio");
            System.out.println("3. Mostrar informacion del centro");
            System.out.println("4. Mostrar numero de socios");
            System.out.println("5. Mostrar todos los socios");
            System.out.println("6. Buscar socio por DNI");
            System.out.println("7. Eliminar socio");
            System.out.println("8. Eliminar persona sin registrar");
            System.out.println("9. Calcular ingresos mensuales");
            System.out.println("10. Salir");
            System.out.println("Elige una opcion:");

            opcion = entrada.nextLine();

            switch (opcion) {

                case "1":

                    if (nPersonas < personas.length) {

                        System.out.println("Introduce el nombre:");
                        String nombre = entrada.nextLine();

                        String dni = leerPatron(entrada, "Introduce el DNI:", "[0-9]{8}[A-Z]");

                        boolean repetido = centro.buscarSocio(dni);

                        for (int i = 0; i < nPersonas; i++) {

                            if (personas[i].getDni().equalsIgnoreCase(dni)) {
                                repetido = true;
                            }
                        }

                        if (repetido) {

                            System.out.println("Ya existe una persona con ese DNI");

                        } else {

                            System.out.println("Introduce la direccion:");
                            String direccion = entrada.nextLine();

                            LocalDate fecha = leerFecha(entrada, "Introduce la fecha de nacimiento (dd/MM/aaaa):");

                            Socio persona = new Socio(nombre, dni, direccion, fecha);

                            personas[nPersonas] = persona;
                            nPersonas++;

                            System.out.println("Persona creada correctamente");
                        }

                    } else {
                        System.out.println("No hay espacio para mas personas pendientes");
                    }

                    break;

                case "2":

                    if (centro.getNumeroSocios() >= centro.getMaxSocios()) {
                        System.out.println("No hay espacio en el centro deportivo");
                        break;
                    }

                    System.out.println("1. Registrar persona existente");
                    System.out.println("2. Registrar socio nuevo");

                    String registro = entrada.nextLine();

                    if (registro.equals("1")) {

                        if (nPersonas == 0) {
                            System.out.println("No hay personas pendientes");
                            break;
                        }

                        System.out.println("Personas pendientes:");

                        for (int i = 0; i < nPersonas; i++) {
                            System.out.println(personas[i].mostrarInfoSocio());
                        }

                        System.out.println("Introduce el DNI de la persona:");
                        String dniRegistrar = entrada.nextLine();

                        int posicion = -1;

                        for (int i = 0; i < nPersonas; i++) {

                            if (personas[i].getDni().equalsIgnoreCase(dniRegistrar)) {
                                posicion = i;
                                break;
                            }
                        }

                        if (posicion != -1) {

                            Socio p = personas[posicion];

                            long telefono = Long.parseLong(leerPatron(entrada, "Introduce el telefono:", "[0-9]{9}"));

                            double cuota = leerCuota(entrada);

                            Socio nuevo = new Socio(
                                    p.getNombre(),
                                    p.getDni(),
                                    p.getDireccion(),
                                    p.getFechaNacimiento(),
                                    telefono,
                                    cuota
                            );

                            if (centro.registrarSocio(nuevo)) {

                                for (int i = posicion; i < nPersonas - 1; i++) {
                                    personas[i] = personas[i + 1];
                                }

                                nPersonas--;
                                personas[nPersonas] = null;

                                System.out.println("Socio registrado correctamente");

                            } else {
                                System.out.println("No se ha podido registrar el socio");
                            }

                        } else {
                            System.out.println("No existe una persona con ese DNI");
                        }

                    } else if (registro.equals("2")) {

                        System.out.println("Introduce el nombre:");
                        String nombreSocio = entrada.nextLine();

                        String dniSocio = leerPatron(entrada, "Introduce el DNI:", "[0-9]{8}[A-Z]");

                        boolean duplicado = centro.buscarSocio(dniSocio);

                        for (int i = 0; i < nPersonas; i++) {

                            if (personas[i].getDni().equalsIgnoreCase(dniSocio)) {
                                duplicado = true;
                            }
                        }

                        if (!duplicado) {

                            System.out.println("Introduce la direccion:");
                            String direccionSocio = entrada.nextLine();

                            LocalDate fechaSocio = leerFecha(entrada, "Introduce la fecha de nacimiento (dd/MM/aaaa):");

                            long telefonoSocio = Long.parseLong(leerPatron(entrada, "Introduce el telefono:", "[0-9]{9}"));

                            double cuotaSocio = leerCuota(entrada);

                            Socio nuevo = new Socio(
                                    nombreSocio,
                                    dniSocio,
                                    direccionSocio,
                                    fechaSocio,
                                    telefonoSocio,
                                    cuotaSocio
                            );

                            if (centro.registrarSocio(nuevo)) {
                                System.out.println("Socio registrado correctamente");
                            } else {
                                System.out.println("No se ha podido registrar el socio");
                            }

                        } else {
                            System.out.println("Ya existe una persona con ese DNI");
                        }

                    } else {
                        System.out.println("Opcion no valida");
                    }

                    break;

                case "3":

                    System.out.println(centro.mostrarInfoCentro());

                    break;

                case "4":

                    System.out.println("Numero de socios: " + centro.getNumeroSocios());

                    break;

                case "5":

                    System.out.println(centro.mostrarSocios());

                    break;

                case "6":

                    System.out.println("Introduce el DNI del socio:");
                    String dniBuscar = entrada.nextLine();

                    if (centro.buscarSocio(dniBuscar)) {
                        System.out.println("El socio esta registrado");
                    } else {
                        System.out.println("No existe un socio con ese DNI");
                    }

                    break;

                case "7":

                    System.out.println("Introduce el DNI del socio a eliminar:");
                    String dniEliminar = entrada.nextLine();

                    if (centro.eliminarSocio(dniEliminar)) {
                        System.out.println("Socio eliminado correctamente");
                    } else {
                        System.out.println("No se ha encontrado el socio");
                    }

                    break;

                case "8":

                    if (nPersonas > 0) {

                        System.out.println("Personas pendientes:");

                        for (int i = 0; i < nPersonas; i++) {
                            System.out.println(personas[i].mostrarInfoSocio());
                        }

                        System.out.println("Introduce el DNI de la persona a eliminar:");
                        String dniPersona = entrada.nextLine();

                        int posicionEliminar = -1;

                        for (int i = 0; i < nPersonas; i++) {

                            if (personas[i].getDni().equalsIgnoreCase(dniPersona)) {
                                posicionEliminar = i;
                                break;
                            }
                        }

                        if (posicionEliminar != -1) {

                            for (int i = posicionEliminar; i < nPersonas - 1; i++) {
                                personas[i] = personas[i + 1];
                            }

                            nPersonas--;
                            personas[nPersonas] = null;

                            System.out.println("Persona eliminada correctamente");

                        } else {
                            System.out.println("No se ha encontrado la persona");
                        }

                    } else {
                        System.out.println("No hay personas pendientes");
                    }

                    break;

                case "9":

                    System.out.println("Ingresos mensuales: "
                            + centro.calcularIngresosMensuales() + " euros");

                    break;

                case "10":

                    System.out.println("Saliendo del programa, Adios");

                    break;

                default:

                    System.out.println("Opcion no valida");

                    break;
            }

        } while (!opcion.equals("10"));

        entrada.close();
    }

    // Leer y validar un texto
    public static String leerPatron(Scanner entrada, String mensaje, String patron) {

        String texto;

        do {

            System.out.println(mensaje);
            texto = entrada.nextLine();

            if (!texto.matches(patron)) {
                System.out.println("Formato incorrecto");
            }

        } while (!texto.matches(patron));

        return texto;
    }

    // Leer y validar una fecha
    public static LocalDate leerFecha(Scanner entrada, String mensaje) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(java.time.format.ResolverStyle.STRICT);

        LocalDate fecha = null;

        do {

            System.out.println(mensaje);

            try {
                fecha = LocalDate.parse(entrada.nextLine(), formato);

            } catch (DateTimeParseException e) {
                System.out.println("Fecha incorrecta");
            }

        } while (fecha == null);

        return fecha;
    }

    // Leer y validar cuota mensual
    public static double leerCuota(Scanner entrada) {

        double cuota;

        do {

            System.out.println("Introduce la cuota mensual:");

            if (entrada.hasNextDouble()) {
                cuota = entrada.nextDouble();
            } else {
                cuota = -1;
            }

            entrada.nextLine();

            if (cuota < 0 || !Double.isFinite(cuota)) {
                System.out.println("Cuota incorrecta");
            }

        } while (cuota < 0 || !Double.isFinite(cuota));

        return cuota;
    }
}
