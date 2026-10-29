import java.util.Scanner;

public class main6 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 6: Calculadora de operaciones avanzadas");

        String opcion ="";
        Scanner reader1 = new Scanner (System.in);

        do {

            System.out.println("Menu");
            System.out.println("1-Calcular la potencia");
            System.out.println("-Estadisticas avanzadas");
            System.out.println("2-Calcular la raiz cuadrada");
            System.out.println("3-Calcular el resto de la division");
            System.out.println("4-Calcular el area de un triangulo");
            System.out.println("-Ampliar las operaciones");
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
                    // Math.pow eleva el primer número al exponente del segundo número
                    double potencia = Math.pow(num1, num2);
                    System.out.println("El resultado es: ");
                    System.out.println(potencia);
                    break;

                case "2":

                    System.out.println("Introduce un numero:");
                    double num3 = reader1.nextDouble();
                    reader1.nextLine();
                    double raiz = Math.sqrt(num3); // Math.sqrt calcula la raíz cuadrada de un solo número
                    System.out.println("La raiz cuadrada es: ");
                    System.out.println(raiz);
                    break;

                case "3":

                    System.out.println("Introduce un numero:");
                    double num5 = reader1.nextDouble();
                    System.out.println("Introduce un numero:");
                    double num6 = reader1.nextDouble();
                    reader1.nextLine();
                    double resto = num5 % num6; // El operador % obtiene el residuo sobrante de la división
                    System.out.println("El resto es: ");
                    System.out.println(resto);
                    break;

                case "4":

                    System.out.println("Introduce un numero:");
                    double num7 = reader1.nextDouble();
                    System.out.println("Introduce un numero:");
                    double num8 = reader1.nextDouble();
                    reader1.nextLine();
                    System.out.println("El area es: " + ((num7 * num8) / 2)); // Área de un triángulo: base * altura / 2
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

