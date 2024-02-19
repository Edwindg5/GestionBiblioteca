package models;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca ");


        Bibliotecario bibliotecario = new Bibliotecario("USER_01", "Bibliotecario");
        Usuario usuario = new Usuario("USER_02", "Usuario");

        if (login()) {
            int opcion;
            do {
                mostrarMenu();
                Scanner scanner = new Scanner(System.in);
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        registrarLibro(bibliotecario, biblioteca);
                        break;
                    case 2:
                        registrarPrestamo(bibliotecario, biblioteca);
                        break;
                    case 3:
                        registrarDevolucion(bibliotecario, biblioteca);
                        break;
                    case 4:
                        consultarMaterialBibliografico(usuario, biblioteca);
                        break;
                    case 5:
                        verInventario(bibliotecario, biblioteca);
                        break;
                    case 6:
                        System.out.println("Saliendo del programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }

            } while (opcion != 6);
        } else {
            System.out.println("Inicio de sesión fallido. No se pueden realizar operaciones.");
        }
    }

    private static boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el usuario:");
        String usuario = scanner.nextLine();
        System.out.println("Ingrese la contraseña:");
        String contrasena = scanner.nextLine();

        if (usuario.equals("bibliotecario")) if (contrasena.equals("123")) return true;
        return false;
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú Principal");
        System.out.println("1. Registrar Libro");
        System.out.println("2. Registrar Préstamo a Domicilio");
        System.out.println("3. Registrar Devolución de Libro");
        System.out.println("4. Consulta de Material Bibliográfico");
        System.out.println("5. Ver Inventario");
        System.out.println("6. Salir del Programa");
        System.out.println("Ingrese el número de la opción deseada:");
    }

    private static void registrarLibro(Bibliotecario bibliotecario, Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ISBN del libro:");
        String isbn = scanner.nextLine();

        if (buscarLibroPorISBN(biblioteca, isbn) != null) {
            System.out.println("¡El libro con ISBN " + isbn + " ya está registrado!");
            return;
        }

        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();

        Libro nuevoLibro = new Libro(isbn, titulo, autor);
        bibliotecario.registrarLibro(biblioteca, nuevoLibro);

        System.out.println("Libro registrado exitosamente.");
    }

    private static Libro buscarLibroPorISBN(Biblioteca biblioteca, String isbn) {
        List<Libro> inventario = biblioteca.getInventario();
        for (Libro libro : inventario) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }


    private static void registrarPrestamo(Bibliotecario bibliotecario, Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro a prestar:");
        String tituloLibro = scanner.nextLine();

        bibliotecario.registrarPrestamo(biblioteca, tituloLibro);
    }

    private static void registrarDevolucion(Bibliotecario bibliotecario, Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro a devolver:");
        String tituloLibro = scanner.nextLine();

        bibliotecario.registrarDevolucion(biblioteca, tituloLibro);
    }

    private static void consultarMaterialBibliografico(Usuario usuario, Biblioteca biblioteca) {
        usuario.consultarMaterialBibliografico(biblioteca);
    }

    private static void verInventario(Bibliotecario bibliotecario, Biblioteca biblioteca) {
        bibliotecario.verInventario(biblioteca);
    }
}