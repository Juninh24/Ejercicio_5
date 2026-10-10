import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private List<Jugador> jugadores;
    private int turno;   

    public Tablero(Jugador... jugadores) {
        this.jugadores = new ArrayList<>(List.of(jugadores));
        this.turno = 0;
    }

    public Jugador getJugadorActual() {
        return jugadores.get(turno);
    }

    public Jugador getRival(Jugador jugador) {
        int i = jugadores.indexOf(jugador);
        return jugadores.get((i + 1) % jugadores.size());
    }

    public Jugador siguienteTurno() {
        turno = (turno + 1) % jugadores.size();
        Jugador actual = getJugadorActual();
        actual.ganarEnergia(1);
        return actual;
    }

    public void modificarEnergiaATodos(int delta) {
        for (Jugador j : jugadores) {
            if (delta >= 0) j.ganarEnergia(delta);
            else j.perderEnergia(-delta);
        }
    }

    public List<Jugador> getJugadores() { return jugadores; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TABLERO\n");
        for (Jugador j : jugadores) {
            sb.append(j == getJugadorActual() ? " > " : "   ").append(j).append("\n");
        }
        return sb.toString();
    }
}
