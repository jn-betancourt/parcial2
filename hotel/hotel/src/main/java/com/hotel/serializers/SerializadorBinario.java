package com.hotel.serializers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.hotel.models.Reserva;

public class SerializadorBinario {

    public static void serializarReservaBinario(Reserva reserva, String archivoDestino) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoDestino))) {
            oos.writeObject(reserva);
            System.out.println("Reserva guardada en formato binario");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
