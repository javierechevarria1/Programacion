import java.util.Scanner;

public class main8 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 8: Estadísticas de una colección de números guardando la coleccion");

        String opcion ="";
        Scanner reader1 = new Scanner (System.in);

        System.out.println("¿Cuantos numeros quieres almacenar?");
        int t = reader1.nextInt();
        reader1.nextLine();

        double[] coleccion = new double[t];
        int contador = 0;

        do {

            System.out.println("Menu");
            System.out.println("1-Suma de valores no nulos");
            System.out.println("2-Maximo de la eleccion");
            System.out.println("3-Minimo de la eleccion");
            System.out.println("4-Media de los numeros");
            System.out.println("5-Salir");
            System.out.println("Elige una opcion: ");

            opcion = reader1.nextLine();

            switch(opcion){

                case "1":
                    // Si la colección no se ha rellenado entera todavía
                    if (contador < t) {
                        System.out.println("Introduce los " + (t - contador) + " numeros que faltan:");

                        // Bucle qu pide los números seguidos hasta rellenar el tamaño t
                        while (contador < t) {
                            System.out.println("Introduce un numero:");
                            coleccion[contador] = reader1.nextDouble();
                            contador++;
                        }
                        reader1.nextLine(); // Limpieza de buffer al terminar de meter todos

                        double suma = 0;
                        for (int i = 0; i < contador; i++) {
                            suma += coleccion[i];
                        }
                        System.out.println("La suma de valores no nulos es: " + suma);
                    } else {
                        System.out.println("La coleccion ya esta llena.");
                    }
                    break;

                case "2":
                    if (contador == 0) {
                        System.out.println("La coleccion esta vacia. Añade numeros en la opcion 1 primero.");
                    } else {
                        double mayor = coleccion[0];
                        for (int i = 1; i < contador; i++) {
                            mayor = Math.max(mayor, coleccion[i]);
                        }
                        System.out.println("El numero maximo es: ");
                        System.out.println(mayor);
                    }
                    break;

                case "3":
                    if (contador == 0) {
                        System.out.println("La coleccion esta vacia. Añade numeros en la opcion 1 primero.");
                    } else {
                        double menor = coleccion[0];
                        for (int i = 1; i < contador; i++) {
                            menor = Math.min(menor, coleccion[i]);
                        }
                        System.out.println("El minimo es: ");
                        System.out.println(menor);
                    }
                    break;

                case "4":
                    if (contador == 0) {
                        System.out.println("La coleccion esta vacia. Añade numeros en la opcion 1 primero.");
                    } else {
                        double sumaMedia = 0;
                        for (int i = 0; i < contador; i++) {
                            sumaMedia += coleccion[i];
                        }
                        double media = sumaMedia / contador;
                        System.out.println("La media es: " + media);
                    }
                    break;

                case "5":
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("La opcion no es valida");
                    break;
            }
        }
        while(!opcion.equals("5"));
        reader1.close();
    }
}
