/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.sql.Date;

/**
 *
 * @author JORGE
 */
public class PrestamoValidator {

    public static boolean validateName(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean validateIsbn(String isbn) {
        return isbn != null && !isbn.trim().isEmpty();
    }
    
    public static boolean validateFechaPrestamo(Date fechaPrestamo) {
        return fechaPrestamo != null;
    }
    public static boolean validateFechaDevolucion(Date fechaDevolucion) {
        return fechaDevolucion != null;
    }
}
