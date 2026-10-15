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

        //Ahora creamos el array para los 20 numeros enteros
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

        // Creamos el array para los 20 numeros enteros
        double[] enteros1 = new double[20];
        suma = 0; // Aqui la variable suma ya esta creada arriba sino iria con double

        // Bucle para pedir los 20 numeros reales por teclado
        for (int i = 0; i < enteros1.length; i++){
            System.out.println("Introduce el numero: ");
            enteros1[i] = scan.nextDouble();
        }
        // Bucle para recorrer el array para sumar todos los valores
        for (int i = 0; i < enteros1.length; i++){
            suma += enteros1[i];
        }
        // Calcular la media y mostrar
        double media = suma / enteros1.length;
        System.out.println("La media de los valores es: " +media);

/* 6. Crea un programa que pida dos valores enteros N y M, luego cree un array de tamaño
N, escriba M en todas sus posiciones y lo muestre por pantalla. */
        System.out.println("Ejercicio 6");
        scan = new Scanner(System.in);

        // Pedir los valores N y M
        System.out.print("Introduce el tamaño del array (N): ");
        int N = scan.nextInt();

        System.out.print("Introduce el valor a guardar (M): ");
        int M = scan.nextInt();

        // Crear el array con el tamaño dinamico N
        int[] valores = new int[N];

        // Bucle para escribir M en todas las posiciones
        for (int i = 0; i < valores.length; i++){
            valores[i] = M;
        }

        // Bucle para mostrar el array por pantalla
        System.out.println("El contenido del array es:");
        for (int i = 0; i < valores.length; i++){
            System.out.println("Posicion " + i + ": " + valores[i]);
        }

/* 7. Crea un programa que pida dos valores enteros P y Q, luego cree un array que contenga
todos los valores desde P hasta Q, y lo muestre por pantalla. */
        System.out.println("Ejercicio 7");
        scan = new Scanner(System.in);

        // Pedir los valores P y Q
        System.out.println("Introduce el valor inicial (P). ");
        int P = scan.nextInt();

        System.out.println("Introduce el valor final (Q)");
        int Q = scan.nextInt();

        // Calcular el tamaño y crear array
        int tamaño = Math.abs(Q - P) + 1;
        int[] rangoValores = new int [tamaño];

        // Primer bucle: Rellenar el array con los valores consecutivos desde P hasta Q
        int valorActual = P;
        for (int i = 0; i < rangoValores.length; i++){
            rangoValores[i] = valorActual;
            valorActual++; // Incrementa para el siguiente numero
        }

        // Segundo bucle: recorrer el array para mostrarlo por pantalla
        System.out.println("Los valores desde P hasta Q son: ");
        for (int i = 0; i < rangoValores.length; i++){
            System.out.println("Posicion " + i + ": " + rangoValores[i]);
        }

/* 8. Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0,
utilizando Math.random(), y luego le pida al usuario un valor real R. Por último, mostrará
cuántos valores del array son igual o superiores a R. */
        System.out.println("Ejercicio 8");
        scan = new Scanner(System.in);

        double[] aleatorios = new double[100]; // Array para los 100

        // Bucle rellenar array con números aleatorios entre 0.0 y 1.0
        for (int i = 0; i < aleatorios.length; i++) {
            aleatorios[i] = Math.random();
        }

        // Pedimos por teclado valor de R
        System.out.println("Introduce el valor real R (entre 0.0 y 1.0): ");
        double R = scan.nextDouble();

        int contador = 0; // Variable contador

        // Bucle para rrecorrer array y contar iguales o superiores a R
        for (int i = 0; i < aleatorios.length; i++){
            if (aleatorios[i] >= R){
                contador++; // Si es igual o mayor, sumamos 1
            }
        }
        System.out.println("Cantidad de valores iguales o superiores a " + R + ": " + contador);

/* 9. Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores
enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N
y mostrará en qué posiciones del array aparece N. */
        System.out.println("Ejercicio 9");
        scan = new Scanner(System.in);

        // 1. Crear el array de enteros de tamaño 100
        int[] enteros2 = new int[100];

        // Bucle: Rellenar el array con enteros aleatorios entre 1 y 10
        for (int i = 0; i < enteros2.length; i++) {
            enteros2[i] = (int) (1 + Math.random() * 10);
        }

        // Pedir al usuario el valor N a buscar
        System.out.print("Introduce un valor entero N a buscar (entre 1 y 10): ");
        N = scan.nextInt(); // Ya esta declarada arriba entonces no especifico la variable con INT

        // Bucle: Buscar y mostrar en qué posiciones aparece N
        System.out.print("El número " + N + " aparece en las posiciones: ");
        for (int i = 0; i < enteros2.length; i++) {
            if (enteros2[i] == N) {
                System.out.print(i + " "); // Muestra la posición (i) seguida de un espacio
            }
        }
        System.out.println(); // Salto de línea final para limpiar la consola


/* 10. Crea un programa para realizar cálculos relacionados con la altura (en metros) de
personas. Pedirá un valor N y luego almacenará en un array N alturas introducidas por teclado. Luego mostrará la altura media, máxima y mínima, así como cuántas personas
miden por encima y por debajo de la media. */
        System.out.println("Ejercicio 10");
        scan = new Scanner(System.in);

        // Bucle para pedir el número de personas N
        System.out.print("Introduce el número de personas (N): ");
        N = scan.nextInt();

        // Crear el array de alturas reales y variables de cálculo
        double[] alturas = new double[N];
        suma = 0; // Ya esta creada sino iria el double

        // Bucle pedir y almacenar las alturas en el array
        for (int i = 0; i < alturas.length; i++) {
            System.out.print("Introduce la altura de la persona " + (i + 1) + " (en metros): ");
            alturas[i] = scan.nextDouble();
        }

        // Bucle calcular la suma total para poder sacar la media
        for (int i = 0; i < alturas.length; i++) {
            suma += alturas[i];
        }

        media = suma / N; // Ya esta creada sino iria el double
        System.out.println("La altura media es: " + media + " metros.");

        // Variables contadoras para la clasificación
        int porEncima = 0;
        int porDebajo = 0;

        // Bucle para comparar cada altura con la media calculada
        for (int i = 0; i < alturas.length; i++) {
            if (alturas[i] > media) {
                porEncima++;
            } else if (alturas[i] < media) {
                porDebajo++;
            }
        }

        System.out.println("Personas por encima de la media: " + porEncima);
        System.out.println("Personas por debajo de la media: " + porDebajo);

/* 11. Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá en
el primer array todos los valores del 1 al 100. Por último, deberá copiar todos los valores
del primer array al segundo array en orden inverso, y mostrar ambos por pantalla. */



    }
}
