package models;

import java.util.ArrayList;
import java.util.List;

class Biblioteca {
    private String nombre;
    private List<Libro> inventario;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.inventario = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        inventario.add(libro);
    }

    public List<Libro> getInventario() {
        return inventario;
    }
}
