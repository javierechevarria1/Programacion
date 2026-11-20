import java.util.Scanner;
import java.time.LocalDate;

public class GestionVideoDaw {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VideoDaw videoClub = null;

        int opcion;

        do {
            System.out.println("VIDEODAW");
            System.out.println("1. Crear y registrar videoclub");
            System.out.println("2. Registrar pelicula");
            System.out.println("3. Crear y registrar cliente");
            System.out.println("4. Alquilar pelicula");
            System.out.println("5. Devolver pelicula");
            System.out.println("6. Dar de baja cliente");
            System.out.println("7. Dar de baja pelicula");
            System.out.println("8. Salir");
            System.out.print("Introduce una opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("Debes introducir un numero.");
                sc.nextLine();
                opcion = 0;
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion >= 2 && opcion <= 7 && videoClub == null) {
                System.out.println("Primero debes crear un videoclub.");
                continue;
            }

            switch (opcion) {

                // Crear y registrar videoclub
                case 1: {

                    if (videoClub != null) {
                        System.out.println("Ya existe un videoclub registrado.");
                        break;
                    }

                    System.out.print("Introduce el CIF: ");
                    String cif = sc.nextLine().toUpperCase();

                    if (!cif.matches("[ABCDEFGHJNPQRSUVW][0-9]{7}[0-9A-J]")) {
                        System.out.println("CIF incorrecto.");
                        break;
                    }

                    System.out.print("Introduce la direccion: ");
                    String direccion = sc.nextLine();

                    videoClub = new VideoDaw(cif, direccion);

                    System.out.println("Videoclub registrado correctamente.");
                    videoClub.mostrarInfoVideoClub();

                    break;
                }

                // Registrar pelicula
                case 2: {

                    System.out.print("Introduce el codigo: ");
                    String cod = sc.nextLine();

                    System.out.print("Introduce el titulo: ");
                    String titulo = sc.nextLine();

                    Genero[] generos = Genero.values();

                    for (int i = 0; i < generos.length; i++) {
                        System.out.println((i + 1) + ". " + generos[i]);
                    }

                    System.out.print("Selecciona el genero: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Genero incorrecto.");
                        sc.nextLine();
                        break;
                    }

                    int opcionGenero = sc.nextInt();
                    sc.nextLine();

                    if (opcionGenero < 1 || opcionGenero > generos.length) {
                        System.out.println("Genero incorrecto.");
                        break;
                    }

                    Genero genero = generos[opcionGenero - 1];

                    Pelicula p = new Pelicula(cod, titulo, genero);

                    if (videoClub.registrarPelicula(p)) {
                        System.out.println("Pelicula registrada correctamente.");
                    } else {
                        System.out.println("No se ha podido registrar la pelicula.");
                    }

                    break;
                }

                // Crear y registrar cliente
                case 3: {

                    System.out.print("Introduce el DNI: ");
                    String dni = sc.nextLine().toUpperCase();

                    if (!Cliente.validarDni(dni)) {
                        System.out.println("DNI incorrecto.");
                        break;
                    }

                    System.out.print("Introduce el nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Introduce el numero de socio: ");
                    String numSocio = sc.nextLine();

                    System.out.print("Introduce la direccion: ");
                    String direccion = sc.nextLine();

                    System.out.print("Introduce la fecha de nacimiento (AAAA-MM-DD): ");
                    LocalDate fechaNacimiento;

                    try {
                        fechaNacimiento = LocalDate.parse(sc.nextLine());
                    } catch (Exception e) {
                        System.out.println("Fecha incorrecta.");
                        break;
                    }

                    if (!Cliente.esMayorDeEdad(fechaNacimiento)) {
                        System.out.println("El cliente debe ser mayor de edad.");
                        break;
                    }

                    Cliente c = new Cliente(dni, nombre, numSocio,
                            direccion, fechaNacimiento);

                    if (videoClub.registrarCliente(c)) {
                        System.out.println("Cliente registrado correctamente.");
                    } else {
                        System.out.println("No se ha podido registrar el cliente.");
                    }

                    break;
                }

                // Alquilar pelicula
                case 4: {

                    videoClub.mostrarPeliculasRegistradas();

                    System.out.print("Introduce el codigo de la pelicula: ");
                    String cod = sc.nextLine();

                    Pelicula p = null;

                    for (int i = 0; i < videoClub.getPeliculasRegistradas().length; i++) {
                        if (videoClub.getPeliculasRegistradas()[i] != null &&
                                videoClub.getPeliculasRegistradas()[i].getCod().equals(cod)) {

                            p = videoClub.getPeliculasRegistradas()[i];
                        }
                    }

                    videoClub.mostrarClientesRegistrados();

                    System.out.print("Introduce el DNI del cliente: ");
                    String dni = sc.nextLine().toUpperCase();

                    Cliente c = null;

                    for (int i = 0; i < videoClub.getClientesRegistrados().length; i++) {
                        if (videoClub.getClientesRegistrados()[i] != null &&
                                videoClub.getClientesRegistrados()[i].getDni().equals(dni)) {

                            c = videoClub.getClientesRegistrados()[i];
                        }
                    }

                    if (videoClub.alquilarPelicula(p, c)) {
                        System.out.println("Pelicula alquilada correctamente.");
                    } else {
                        System.out.println("No se ha podido alquilar la pelicula.");
                    }

                    break;
                }

                // Devolver pelicula
                case 5: {

                    System.out.print("Introduce el codigo de la pelicula: ");
                    String cod = sc.nextLine();

                    Pelicula p = null;

                    for (int i = 0; i < videoClub.getPeliculasRegistradas().length; i++) {
                        if (videoClub.getPeliculasRegistradas()[i] != null &&
                                videoClub.getPeliculasRegistradas()[i].getCod().equals(cod)) {

                            p = videoClub.getPeliculasRegistradas()[i];
                        }
                    }

                    System.out.print("Introduce el DNI del cliente: ");
                    String dni = sc.nextLine().toUpperCase();

                    Cliente c = null;

                    for (int i = 0; i < videoClub.getClientesRegistrados().length; i++) {
                        if (videoClub.getClientesRegistrados()[i] != null &&
                                videoClub.getClientesRegistrados()[i].getDni().equals(dni)) {

                            c = videoClub.getClientesRegistrados()[i];
                        }
                    }

                    if (videoClub.devolverPelicula(p, c)) {
                        System.out.println("Pelicula devuelta correctamente.");
                    } else {
                        System.out.println("No se ha podido devolver la pelicula.");
                    }

                    break;
                }

                // Dar de baja cliente
                case 6: {

                    videoClub.mostrarClientesRegistrados();

                    System.out.print("Introduce el DNI del cliente: ");
                    String dni = sc.nextLine().toUpperCase();

                    Cliente c = null;

                    for (int i = 0; i < videoClub.getClientesRegistrados().length; i++) {
                        if (videoClub.getClientesRegistrados()[i] != null &&
                                videoClub.getClientesRegistrados()[i].getDni().equals(dni)) {

                            c = videoClub.getClientesRegistrados()[i];
                        }
                    }

                    if (videoClub.darBajaCliente(c)) {
                        System.out.println("Cliente dado de baja correctamente.");
                    } else {
                        System.out.println("No se ha podido dar de baja al cliente.");
                    }

                    break;
                }

                // Dar de baja pelicula
                case 7: {

                    videoClub.mostrarPeliculasRegistradas();

                    System.out.print("Introduce el codigo de la pelicula: ");
                    String cod = sc.nextLine();

                    Pelicula p = null;

                    for (int i = 0; i < videoClub.getPeliculasRegistradas().length; i++) {
                        if (videoClub.getPeliculasRegistradas()[i] != null &&
                                videoClub.getPeliculasRegistradas()[i].getCod().equals(cod)) {

                            p = videoClub.getPeliculasRegistradas()[i];
                        }
                    }

                    if (p != null && p.getFechaBaja() == null &&
                            !p.isAlquilada()) {

                        p.setFechaBaja(LocalDate.now());
                        System.out.println("Pelicula dada de baja correctamente.");

                    } else {
                        System.out.println("No se ha podido dar de baja la pelicula.");
                    }

                    break;
                }

                // Salir
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }

        } while (opcion != 8);

        sc.close();
    }
}