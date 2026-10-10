public class SemanaDeParciales extends EventoCampus {
    public SemanaDeParciales(int id, int costoEnergia, int magnitud) {
        super(id, "Semana de Parciales", costoEnergia,
                "Todos los jugadores se desvelan estudiando y pierden energía.", magnitud);
    }

    @Override
    public String jugarCarta(Jugador jugador, Tablero tablero) {
        tablero.modificarEnergiaATodos(-getMagnitud());
        return "¡Semana de Parciales! Todos los jugadores pierden " + getMagnitud() + " de energía.";
    }
}
