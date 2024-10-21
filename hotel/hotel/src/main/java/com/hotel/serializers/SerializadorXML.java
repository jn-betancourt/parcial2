package com.hotel.serializers;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

import com.hotel.models.Reserva;

public class SerializadorXML {

    public static void serializarReservaXML(Reserva reserva, String archivoDestino) {
        try (XMLEncoder encoder = new XMLEncoder(new FileOutputStream(archivoDestino))) {
            encoder.writeObject(reserva);
            System.out.println("Reserva guardada en formato XML");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
