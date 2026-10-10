import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        mazo.cargarInicial(12);

        Jugador j1 = new Jugador("Jugador 1");
        Jugador j2 = new Jugador("Jugador 2");
        Tablero tablero = new Tablero(j1, j2);
        for (int i = 0; i < 3; i++) {   
            j1.tomarCarta(mazo);
            j2.tomarCarta(mazo);
        }

        int opcion;
        do {
            System.out.println("\n=== UVG CARD BATTLE ===");
            System.out.println("1. Listar cartas del mazo");
            System.out.println("2. Buscar carta por ID");
            System.out.println("3. Buscar carta por nombre");
            System.out.println("4. Ordenar mazo por costo de energía");
            System.out.println("5. Jugar por turnos");
            System.out.println("0. Salir");
            opcion = leerEntero("Opción: ");

            switch (opcion) {
                case 1: mostrarCartas(mazo.getCartas()); break;
                case 2: {
                    Carta c = mazo.buscar(leerEntero("ID: "));
                    System.out.println(c != null ? c : "No se encontró la carta.");
                    break;
                }
                case 3: {
                    System.out.print("Nombre: ");
                    Carta c = mazo.buscar(sc.nextLine().trim());
                    System.out.println(c != null ? c : "No se encontró la carta.");
                    break;
                }
                case 4:
                    mazo.ordenarPorEnergia();
                    System.out.println("Mazo ordenado por costo de energía:");
                    mostrarCartas(mazo.getCartas());
                    break;
                case 5: jugar(mazo, tablero); break;
                case 0: System.out.println("¡Hasta pronto!"); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private static void jugar(Mazo mazo, Tablero tablero) {
        int op;
        do {
            Jugador actual = tablero.getJugadorActual();
            System.out.println("\n" + tablero);
            System.out.println("Turno de " + actual.getNombre() + " | Mano:");
            mostrarCartas(actual.getMano());
            System.out.println("1. Usar una carta");
            System.out.println("2. Tomar una carta del mazo");
            System.out.println("3. Pasar el turno");
            System.out.println("0. Volver al menú principal");
            op = leerEntero("Opción: ");

            switch (op) {
                case 1: {
                    int pos = leerEntero("Posición de la carta en tu mano: ");
                    int energiaAntes = actual.getEnergia();
                    int manoAntes = actual.getMano().size();
                    String resultado = actual.usarCarta(pos, tablero);
                    System.out.println(resultado);
                    if (actual.getMano().size() < manoAntes) { 
                        tablero.siguienteTurno();
                    }
                    break;
                }
                case 2:
                    if (actual.tomarCarta(mazo)) {
                        System.out.println(actual.getNombre() + " tomó una carta.");
                        tablero.siguienteTurno();
                    } else {
                        System.out.println("El mazo está vacío.");
                    }
                    break;
                case 3:
                    System.out.println(actual.getNombre() + " pasa el turno.");
                    tablero.siguienteTurno();
                    break;
                case 0: break;
                default: System.out.println("Opción inválida.");
            }
        } while (op != 0);
    }

    private static void mostrarCartas(List<Carta> cartas) {
        if (cartas.isEmpty()) {
            System.out.println("  (sin cartas)");
            return;
        }
        for (int i = 0; i < cartas.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + cartas.get(i));
        }
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
