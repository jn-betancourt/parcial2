package com.hotel.serializers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.hotel.models.Habitacion;

public class ArchivoHabitaciones {

    private static final String ARCHIVO_HABITACIONES = "habitaciones.txt";

    public static void guardarHabitacionesEnArchivo(List<Habitacion> habitaciones) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_HABITACIONES, true))) {
            for (Habitacion habitacion : habitaciones) {
                writer.write(habitacion.toString());
                writer.newLine();
            }
            System.out.println("Información de las habitaciones guardada en el archivo " + ARCHIVO_HABITACIONES);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de habitaciones: " + e.getMessage());
        }
    }
}