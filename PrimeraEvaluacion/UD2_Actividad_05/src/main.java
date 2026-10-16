import java.util.Scanner;

public class main {
    public static void main(String[] args){
/* 1. Crea un programa que pida una cadena de texto por teclado y luego muestre cada
palabra de la cadena en una línea distinta. */
        System.out.println("Ejercicio 1");
        Scanner scan = new Scanner(System.in);

        // 1. Pedir la frase
        System.out.println("Introduce una frase:");
        String texto = scan.nextLine();

        // 2. Romper la frase por cada espacio en blanco
        String[] palabras = texto.split(" ");

        // 3. Mostrar cada una en una línea
        System.out.println("Resultado:");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }

/* 2. Crea un programa que pida dos cadenas de texto por teclado y luego indique si son
iguales, además de si son iguales sin diferenciar entre mayúsculas y minúsculas. */
        System.out.println("Ejercicio 2");
        scan = new Scanner(System.in);

        System.out.println("Introduce la primera cadena de texto: ");
        String texto2 = scan.nextLine();

        System.out.println("Introduce la segunda cadena de texto: ");
        String texto3 = scan.nextLine();
        // Comprobar respetando mayusculas y minusculas
        if(texto2.equals(texto3)){
            System.out.println("Son exactamente iguales.");
        }
        else{
            System.out.println("No son exactamente iguales.");
        }
        // Comrpobar ignorando mayusculas y minusculas
        if(texto2.equalsIgnoreCase(texto3)){
            System.out.println("Son iguales sin diferenciar mayusculas y minusculas.");
        }
        else{
            System.out.println("No son iguales de ninguna forma.");
        }

    }
}
