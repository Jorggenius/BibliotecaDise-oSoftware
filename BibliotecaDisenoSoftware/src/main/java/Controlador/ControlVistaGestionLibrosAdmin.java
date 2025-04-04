/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Libro;
import service.LibroService;

/**
 *
 * @author JORGE
 */
public class ControlVistaGestionLibrosAdmin {
    LibroService libroService;
    ArrayList<Libro> libros;

    public ControlVistaGestionLibrosAdmin() throws SQLException {
        libroService = new LibroService();
        libros = libroService.getLibros();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
    
    
}
