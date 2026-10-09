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
        // Da la lista de los numeros guardados
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
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce un numero: ");
            num[i] = scan.nextDouble();
            suma = suma + num[i]; // Esto suma el numero a la cuenta o sea lo guarda
        }
        // Ahora creamos para que averigue el maximo y minimo y mostrarlos
        double maximo = num[0];
        double minimo = num[0];
        //Ahora creamos el bucle para el array desde la posicion 1 a 9
        for (int i = 1; i < 10; i++){
            if (num[i] > maximo){
                maximo = num[i];
            }
            if (num[i] < minimo){
                minimo = num[i];
            }
        }
        System.out.println("El numero maximo introducido es: " + maximo);
        System.out.println("El numero minimo introducido es: " + minimo);



/* 4. Crea un programa que pida veinte números enteros por teclado, los almacene en un
array y luego muestre por separado la suma de todos los valores positivos y negativos. */
        System.out.println("Ejercicio 4");
        scan = new Scanner(System.in);

        //Ahora creamos el array para los 20 numero enteros
        int[] enteros = new int[20];
        //Creamos las variables para acumular las sumas
        int sumaPositivos = 0;
        int sumaNegativos = 0;

        //Ahora el bucle para pedir los 20 numeros
        for (int i = 0; i < 20; i++){
            System.out.println("Introduce un numero entero: ");
            enteros[i] = scan.nextInt();

            if (enteros[i] > 0){
                sumaPositivos = sumaPositivos + enteros[i]; // Suma si es mayor que 0
            }
            if (enteros[i] < 0){
                sumaNegativos = sumaNegativos + enteros[i]; // Suma si es menor que 0
            }
        }
        System.out.println("La suma de los valores positivos es: " + sumaPositivos);
        System.out.println("La suma de los numeros negativos es: " + sumaNegativos);

/* 5. Crea un programa que pida veinte números reales por teclado, los almacene en un array
y luego lo recorra para calcular y mostrar la media: (suma de valores) / nº de valores. */
        System.out.println("Ejercicio 5");
        scan = new Scanner(System.in);



    }
}
