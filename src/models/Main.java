package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Libro> inventario = new java.util.ArrayList<>();

    public static void main(String[] args) {
        // Iniciar sesión
        Usuario usuario = new Usuario();
        if (usuario.login()) {
            int opcion;
            do {
                mostrarMenu();
                Scanner scanner = new Scanner(System.in);
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        RegistroLibro registroLibro = new RegistroLibro();
                        registroLibro.ejecutar();
                        break;
                    case 2:
                        RegistroPrestamo registroPrestamo = new RegistroPrestamo();
                        registroPrestamo.ejecutar();
                        break;
                    case 3:
                        RegistroDevolucion registroDevolucion = new RegistroDevolucion();
                        registroDevolucion.ejecutar();
                        break;
                    case 4:
                        ConsultaMaterialBibliografico consultaMaterial = new ConsultaMaterialBibliografico();
                        consultaMaterial.ejecutar();
                        break;
                    case 5:
                        VerInventario verInventario = new VerInventario();
                        verInventario.ejecutar();
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

    private static class Usuario {
        private String usuario;
        private String contrasena;

        public boolean login() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el usuario:");
            usuario = scanner.nextLine();
            System.out.println("Ingrese la contraseña:");
            contrasena = scanner.nextLine();

            return (usuario.equals("bibliotecario") && contrasena.equals("clave123")) ||
                    (usuario.equals("usuario") && contrasena.equals("clave456"));
        }
    }

    private static class RegistroLibro {
        public void ejecutar() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el ISBN del libro:");
            String isbn = scanner.nextLine();

            // Verificar si el libro ya está registrado
            if (buscarLibroPorISBN(isbn) != null) {
                System.out.println("¡El libro con ISBN " + isbn + " ya está registrado!");
                return;
            }

            System.out.println("Ingrese el título del libro:");
            String titulo = scanner.nextLine();
            System.out.println("Ingrese el autor del libro:");
            String autor = scanner.nextLine();

            Libro nuevoLibro = new Libro(isbn, titulo, autor);
            inventario.add(nuevoLibro);

            System.out.println("Libro registrado exitosamente.");
        }
    }

    private static class RegistroPrestamo {
        public void ejecutar() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el título del libro a prestar:");
            String tituloLibro = scanner.nextLine();

            for (Libro libro : inventario) {
                if (libro.getTitulo().equals(tituloLibro)) {
                    System.out.println("Préstamo del libro '" + tituloLibro + "' registrado exitosamente.");
                    return;
                }
            }

            System.out.println("Libro no encontrado en el inventario.");
        }
    }

    private static class RegistroDevolucion {
        public void ejecutar() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el título del libro a devolver:");
            String tituloLibro = scanner.nextLine();

            for (Libro libro : inventario) {
                if (libro.getTitulo().equals(tituloLibro)) {
                    System.out.println("Devolución del libro '" + tituloLibro + "' registrada exitosamente.");
                    return;
                }
            }

            System.out.println("Libro no encontrado en el inventario.");
        }
    }

    private static class ConsultaMaterialBibliografico {
        public void ejecutar() {
            System.out.println("Consulta de Material Bibliográfico");
            System.out.println("Material Bibliográfico Disponible:");
            for (Libro libro : inventario) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor());
            }
        }
    }

    private static class VerInventario {
        public void ejecutar() {
            System.out.println("Inventario actual:");
            for (Libro libro : inventario) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor());
            }
        }
    }

    private static Libro buscarLibroPorISBN(String isbn) {
        for (Libro libro : inventario) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    private static class Libro {
        private String isbn;
        private String titulo;
        private String autor;

        public Libro(String isbn, String titulo, String autor) {
            this.isbn = isbn;
            this.titulo = titulo;
            this.autor = autor;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public String getIsbn() {
            return isbn;
        }
    }
}

