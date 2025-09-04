import java.util.Date;

// Interfaces
interface IProducto {
    int getPrecio();
    double getPrecioVenta();
}

interface IElectronico {
    String getFabricante();
}

interface ILibro {
    Date getFechaPublicacion();
    String getAutor();
    String getTitulo();
    String getEditorial();
}

// Clases abstractas
abstract class Producto implements IProducto {
    protected int precio;

    public Producto(int precio) {
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        return precio;
    }
}

abstract class Electronico extends Producto implements IElectronico {
    protected String fabricante;

    public Electronico(int precio, String fabricante) {
        super(precio);
        this.fabricante = fabricante;
    }

    @Override
    public String getFabricante() {
        return fabricante;
    }
}

// Clases concretas
class IPhone extends Electronico {
    private String color;
    private String modelo;

    public IPhone(int precio, String fabricante, String color, String modelo) {
        super(precio, fabricante);
        this.color = color;
        this.modelo = modelo;
    }

    public String getColor() { return color; }
    public String getModelo() { return modelo; }

    @Override
    public double getPrecioVenta() {
        return getPrecio() * 1.2; // ejemplo: 20% más
    }

    @Override
    public String toString() {
        return "IPhone " + modelo + " (" + color + ") - Fabricante: " + fabricante +
               ", Precio base: " + precio + ", Precio venta: " + getPrecioVenta();
    }
}

class TvLcd extends Electronico {
    private int pulgadas;

    public TvLcd(int precio, String fabricante, int pulgadas) {
        super(precio, fabricante);
        this.pulgadas = pulgadas;
    }

    public int getPulgadas() { return pulgadas; }

    @Override
    public double getPrecioVenta() {
        return getPrecio() * 1.15; // ejemplo: 15% más
    }

    @Override
    public String toString() {
        return "Tv LCD " + pulgadas + " pulgadas - Fabricante: " + fabricante +
               ", Precio base: " + precio + ", Precio venta: " + getPrecioVenta();
    }
}

class Libro extends Producto implements ILibro {
    private Date fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;

    public Libro(int precio, Date fechaPublicacion, String autor, String titulo, String editorial) {
        super(precio);
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    @Override
    public Date getFechaPublicacion() { return fechaPublicacion; }

    @Override
    public String getAutor() { return autor; }

    @Override
    public String getTitulo() { return titulo; }

    @Override
    public String getEditorial() { return editorial; }

    @Override
    public double getPrecioVenta() {
        return getPrecio() * 1.1; // 10% más
    }

    @Override
    public String toString() {
        return "Libro: " + titulo + " - Autor: " + autor + ", Editorial: " + editorial +
               ", Precio base: " + precio + ", Precio venta: " + getPrecioVenta();
    }
}

class Comics extends Libro {
    private String personaje;

    public Comics(int precio, Date fechaPublicacion, String autor, String titulo, String editorial, String personaje) {
        super(precio, fechaPublicacion, autor, titulo, editorial);
        this.personaje = personaje;
    }

    public String getPersonaje() { return personaje; }

    @Override
    public double getPrecioVenta() {
        return getPrecio() * 1.25; // 25% más
    }

    @Override
    public String toString() {
        return "Comic: " + getTitulo() + " - Autor: " + getAutor() + ", Personaje: " + personaje +
               ", Editorial: " + getEditorial() +
               ", Precio base: " + getPrecio() + ", Precio venta: " + getPrecioVenta();
    }
}

// Clase principal
public class ProyectoCatalogo {
    public static void main(String[] args) {
        IProducto[] productos = new IProducto[5];

        productos[0] = new IPhone(1000, "Apple", "Negro", "14 Pro");
        productos[1] = new TvLcd(2000, "Sony", 55);
        productos[2] = new Libro(300, new Date(), "Eric Gamma", "Patrones de Diseño", "Addison Wesley");
        productos[3] = new Libro(250, new Date(), "Martin Fowler", "UML Distilled", "Pearson");
        productos[4] = new Comics(150, new Date(), "Stan Lee", "Spider-Man", "Marvel", "Peter Parker");

        for (IProducto p : productos) {
            System.out.println(p);
        }
    }
}
