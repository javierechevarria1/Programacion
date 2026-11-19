
package Proyecto1;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class main9 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el nombre de la empresa:");
        String nombreEmpresa = entrada.nextLine();

        String cif = leerPatron(entrada, "Introduce el CIF:", "[A-Z][0-9]{10}");

        LocalDate fechaFundacion = leerFecha(entrada, "Introduce la fecha de fundacion (dd/MM/aaaa):");

        int cantidad;

        do {
            System.out.println("Introduce la cantidad maxima de trabajadores:");
            cantidad = Integer.parseInt(leerPatron(entrada, "", "[0-9]{1,9}"));

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que 0");
            }

        } while (cantidad <= 0);

        Empresa Empresa1 = new Empresa(nombreEmpresa, cif, fechaFundacion, cantidad);

        // Personas creadas pero no registradas
        Trabajador[] personas = new Trabajador[100];
        int nPersonas = 0;

        String opcion;

        do {

            System.out.println("\nMENU EMPRESA");
            System.out.println("1. Crear persona");
            System.out.println("2. Registrar trabajador en la empresa");
            System.out.println("3. Mostrar informacion de la empresa");
            System.out.println("4. Mostrar numero de trabajadores");
            System.out.println("5. Mostrar trabajadores");
            System.out.println("6. Eliminar trabajador");
            System.out.println("7. Eliminar persona sin registrar");
            System.out.println("8. Salir");
            System.out.println("Elige una opcion:");

            opcion = entrada.nextLine();

            switch (opcion) {

                case "1":

                    if (nPersonas < personas.length) {

                        System.out.println("Introduce el nombre:");
                        String nombre = entrada.nextLine();

                        System.out.println("Introduce la direccion:");
                        String direccion = entrada.nextLine();

                        String dni = leerPatron(entrada, "Introduce el DNI:", "[0-9]{8}[A-Z]");

                        boolean repetido = Empresa1.buscarTrabajador(dni);

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

                            LocalDate fecha = leerFecha(entrada, "Introduce la fecha de nacimiento (dd/MM/aaaa):");

                            Trabajador persona = new Trabajador(nombre, direccion, dni, fecha);

                            personas[nPersonas] = persona;
                            nPersonas++;

                            System.out.println("Persona creada correctamente");
                        }

                    } else {
                        System.out.println("No hay espacio para mas personas pendientes");
                    }

                    break;

                case "2":

                    if (Empresa1.getNumeroTrabajadores() >= Empresa1.getMaxTrabajadores()) {
                        System.out.println("No hay espacio en la empresa");
                        break;
                    }

                    System.out.println("1. Registrar persona existente");
                    System.out.println("2. Registrar trabajador nuevo");

                    String registro = entrada.nextLine();

                    if (registro.equals("1")) {

                        for (int i = 0; i < nPersonas; i++) {
                            System.out.println(personas[i].mostrarInfoTrabajador());
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

                            Trabajador p = personas[posicion];

                            long ss = Long.parseLong(leerPatron(entrada, "Introduce el numero SS (10 digitos):", "[0-9]{10}"));

                            Trabajador nuevo = new Trabajador(
                                    p.getnombre(),
                                    p.getDireccion(),
                                    p.getDni(),
                                    p.getFechaNacimiento(),
                                    ss
                            );

                            if (Empresa1.RegistrarTrabajador(nuevo)) {

                                for (int i = posicion; i < nPersonas - 1; i++) {
                                    personas[i] = personas[i + 1];
                                }

                                nPersonas--;
                                personas[nPersonas] = null;

                                System.out.println("Trabajador registrado correctamente");

                            } else {
                                System.out.println("No se ha podido registrar");
                            }

                        } else {
                            System.out.println("No existe una persona con ese DNI");
                        }

                    } else if (registro.equals("2")) {

                        System.out.println("Introduce el nombre:");
                        String nombreTrabajador = entrada.nextLine();

                        System.out.println("Introduce la direccion:");
                        String direccionTrabajador = entrada.nextLine();

                        String dniTrabajador = leerPatron(entrada, "Introduce el DNI:", "[0-9]{8}[A-Z]");

                        boolean duplicado = Empresa1.buscarTrabajador(dniTrabajador);

                        for (int i = 0; i < nPersonas; i++) {

                            if (personas[i].getDni().equalsIgnoreCase(dniTrabajador)) {
                                duplicado = true;
                            }
                        }

                        if (!duplicado) {

                            LocalDate fecha = leerFecha(entrada, "Introduce la fecha de nacimiento (dd/MM/aaaa):");

                            long ss = Long.parseLong(leerPatron(entrada, "Introduce el numero SS (10 digitos):", "[0-9]{10}"));

                            Trabajador nuevo = new Trabajador(
                                    nombreTrabajador,
                                    direccionTrabajador,
                                    dniTrabajador,
                                    fecha,
                                    ss
                            );

                            if (Empresa1.RegistrarTrabajador(nuevo)) {
                                System.out.println("Trabajador registrado correctamente");
                            } else {
                                System.out.println("No se ha podido registrar");
                            }

                        } else {
                            System.out.println("Ya existe una persona con ese DNI");
                        }

                    } else {
                        System.out.println("Opcion no valida");
                    }

                    break;

                case "3":

                    System.out.println(Empresa1.mostrarInfoEmpresa());

                    break;

                case "4":

                    System.out.println("Numero de trabajadores actuales: "
                            + Empresa1.getNumeroTrabajadores());

                    break;

                case "5":

                    System.out.println(Empresa1.mostrarInfoTrabajador());

                    break;

                case "6":

                    System.out.println("Introduce el DNI del trabajador que quieres eliminar:");
                    String dniEliminar = entrada.nextLine();

                    if (Empresa1.eliminarTrabajador(dniEliminar)) {
                        System.out.println("Trabajador eliminado correctamente");
                    } else {
                        System.out.println("No se ha encontrado el trabajador");
                    }

                    break;

                case "7":

                    if (nPersonas > 0) {

                        System.out.println("Personas pendientes:");

                        for (int i = 0; i < nPersonas; i++) {
                            System.out.println(personas[i].mostrarInfoTrabajador());
                        }

                        System.out.println("Introduce el DNI de la persona que quieres eliminar:");
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
                        System.out.println("No hay personas pendientes para eliminar");
                    }

                    break;

                case "8":

                    System.out.println("Saliendo del programa, Adios");

                    break;

                default:

                    System.out.println("Opcion no valida");

                    break;
            }

        } while (!opcion.equals("8"));

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
}
