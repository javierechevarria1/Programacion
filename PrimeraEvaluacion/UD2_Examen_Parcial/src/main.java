import java.util.Scanner;

public class main {
    public static void main(String[] args){
        System.out.println("UD2_Examen_Parcial");
        Scanner scan = new Scanner(System.in);

        System.out.println("¿Cuantos numeros quieres almacenar?"); // Pedir la cantidad total de numeros a almacenar
        int n = scan.nextInt();
        int array[] = new int[n];
        scan.nextLine();

        String menu = "";

        do { // Menu estructura principal
            System.out.println("a. Modificar coleccion");
            System.out.println("b. Estadisticas de la coleccion");
            System.out.println("c. Ampliar el valor de la coleccion");
            System.out.println("d. Salir");
            menu = scan.nextLine();

            switch (menu) { // Submenu de Modificar coleccion
                case "a":
                    System.out.println("Modificar colección");
                    System.out.println("1- Insertar numero");
                    System.out.println("2- Borrar numero de una posición específica");
                    System.out.println("3- Modificar numero de una posición específica");
                    String menu1 = scan.nextLine();

                    if (menu1.equals("1") || menu1.equals("3")) {
                        System.out.println("Que posicion quieres modificar?");
                        int pos = scan.nextInt();
                        System.out.println("Introduce un numero:");
                        int num = scan.nextInt();
                        scan.nextLine();
                        array[pos - 1] = num;
                        System.out.println("Guardado correctamente");
                    }
                    else if (menu1.equals("2")) {
                        System.out.println("Que posicion quieres borrar?");
                        int pos = scan.nextInt();
                        scan.nextLine();
                        array[pos - 1] = 0;
                        System.out.println("Borrado correctamente");
                    }
                    break;

                case "b": // Submenu de Estadisticas de la coleccion
                    System.out.println("Estadísticas de la colección");
                    System.out.println("1- Media");
                    System.out.println("2- Suma");
                    System.out.println("3- Maximo");
                    System.out.println("4- Minimo");
                    String menu2 = scan.nextLine();

                    if (menu2.equals("1")) {
                        double suma = 0;
                        for (int i = 0; i < array.length; i++) {
                            suma = suma + array[i];
                        }
                        System.out.println("La media es: " + (suma / array.length));
                    }
                    else if (menu2.equals("2")) {
                        int suma = 0;
                        for (int i = 0; i < array.length; i++) {
                            suma = suma + array[i];
                        }
                        System.out.println("La suma es: " + suma);
                    }
                    else if (menu2.equals("3")) {
                        int max = array[0];
                        for (int i = 1; i < array.length; i++) {
                            if (array[i] > max) {
                                max = array[i];
                            }
                        }
                        System.out.println("El maximo es: " + max);
                    }
                    else if (menu2.equals("4")) {
                        int min = array[0];
                        for (int i = 1; i < array.length; i++) {
                            if (array[i] < min) {
                                min = array[i];
                            }
                        }
                        System.out.println("El minimo es: " + min);
                    }
                    break;

                case "c": // Ampliar el valor de la coleccion
                    System.out.println("Nuevo tamaño:");
                    int amp = scan.nextInt();
                    scan.nextLine();
                    int nuevoArray[] = new int[amp];
                    for (int i = 0; i < array.length; i++) {
                        nuevoArray[i] = array[i];
                    }
                    array = nuevoArray;
                    n = amp; // Amplia el numero
                    System.out.println("Ampliado con exito");
                    break;

                case "d":
                    System.out.println("Adios");
                    break;
            }
        }
        while (!menu.equals("d")); // Salir

        scan.close();
    }
}