import java.util.Scanner;

/* 1.Escribe un programa que pide la edad por teclado y nos muestra el mensaje de “Eres
mayor de edad” solo si lo somos ”. */
public class Main {
    public static void main (String[] args) {
        System.out.println("Ejercicio 1");
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca su edad: ");
        int edad;
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

        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }
        else if (edad <18 && edad >= 0) {
            System.out.println("Eres menor");
        }
        else {
            System.out.println("La edad de una persona no puede ser numero negativo");
        }


/* 3. Realiza un programa que muestre por pantalla los 20 primeros números naturales (1, 2,
3... 20). */
        System.out.println("Ejercicio 3");
        System.out.println("Estos son los primeros 20 numeros naturales: ");
        for (int cont = 1; cont <= 20; cont++) {
            System.out.println(cont);
        }
/* 4. Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Para ello utiliza un contador y suma de 2 en 2. */
        System.out.println("Ejercicio 4");
        System.out.println("Estos son los numeros pares comprendidos entre el 1 y el 200: ");
        for (int cont = 2; cont <= 200; cont += 2) {
            System.out.println(cont);
        }

/* 5. Realiza un programa que muestre los números pares comprendidos entre el 1 y el 200.
Esta vez utiliza un contador sumando de 1 en 1. */
        System.out.println("Ejercicio 5");
        System.out.println("Estos son los numeros pares comprendidos entre el 1 y el 200: ");
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
        for (int cont = 1; cont <= n; cont++) {
            System.out.println(cont);
        }
/* 7. Escribe un programa que lea una calificación numérica entre 0 y 10 y la transforma en
calificación alfabética, escribiendo el resultado. */
        System.out.println("Ejercicio 7");
        scan = new Scanner(System.in);
        double nota;
        System.out.println("Introduce la nota: ");
        nota = scan.nextDouble();

        if (nota < 0 || nota > 10) {
            System.out.println("Nota no válida. Debe estar entre 0 y 10.");
        } else if (nota < 3) {
            System.out.println("Muy Deficiente");
        } else if (nota < 5) {
            System.out.println("Insuficiente");
        } else if (nota < 6) {
            System.out.println("Suficiente");
        } else if (nota < 7) {
            System.out.println("Bien");
        } else if (nota < 9) {
            System.out.println("Notable");
        } else {
            System.out.println("Sobresaliente");
        }


/* 8. Realiza un programa que lea un número positivo N y calcule y visualice su factorial N!
Siendo el factorial: */
        System.out.println("Ejercicio 8");
        scan = new Scanner(System.in);
        System.out.println("Introduce un numero: ");
        n = scan.nextInt(); //Aqui la variable n ya existe arriba en los otros ejercicios sino seria "int n"
        double factorial = 1;

        if (n < 0) {
            System.out.println("Error: El numero debe ser positivo");
        } else {
            for (int i = n; i > 0; i--) {
                factorial = factorial * i;
            }
            System.out.println("Resultado: " + factorial);
        }


/* 9. Escribe un programa que recibe como datos de entrada una hora expresada en horas,
minutos y segundos que nos calcula y escribe la hora, minutos y segundos que serán,
transcurrido un segundo. */
        System.out.println("Ejercicio 9");
        scan = new Scanner(System.in);

        System.out.println("Introduce las horas: ");
        int horas = scan.nextInt(); //Guardamos horas
        System.out.println("Introduce los minutos: ");
        int minutos = scan.nextInt(); //Guardamos minutos
        System.out.println("Introduce los segundos: ");
        int segundos = scan.nextInt(); //Guardamos segundos

        segundos = segundos + 1; //Miramos los segundos y añadimos 1 segundo al valor que hay
        if (segundos == 60) { // El programa pregunta: ¿La caja de segundos es igual a 60?
            segundos = 0; //SI era 60 vaciamos la caja de segundos y la ponemos a 0.
            minutos = minutos + 1; // Y como ha pasado un minuto entero le sumamos 1 a la caja de los minutos.

            if (minutos == 60) { // El programa pregunta: ¿Y la caja de minutos es igual a 60?
                minutos = 0; // Si era 60 vaciamos la caja de minutos y la ponemos a 0.
                horas = horas + 1; // Y como ha pasado una hora entera, le sumamos 1 a la caja de las horas.

                if (horas == 24) { // El programa pregunta: ¿La caja de horas ha llegado a 24?
                    horas = 0; // Si era 24 vaciamos la caja y la ponemos a 0.
                }
            }
        }
        System.out.println("La hora un segundos despues es: " + horas + ":" + minutos + ":" + segundos);


/* 10. Realiza un programa que lea 10 números no nulos y luego muestre un mensaje de si ha
leído algún número negativo o no. */
        System.out.println("Ejercicio 10");
        scan = new Scanner(System.in);

        boolean hayNegativo = false; // Esto es que no hay ninguno porque todavia no hemos introducida numero
        for (int i = 1; i <=10; i++){ // Cuenta del 1 al 10 de uno en uno
            System.out.println("Introduce el numero " + i + ": ");
            int num = scan.nextInt(); // Lee y guarda el numero introducido

            if (num < 0){
                hayNegativo = true; // Guarda si un numero es menor que 0
            }
        }

