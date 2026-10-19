import java.util.Scanner;

public class main2 {
    public static void main(String[] args){
        System.out.println("Ejercicio 2: Gestion y recorrido de matrices");
        Scanner scan = new Scanner(System.in);

        String opcion = "";
        int[][] matriz = null;// Dejamos una matriz fuera del do-while para poder usarla en diferentes casos

        do {
            System.out.println(" MENU MATRICES ");
            System.out.println("1- Crear matriz NxM");
            System.out.println("2- Mostrar matriz");
            System.out.println("3- Contar pares e impares");
            System.out.println("4- Salir");
            System.out.println("Elige una opcion: ");

            opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    // Pide N, M y rellena la matriz
                    System.out.println("Filas N: ");
                    int n = scan.nextInt();
                    System.out.println("Columnas M: ");
                    int m = scan.nextInt();

                    matriz = new int[n][m];

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            matriz[i][j] = scan.nextInt();
                        }
                    }
                    scan.nextLine();
                    break;

                case "2":
                    // Muestra la matriz por pantalla
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            System.out.print(matriz[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case "3":
                    // Cuente pares e impares recorriendo la matriz
                    int pares = 0, impares = 0;
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz[i].length; j++) {
                            if (matriz[i][j] % 2 == 0) {
                                pares++;
                            }
                            else {
                                impares++;
                            }
                        }
                    }
                    System.out.println("Pares: " + pares + " - Impares: " + impares);
                    break;

                case "4":
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opcion no valida");
                    break;
            }

        } while (!opcion.equals("4"));

        scan.close();
    }
}
