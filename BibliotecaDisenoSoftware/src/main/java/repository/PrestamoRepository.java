/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import com.mycompany.bibliotecadisenosoftware.DataBaseConfig;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Prestamo;

/**
 *
 * @author JORGE
 */
public class PrestamoRepository {

    public Prestamo findById(int id) throws SQLException {
        String query = "SELECT * FROM cliente WHERE id = " + id;
        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new Prestamo(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("isbn"),
                        resultSet.getDate("fechaPrestamo"),
                        resultSet.getDate("fechaDevolucion")
                );
            } else {
                return null;
            }
        }
    }

    public ArrayList<Prestamo> findAll() throws SQLException {
        String query = "SELECT * FROM prestamo WHERE cliente_id";
        ArrayList<Prestamo> prestamos = new ArrayList<>();

        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                prestamos.add(new Prestamo(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("isbn"),
                        resultSet.getDate("fechaPrestamo"),
                        resultSet.getDate("fechaDevolucion")
                ));
            }
        }
        return prestamos;
    }

    public void save(Prestamo prestamo) throws SQLException {
        String query = "INSERT INTO prestamo (cliente_id ,nombre, isbn, fechaPrestamo, fechaDevolucion) VALUES ('"
                + prestamo.getClienteId() + "', '" + prestamo.getNombre()
                + "', '" + prestamo.getIsbn() + "', '" + prestamo.getFechaPrestamo() + "', '" + prestamo.getFechaDevolucion() + "')";
        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
    
    public ArrayList<Prestamo> findByClienteId(int clienteId) throws SQLException {
    String query = "SELECT * FROM prestamo WHERE cliente_id = ?";
    ArrayList<Prestamo> prestamos = new ArrayList<>();

    try (Connection connection = DataBaseConfig.getConnection();
         PreparedStatement statement = connection.prepareStatement(query)) {

        statement.setInt(1, clienteId); // Se asigna el valor del clienteId en la consulta
        
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                prestamos.add(new Prestamo(
                        resultSet.getInt("id"),
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("isbn"),
                        resultSet.getDate("fechaPrestamo"),
                        resultSet.getDate("fechaDevolucion")
                ));
            }
        }
    }
    return prestamos;
}
}
