import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class MainProyectoVuelo {

    public static void main(String[] args) {

        // Creamos una lista para guardar todos los vuelos 
        List<Vuelo> vuelos = new ArrayList<>();

        // Para que Java entienda las fechas en español ("Lun", "Ago"), 
        // creamos un formateador con el Locale correspondiente.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E dd MMM yyyy HH:mm", new Locale("es", "ES"));

        // Agregamos todos los vuelos de la tabla a nuestra lista [cite: 3]
        vuelos.add(new Vuelo("AAL 933", "New York", "Santiago", LocalDateTime.parse("Lun 29 Ago 2021 05:39", formatter), 62));
        vuelos.add(new Vuelo("LAT 755", "Sao Paulo", "Santiago", LocalDateTime.parse("Lun 31 Ago 2021 04:45", formatter), 47));
        vuelos.add(new Vuelo("SKU 621", "Rio De Janeiro", "Santiago", LocalDateTime.parse("Lun 30 Ago 2021 16:00", formatter), 52));
        vuelos.add(new Vuelo("DAL 147", "Atlanta", "Santiago", LocalDateTime.parse("Lun 29 Ago 2021 13:22", formatter), 59));
        vuelos.add(new Vuelo("AVA 241", "Bogota", "Santiago", LocalDateTime.parse("Lun 31 Ago 2021 14:05", formatter), 25));
        vuelos.add(new Vuelo("AMX 10", "Mexico City", "Santiago", LocalDateTime.parse("Lun 31 Ago 2021 05:20", formatter), 29));
        vuelos.add(new Vuelo("IBE 6833", "Londres", "Santiago", LocalDateTime.parse("Lun 30 Ago 2021 08:45", formatter), 55));
        vuelos.add(new Vuelo("LAT 2479", "Frankfurt", "Santiago", LocalDateTime.parse("Lun 29 Ago 2021 07:41", formatter), 51));
        vuelos.add(new Vuelo("SKU 803", "Lima", "Santiago", LocalDateTime.parse("Lun 30 Ago 2021 10:35", formatter), 48));
        vuelos.add(new Vuelo("LAT 533", "Los Ángeles", "Santiago", LocalDateTime.parse("Lun 29 Ago 2021 09:14", formatter), 59));
        vuelos.add(new Vuelo("LAT 1447", "Guayaquil", "Santiago", LocalDateTime.parse("Lun 31 Ago 2021 08:33", formatter), 31));
        vuelos.add(new Vuelo("CMP 111", "Panama City", "Santiago", LocalDateTime.parse("Lun 31 Ago 2021 15:15", formatter), 29));
        vuelos.add(new Vuelo("LAT 705", "Madrid", "Santiago", LocalDateTime.parse("Lun 30 Ago 2021 08:14", formatter), 47));
        vuelos.add(new Vuelo("AAL 957", "Miami", "Santiago", LocalDateTime.parse("Lun 29 Ago 2021 22:53", formatter), 60));
        vuelos.add(new Vuelo("ARG 5091", "Buenos Aires", "Santiago", LocalDateTime.parse("Lun 31 Ago 2021 09:57", formatter), 32));
        vuelos.add(new Vuelo("LAT 1283", "Cancún", "Santiago", LocalDateTime.parse("Lun 31 Ago 2021 04:00", formatter), 35));
        vuelos.add(new Vuelo("LAT 579", "Barcelona", "Santiago", LocalDateTime.parse("Lun 29 Ago 2021 07:45", formatter), 61));
        vuelos.add(new Vuelo("AAL 945", "Dallas-Fort Worth", "Santiago", LocalDateTime.parse("Lun 30 Ago 2021 07:12", formatter), 58));
        vuelos.add(new Vuelo("LAT 501", "París", "Santiago", LocalDateTime.parse("Lun 29 Ago 2021 18:29", formatter), 49));
        vuelos.add(new Vuelo("LAT 405", "Montevideo", "Santiago", LocalDateTime.parse("Lun 30 Ago 2021 15:45", formatter), 39));

        // 1. Ordenar la lista por fecha de llegada de forma ascendente [cite: 6, 9]
        vuelos.sort(Comparator.comparing(Vuelo::getFechaLlegada));
        System.out.println("Lista de vuelos ordenada por llegada:");
        vuelos.forEach(System.out::println);

        System.out.println("\n------------------------------------------------\n");

        // 2. Obtener el último vuelo en llegar [cite: 10]
        // Como la lista ya está ordenada, el último es el que está al final.
        Vuelo ultimoVuelo = vuelos.get(vuelos.size() - 1);
        DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss yyyy", new Locale("en", "US"));
        System.out.println("✈️ El último vuelo en llegar es " + ultimoVuelo.getNombre() + ": " + ultimoVuelo.getOrigen() +
                           ", aterriza el " + ultimoVuelo.getFechaLlegada().format(formatoSalida));

        System.out.println("\n------------------------------------------------\n");
        
        // 3. Obtener el vuelo con menor número de pasajeros [cite: 11]
        Vuelo vueloMenosPasajeros = vuelos.get(0); // Empezamos asumiendo que el primero es el menor
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getNumPasajeros() < vueloMenosPasajeros.getNumPasajeros()) {
                vueloMenosPasajeros = vuelo; // Si encontramos uno con menos, lo guardamos
            }
        }
        System.out.println("El vuelo con menor número de pasajeros es " + vueloMenosPasajeros.getNombre() + ": " +
                           vueloMenosPasajeros.getOrigen() + ", con " + vueloMenosPasajeros.getNumPasajeros() + " pasajeros.");
    }
}
