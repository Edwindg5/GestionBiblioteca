package models;
import java.util.List;

class Bibliotecario extends Usuario {

    public Bibliotecario(String idUsuario, String rol) {
        super(idUsuario, rol);
    }
    public void registrarLibro(Biblioteca biblioteca, Libro libro) {
        biblioteca.agregarLibro(libro);
    }
    public void registrarPrestamo(Biblioteca biblioteca, String tituloLibro) {
        List<Libro> inventario = biblioteca.getInventario();
        for (Libro libro : inventario) {
            if (libro.getTitulo().equals(tituloLibro)) {
                System.out.println("Préstamo del libro '" + tituloLibro + "' registrado exitosamente.");
                return;
            }
        }

        System.out.println("Libro no encontrado en el inventario.");
    }
    public void registrarDevolucion(Biblioteca biblioteca, String tituloLibro) {
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