/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import excepciones.InvalidUserDataException;
import java.sql.SQLException;
import modelo.Libro;
import service.LibroService;

/**
 *
 * @author JORGE
 */
public class ControlVistaAgregarLibrosAdmin {

    public ControlVistaAgregarLibrosAdmin() {
    }
    
     public void registrarLibro (Libro libro) throws InvalidUserDataException, SQLException {
         LibroService servicio = new LibroService();
        servicio.createLibro(libro.getNombre(),
                libro.getAutor(), libro.getIsbn(),
                libro.getEditorial(), libro.getNpaginas(),
                libro.getDisponibilidad(), libro.getGenero()
                );
    }
}
