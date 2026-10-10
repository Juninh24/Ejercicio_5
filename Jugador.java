import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int energia;
    private List<Carta> mano;   // polimórfica: puede tener cualquier tipo de Carta

    public Jugador(String nombre) {
        this(nombre, 5);
    }

    /** Sobrecarga: permite elegir la energía inicial. */
    public Jugador(String nombre, int energiaInicial) {
        this.nombre = nombre;
        this.energia = energiaInicial;
        this.mano = new ArrayList<>();
    }

    public void ganarEnergia(int cantidad) {
        energia += cantidad;
    }

    /** La energía nunca baja de 0. */
    public void perderEnergia(int cantidad) {
        energia = Math.max(0, energia - cantidad);
    }

    /**
     * Usa una carta de la mano: valida energía, paga el costo y ejecuta su efecto.
     * Aquí está el polimorfismo: no importa qué tipo de carta sea, se llama igual.
     */
    public String usarCarta(Carta carta, Tablero tablero) {
        if (!mano.contains(carta)) {
            return "Esa carta no está en tu mano.";
        }
        if (energia < carta.getCostoEnergia()) {
            return "Energía insuficiente: tenés " + energia + " y la carta cuesta " + carta.getCostoEnergia() + ".";
        }
        perderEnergia(carta.getCostoEnergia());
        mano.remove(carta);
        return carta.jugarCarta(this, tablero);
    }

    /** Sobrecarga: usar la carta por su posición (1, 2, 3...) en la mano. */
    public String usarCarta(int posicion, Tablero tablero) {
        if (posicion < 1 || posicion > mano.size()) {
            return "Posición inválida.";
        }
        return usarCarta(mano.get(posicion - 1), tablero);
    }

    /** Toma una carta del mazo. Devuelve false si el mazo ya no tiene cartas. */
    public boolean tomarCarta(Mazo mazo) {
        Carta c = mazo.robar();
        if (c == null) return false;
        mano.add(c);
        return true;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getEnergia() { return energia; }
    public List<Carta> getMano() { return mano; }

    @Override
    public String toString() {
        return nombre + " (energía: " + energia + ", cartas en mano: " + mano.size() + ")";
    }
}
