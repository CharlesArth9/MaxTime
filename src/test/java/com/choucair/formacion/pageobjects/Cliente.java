package com.choucair.formacion.pageobjects;
import java.util.List;

//================================= TALLER DE REFACTORIAZACION =====================================================

public class Cliente<Compras>{
     private List <Compras> cmp;



     public void infoPersonalcliente(){
          System.out.println("Nombre:" + "Carlos");
          System.out.println("Primer apellido:" + "Mestra");
          System.out.println("Segundo apellido:" + "López");
          System.out.println("Numero de documento de identificacion:" + "1064993389");
          for (Compras cmpLocal:cmp){
               System.out.println(cmpLocal);
          }
     }
    /* public void fullInfocliente(){
          System.out.println("Nombre:" + "Carlos");
          System.out.println("Primer apellido:" + "Mestra");
          System.out.println("Segundo apellido:" + "López");
          System.out.println("Numero de documento de identificacion:" + "1064993389");

          for (Compras cmpLocal:cmp){
               System.out.println(cmpLocal);
          }
     }*/

}
