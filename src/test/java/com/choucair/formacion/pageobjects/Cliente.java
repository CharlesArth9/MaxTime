package com.choucair.formacion.pageobjects;
import java.util.List;

//================================= TALLER DE REFACTORIAZACION =====================================================

public class Cliente<Compras>{
     List <Compras> cmp;

     public void infoPersonalcliente(){
          System.out.println("Nombre:" + "Carlos");
          System.out.println("Primer apellido:" + "Mestra");
          System.out.println("Segundo apellido:" + "López");
          System.out.println("Numero de documento de identificacion:" + "1064993389");
     }
     public void fullInfocliente(){
          System.out.println("Nombre:" + "Carlos");
          System.out.println("Primer apellido:" + "Mestra");
          System.out.println("Segundo apellido:" + "López");
          System.out.println("Numero de documento de identificacion:" + "1064993389");

          for (Compras cmpLOcal:cmp);
     }

}
