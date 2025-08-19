import java.util.Scanner;

public class Ejercicio2Arreglos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arreglo = new int[10];

        System.out.println("Ingresa 10 numeros del 1 al 9:");

        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            arreglo[i] = sc.nextInt();
        }

        int numeroMasRepetido = arreglo[0];
        int maxOcurrencias = 0;

        for (int i = 0; i < arreglo.length; i++) {
            int contador = 0;

            for (int j = 0; j < arreglo.length; j++) {
                if (arreglo[i] == arreglo[j]) {
                    contador++;
                }
            }

            if (contador > maxOcurrencias) {
                maxOcurrencias = contador;
                numeroMasRepetido = arreglo[i];
            }
        }

        System.out.println("La mayor ocurrencia es: " + maxOcurrencias);
        System.out.println("El elemento que mas se repite es: " + numeroMasRepetido);
    }
}
