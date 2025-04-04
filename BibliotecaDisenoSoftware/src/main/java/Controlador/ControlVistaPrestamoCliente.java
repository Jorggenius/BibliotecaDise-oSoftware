/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import excepciones.InvalidUserDataException;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Libro;
import modelo.Prestamo;
import org.json.JSONObject;
import service.LibroService;
import service.PrestamoService;

/**
 *
 * @author JORGE
 */
public class ControlVistaPrestamoCliente {
    PrestamoService prestamoService;
    LibroService libroService;
    ArrayList<Libro> libros;
    int clienteId;
    String recomendation;
    String query;
    ArrayList<Prestamo> prestamos;
    private static final Dotenv dotenv = Dotenv.load();
    private static final String API_KEY = dotenv.get("API_KEY");
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-pro:generateContent";
    private static final HttpClient httpClient = HttpClient.newHttpClient();
    private static final Gson gson = new Gson();

    public ControlVistaPrestamoCliente(int clienteId) throws SQLException {
        this.clienteId = clienteId;
        libroService = new LibroService();
        prestamoService = new PrestamoService(clienteId);
        libros = libroService.getLibros();
        recomendation = "";
        query = "";
        prestamos = prestamoService.getPrestamosCliente();
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void registrarPrestamo(Prestamo prestamo) throws InvalidUserDataException, SQLException {
        PrestamoService servicio = new PrestamoService(clienteId);
        servicio.createPrestamo(prestamo.getClienteId(), prestamo.getNombre(),
                prestamo.getIsbn(), prestamo.getFechaPrestamo(),
                prestamo.getFechaDevolucion());
    }

    public static String createContent(String peticion) {
        String message = peticion;
        JsonObject requestBody = new JsonObject();
        JsonObject content = new JsonObject();
        JsonObject part = new JsonObject();
        part.addProperty("text", message);
        content.add("parts", gson.toJsonTree(new JsonObject[]{part}));
        requestBody.add("contents", gson.toJsonTree(new JsonObject[]{content}));
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type", "application/json")
                    .header("x-goog-api-key", API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();
            HttpResponse<String> response = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());
            JSONObject jsonObj = new JSONObject(response.body());
            String mensaje = jsonObj.getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");
//            System.out.println(mensaje);
                    return mensaje;
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al crear contenido: " + e.getMessage());
        }
        return "";
    }
    
}
