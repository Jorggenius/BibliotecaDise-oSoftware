/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author JORGE
 */
public class LibroValidator {
    public static boolean validateName(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
    public static boolean validateAutor(String autor) {
        return autor != null && !autor.trim().isEmpty();
    }
    public static boolean validateIsbn(String isbn) {
        return isbn != null && !isbn.trim().isEmpty();
    }
    public static boolean validateEditorial(String editorial) {
        return editorial != null && !editorial.trim().isEmpty();
    }
    public static boolean validateNpaginas(String npaginas) {
        return npaginas != null && !npaginas.trim().isEmpty();
    }
    public static boolean validateDisponibilidad(String disponibilidad) {
        return disponibilidad != null && !disponibilidad.trim().isEmpty();
    }
    public static boolean validateGenero(String genero) {
        return genero != null && !genero.trim().isEmpty();
    }
}
