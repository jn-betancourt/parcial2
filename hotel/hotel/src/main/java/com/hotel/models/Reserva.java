package com.hotel.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * La clase Reserva representa una reserva en un hotel, que incluye información
 * del cliente, la fecha de la reserva y la habitación reservada.
 * Implementa Serializable para permitir su serialización en archivos binarios y XML.
 */
public class Reserva implements Serializable {
    private String fechaReserva;
    private double total;
    private String tipoHabitacion;
    private String cliente;
    private int numeroHabitacion;
    private int codigo;

    public Reserva (){}

    public Reserva(String fechaReserva, double total, String tipoHabitacion, String cliente, int numeroHabitacion, int codigo) {
        this.fechaReserva = fechaReserva;
        this.total = total;
        this.tipoHabitacion = tipoHabitacion;
        this.cliente = cliente;
        this.numeroHabitacion = numeroHabitacion;
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "fechaReserva='" + fechaReserva + '\'' +
                ", total=" + total +
                ", tipoHabitacion='" + tipoHabitacion + '\'' +
                ", cliente='" + cliente + '\'' +
                ", numeroHabitacion=" + numeroHabitacion +
                ", codigo=" + codigo +
                '}';
    }
}