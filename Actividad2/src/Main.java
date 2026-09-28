import java.util.Scanner;

/* 1.Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “Eres
mayor de edad” solo si lo somos ”. */
public class Main {
    public static void main (String[] args) {
        System.out.println("Ejercicio 1");
        Scanner scan = new Scanner(System.in);
        int edad;
        System.out.println("Introduzca su edad: ");
        edad = scan.nextInt();

        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }

/* 2. Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “eres
mayor de edad” o el mensaje de “eres menor de edad”. */
        System.out.println("Ejercicio 2");
        scan = new Scanner(System.in);
        System.out.println("Introduzca su edad: ");
        edad = scan.nextInt();

        if (edad >= 18){
            System.out.println("Eres mayor de edad");
        }
        else {
            System.out.println("Eres menor de edad");
        }


/* 3. Realiza un programa que muestre por pantalla los 20 primeros números naturales (1, 2,
3... 20). */
        System.out.println("Ejercicio 3");
        System.out.println("Estos son los primeros 20 numeros naturales: " );
        for (int cont = 1; cont <= 20; cont++){
            System.out.println(cont);
        }
    /* 4. Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Para ello utiliza un contador y suma de 2 en 2. */
        System.out.println("Ejercicio 4");
        System.out.println("Estos son los numeros pares comprendidos entre el 1 y el 200: " );
        for (int cont = 2; cont <= 200; cont += 2){
            System.out.println(cont);
        }

    /* 5. Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Esta vez utiliza un contador sumando de 1 en 1. */
        System.out.println("Ejercicio 5");
        System.out.println("Estos son los numeros pares comprendidos entre el 1 y el 200: " );
        for (int cont = 1; cont <= 200; cont++) {
            if (cont % 2 == 0) {
                System.out.println(cont);
            }
        }

    /* 6. Realiza un programa que muestre los números desde el 1 hasta un número N que se
introducirá por teclado. */
        System.out.println("Ejercicio 6");
        scan = new Scanner(System.in);
        System.out.println("Introduce el numero limite: ");
        int n = scan.nextInt();
        System.out.println("Estos son los numeros desde el 1 hasta el " + n + ":");
        for (int cont = 1; cont<= n; cont ++){
            System.out.println(cont);
        }
    /* 7. Escribe un programa que lea una calificación numérica entre 0 y 10 y la transforma en
calificación alfabética, escribiendo el resultado. */
        System.out.println("Ejercicio 7");
        scan = new Scanner(System.in);
        System.out.println("Introduce la nota: ");


    /* 8.  */

    /* 9.  */

    /* 10.  */

    /* 11.  */

    /* 12.  */

    /* 13.  */

    /* 14.  */


    }
}
