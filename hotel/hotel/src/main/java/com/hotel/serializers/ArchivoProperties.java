package com.hotel.serializers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ArchivoProperties {

    private static Properties properties = new Properties();

    public static void cargarPropiedades() {
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
            System.out.println("Propiedades cargadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de propiedades: " + e.getMessage());
        }
    }

    public static String getRutaArchivoXML() {
        return properties.getProperty("rutaArchivoXML");
    }

    public static String getRutaArchivoBinario() {
        return properties.getProperty("rutaArchivoBinario");
    }

    public static String getRutaArchivoLog() {
        return properties.getProperty("rutaArchivoLog");
    }

    public static String getTipoHabitacion1() {
        return properties.getProperty("tipoHabitacion1");
    }

    public static String getTipoHabitacion2() {
        return properties.getProperty("tipoHabitacion2");
    }
}