        if (hayNegativo == true){
            System.out.println("Se ha leido algun numero negativo");
        }
        else {
            System.out.println("No se ha leido ningun numero negativo");
        }

/* 11. Realiza un programa que lea 10 números no nulos y luego muestre un mensaje
indicando cuántos son positivos y cuantos negativos.
 */
        System.out.println("Ejercicio 11");
        scan = new Scanner(System.in);

        int positivos = 0; // Contador de positivos
        int negativos = 0; // Contador de negativos

        for (int i = 1; i <=10; i++) { // Cuenta del 1 al 10 de uno en uno
            System.out.println("Introduce el numero " + i + ": ");
            int num = scan.nextInt(); // Lee y guarda el numero introducido

            if (num < 0){
                negativos = negativos + 1; // Aqui si el numero es menor que 0 se añade un 1 a los negativos
            }
            else {
                positivos = positivos + 1; // Si no es menor que 0 o sea es positivo se añade un 1 a los positivos
            }
        }
        System.out.println("Total de numeros positivos: " + positivos);
        System.out.println("Total de numeros negativos: " + negativos);


/* 12. Realiza un programa que lea una secuencia de números no nulos hasta que se introduzca
un 0, y luego muestre si ha leído algún número negativo, cuantos positivos y cuantos
negativos. */
        System.out.println("Ejercicio 12");
        scan = new Scanner(System.in);

        positivos = 0; // Aqui la variable existe ya asi que no hace falta poner el int
        negativos = 0; // Aqui la variable existe ya asi que no hace falta poner el int
        boolean hayNegativos = false; // Libreta para apuntar con true/false si vimos algún negativo

        System.out.println("Introduce un número (o pon 0 para terminar): ");
        int num = scan.nextInt(); // Pedimos un numero para tener antes del bucle

        while (num != 0) { // Mientras el número metido NO sea 0, haz lo que hay aquí dentro
            if  (num <0) {
                negativos = negativos + 1; // Sumamos 1 a la caja de negativos
                hayNegativos = true; // Se apunta un SÍ
            }
            else {
                positivos = positivos + 1; // Sumamos 1 a la caja de positivos
            }
            System.out.println("Introduce otro numero (o pon 0 para terminar: ");
            num = scan.nextInt();
        }
        if (hayNegativos == true){
            System.out.println("Si se ha leido algun numero negativo.");
        }
        else{
            System.out.println("No se ha leido ningun numero negativo.");
        }

        System.out.println("Total de numeros positivos: " + positivos);
        System.out.println("Total de numeros negativos: " + negativos);


/* 13.  Realiza un programa que calcule y escriba la suma y el producto de los 10 primeros
números naturales. */
        System.out.println("Ejercicio 13");

        int suma = 0;
        int producto = 1;

        for (int i = 1; i <=10; i++) {
            suma = suma + i; // Cogemos lo que ya había en la caja 'suma' y le añadimos el número actual 'i'
            producto = producto * i; // Cogemos lo que había en la caja 'producto' y lo multiplicamos por el número 'i'
        }
        System.out.println("La suma de los 10 primero numeros es: " + suma);
        System.out.println("El producto de los 10 primero numeros es: " + producto);


/* 14. Escribe un programa que calcula el salario neto semanal de un trabajador en función del
número de horas trabajadas y la tasa de impuestos de acuerdo a las siguientes hipótesis:
 */
        System.out.println("Ejercicio 14");
        scan = new Scanner(System.in);

        System.out.println("Introduce tu nombre: ");
        String nombre = scan.next(); //Guardamos el nombre

        System.out.println("Introduce las horas trabajadas esta semana: ");
        double horasTrabajadas = scan.nextDouble(); // Esto es para decimales

        //Lo siguiente es para crear las tarifas y precio
        double precioHoraNormal = 10.0; //Precio base
        double precioHoraExtra = precioHoraNormal * 1.5; // Las extras valen 1.5 mas
        double salarioBruto = 0; // Aqui se guarda el total antes de impuestos

        // Aqui calculamos el salario bruto
        if (horasTrabajadas <= 35) {
            salarioBruto = horasTrabajadas * precioHoraNormal; // Aqui se paga las horas que hagas menor a 35 a precio normal
        }
        else {
            salarioBruto = (35* precioHoraNormal) + ((horasTrabajadas - 35) * precioHoraExtra); // Aqui se paga las 35 horas a precio normal, y las horas extras que se pagan 1.5
        }
        // Calculo de las tasas
        double tasas = 0; //Empezamos con 0

        if (salarioBruto > 500) { //Si ganas mas de 500 pagas impuesto
            if (salarioBruto <= 900) { // Si ganas entre 500€ y 900€:
                tasas = (salarioBruto - 500) * 25 / 100; // Pagas el 25% de lo que pase de 500
            }
            else {
                tasas = 100 + ((salarioBruto - 900) * 45 / 100); // Pagas 100€ fijos más el 45% de lo que pase de 900
            }
        }
        double salarioNeto = salarioBruto - tasas; //Dinero limpio total restando impuestos

        System.out.println("Trabajador: " + nombre);
        System.out.println("Salario Bruto: " + salarioBruto + "$");
        System.out.println("Tasas Impuestos: " + tasas + "$");
        System.out.println("Salario Neto: " + salarioNeto + "$");
    }
}


