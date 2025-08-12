import java.util.Scanner;

public class MultiplicarSinAsterisco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el primer entero: ");
        int num1 = sc.nextInt();

        System.out.print("Introduce el segundo entero: ");
        int num2 = sc.nextInt();

        boolean negativo = (num1 < 0) ^ (num2 < 0);

        int a = Math.abs(num1);
        int b = Math.abs(num2);

        int resultado = 0;

        for (int i = 0; i < b; i++) {
            resultado += a;
        }

        if (negativo) {
            resultado = -resultado;
        }

        System.out.println("Resultado: " + resultado);
    }
}
