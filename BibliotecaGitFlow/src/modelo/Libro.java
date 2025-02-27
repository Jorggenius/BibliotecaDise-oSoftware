/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author JORGE
 */
public class Libro implements Serializable {

    String nombre;
    String autor;
    String isbn;
    String editorial;
    String Npaginas;
    String disponibilidad;
    String genero;

    public Libro(String nombre, String autor, String isbn, String editorial, String Npaginas, String disponibilidad, String genero) {
        this.nombre = nombre;
        this.autor = autor;
        this.isbn = isbn;
        this.editorial = editorial;
        this.Npaginas = Npaginas;
        this.disponibilidad = disponibilidad;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getNpaginas() {
        return Npaginas;
    }

    public void setNpaginas(String Npaginas) {
        this.Npaginas = Npaginas;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    
}
