package models;

import java.util.List;
import java.util.Scanner;

class Bibliotecario extends Usuario {

    public Bibliotecario(String idUsuario, String rol) {
        super(idUsuario, rol);
    }

    public void registrarLibro(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ISBN del libro:");
        String isbn = scanner.nextLine();
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();

        Libro nuevoLibro = new Libro(isbn, titulo, autor);
        biblioteca.agregarLibro(nuevoLibro);

        System.out.println("Libro registrado exitosamente.");
    }

    public void registrarPrestamo(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro a prestar:");
        String tituloLibro = scanner.nextLine();

        List<Libro> inventario = biblioteca.getInventario();
        for (Libro libro : inventario) {
            if (libro.getTitulo().equals(tituloLibro)) {
                System.out.println("Prestamo del libro '" + tituloLibro + "' registrado exitosamente.");
                return;
            }
        }

        System.out.println("Libro no encontrado en el inventario.");
    }

    public void registrarDevolucion(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del libro a devolver:");
        String tituloLibro = scanner.nextLine();

        List<Libro> inventario = biblioteca.getInventario();
        for (Libro libro : inventario) {
            if (libro.getTitulo().equals(tituloLibro)) {
                System.out.println("Devolución del libro '" + tituloLibro + "' registrada exitosamente.");
                return;
            }
        }

        System.out.println("Libro no encontrado en el inventario.");
    }

    public void verInventario(Biblioteca biblioteca) {
        System.out.println("Inventario actual:");
        List<Libro> inventario = biblioteca.getInventario();
        for (Libro libro : inventario) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor());
        }
    }
}
