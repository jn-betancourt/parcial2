package com.parcial.punto1;

public class Hilo1 implements Runnable{

    private static int [][] matriz = {
        {1,2,3,4},	
        {1,2,3,4},	
        {1,2,3,4},	
        {1,2,3,4},
    };

    public static int suma = 0;

    @Override
    public void run() {
        suma = calcularSumaDiagonal(1, 0);
        System.out.println(suma);
    }


    private static int calcularSumaDiagonal(int fila, int columna) {
        if (fila >= matriz.length) {
            return 0; // Condición de término
        }

        if (columna >= fila) {
            return calcularSumaDiagonal(fila + 1, 0); // Pasar a la siguiente fila
        }
        // Sumar el valor actual y avanzar en la fila
        return matriz[fila][columna] + calcularSumaDiagonal(fila+1, columna + 1);
    }
    
}
