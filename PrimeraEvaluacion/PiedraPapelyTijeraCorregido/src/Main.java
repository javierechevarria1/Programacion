import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // El array con los nombres de las jugadas para el ordenador
        String[] jugadas = {"p", "l", "t"};
        String jugada = "";

        do {
            IO.println("Bienvenido al juego de Piedra, Papel, Tijera de Decroly");
            IO.println("Escoja la jugada a realizar: Piedra (P), Papel (L), Tijera (T). Pulse S para salir");

            jugada = sc.nextLine();

            // Si el usuario quiere salir, rompemos el bucle antes de jugar
            if (jugada.equalsIgnoreCase("s")) {
                IO.println("Gracias por jugar. ¡Adiós!");
                break;
            }

            // Generar la jugada aleatoria del ordenador directamente del array ("p", "l" o "t")
            String jugadaOrdenador = jugadas[(int) (Math.random() * 3)];

            // Comprobamos si la jugada introducida es válida
            if (jugada.equalsIgnoreCase("p") || jugada.equalsIgnoreCase("l") || jugada.equalsIgnoreCase("t")) {

                // PRIMERO: Comprobar si hay empate
                if (jugada.equalsIgnoreCase(jugadaOrdenador)) {
                    IO.println("Empate: " + jugada + " vs " + jugadaOrdenador);
                }

                // SEGUNDO: Si el jugador elige Piedra (P)
                else if (jugada.equalsIgnoreCase("p")) {
                    if (jugadaOrdenador.equalsIgnoreCase("t")) {
                        IO.println("Gana jugador: Piedra gana a tijera: " + jugada + " vs " + jugadaOrdenador);
                    } else if (jugadaOrdenador.equalsIgnoreCase("l")) {
                        IO.println("Gana ordenador: Papel gana a piedra: " + jugada + " vs " + jugadaOrdenador);
                    }
                }

                // TERCERO: Si el jugador elige Papel (L)
                else if (jugada.equalsIgnoreCase("l")) {
                    if (jugadaOrdenador.equalsIgnoreCase("p")) {
                        IO.println("Gana jugador: Papel gana a piedra: " + jugada + " vs " + jugadaOrdenador);
                    } else if (jugadaOrdenador.equalsIgnoreCase("t")) {
                        IO.println("Gana ordenador: Tijera gana a papel: " + jugada + " vs " + jugadaOrdenador);
                    }
                }

                // CUARTO: Si el jugador elige Tijera (T)
                else if (jugada.equalsIgnoreCase("t")) {
                    if (jugadaOrdenador.equalsIgnoreCase("l")) {
                        IO.println("Gana jugador: Tijera gana a papel: " + jugada + " vs " + jugadaOrdenador);
                    } else if (jugadaOrdenador.equalsIgnoreCase("p")) {
                        IO.println("Gana ordenador: Piedra gana a tijera: " + jugada + " vs " + jugadaOrdenador);
                    }
                }

            } else {
                IO.println("Opción inválida. Por favor, introduce P, L, T o S.");
            }

            IO.println(""); // Línea en blanco para separar las rondas

        } while (!jugada.equalsIgnoreCase("s"));

        sc.close();
    }
}

