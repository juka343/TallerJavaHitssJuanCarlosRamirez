import java.util.ArrayList;

class Cuenta {
    private static int contadorCuentas = 1; 
    private int id;
    private String titular;
    private double saldo;
    private ArrayList<Transaccion> historial;

    public Cuenta(String titular, double depositoInicial) {
        this.id = contadorCuentas++;
        this.titular = titular;
        this.saldo = depositoInicial;
        this.historial = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        saldo += monto;
        Transaccion t = new Transaccion("Depósito", monto, this);
        historial.add(t);
    }

    public void retirar(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            Transaccion t = new Transaccion("Retiro", monto, this);
            historial.add(t);
        } else {
            System.out.println("Fondos insuficientes para retirar $" + monto);
        }
    }

    public void mostrarInfo() {
        System.out.println("Cuenta ID: " + id + " | Titular: " + titular + " | Saldo: $" + saldo);
        System.out.println("Historial de transacciones:");
        for (Transaccion t : historial) {
            t.mostrarInfo();
        }
    }
}

class Transaccion {
    private static int contadorTransacciones = 1;
    private int id;
    private String tipo;
    private double monto;
    private Cuenta cuenta;

    public Transaccion(String tipo, double monto, Cuenta cuenta) {
        this.id = contadorTransacciones++;
        this.tipo = tipo;
        this.monto = monto;
        this.cuenta = cuenta;
    }

    public void mostrarInfo() {
        System.out.println("   Transacción ID: " + id +
                           " | Tipo: " + tipo +
                           " | Monto: $" + monto +
                           " | Cuenta ID: " + cuenta.getId());
    }
}

public class SistemaBancario {
    public static void main(String[] args) {
        // Crear cuentas
        Cuenta cuenta1 = new Cuenta("Ana", 5000);
        Cuenta cuenta2 = new Cuenta("Luis", 10000);

        // Operaciones de Ana
        cuenta1.depositar(2000);
        cuenta1.retirar(1000);

        // Operaciones de Luis
        cuenta2.retirar(3000);
        cuenta2.depositar(1500);

        // Mostrar resultados
        System.out.println("\n--- Estado de las cuentas ---");
        cuenta1.mostrarInfo();
        System.out.println();
        cuenta2.mostrarInfo();
    }
}
