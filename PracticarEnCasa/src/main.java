import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1: Menu de operaciones aritmeticas");
        Scanner scan = new Scanner(System.in);
        String opcion = "";

        do {
            System.out.println("1- Suma de valores no nulos");
            System.out.println("2- Maximo de la eleccion");
            System.out.println("3- Minimo de la eleccion");
            System.out.println("4- Media de los numeros");
            System.out.println("5- Salir");

            opcion = scan.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("Introduce un numero: ");
                    double num1 = scan.nextDouble();
                    System.out.println("Introduce un numero: ");
                    double num2 = scan.nextDouble();
                    System.out.println("El resultado es: " + (num1 + num2));
                    scan.nextLine();
                    break;

                case "2":
                    System.out.println("Introduce un numero: ");
                    double num3 = scan.nextDouble();
                    System.out.println("Introduce un numero: ");
                    double num4 = scan.nextDouble();
                    double mayor = Math.max(num4, num3);
                    System.out.println("El numero maximo es: ");
                    System.out.println(mayor);
                    scan.nextLine();
                    break;

                case "3":
                    System.out.println("Introduce un numero: ");
                    double num5 = scan.nextDouble();
                    System.out.println("Introduce otro: ");
                    double num6 = scan.nextDouble();
                    double menor = Math.min(num5, num6);
                    System.out.println("El minimo es: ");
                    System.out.println(menor);
                    scan.nextLine();
                    break;

                case "4":
                    System.out.println("Introduce un numero: ");
                    double num7 = scan.nextDouble();
                    System.out.println("Introduce un numero: ");
                    double num8 = scan.nextDouble();
                    System.out.println("La media es: " + ((num7 + num8) / 2));
                    scan.nextLine();
                    break;

                case "5":
                    System.out.println("Adios y gracias por todo");
                    break;

                default:
                    System.out.println("La opcion no es valida");
                    break;
            }
        }
        while (!opcion.equals("5"));
    }
}