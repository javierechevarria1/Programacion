import java.util.Scanner;

public class main5 {
    public static void main(String[] args) {
        System.out.println("Ejercicio 5: Tabla de multiplicar");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número entero para ver su tabla de multiplicar: ");
        int numero = scanner.nextInt();

        System.out.println("Tabla de multiplicar del " + numero + " ");

        for (int i = 1; i <= 10; i++) { // Bucle que va desde 1 hasta 10
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }

        scanner.close();
    }
}