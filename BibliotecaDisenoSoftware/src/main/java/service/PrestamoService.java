/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import excepciones.InvalidUserDataException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Prestamo;
import repository.PrestamoRepository;
import validator.PrestamoValidator;

/**
 *
 * @author JORGE
 */
public class PrestamoService {
    int clienteId;
    public PrestamoService(int clienteId) {
        this.clienteId = clienteId;
    }
    
    

    private PrestamoRepository prestamoRepository = new PrestamoRepository();

    
    public Prestamo getPrestamoById(int id) throws SQLException {
        return prestamoRepository.findById(id);
    }

    public ArrayList<Prestamo> getPrestamos() throws SQLException {
        return prestamoRepository.findAll();
    }
    
    public ArrayList<Prestamo> getPrestamosCliente() throws SQLException {
        return prestamoRepository.findByClienteId(clienteId);
    }

    public void createPrestamo(int clienteId , String nombre, String isbn, Date fechaPrestamo, Date fechaDevolucion) throws SQLException, InvalidUserDataException {
        if (!PrestamoValidator.validateName(nombre)
                || !PrestamoValidator.validateIsbn(isbn) || !PrestamoValidator.validateFechaPrestamo(fechaPrestamo)
                || !PrestamoValidator.validateFechaDevolucion(fechaDevolucion)) {
            throw new InvalidUserDataException("Invalid user data");
        }
        Prestamo prestamo = new Prestamo(clienteId, nombre, isbn, fechaPrestamo, fechaDevolucion);
        prestamoRepository.save(prestamo);
    }
}
