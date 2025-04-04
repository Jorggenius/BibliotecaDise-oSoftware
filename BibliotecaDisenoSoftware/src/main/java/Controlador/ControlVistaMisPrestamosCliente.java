/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Prestamo;
import service.PrestamoService;

/**
 *
 * @author JORGE
 */
public class ControlVistaMisPrestamosCliente {
    PrestamoService prestamoService;
    ArrayList<Prestamo> prestamos;
    int clienteId;

    public ControlVistaMisPrestamosCliente(int clienteId) throws SQLException {
        this.clienteId = clienteId;
        prestamoService = new PrestamoService(clienteId);
        prestamos = prestamoService.getPrestamosCliente();
        
    }
    
    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }
}
