import java.util.Scanner;

public class main7 {
        public static void main(String[] args) {
            System.out.println("Ejercicio 7: Estadísticas de una colección de números");

            String opcion ="";
            Scanner reader1 = new Scanner (System.in);

            do {

                System.out.println("Menu");
                System.out.println("1-Suma de valores no nulos");
                System.out.println("-Estadisticas de la coleccion");
                System.out.println("2-Maximo de la eleccion");
                System.out.println("3-Minimo de la eleccion");
                System.out.println("4-Media de los numeros");
                System.out.println("-Ampliar el valor de la coleccion");
                System.out.println("5-Salir");
                System.out.println("Elige una opcion: ");

                opcion = reader1.nextLine();

                switch(opcion){

                    case "1":

                        System.out.println("Introduce un numero:");
                        double num1 = reader1.nextDouble();
                        System.out.println("Introduce un numero:");
                        double num2 = reader1.nextDouble();
                        reader1.nextLine();
                        System.out.println("El resultado es: " + (num1+num2));
                        break;

                    case "2":

                        System.out.println("Introduce un numero:");
                        double num3 = reader1.nextDouble();
                        System.out.println("Introduce un numero:");
                        double num4 = reader1.nextDouble();
                        reader1.nextLine();
                        double mayor = Math.max(num4, num3 );
                        System.out.println("El numero maximo es: ");
                        System.out.println(mayor);
                        break;

                    case "3":

                        System.out.println("Introduce un numero:");
                        double num5 = reader1.nextDouble();
                        System.out.println("Introduce un numero");
                        double num6 =reader1.nextDouble();
                        reader1.nextLine();
                        double menor = Math.min (num5, num6);
                        System.out.println("El minimo es: ");
                        System.out.println(menor);
                        break;

                    case "4":

                        System.out.println("Introduce un numero:");
                        double num7 = reader1.nextDouble();
                        System.out.println("Introduce un numero:");
                        double num8 = reader1.nextDouble();
                        reader1.nextLine();
                        System.out.println("La media es: " + ((num7 + num8) / 2));
                        break;

                    case "5":
                        System.out.println("Adios");
                        break;

                    default:
                        System.out.println("La opcion no es valida"); // Cualquier número que no sea del 1 al 5 no es válido
                        break;
                }
            }
            while(!opcion.equals("5"));
            reader1.close();
        }
}