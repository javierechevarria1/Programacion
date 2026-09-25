import java.util.Scanner;

/* 1. Escribe un programa que dé los “buenos días”. */
    public class Main {
        public static void main(String[] args) {
        System.out.println("Ejercicio 1");
        System.out.println("Buenos dias");

/* 2. Escribe un programa que calcule y muestre el área de un cuadrado de lado igual a 5. */
        System.out.println("Ejercicio 2");
        double lado = 7;
        double area = lado * lado;
        System.out.println("El area es: " + area);

/* 3. Escribe un programa que calcule el área de un cuadrado cuyo lado se introduce por teclado. */
        System.out.println("Ejercicio 3");
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el valor de lado");
        double lado2 = scan.nextDouble();
        System.out.println("El area del cuadrado es: " + (lado2 * lado2));

/* 4.Escribe un programa que lea dos números, calcule y muestre el valor de sus suma, resta, producto y división. */
        System.out.println("Ejercicio 4");
        System.out.println("Ingrese el primer numero");
        double num1 = scan.nextDouble();
        System.out.println("Ingrese el segundo numero");
        double num2 = scan.nextDouble();

        System.out.println("Suma: " + (num1 + num2));
        System.out.println("Resta: " + (num1 - num2));
        System.out.println("Producto: " + (num1 * num2));
        System.out.println("Division: " + (num1 / num2));

/* 5.Escribe un programa que toma como dato de entrada un número que corresponde a la
longitud de un radio y nos escribe la longitud de la circunferencia, el área del círculo y el
volumen de la esfera que corresponden con dicho radio. */
        System.out.println("Ejercicio 5");
        System.out.println("Ingrese el valor del radio");
        double radio = scan.nextDouble();

        System.out.println("La longitud de la circunferencia es: " + (2 * radio * Math.PI));
        System.out.println("El area de la circunferencia es: " + (Math.PI * radio * radio));
        System.out.println("El volumen de la esfera es: " + ((4/3.0) * Math.PI * Math.pow(radio, 3)));

/* 6.Escribe un programa que dado el precio de un artículo y el precio de venta real nos
muestre el porcentaje de descuento realizado. */
        System.out.println("Ejercicio 6");
        System.out.println("El precio del articulo es: ");
        double precio1 = scan.nextDouble();

        System.out.println("El precio de venta real es: ");
        double precio2 = scan.nextDouble();

        System.out.println("El porcentaje de descuento es: " + ((precio1 - precio2 ) / precio1 * 100));
/* 7.Escribe un programa que lea un valor correspondiente a una distancia en millas marinas
y escriba la distancia en metros. Sabiendo que una milla marina equivale a 1.852 metros. */




    }
}