import java.util.Scanner;

public class Main {
    public static void main(String[] args){
/* 1. Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del 1 al 25
y luego muestre la matriz por pantalla. */
        System.out.println("Ejercicio 1");
        Scanner scan = new Scanner(System.in);

        // Creamos la matriz de tamaño 5x5
        int[][] matriz = new int[5][5];
        int contador = 1;

        // Rellenamos la matriz con los números del 1 al 25, la i es la primera casilla y la j nos dice siguiente casilla ya que va despues del abecedario
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = contador;
                contador++;
            }
        }

        // Mostramos la matriz por pantalla en formato de tabla
        System.out.println("Matriz 5x5 del 1 al 25: ");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " "); // Espacio en blanco entre los numeros
            }
            System.out.println(); // Salto de línea
        }


/* 2. Crea un programa que cree una matriz de 10x10 e introduzca los valores de las tablas de
multiplicar del 1 al 10 (cada tabla en una fila). Luego mostrará la matriz por pantalla. */
        System.out.println("Ejercicio 2");
        scan = new Scanner(System.in);

        // Creamos la matriz de tamaño 10x10
        int[][] matrizTablas = new int[10][10];

        // Rellenamos la matriz con las tablas de multiplicar del 1 al 10
        for (int i = 0; i < matrizTablas.length; i++) {
            for (int j = 0; j < matrizTablas[i].length; j++) {
                matrizTablas[i][j] = (i + 1) * (j + 1); // La fila 'i' representa el número base (i + 1)-La columna 'j' representa el multiplicador (j + 1)
            }
        }

        // Mostramos la matriz por pantalla
        System.out.println("Matriz de tablas de multiplicar (1 al 10):");
        for (int i = 0; i < matrizTablas.length; i++) {
            for (int j = 0; j < matrizTablas[i].length; j++) {
                System.out.print(matrizTablas[i][j] + " ");
            }
            System.out.println(); // Salto de línea al terminar cada fila
        }

/* 3. Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por teclado) e
introduzca en ella NxM valores (también introducidos por teclado). Luego deberá recorrer la
matriz y al final mostrar por pantalla cuántos valores son mayores que cero, cuántos son
menores que cero y cuántos son igual a cero. */
        System.out.println("Ejercicio 3");
        scan = new Scanner(System.in);

        System.out.println("Introduce el número de filas (N): ");
        int n = scan.nextInt();

        System.out.println("Introduce el número de columnas (M): ");
        int m = scan.nextInt();

        int[][] matrizNM = new int[n][m]; // Creamos la matriz con el tamaño dinámico introducido

        // Pedimos los valores para rellenar la matriz
        System.out.println("Introduce los valores de la matriz:");
        for (int i = 0; i < matrizNM.length; i++) {
            for (int j = 0; j < matrizNM[i].length; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matrizNM[i][j] = scan.nextInt();
            }
        }

        int mayoresCero = 0; // Contador
        int menoresCero = 0; // Contador
        int igualesCero = 0; // Contador

        // Recorremos la matriz para contar los positivos, negativos y ceros
        for (int i = 0; i < matrizNM.length; i++) {
            for (int j = 0; j < matrizNM[i].length; j++) {
                if (matrizNM[i][j] > 0) {
                    mayoresCero++;
                } else if (matrizNM[i][j] < 0) {
                    menoresCero++;
                } else {
                    igualesCero++;
                }
            }
        }

        System.out.println("Valores mayores que cero: " + mayoresCero);
        System.out.println("Valores menores que cero: " + menoresCero);
        System.out.println("Valores iguales a cero: " + igualesCero);

/* 4. Necesitamos crear un programa para almacenar las notas de 4 alumnos (llamados “Alumno
1”, “Alumno 2”, etc.) y 5 asignaturas. El usuario introducirá las notas por teclado y luego el
programa mostrará la nota mínima, máxima y media de cada alumno. */
        System.out.println("Ejercicio 4");
        scan = new Scanner(System.in);

        double[][] notasAlumnos = new double[4][5]; // Creamos una matriz de 4 filas (alumnos) y 5 columnas (asignaturas)

        // Pedir por teclado
        for (int i = 0; i < notasAlumnos.length; i++) {
            System.out.println("Introduce las notas para el Alumno " + (i + 1) + ":");
            for (int j = 0; j < notasAlumnos[i].length; j++) {
                System.out.print("  Asignatura " + (j + 1) + ": ");
                notasAlumnos[i][j] = scan.nextDouble();
            }
        }

        // Recorremos la matriz para calcular la mínima, máxima y media de cada alumno
        System.out.println(" Resultados por alumno: ");
        for (int i = 0; i < notasAlumnos.length; i++) {
            double suma = notasAlumnos[i][0];
            double minimo = notasAlumnos[i][0];
            double maximo = notasAlumnos[i][0];

            // Calculamos los valores recorriendo las asignaturas de este alumno
            for (int j = 1; j < notasAlumnos[i].length; j++) {
                suma += notasAlumnos[i][j];

                if (notasAlumnos[i][j] < minimo) {
                    minimo = notasAlumnos[i][j];
                }
                if (notasAlumnos[i][j] > maximo) {
                    maximo = notasAlumnos[i][j];
                }
            }

            double media = suma / notasAlumnos[i].length; // Calculr la media


            System.out.println("Alumno " + (i + 1) + ": ");
            System.out.println("  Nota mínima: " + minimo);
            System.out.println("  Nota máxima: " + maximo);
            System.out.println("  Nota media:  " + media);
        }

/* 5.  Necesitamos crear un programa para registrar sueldos de hombres y mujeres de una empresa
y detectar si existe brecha salarial entre ambos. El programa pedirá por teclado la información
de N personas distintas (valor también introducido por teclado). Para cada persona, pedirá su
género (0 para varón y 1 para mujer) y su sueldo. Esta información debe guardarse en una única
matriz. Luego se mostrará por pantalla el sueldo medio de cada género. */
        System.out.println("Ejercicio 5");
        scan = new Scanner(System.in);

        System.out.println("Introduce el número de personas (N): ");
        int n5 = scan.nextInt();

        double[][] matrizSueldos = new double[n5][2];


        for (int i = 0; i < n5; i++) {
            System.out.println("Persona " + (i + 1));
            System.out.println("Género (0 varón, 1 mujer): ");
            matrizSueldos[i][0] = scan.nextDouble();

            System.out.println("Sueldo: ");
            matrizSueldos[i][1] = scan.nextDouble();
        }

        double sumaVarones = 0;
        int contVarones = 0;
        double sumaMujeres = 0;
        int contMujeres = 0;

        // Recorremos la matriz para sumar
        for (int i = 0; i < n5; i++) {
            if (matrizSueldos[i][0] == 0) {
                sumaVarones = sumaVarones + matrizSueldos[i][1];
                contVarones++;
            } else {
                sumaMujeres = sumaMujeres + matrizSueldos[i][1];
                contMujeres++;
            }
        }

        // Mostramos resultados
        System.out.println("Sueldo medio varones: " + (sumaVarones / contVarones));
        System.out.println("Sueldo medio mujeres: " + (sumaMujeres / contMujeres));

    }
}