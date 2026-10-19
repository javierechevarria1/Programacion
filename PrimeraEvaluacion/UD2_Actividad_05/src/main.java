import java.util.Scanner;

public class main {
    public static void main(String[] args){
/* 1. Crea un programa que pida una cadena de texto por teclado y luego muestre cada
palabra de la cadena en una línea distinta. */
        System.out.println("Ejercicio 1");
        Scanner scan = new Scanner(System.in);

        // Pedir la frase
        System.out.println("Introduce una frase:");
        String texto = scan.nextLine();

        // Romper la frase por cada espacio en blanco
        String[] palabras = texto.split(" ");

        // Mostrar cada una en una línea
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

/* 3. Crea un programa que pida por teclado tres cadenas de texto: nombre y dos apellidos.
Luego mostrará un código de usuario (en mayúsculas) formado por la concatenación de
las tres primeras letras de cada uno de ellos. Por ejemplo, si se introduce “Lionel”,
“Tarazón” y “Alcocer” mostrará “LIOTARALC”. */
        System.out.println("Ejercicio 3");
        scan = new Scanner(System.in);
        //Pedimos datos por terminal
        System.out.println("Introduzca su nombre: ");
        String texto4 = scan.nextLine();

        System.out.println("Introduzca su primer apellido: ");
        String texto5 = scan.nextLine();

        System.out.println("Introduzca su segundo apellido: ");
        String texto6 = scan.nextLine();

        // Muestra un codigo de usuario en mayusculas formado por concatenacion
        String codigo = texto4.substring(0,3);
        codigo = codigo + texto5.substring(0, 3);
        codigo = codigo + texto6.substring(0, 3);

        System.out.println("Codigo de usuario: " + codigo.toUpperCase());


/* 4. Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay (cuantas
‘a’, cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe diferenciar entre
mayúsculas y minúsculas. Por ejemplo, dada la frase “Mi mama me mima” dirá que hay:
Nº de A's: 3
Nº de E's: 1
Nº de I's: 2
Nº de O's: 0
Nº de U's: 0 */
        System.out.println("Ejercicio 4");
        scan = new Scanner(System.in);

        // Pedimos datos por terminal
        System.out.println("Introduzca una frase: ");
        String texto7 = scan.nextLine();

        // Pasamos la frase a minúsculas para no diferenciar mayúsculas de minúsculas
        texto7 = texto7.toLowerCase();

        // Las vocales que vamos a contar
        String vocales = "aeiou";

        // Bucle recorre cada vocal (a, e, i, o, u)
        for (int v = 0; v < vocales.length(); v++) {

            // Reiniciamos el contador a 0 para cada vocal nueva
            int contador = 0;

            // Bucle recorre cada carácter de la frase
            for (int k = 0; k < texto7.length(); k++) {

                // Si el carácter actual es la vocal que buscamos, sumamos 1
                if (texto7.charAt(k) == vocales.charAt(v)) {
                    contador++;
                }
            }

            // Mostramos el resultado de esa vocal en mayúscula
            System.out.println("Nº de " + Character.toUpperCase(vocales.charAt(v)) + "'s: " + contador);
        }

/* 5. Realiza un programa que lea una frase por teclado e indique si la frase es un palíndromo
o no (ignorando espacios y sin diferenciar entre mayúsculas y minúsculas).
Supondremos que el usuario solo introducirá letras y espacios (ni comas, ni puntos, ni
acentos, etc.). Un palíndromo es un texto que se lee igual de izquierda a derecha que de
derecha a izquierda.
Por ejemplo:
Amigo no gima
Dabale arroz a la zorra el abad
Amo la pacífica paloma
A man a plan a canal Panama */
        System.out.println("Ejercicio 5");
        scan = new Scanner(System.in);

        System.out.println("Introduzca una frase: ");
        String texto8 = scan.nextLine();

        int aes = 0;
        int ees = 0;
        int ies = 0;
        int oes = 0;
        int ues = 0;

        // Pasamos a minúsculas y quitamos los espacios
        String frase = texto8.toLowerCase().replace(" ", "");

        // Contamos cuántas letras no coinciden con su opuesta (primera con última, segunda con penúltima...)
        int diferencias = 0;
        for (int c = 0; c < frase.length() / 2; c++) {
            if (frase.charAt(c) != frase.charAt(frase.length() - 1 - c)) {
                diferencias++;
            }
        }

        // Si no hay ninguna diferencia, es palíndromo
        switch (diferencias) {
            case 0:
                System.out.println("La frase es un palíndromo");
                break;
            default:
                System.out.println("La frase NO es un palíndromo");
                break;
        }

    }
}