/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

/**
 *
 * @author JORGE
 */
public class ClienteValidator {

    public static boolean validateName(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
    public static boolean validateEdad(Integer edad) {
    return edad != null && edad > 0 && edad < 120;
}
    public static boolean validateContraseña(String contraseña) {
        return contraseña != null && !contraseña.trim().isEmpty();
    }
    public static boolean validateCorreo(String correo) {
        return correo != null && !correo.trim().isEmpty();
    }
    public static boolean validateTelefono(String telefono) {
        return telefono != null && !telefono.trim().isEmpty();
    }
    public static boolean validatePreferencia1(String preferencia1) {
        return preferencia1 != null && !preferencia1.trim().isEmpty();
    }
    public static boolean validatePreferencia2(String preferencia2) {
        return preferencia2 != null && !preferencia2.trim().isEmpty();
    }
    public static boolean validatePreferencia3(String preferencia3) {
        return preferencia3 != null && !preferencia3.trim().isEmpty();
    }

}
