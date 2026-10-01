import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        /* Realiza un programa que dada una cantidad de euros que el usuario introduce por teclado....*/
        System.out.println("Ejercicio 1");
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce la cantidad de euros: ");
        int num = scan.nextInt();

        int billetes500 = num / 500; // Variable que calcula cuantos billetes de 500 caben
        num = num % 500; // Guarda el dinero que sobra para la siguiente variable/billete
        int billetes200 = num / 200; // Variable que calcula cuantos billetes de 200 caben
        num = num % 200; // Guarda el dinero que sobra para la siguiente variiable/billete
        int billetes100 = num / 100; // Variable que calcula cuantos billetes de 100 caben
        num = num % 100; // Guarda el dinero que sobra para la siguiente variable
        int billetes50 = num / 50; //Variable que calcula cuantos billetes de 50 caben
        num = num % 50; // Guarda el dinero que sobra para la siguiente variable
        int billetes20 = num / 20; //Variable que calcula cuantos billetes de 20 caben
        num = num % 20; // Guarda el dinero que sobra para la siguiente variable
        int billetes10 = num / 10; //Variable que calcula cuantos billetes de 10 caben
        num = num % 10; // Guarda el dinero que sobra para la siguiente variable
        int billetes5 = num / 5; //Variable que calcula cuantos billetes de 5 caben
        num = num % 5;// Guarda el dinero que sobra para la siguiente variable

        System.out.println("Billetes de 500: " + billetes500);
        System.out.println("Billetes de 200: " + billetes200);
        System.out.println("Billetes de 100: " + billetes100);
        System.out.println("Billetes de 50: " + billetes50);
        System.out.println("Billetes de 20: " + billetes20);
        System.out.println("Billetes de 10: " + billetes10);
        System.out.println("Billetes de 5: " + billetes5);

        /* Realiza un programa que muestre un menú de opciones como el siguiente:
        1. Sumar
        2. Restar
        3. Multiplicar
        4. Dividir (incluir manejo de división por 0)
        5. Salir
        El menú debe de repetirse hasta que se escoja la opción 5 (Salir).
        */
        System.out.println("Ejercicio 2");
        scan = new Scanner(System.in);
        int opcion; // Se crea la variable opcion para guardar los datos antes del do para que sepa que existe

        do {
            System.out.println("1.Sumar");
            System.out.println("2.Restar");
            System.out.println("3.Multiplicar");
            System.out.println("4.Dividir (incluir manejo de division 0)");
            System.out.println("5.Salir");

            System.out.println("Elige una opcion: ");
            opcion = scan.nextInt(); // Se guarda el numero del usuario

            int num1;
            int num2;

            switch (opcion){
                case 1:
                    System.out.println("Has elegido Sumar");
                    System.out.println("Introduce el primer numero: ");
                    num1 = scan.nextInt();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = scan.nextInt();
                    int resultadoSuma = num1 + num2;
                    System.out.println("El resultado es: " + resultadoSuma);
                    break;
                case 2:
                    System.out.println("Has elegido Restar");
                    System.out.println("Introduce el primer numero: ");
                    num1 = scan.nextInt();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = scan.nextInt();
                    int resultadoResta = num1 - num2;
                    System.out.println("El resultado es: " + resultadoResta);
                    break;
                case 3:
                    System.out.println("Has elegido Multiplicar");
                    System.out.println("Introduce el primer numero: ");
                    num1 = scan.nextInt();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = scan.nextInt();
                    int resultadoMultiplicar = num1 * num2;
                    System.out.println("El resultado es: " + resultadoMultiplicar);
                    break;
                case 4:
                    System.out.println("Has elegido Dividir");
                    System.out.println("Introduce el primer numero: ");
                    num1 = scan.nextInt();
                    System.out.println("Introduce el segundo numero: ");
                    num2 = scan.nextInt();

                    if (num2 == 0) { // Si el segundo número es 0, avisa del error para que el programa no explote
                        System.out.println("Error: No se puede dividir entre cero.");
                    } else { // Si no es 0, hace la división normal y muestra el resultado
                        int resultadoDivision = num1 / num2;
                        System.out.println("El resultado de la división es: " + resultadoDivision);
                    }
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
            }
        }
        while (opcion != 5); // Si es 5 termina sino vuelve al do
    }
}

