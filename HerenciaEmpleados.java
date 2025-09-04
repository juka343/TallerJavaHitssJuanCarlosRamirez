class Persona {
    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Edad: " + edad;
    }
}

class Empleado extends Persona {
    private double sueldo;

    public Empleado(String nombre, int edad, double sueldo) {
        super(nombre, edad);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void aumentarSueldo(double porcentaje) {
        sueldo += sueldo * porcentaje / 100.0;
    }

    @Override
    public String toString() {
        return super.toString() + ", Sueldo: $" + sueldo;
    }
}

class Gerente extends Empleado {
    private double presupuesto;

    public Gerente(String nombre, int edad, double sueldo, double presupuesto) {
        super(nombre, edad, sueldo);
        this.presupuesto = presupuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return super.toString() + ", Presupuesto: $" + presupuesto;
    }
}

class Cliente extends Persona {
    private String telefono;

    public Cliente(String nombre, int edad, String telefono) {
        super(nombre, edad);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return super.toString() + ", Teléfono: " + telefono;
    }
}

public class Main {
    public static void main(String[] args) {
        Gerente g = new Gerente("Ana", 40, 50000, 200000);
        System.out.println("=== Datos del Gerente ===");
        System.out.println(g);

        // Probar aumento de sueldo y cambio de presupuesto
        g.aumentarSueldo(10); // 10%
        g.setPresupuesto(250000);

        System.out.println("\n=== Datos del Gerente tras modificaciones ===");
        System.out.println(g);
    }
}
