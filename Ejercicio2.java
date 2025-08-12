import java.util.Scanner;

public class MenorNumero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números a comparar (mínimo 10): ");
        int cantidad = sc.nextInt();

        if (cantidad < 10) {
            System.out.println("Debes ingresar al menos 10 números.");
            sc.close();
            return;
        }

        int menor = Integer.MAX_VALUE;

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int num = sc.nextInt();

            if (num < menor) {
                menor = num;
            }
        }

        System.out.println("El número menor es: " + menor);

        if (menor < 10) {
            System.out.println("El número menor es menor que 10!");
        } else {
            System.out.println("El número menor es igual o mayor que 10!");
        }

        sc.close();
    }
}
