package com.hotel.models;

import java.util.ArrayList;
import java.util.List;
/**
 * La clase Habitacion representa una habitación de un hotel, identificada por su número y tipo,
 * además de almacenar una lista de códigos de reservas asociadas a esa habitación.
 */
public class Habitacion {
    private int numero; // Número de la habitación
    private String tipoHabitacion; // Tipo de la habitación (sencilla, doble, etc.)
    private List<Integer> codigosReservas; // Lista de códigos de reservas asociadas a la habitación

    /**
     * Constructor de la clase Habitacion.
     * Inicializa el número y el tipo de habitación, y crea una lista vacía de códigos de reservas.
     *
     * @param numero Número de la habitación.
     * @param tipoHabitacion Tipo de la habitación (por ejemplo, "Sencilla", "Doble").
     */
    public Habitacion(int numero, String tipoHabitacion) {
        this.numero = numero;
        this.tipoHabitacion = tipoHabitacion;
        this.codigosReservas = new ArrayList<>();
    }

    /**
     * Obtiene el número de la habitación.
     *
     * @return El número de la habitación.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la habitación.
     *
     * @param numero El nuevo número de la habitación.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Obtiene el tipo de habitación.
     *
     * @return El tipo de la habitación.
     */
    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    /**
     * Establece el tipo de habitación.
     *
     * @param tipoHabitacion El nuevo tipo de la habitación.
     */
    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    /**
     * Obtiene la lista de códigos de reservas asociadas a la habitación.
     *
     * @return La lista de códigos de reservas.
     */
    public List<Integer> getCodigosReservas() {
        return codigosReservas;
    }

    /**
     * Agrega un nuevo código de reserva a la lista de códigos de reservas.
     *
     * @param codigoReserva El código de reserva a agregar.
     */
    public void agregarCodigoReserva(int codigoReserva) {
        this.codigosReservas.add(codigoReserva);
    }

    /**
     * Devuelve una representación en forma de cadena de la habitación,
     * incluyendo su número, tipo y los códigos de reservas asociados.
     * El formato de salida es: numero@tipoHabitacion@codigoReserva1@codigoReserva2...
     *
     * @return Una cadena que representa la habitación y sus reservas.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(numero).append("@").append(tipoHabitacion);
        for (Integer codigo : codigosReservas) {
            sb.append("@").append(codigo);
        }
        return sb.toString();
    }
}
