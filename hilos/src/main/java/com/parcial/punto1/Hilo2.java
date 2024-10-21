package com.parcial.punto1;

public class Hilo2 implements Runnable{

    private static int [][] matriz = {
        {1,2,3,4},	
        {1,2,3,4},	
        {1,2,3,4},	
        {1,2,3,4},
    };

    public static int promedio = 0;

    @Override
    public void run() {
        int suma  = calcularSumaDiagonal(0, 1);
        int coontar = contarPasosDiagonalSuperior(0, 1);
        promedio = suma/coontar;
        System.out.println(promedio);
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


    private static int contarPasosDiagonalSuperior(int fila, int columna) {
        // Caso base: si se sale de los límites de la matriz
        if (fila >= matriz.length || columna >= matriz[0].length) {
            return 0;
        }

        // Si estamos en la diagonal superior (incluyendo la diagonal principal)
        if (columna >= fila) {
            // Contar este paso y continuar recursivamente en la misma fila
            return 1 + contarPasosDiagonalSuperior(fila, columna + 1);
        } else {
            // Si llegamos al final de la fila, pasar a la siguiente fila
            return contarPasosDiagonalSuperior(fila + 1, fila + 1);
        }
    }
    
}
