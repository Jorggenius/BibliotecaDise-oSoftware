/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.mycompany.bibliotecadisenosoftware.DataBaseConfig;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Libro;

/**
 *
 * @author JORGE
 */
public class LibroRepository {

    public Libro findById(int id) throws SQLException {
        String query = "SELECT * FROM libro WHERE id = " + id;
        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new Libro(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("autor"),
                        resultSet.getString("isbn"),
                        resultSet.getString("editorial"),
                        resultSet.getString("Npaginas"),
                        resultSet.getString("disponibilidad"),
                        resultSet.getString("genero")
                );
            } else {
                return null;
            }
        }
    }

    public ArrayList<Libro> findAll() throws SQLException {
        String query = "SELECT * FROM libro";
        ArrayList<Libro> libros = new ArrayList<>();

        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                libros.add(new Libro(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("autor"),
                        resultSet.getString("isbn"),
                        resultSet.getString("editorial"),
                        resultSet.getString("Npaginas"),
                        resultSet.getString("disponibilidad"),
                        resultSet.getString("genero")
                ));
            }
        }
        return libros;
    }
    
        public void save(Libro libro) throws SQLException {
        String query = "INSERT INTO libro (nombre, autor, isbn, editorial, Npaginas, disponibilidad, genero) VALUES ('"
                + libro.getNombre() + "', '" + libro.getAutor()
                + "', '" + libro.getIsbn() + "', '" + libro.getEditorial() + "', '" + libro.getNpaginas() + "', '"
                + libro.getDisponibilidad() + "', '" + libro.getGenero() + "')";
        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
}
