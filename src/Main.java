import java.util.Scanner;
public class Main {

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