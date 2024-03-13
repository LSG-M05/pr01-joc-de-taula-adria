import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Main {

    private static void iniciarJuego() {


        boolean juegoActivo = true;

    }


    enum Rol {
        HOMBRE_LOBO, ALDEANO, NARRADOR, VIDENTE, BRUJA, LADRON, NINA, CUPIDO, CAZADOR
    }

    class Jugador {
        String nombre;
        Rol rol;

    }

    public class AsignacionDeRoles {
        public static void asignarRoles(List<Jugador> jugadores) {
            Collections.shuffle(jugadores);
            int totalJugadores = jugadores.size();
            int hombresLobo = Math.max(totalJugadores / 4, 1);

            ArrayList<Rol> roles = new ArrayList<>();
            roles.add(Rol.NARRADOR);
            roles.add(Rol.VIDENTE);
            roles.add(Rol.BRUJA);
            roles.add(Rol.LADRON);
            roles.add(Rol.NINA);
            roles.add(Rol.CUPIDO);
            roles.add(Rol.CAZADOR);
            for (int i = 0; i < hombresLobo; i++) {
                roles.add(Rol.HOMBRE_LOBO);
            }
            while (roles.size() < totalJugadores) {
                roles.add(Rol.ALDEANO);
            }

            Collections.shuffle(roles);

            for (int i = 0; i < totalJugadores; i++) {
                jugadores.get(i).rol = roles.get(i);
            }
        }
    }
    public static int leerInt(String mensaje) {
        Scanner input = new Scanner(System.in);
        System.out.print(mensaje);
        while (!input.hasNextInt()) {
            System.out.println("Entrada no válida. Por favor, introduzca un número.");
            input.next();
            System.out.print(mensaje);
        }
        return input.nextInt();
    }

    private static boolean leerBoolean(String mensaje) {
        Scanner input = new Scanner(System.in);
        System.out.print(mensaje + " (true/false): ");
        while (!input.hasNextBoolean()) {
            System.out.println("Entrada no válida. Por favor, ingrese 'true' o 'false'.");
            input.next();
            System.out.print(mensaje + " (true/false): ");
        }
        return input.nextBoolean();
    }

    public static void MenuPrincipal() {
        Scanner input = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("1. Iniciar Juego");
            System.out.println("2. Salir");

            opcion = leerInt("Seleccione una opción: ");

                switch (opcion) {
                    case 1:
                        System.out.println("Iniciando el juego...");
                        break;
                    case 2:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                        break;
                }
        }while (opcion != 2);
    }
    public static void main(String[] args) {
        MenuPrincipal();
    }
}