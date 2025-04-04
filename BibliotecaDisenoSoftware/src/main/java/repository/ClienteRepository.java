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
import modelo.Cliente;

/**
 *
 * @author JORGE
 */
public class ClienteRepository {

    public Cliente findById(int id) throws SQLException {
        String query = "SELECT * FROM cliente WHERE id = " + id;
        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                return new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        resultSet.getString("contraseña"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("preferencia1"),
                        resultSet.getString("preferencia2"),
                        resultSet.getString("preferencia3")
                );
            } else {
                return null;
            }
        }
    }

    public ArrayList<Cliente> findAll() throws SQLException {
        String query = "SELECT * FROM cliente";
        ArrayList<Cliente> clientes = new ArrayList<>();

        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                clientes.add(new Cliente(
                        resultSet.getInt("id"),
                        resultSet.getString("nombre"),
                        resultSet.getInt("edad"),
                        resultSet.getString("contraseña"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono"),
                        resultSet.getString("preferencia1"),
                        resultSet.getString("preferencia2"),
                        resultSet.getString("preferencia3")
                ));
            }
        }
        return clientes;
    }

    public void save(Cliente cliente) throws SQLException {
        String query = "INSERT INTO cliente (nombre, edad, contraseña, correo, telefono, preferencia1, preferencia2, preferencia3 ) VALUES ('"
                + cliente.getNombre() + "', '" + cliente.getEdad()
                + "', '" + cliente.getPassword() + "', '" + cliente.getCorreo() + "', '" + cliente.getTelefono() + "', '"
                + cliente.getPreferencia1() + "', '" + cliente.getPreferencia2() + "', '" + cliente.getPreferencia3() + "')";
        try (Connection connection = DataBaseConfig.getConnection(); Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        }
    }
}
