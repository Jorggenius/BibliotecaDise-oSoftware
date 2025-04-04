/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import excepciones.InvalidUserDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Cliente;
import repository.ClienteRepository;
import validator.ClienteValidator;

/**
 *
 * @author JORGE
 */
public class ClienteService {

    private ClienteRepository clienteRepository = new ClienteRepository();

    public Cliente getClienteById(int id) throws SQLException {
        return clienteRepository.findById(id);
    }
    
    public ArrayList<Cliente> getClientes()  throws SQLException{
        return clienteRepository.findAll();
    }

    public void createCliente(String nombre, int edad, String contraseña, String correo, String telefono, String preferencia1, String preferencia2, String preferencia3) throws SQLException, InvalidUserDataException {
        if (!ClienteValidator.validateName(nombre)
                || !ClienteValidator.validateEdad(edad) || !ClienteValidator.validateContraseña(contraseña)
                ||!ClienteValidator.validateCorreo(correo) || !ClienteValidator.validateTelefono(telefono)
                ||!ClienteValidator.validatePreferencia1(preferencia1)||!ClienteValidator.validatePreferencia2(preferencia2)
                ||!ClienteValidator.validatePreferencia3(preferencia3)) {
            throw new InvalidUserDataException("Invalid user data");
        }
        Cliente cliente = new Cliente(nombre, edad, contraseña, correo, telefono, preferencia1, preferencia2, preferencia3);
        clienteRepository.save(cliente);
    }
}
