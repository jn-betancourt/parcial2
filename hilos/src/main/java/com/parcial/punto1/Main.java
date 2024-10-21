package com.parcial.punto1;

public class Main {

    public static void main(String[] args) {

        Thread a = new Thread(new Hilo1());
        
        Thread b = new Thread(new Hilo2());
        
        a.start();
        b.start();

        try {
            a.join();
            b.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int c = Hilo1.suma * Hilo2.promedio;
        System.out.println(c);

    }

}