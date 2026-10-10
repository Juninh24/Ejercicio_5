public class FeriaDeClubes extends EventoCampus {
    public FeriaDeClubes(int id, int costoEnergia, int magnitud) {
        super(id, "Feria de Clubes", costoEnergia,
                "El campus se llena de ambiente y todos los jugadores recuperan energía.", magnitud);
    }

    @Override
    public String jugarCarta(Jugador jugador, Tablero tablero) {
        tablero.modificarEnergiaATodos(getMagnitud());
        return "¡Feria de Clubes! Todos los jugadores ganan " + getMagnitud() + " de energía.";
    }
}
