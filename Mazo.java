import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mazo {
    private List<Carta> cartas;
    private Random random;

    private static final String[] CURSOS = {"Programación Orientada a Objetos", "Cálculo II", "Álgebra Lineal",
            "Estructuras de Datos", "Física I", "Bases de Datos", "Redes", "Estadística"};
    private static final String[] CATEDRATICOS = {"Catedrático de Algoritmos", "Catedrático de Matemática",
            "Catedrática de Física", "Catedrático de Redes", "Catedrática de Estadística", "Catedrático de Software"};
    private static final String[] DEPARTAMENTOS = {"Computación", "Matemática", "Física", "Ingeniería"};

    public Mazo() {
        this.cartas = new ArrayList<>();
        this.random = new Random();
    }

    public void cargarInicial(int cantidad) {
        cantidad = Math.max(cantidad, 10);
        for (int id = 1; id <= cantidad; id++) {
            int tipo = (id <= 4) ? id - 1 : random.nextInt(4);
            cartas.add(crearCartaAleatoria(id, tipo));
        }
    }

    private Carta crearCartaAleatoria(int id, int tipo) {
        switch (tipo) {
            case 0: {
                int dificultad = 1 + random.nextInt(5);
                String nombre = CURSOS[random.nextInt(CURSOS.length)];
                return new Curso(id, nombre, dificultad, "Curso de la carrera: gana energía al aprobarlo.",
                        3 + random.nextInt(4), dificultad);
            }
            case 1: {
                String nombre = CATEDRATICOS[random.nextInt(CATEDRATICOS.length)];
                return new Catedratico(id, nombre, 2 + random.nextInt(3), "Pone en aprietos al rival.",
                        DEPARTAMENTOS[random.nextInt(DEPARTAMENTOS.length)],
                        1 + random.nextInt(3), 1 + random.nextInt(3));
            }
            case 2:
                return new SemanaDeParciales(id, 1 + random.nextInt(3), 1 + random.nextInt(3));
            default:
                return new FeriaDeClubes(id, 1 + random.nextInt(3), 1 + random.nextInt(3));
        }
    }

    public Carta buscar(int id) {
        for (Carta c : cartas) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public Carta buscar(String nombre) {
        for (Carta c : cartas) {
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase())) return c;
        }
        return null;
    }

    public void ordenarPorEnergia() {
        Collections.sort(cartas);
    }

    public Carta robar() {
        if (cartas.isEmpty()) return null;
        return cartas.remove(random.nextInt(cartas.size()));
    }

    public List<Carta> getCartas() { return Collections.unmodifiableList(cartas); }
    public int getCantidad() { return cartas.size(); }
}
