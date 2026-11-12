package Proyecto2;
import java.util.Scanner;
import java.time.LocalDate;

public class main10 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el nombre del centro:");
        String nombreCentro = entrada.nextLine();

        System.out.println("Introduce el CIF:");
        String cif = entrada.nextLine();

        int maxSocios;

        do {
            System.out.println("Introduce el numero maximo de socios:");
            maxSocios = entrada.nextInt();
            entrada.nextLine();

            if (maxSocios <= 0) {
                System.out.println("La cantidad debe ser mayor que 0");
            }

        } while (maxSocios <= 0);

        CentroDeportivo centro = new CentroDeportivo(nombreCentro, cif, maxSocios);

        Socio[] personas = new Socio[maxSocios];
        int nPersonas = 0;

        String opcion;

        do {

            System.out.println("MENU CENTRO DEPORTIVO");
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

                        System.out.println("Introduce el DNI:");
                        String dni = entrada.nextLine();

                        boolean repetido = centro.buscarSocio(dni);

                        for (int i = 0; i < nPersonas; i++) {
                            if (personas[i].getDni().equalsIgnoreCase(dni)) {
                                repetido = true;
                            }
                        }

                        if (dni.isEmpty()) {
                            System.out.println("El DNI no puede estar vacio");

                        } else if (repetido) {
                            System.out.println("Ya existe una persona con ese DNI");

                        } else {

                            System.out.println("Introduce la direccion:");
                            String direccion = entrada.nextLine();

                            System.out.println("Introduce la fecha de nacimiento (AAAA-MM-DD):");
                            LocalDate fecha = LocalDate.parse(entrada.nextLine());

                            System.out.println("Introduce el telefono:");
                            long telefono = entrada.nextLong();

                            System.out.println("Introduce la cuota mensual:");
                            double cuota = entrada.nextDouble();
                            entrada.nextLine();

                            if (cuota < 0) {
                                System.out.println("La cuota no puede ser negativa");

                            } else {

                                Socio persona = new Socio(nombre, dni, direccion,
                                        fecha, telefono, cuota);

                                personas[nPersonas] = persona;
                                nPersonas++;

                                System.out.println("Persona creada correctamente");
                            }
                        }

                    } else {
                        System.out.println("No hay espacio para mas personas pendientes");
                    }

                    break;

                case "2":

                    if (nPersonas > 0) {

                        System.out.println("Personas pendientes: ");

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

                            if (centro.registrarSocio(personas[posicion])) {

                                System.out.println("Socio registrado correctamente");

                                for (int i = posicion; i < nPersonas - 1; i++) {
                                    personas[i] = personas[i + 1];
                                }

                                nPersonas--;
                                personas[nPersonas] = null;

                            } else {
                                System.out.println("No se ha podido registrar el socio");
                            }

                        } else {
                            System.out.println("No existe una persona pendiente con ese DNI");
                        }

                    } else {
                        System.out.println("No hay personas pendientes");
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

                        System.out.println("Personas pendientes: ");

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
}
