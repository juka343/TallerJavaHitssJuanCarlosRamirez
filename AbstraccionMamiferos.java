abstract class Mamifero {
    protected String habitat;
    protected double altura;
    protected double largo;
    protected double peso;
    protected String nombreCientifico;

    public Mamifero(String habitat, double altura, double largo, double peso, String nombreCientifico) {
        this.habitat = habitat;
        this.altura = altura;
        this.largo = largo;
        this.peso = peso;
        this.nombreCientifico = nombreCientifico;
    }

    public String getHabitat() { return habitat; }
    public double getAltura() { return altura; }
    public double getLargo() { return largo; }
    public double getPeso() { return peso; }
    public String getNombreCientifico() { return nombreCientifico; }

    public abstract String comer();
    public abstract String dormir();
    public abstract String correr();
    public abstract String comunicarse();

    @Override
    public String toString() {
        return "Nombre científico: " + nombreCientifico +
               ", Habitat: " + habitat +
               ", Altura: " + altura + "m" +
               ", Largo: " + largo + "m" +
               ", Peso: " + peso + "kg";
    }
}

abstract class Canino extends Mamifero {
    protected String color;
    protected double tamColmillos;

    public Canino(String habitat, double altura, double largo, double peso, String nombreCientifico,
                  String color, double tamColmillos) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.color = color;
        this.tamColmillos = tamColmillos;
    }

    public String getColor() { return color; }
    public double getTamColmillos() { return tamColmillos; }
}

abstract class Felino extends Mamifero {
    protected double tamGarras;
    protected int velocidad;

    public Felino(String habitat, double altura, double largo, double peso, String nombreCientifico,
                  double tamGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico);
        this.tamGarras = tamGarras;
        this.velocidad = velocidad;
    }

    public double getTamGarras() { return tamGarras; }
    public int getVelocidad() { return velocidad; }
}

class Leon extends Felino {
    private int numManada;
    private double potenciaRugido;

    public Leon(String habitat, double altura, double largo, double peso, String nombreCientifico,
                double tamGarras, int velocidad, int numManada, double potenciaRugido) {
        super(habitat, altura, largo, peso, nombreCientifico, tamGarras, velocidad);
        this.numManada = numManada;
        this.potenciaRugido = potenciaRugido;
    }

    @Override
    public String comer() {
        return "El León caza junto a su grupo de " + numManada + " individuos en " + habitat;
    }

    @Override
    public String dormir() {
        return "El León duerme bajo la sombra en " + habitat;
    }

    @Override
    public String correr() {
        return "El León corre a una velocidad de " + velocidad + " km/h";
    }

    @Override
    public String comunicarse() {
        return "El León ruge con una potencia de " + potenciaRugido + " decibeles";
    }
}

class Tigre extends Felino {
    private String especieTigre;

    public Tigre(String habitat, double altura, double largo, double peso, String nombreCientifico,
                 double tamGarras, int velocidad, String especieTigre) {
        super(habitat, altura, largo, peso, nombreCientifico, tamGarras, velocidad);
        this.especieTigre = especieTigre;
    }

    @Override
    public String comer() {
        return "El Tigre de especie " + especieTigre + " acecha en " + habitat;
    }

    @Override
    public String dormir() {
        return "El Tigre duerme entre la vegetación de " + habitat;
    }

    @Override
    public String correr() {
        return "El Tigre corre a " + velocidad + " km/h en la selva";
    }

    @Override
    public String comunicarse() {
        return "El Tigre ruge imponente";
    }
}

class Guepardo extends Felino {
    public Guepardo(String habitat, double altura, double largo, double peso, String nombreCientifico,
                    double tamGarras, int velocidad) {
        super(habitat, altura, largo, peso, nombreCientifico, tamGarras, velocidad);
    }

    @Override
    public String comer() {
        return "El Guepardo caza con rapidez en " + habitat;
    }

    @Override
    public String dormir() {
        return "El Guepardo duerme bajo arbustos en " + habitat;
    }

    @Override
    public String correr() {
        return "El Guepardo alcanza hasta " + velocidad + " km/h";
    }

    @Override
    public String comunicarse() {
        return "El Guepardo emite gruñidos cortos";
    }
}

class Lobo extends Canino {
    private int numCamada;
    private String especieLobo;

    public Lobo(String habitat, double altura, double largo, double peso, String nombreCientifico,
                String color, double tamColmillos, int numCamada, String especieLobo) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamColmillos);
        this.numCamada = numCamada;
        this.especieLobo = especieLobo;
    }

    @Override
    public String comer() {
        return "El Lobo " + especieLobo + " caza en manada de " + numCamada + " individuos";
    }

    @Override
    public String dormir() {
        return "El Lobo " + color + " duerme en cuevas de " + habitat;
    }

    @Override
    public String correr() {
        return "El Lobo recorre largas distancias en " + habitat;
    }

    @Override
    public String comunicarse() {
        return "El Lobo aúlla bajo la luna";
    }
}

class Perro extends Canino {
    private int fuerzaMordida;

    public Perro(String habitat, double altura, double largo, double peso, String nombreCientifico,
                 String color, double tamColmillos, int fuerzaMordida) {
        super(habitat, altura, largo, peso, nombreCientifico, color, tamColmillos);
        this.fuerzaMordida = fuerzaMordida;
    }

    @Override
    public String comer() {
        return "El Perro salvaje africano caza con mordida de " + fuerzaMordida + " psi";
    }

    @Override
    public String dormir() {
        return "El Perro salvaje africano duerme en " + habitat;
    }

    @Override
    public String correr() {
        return "El Perro salvaje africano corre en grupos organizados";
    }

    @Override
    public String comunicarse() {
        return "El Perro salvaje africano ladra y chilla para comunicarse";
    }
}

public class EjemploMamiferos {
    public static void main(String[] args) {
        Mamifero[] mamiferos = new Mamifero[5];

        mamiferos[0] = new Leon("Sabana africana", 1.2, 2.3, 190, "Panthera leo", 7, 80, 10, 114);
        mamiferos[1] = new Tigre("Selva tropical", 1.1, 2.5, 220, "Panthera tigris", 8, 60, "Bengala");
        mamiferos[2] = new Guepardo("Llanuras africanas", 0.9, 1.5, 72, "Acinonyx jubatus", 5, 110);
        mamiferos[3] = new Lobo("Bosques templados", 0.8, 1.4, 60, "Canis lupus", "gris", 5, 8, "Ártico");
        mamiferos[4] = new Perro("Sabana africana", 0.75, 1.2, 40, "Lycaon pictus", "manchado", 4, 340);

        for (Mamifero m : mamiferos) {
            System.out.println("=== " + m.getClass().getSimpleName() + " ===");
            System.out.println(m);
            System.out.println(m.comer());
            System.out.println(m.dormir());
            System.out.println(m.correr());
            System.out.println(m.comunicarse());
            System.out.println();
        }
    }
}
