import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /* 1. Crea un programa del juego de “Piedra, papel o tijera”, el programa debe de seguir la siguiente estructura.*/
        System.out.println("Ejercicio 1 - Piedra, papel y tijera \n");
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // Explicarle al jugador como se juega
        IO.println("ESTAS SON LAS NORMAS DEL PROGRAMA: ");
        IO.println("1. Introduces una de las siguientes opciones y el pc contestara aleatoriamente y dara el resultado");
        IO.println("2. Piedra gana a tijeras");
        IO.println("3. Papel gana a piedra");
        IO.println("4. Tijeras gana a papel \n");

        //Variables que utilizaremos
        String[] opciones = {"P", "L", "T"};
        String[] nombres = {"Piedra", "Papel", "Tijeras"};
        String[] jugadaUsuario = new String[0];

        // Pedir al jugador su jugada (P para piedra, L para papel, T para tijeras, o S para salir terminando la partida):
        String opcion = "S";
        int jugadaOrdenador;
        do {
            jugadaOrdenador = random.nextInt(3);
            IO.println("Ahora escoja una de las opciones propuestas: P(piedra) - L(papel) - T(tijeras) - S(Salir) ");
            IO.println("P (piedra)");
            IO.println("L (papel)");
            IO.println("T (tijeras)");
            IO.println("S (Salir)");

            opcion = scan.nextLine();
            switch (opcion) {
                case "P" -> {
                    IO.println("Has elegido piedra");
                    IO.println("El ordenador eligio: " + nombres[jugadaOrdenador]);

                }

                case "L" -> {
                    IO.println("Has elegido papel");
                    IO.println("El ordenador eligio: " + nombres[jugadaOrdenador]);

                }

                case "T" -> {
                    IO.println("Has elegido tijeras");
                    IO.println("El ordenador eligio: " + nombres[jugadaOrdenador]);

                }

                case "S" -> {
                    IO.println("Gracias por usar el programa, adios");
                }

                default -> {
                    IO.println("Opcion invalida");
                }
            }

        } while (!opcion.equals("S"));

    }
}
