package models;

import java.util.List;

class Usuario {
    private String idUsuario;
    private String rol;

    public Usuario(String idUsuario, String rol) {
        this.idUsuario = idUsuario;
        this.rol = rol;
    }

    public void consultarMaterialBibliografico(Biblioteca biblioteca) {
        System.out.println("Consulta de Material Bibliográfico como " + rol);
        List<Libro> inventario = biblioteca.getInventario();
        System.out.println("Material Bibliográfico Disponible:");
        for (Libro libro : inventario) {
            System.out.println(libro.getTitulo() + " - " + libro.getAutor());
        }
    }
}

