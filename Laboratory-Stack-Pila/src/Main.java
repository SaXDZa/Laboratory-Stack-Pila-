import java.util.Scanner;

public class Main {

    private static void mostrarMenu(){

        System.out.println();
        System.out.println("========== MENU PILA ==========");
        System.out.println("1. Push (apilar)");
        System.out.println("2. Pop (desapilar)");
        System.out.println("3. Peek (ver la cima)");
        System.out.println("4. Size (cantidad de elementos)");
        System.out.println("5. isEmpty (esta vacia?)");
        System.out.println("6. Search (buscar un elemento)");
        System.out.println("7. Mostrar la pila (toString)");
        System.out.println("8. Clear (vaciar)");
        System.out.println("0. Salir");
        System.out.println("===============================");
        System.out.print("Seleccione una opcion: ");
    }

    private static String leerTexto(Scanner sc, String mensaje) { // Lee una linea de text y nos devuelve null si ya no hay entrada.
        System.out.print(mensaje);
        if (!sc.hasNextLine()) {
            return null;
        }
        return sc.nextLine().trim();
    }

    private static int leerOpcion(Scanner sc) {
        if (!sc.hasNextLine()) {
            return 0;
        }
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StackInterface pila = new ListStack();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion(sc);

            switch (opcion) {
                case 1: {
                    String dato = leerTexto(sc, "Elemento a apilar: ");
                    if (dato == null || dato.isEmpty()) {
                        System.out.println("No se escribio ningun elemento.");
                    } else if (pila.push(dato)) {
                        System.out.println("Apilado: " + dato);
                    } else {
                        System.out.println("No se pudo apilar el elemento.");
                    }
                    break;
                }
                case 2: {
                    Object dato = pila.pop();
                    System.out.println(dato == null ? "La pila esta vacia, no hay nada que sacar."
                            : "Desapilado: " + dato);
                    break;
                }
                case 3: {
                    Object dato = pila.peek();
                    System.out.println(dato == null ? "La pila esta vacia." : "Cima: " + dato);
                    break;
                }
                case 4:
                    System.out.println("Tamano: " + pila.size());
                    break;
                case 5:
                    System.out.println("Esta vacia? " + (pila.isEmpty() ? "Si" : "No"));
                    break;
                case 6: {
                    String dato = leerTexto(sc, "Elemento a buscar: ");
                    if (dato != null) {
                        System.out.println(pila.search(dato) ? "\"" + dato + "\" SI esta en la pila."
                                : "\"" + dato + "\" NO esta en la pila.");
                    }
                    break;
                }
                case 7:
                    break;
                case 8:
                    pila.clear();
                    System.out.println("Pila vaciada.");
                    break;
                case 0:
                    System.out.println("Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida. Elija un numero del 0 al 8.");
            }

            if (opcion != 0) {
                System.out.println("Pila [base ... cima]: " + pila + "   (tamano: " + pila.size() + ")");
            }
        } while (opcion != 0);
    }
}


