/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import service.ClienteService;

/**
 *
 * @author JORGE
 */
public class ControlVistaAdminUsuariosRegistradosPlus {
    ClienteService clienteService;
    ArrayList<Cliente> clientes;
    
    public ControlVistaAdminUsuariosRegistradosPlus() throws SQLException {
        clienteService = new ClienteService();
        clientes = clienteService.getClientes();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    
    
    
}
