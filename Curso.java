public class Curso extends Carta {
    private int creditos;
    private int nivelDificultad;

    public Curso(int id, String nombre, int costoEnergia, String descripcion,
                 int creditos, int nivelDificultad) {
        super(id, nombre, costoEnergia, descripcion);
        this.creditos = creditos;
        this.nivelDificultad = nivelDificultad;
    }

    /** Quien la juega gana tanta energía como créditos aporta el curso. */
    @Override
    public String jugarCarta(Jugador jugador, Tablero tablero) {
        jugador.ganarEnergia(creditos);
        return jugador.getNombre() + " aprueba " + getNombre() + " y gana " + creditos + " de energía.";
    }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }
    public int getNivelDificultad() { return nivelDificultad; }
    public void setNivelDificultad(int nivelDificultad) { this.nivelDificultad = nivelDificultad; }

    @Override
    public String toString() {
        return "CURSO " + super.toString() + " | Créditos: " + creditos + " | Dificultad: " + nivelDificultad;
    }
}
