import java.util.Scanner;

public class MenuRestaurante {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double totalVentas = 0;
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("1. Registrar un pedido");
            System.out.println("2. Mostrar total de ventas");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();

            if (opcion == 1) {
                System.out.print("Ingrese el precio del pedido: ");
                double precio = sc.nextDouble();
                if (precio > 0) {
                    totalVentas = totalVentas + precio;
                } else {
                    System.out.println("El precio debe ser positivo.");
                }
            } else if (opcion == 2) {
                System.out.println("Total de ventas: $" + totalVentas);
            } else if (opcion == 3) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}
