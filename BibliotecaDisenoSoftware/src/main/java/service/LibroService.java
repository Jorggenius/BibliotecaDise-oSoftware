/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import excepciones.InvalidUserDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Libro;
import repository.LibroRepository;
import validator.LibroValidator;

/**
 *
 * @author JORGE
 */
public class LibroService {
    private LibroRepository libroRepository = new LibroRepository();
    
    public Libro getLibroById(int id) throws SQLException {
        return libroRepository.findById(id);
    }
    
     public ArrayList<Libro> getLibros()  throws SQLException{
        return libroRepository.findAll();
    }
      public void createLibro(String nombre, String autor, String isbn, String editorial, String Npaginas, String disponibilidad, String genero) throws SQLException, InvalidUserDataException {
        if (!LibroValidator.validateName(nombre)
                || !LibroValidator.validateAutor(autor) || !LibroValidator.validateIsbn(isbn)
                ||!LibroValidator.validateEditorial(editorial) || !LibroValidator.validateNpaginas(Npaginas)
                ||!LibroValidator.validateDisponibilidad(disponibilidad)||!LibroValidator.validateGenero(genero)
                ) {
            throw new InvalidUserDataException("Invalid user data");
        }
        Libro libro = new Libro(nombre, autor, isbn, editorial, Npaginas, disponibilidad, genero);
        libroRepository.save(libro);
    }
    
}
