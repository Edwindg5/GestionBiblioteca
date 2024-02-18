package models;

import java.util.Scanner;

public class Login {
    private String usuario;
    private String contraseña;

    public Login() {
        this.usuario = "bibliotecario";
        this.contraseña = "clave123";
    }

    public boolean iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el usuario:");
        String inputUsuario = scanner.nextLine();
        System.out.println("Ingrese la contraseña:");
        String inputContraseña = scanner.nextLine();

        return usuario.equals(inputUsuario) && contraseña.equals(inputContraseña);
    }

    public void realizarPrestamo(Libro libro) {
        System.out.println("Realizando préstamo Adomicilio del libro: " + libro.getTitulo());
    }

    public void realizarDevolucion(Libro libro) {
        System.out.println("Realizando devolución del libro: " + libro.getTitulo());
    }

    public void realizarConsultaBibliografica(Libro libro) {
        System.out.println("Realizando consulta bibliográfica del libro: " + libro.getTitulo());
    }
}
