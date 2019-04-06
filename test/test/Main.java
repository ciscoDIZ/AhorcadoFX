/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Scanner;
import modelo.Ahorcado;

/**
 *
 * @author Francisco de Asís Domínguez Iceta. 1º DAW, IES Puerto de la Cruz
 */
public class Main {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] palabras = {"flor", "otorrino", "alpaca", "alquitranado",
            "esternocleidomastoideo"};
        boolean salir = false;
        while (!salir) {
            System.out.println("Para nueva partida pulsar n, salir s");
            char opt = sc.next().charAt(0);
            if (opt == 'n') {
                System.out.println("Introducir nombre del jugador");
                String nombre = sc.next();
                Ahorcado a = new Ahorcado(nombre, palabras, 6);
                while (a.isPartidaActiva()) {
                    System.out.println("Turno de: "+a.getJugador());
                    System.out.println("Introducir intento");
                    System.out.println(a.getTablero());
                    a.apostar(sc.next().charAt(0));
                    if (a.comprobarAcierto()) {
                        System.out.println("Has acertado!!");
                    } else {
                        System.out.println("Has fallado!!");
                        
                       
                    }
                    a.actualizarTablero();
                    System.out.println(a.getTablero());
                    
                }
            }else if(opt == 's'){
                System.out.println("Nos vemos pronto!!");
                salir = true;
            }
        }
    }
}
