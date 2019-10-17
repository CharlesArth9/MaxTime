package com.choucair.formacion.pageobjects;

import java.util.Arrays;

public class BusquedaBinaria{
     public static void busqueda(String[] args) {
          // para que funcione la busqueda binaria usando la clase Arrays de java ahi que tener el arreglo ordenado
          int[] array = { 10, 15, 20, 40, 50, 100, 120, 200, 400, 500, 600, 800, 2222 };
          int result = Arrays.binarySearch(array, 400);
          System.out.println(String.format("Result %d", result));
     }
}
