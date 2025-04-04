/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author JORGE
 */
public class Prestamo {

    int id;
    int clienteId;
    String nombre;
    String isbn;
    Date fechaPrestamo;
    Date fechaDevolucion;

    public Prestamo(int clienteId, String nombre, String isbn, Date fechaPrestamo, Date fechaDevolucion) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.isbn = isbn;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Prestamo(int id, int clienteId, String nombre, String isbn, Date fechaPrestamo, Date fechaDevolucion) {
        this.id = id;
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.isbn = isbn;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String toString() {
        return nombre;
    }

}
