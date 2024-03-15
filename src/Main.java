import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    enum Rol {
        HOMBRE_LOBO, ALDEANO, NARRADOR, VIDENTE, BRUJA
    }

    static class Jugador {
        String nombre;
        Rol rol;

        Jugador(String nombre) {
            this.nombre = nombre;
        }

        public void setRol(Rol rol) {
            this.rol = rol;
        }
    }

    public static void iniciarJuego() {
        List<Jugador> jugadores = configurarJugadores();
        asignarRoles(jugadores);

    }

    private static List<Jugador> configurarJugadores() {
        Scanner input = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            System.out.print("Introduzca el nombre del jugador " + (i + 1) + ": ");
            String nombre = input.nextLine();
            jugadores.add(new Jugador(nombre));
        }
        return jugadores;
    }

    public static void asignarRoles(List<Jugador> jugadores) {
        Collections.shuffle(jugadores);
        int totalJugadores = jugadores.size();
        int hombresLobo = Math.max(totalJugadores / 4, 1);

        ArrayList<Rol> roles = new ArrayList<>();
        roles.add(Rol.NARRADOR);
        roles.add(Rol.VIDENTE);
        roles.add(Rol.BRUJA);
        for (int i = 0; i < hombresLobo; i++) {
            roles.add(Rol.HOMBRE_LOBO);
        }
        while (roles.size() < totalJugadores) {
            roles.add(Rol.ALDEANO);
        }

        Collections.shuffle(roles);

        for (int i = 0; i < totalJugadores; i++) {
            jugadores.get(i).setRol(roles.get(i));
        }
    }

    public static void main(String[] args) {
        iniciarJuego();
    }
}
