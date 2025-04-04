/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author JORGE
 */
public class Cliente implements Serializable{
    
    int id;
    String nombre;
    int edad;
    String contraseña;
    String correo;
    String telefono;
    String preferencia1;
    String preferencia2;
    String preferencia3;

    public Cliente(int id, String nombre, int edad, String contraseña, String correo, String telefono, String preferencia1, String preferencia2, String preferencia3) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.contraseña = contraseña;
        this.correo = correo;
        this.telefono = telefono;
        this.preferencia1 = preferencia1;
        this.preferencia2 = preferencia2;
        this.preferencia3 = preferencia3;
    }
    public Cliente(String nombre, int edad, String contraseña, String correo, String telefono, String preferencia1, String preferencia2, String preferencia3) {
        this.nombre = nombre;
        this.edad = edad;
        this.contraseña = contraseña;
        this.correo = correo;
        this.telefono = telefono;
        this.preferencia1 = preferencia1;
        this.preferencia2 = preferencia2;
        this.preferencia3 = preferencia3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPassword() {
        return contraseña;
    }

    public void setPassword(String password) {
        this.contraseña = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPreferencia1() {
        return preferencia1;
    }

    public void setPreferencia1(String preferencia1) {
        this.preferencia1 = preferencia1;
    }

    public String getPreferencia2() {
        return preferencia2;
    }

    public void setPreferencia2(String preferencia2) {
        this.preferencia2 = preferencia2;
    }

    public String getPreferencia3() {
        return preferencia3;
    }

    public void setPreferencia3(String preferencia3) {
        this.preferencia3 = preferencia3;
    }
    
    
    

    
    
    
    
    
}
