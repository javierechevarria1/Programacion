import java.util.Scanner;

public class main4 {
    public static void main(String[] args){
        System.out.println("Ejercicio 4: Contador de vocales");
        Scanner scan = new Scanner(System.in);

        System.out.println("Introduce una frase:");
        String frase = scan.nextLine();

        // Convertimos la frase a minusculas para contar igual mayusculas y minusculas
        frase = frase.toLowerCase();

        int contA = 0;
        int contE = 0;
        int contI = 0;
        int contO = 0;
        int contU = 0;

        // Recorremos la cadena caracter a caracter usando .length() y .charAt()
        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);

            if (letra == 'a') {
                contA = contA + 1;
            } else if (letra == 'e') {
                contE = contE + 1;
            } else if (letra == 'i') {
                contI = contI + 1;
            } else if (letra == 'o') {
                contO = contO + 1;
            } else if (letra == 'u') {
                contU = contU + 1;
            }
        }
        System.out.println("Numero de A: " + contA);
        System.out.println("Numero de E: " + contE);
        System.out.println("Numero de I: " + contI);
        System.out.println("Numero de O: " + contO);
        System.out.println("Numero de U: " + contU);

        scan.close();
    }
}
