public class Catedratico extends Carta {
    private String departamento;
    private int llamadasDeAtencion;
    private int tiempoDeAtencion;

    public Catedratico(int id, String nombre, int costoEnergia, String descripcion,
                       String departamento, int llamadasDeAtencion, int tiempoDeAtencion) {
        super(id, nombre, costoEnergia, descripcion);
        this.departamento = departamento;
        this.llamadasDeAtencion = llamadasDeAtencion;
        this.tiempoDeAtencion = tiempoDeAtencion;
    }

    @Override
    public String jugarCarta(Jugador jugador, Tablero tablero) {
        Jugador rival = tablero.getRival(jugador);
        rival.perderEnergia(llamadasDeAtencion);
        jugador.ganarEnergia(tiempoDeAtencion);
        return getNombre() + " le da " + llamadasDeAtencion + " llamadas de atención a " + rival.getNombre()
                + " (-" + llamadasDeAtencion + " energía) y " + jugador.getNombre()
                + " recupera " + tiempoDeAtencion + " de energía.";
    }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
    public int getLlamadasDeAtencion() { return llamadasDeAtencion; }
    public void setLlamadasDeAtencion(int llamadasDeAtencion) { this.llamadasDeAtencion = llamadasDeAtencion; }
    public int getTiempoDeAtencion() { return tiempoDeAtencion; }
    public void setTiempoDeAtencion(int tiempoDeAtencion) { this.tiempoDeAtencion = tiempoDeAtencion; }

    @Override
    public String toString() {
        return "CATEDRÁTICO " + super.toString() + " | Depto: " + departamento
                + " | Llamadas: " + llamadasDeAtencion + " | Tiempo: " + tiempoDeAtencion;
    }
}
