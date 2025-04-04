/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import excepciones.InvalidUserDataException;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Cliente;
import org.mindrot.jbcrypt.BCrypt;
import service.ClienteService;

/**
 *
 * @author JORGE
 */
public class ControlVistaRegistroPlus {

    private static final Dotenv dotenv = Dotenv.load();

    private static final String DB_URL = dotenv.get("DB_URL");
    private static final String DB_USER = dotenv.get("DB_USER");
    private static final String DB_PASSWORD = dotenv.get("DB_PASSWORD");

    public ControlVistaRegistroPlus() {
    }

//    public void registrarCliente(Cliente cliente) throws InvalidUserDataException, SQLException {
//        ClienteService servicio = new ClienteService();
//        servicio.createCliente(cliente.getNombre(),
//                cliente.getEdad(), cliente.getPassword(),
//                cliente.getCorreo(), cliente.getTelefono(),
//                cliente.getPreferencia1(), cliente.getPreferencia2(),
//                cliente.getPreferencia3());
//    }

    public static boolean register(String nombre, int edad, String contraseña,
            String correo, String telefono, String preferencia1,
            String preferencia2, String preferencia3) {
        String query = "INSERT INTO cliente (nombre, edad, contraseña, correo, telefono, preferencia1, preferencia2, preferencia3) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD); PreparedStatement ps = conn.prepareStatement(query)) {

            String hashedPassword = hashPassword(contraseña);

            ps.setString(1, nombre);
            ps.setInt(2, edad);
            ps.setString(3, hashedPassword);
            ps.setString(4, correo);
            ps.setString(5, telefono);
            ps.setString(6, preferencia1);
            ps.setString(7, preferencia2);
            ps.setString(8, preferencia3);

            int result = ps.executeUpdate();
            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
      private static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }
}
