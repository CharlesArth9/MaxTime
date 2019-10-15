package com.choucair.formacion.pageobjects;

public class EjemploBreakLabel{
     public static void ejemploLabelBreak(){

          // Se crea el arreglo de dos dimensiones
          int[][] arregloInts = { { 32, 87, 3, 589 }, { 12, 1076, 2000, 8 }, { 622, 127, 77, 955 } };

          // Declaración de variables
          int buscarA = 12;
          int i;
          int j = 0;
          boolean encontrado = false;

          // El label en este caso se llama buscar y ocurre cuando se quiebra el ciclo for cuando el numero es encontrado
          buscar:
          for (i = 0; i < arregloInts.length; i++){
               for (
                    j = 0; j < arregloInts[i].length; j++
               ){
                    if ( arregloInts[i][j] == buscarA ){
                         encontrado = true;
                         break buscar;
                    }
               }
          }

          if ( encontrado ){
               System.out.println( "Encontrado el "+buscarA+" en "+i+", "+j );
          } else {
               System.out.println( buscarA+" no se encuentra en el arreglo" );
          }
     }
}

