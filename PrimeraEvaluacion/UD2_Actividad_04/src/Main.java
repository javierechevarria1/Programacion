import java.util.Scanner;

public class Main {
    public static void main(String[] args){
/* 1. Crea un programa que pida diez números reales por teclado, los almacene en un array,
y luego muestre todos sus valores. */
        System.out.println("Ejercicio 1");
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduce el primer numero");

        // Creamos la lista/array para 10 numero que piden
        double[] num = new double[10];
        // Ahora vamos a crear el bucle para que pida las 10 veces un numero
        for (int i = 0; i < 10; i++){
            System.out.println("Introduce un numero: ");
            num[i] = scan.nextDouble();
        }
        // Da la lista de los numero guardados
        System.out.println("Los numeros guardados son: ");
        for (int i = 0; i < 10; i++){
            System.out.println(num[i]);
        }
/* 2. Crea un programa que pida diez números reales por teclado, los almacene en un array,
y luego muestre la suma de todos los valores. */
        System.out.println("Ejercicio 2");
        scan = new Scanner(System.in);
        System.out.println("Introduce el primer numero");

        // Creamos la lista/array para 10 numero que piden
        num = new double[10]; // Aqui la variable ya esta creada sino iria un double delante
        double suma = 0; // Aqui creamos la nueva variable para acumular la suma de los numeros
        // Ahora vamos a crear el bucle para que pida las 10 veces un numero
        for (int i = 0; i < 10; i++){
            System.out.println("Introduce un numero: ");
            num[i] = scan.nextDouble();
            suma = suma + num[i]; // Esto suma el numero a la cuenta o sea lo guarda
        }
        // Muestra la suma de los numeros sumados
        System.out.println("La suma de los valores es: " + suma);
/* 3. Crea un programa que pida diez números reales por teclado, los almacene en un array,
y luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla. */
        System.out.println("Ejercicio 3");
        scan = new Scanner(System.in);
        System.out.println("Introduce el primer numero");

        // Creamos la lista/array para 10 numero que piden
        num = new double[10]; // Aqui la variable ya esta creada sino iria un double delante
        suma = 0; // Aqui creamos la nueva variable para acumular la suma de los numeros
        // Ahora vamos a crear el bucle para que pida las 10 veces un numero
        for (int i = 0; i < 10; i++){
            System.out.println("Introduce un numero: ");
            num[i] = scan.nextDouble();
            suma = suma + num[i]; // Esto suma el numero a la cuenta o sea lo guarda

        }

    }
}
