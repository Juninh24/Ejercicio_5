public abstract class EventoCampus extends Carta {
    private int magnitud;

    public EventoCampus(int id, String nombre, int costoEnergia, String descripcion, int magnitud) {
        super(id, nombre, costoEnergia, descripcion);
        this.magnitud = magnitud;
    }

    public int getMagnitud() { return magnitud; }
    public void setMagnitud(int magnitud) { this.magnitud = magnitud; }

    @Override
    public String toString() {
        return "EVENTO " + super.toString() + " | Magnitud: " + magnitud;
    }
}
