/**
 * Clase abstracta: la base común de todas las cartas.
 * No existe una "carta genérica" en el juego, por eso no se puede instanciar.
 */
public abstract class Carta implements Comparable<Carta> {
    private final int id;
    private String nombre;
    private int costoEnergia;
    private String descripcion;

    public Carta(int id, String nombre, int costoEnergia, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.costoEnergia = costoEnergia;
        this.descripcion = descripcion;
    }

    /**
     * Método polimórfico: cada tipo de carta tiene su propio efecto.
     * Devuelve un texto que describe lo que pasó, para que quien lo llame lo muestre.
     */
    public abstract String jugarCarta(Jugador jugador, Tablero tablero);

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getCostoEnergia() { return costoEnergia; }
    public void setCostoEnergia(int costoEnergia) { this.costoEnergia = costoEnergia; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    /** Orden natural: por costo de energía (lo usa Collections.sort). */
    @Override
    public int compareTo(Carta otra) {
        return Integer.compare(this.costoEnergia, otra.costoEnergia);
    }

    /** Dos cartas son iguales si tienen el mismo id. */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carta)) return false;
        return this.id == ((Carta) o).id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + nombre + " | Costo: " + costoEnergia + " | " + descripcion;
    }
}
