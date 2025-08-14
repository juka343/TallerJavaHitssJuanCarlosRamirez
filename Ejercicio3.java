import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sumaMayores = 0, sumaMenores = 0, sumaTotal = 0;
        int contMayores = 0, contMenores = 0, contIgualUno = 0;

        for (int i = 1; i <= 20; i++) {
            System.out.print("Ingrese la nota " + i + " (1.0 - 10.0): ");
            double nota = sc.nextDouble();

            if (nota < 1.0 || nota > 10.0) {
                System.out.println("Error: nota fuera de rango. Programa finalizado.");
                return; // Sale del programa
            }

            sumaTotal += nota;

            if (nota >= 6.0) {
                sumaMayores += nota;
                contMayores++;
            } else {
                sumaMenores += nota;
                contMenores++;
            }

            if (nota == 1.0) {
                contIgualUno++;
            }
        }

        double promMayores = (contMayores > 0) ? (sumaMayores / contMayores) : 0;
        double promMenores = (contMenores > 0) ? (sumaMenores / contMenores) : 0;
        double promTotal = sumaTotal / 20;

        System.out.println("Promedio de notas >= 6: " + promMayores);
        System.out.println("Promedio de notas < 6: " + promMenores);
        System.out.println("Cantidad de notas iguales a 1: " + contIgualUno);
        System.out.println("Promedio total: " + promTotal);
    }
}
