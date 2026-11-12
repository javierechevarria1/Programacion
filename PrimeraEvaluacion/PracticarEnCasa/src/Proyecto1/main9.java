package Proyecto1;
import java.util.Scanner;
import java.time.LocalDate;

public class main9 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce el nombre de la empresa:");
        String nombreEmpresa = entrada.nextLine();

        System.out.println("Introduce el CIF:");
        String cif = entrada.nextLine();

        int cantidad;

        do {
            System.out.println("Introduce la cantidad maxima de trabajadores:");
            cantidad = entrada.nextInt();
            entrada.nextLine();

            if (cantidad <= 0) {
                System.out.println("La cantidad debe ser mayor que 0");
            }

        } while (cantidad <= 0);

        Empresa Empresa1 = new Empresa(nombreEmpresa, cif, cantidad);

        // Personas creadas pero no registradas
        Trabajador[] personas = new Trabajador[cantidad];
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

                        System.out.println("Introduce el DNI:");
                        String dni = entrada.nextLine();

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

                            System.out.println("Introduce la fecha de nacimiento (AAAA-MM-DD):");
                            LocalDate fecha = LocalDate.parse(entrada.nextLine());

                            System.out.println("Introduce el numero de Seguridad Social:");
                            long numeroSS = entrada.nextLong();
                            entrada.nextLine();

                            Trabajador persona = new Trabajador(
                                    nombre, direccion, dni, fecha, numeroSS
                            );

                            personas[nPersonas] = persona;
                            nPersonas++;

                            System.out.println("Persona creada correctamente");
                        }

                    } else {
                        System.out.println("No hay espacio para mas personas pendientes");
                    }

                    break;

                case "2":

                    if (nPersonas > 0) {

                        System.out.println("Personas pendientes de registrar: ");

                        for (int i = 0; i < nPersonas; i++) {
                            System.out.println(personas[i].mostrarInfoTrabajador());
                        }

                        System.out.println("Introduce el DNI de la persona que quieres registrar:");
                        String dniRegistrar = entrada.nextLine();

                        int posicion = -1;

                        for (int i = 0; i < nPersonas; i++) {

                            if (personas[i].getDni().equalsIgnoreCase(dniRegistrar)) {
                                posicion = i;
                                break;
                            }
                        }

                        if (posicion != -1) {

                            if (Empresa1.RegistrarTrabajador(personas[posicion])) {

                                System.out.println("Trabajador registrado correctamente");

                                for (int i = posicion; i < nPersonas - 1; i++) {
                                    personas[i] = personas[i + 1];
                                }

                                nPersonas--;
                                personas[nPersonas] = null;

                            } else {
                                System.out.println("No se ha podido registrar el trabajador");
                            }

                        } else {
                            System.out.println("No existe una persona pendiente con ese DNI");
                        }

                    } else {
                        System.out.println("No hay personas pendientes de registrar");
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

                        System.out.println("Personas pendientes: ");

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
}
