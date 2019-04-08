/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.HashSet;

/**
 *
 * @author Francisco de Asís Domínguez Iceta. 1º DAW, IES Puerto de la Cruz
 */
public class Ahorcado {

    private String jugador;
    private final String PALABRA_SECRETA;
    private String[] palabras = {"flor", "otorrino", "alpaca", "alquitranado", "esternocleidomastoideo"};
    private char[] tablero;
    private char intento;
    private String erroresString;
    private HashSet<Character> errores;
    private final int ERRORES_POSIBLES;
    private boolean partidaActiva;

    public Ahorcado() {
        PALABRA_SECRETA = palabras[(int) (Math.random() * (palabras.length))];
        tablero = new char[PALABRA_SECRETA.length()];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] += '_';

        }
        ERRORES_POSIBLES = 7;
        erroresString="";
        errores = new HashSet<>();
    }

    public Ahorcado(String jugador, String[] palabras, int erroresPosibles) {
        this.jugador = jugador;
        this.palabras = palabras;
        PALABRA_SECRETA = palabras[(int) (Math.random() * (palabras.length))];
        tablero = new char[PALABRA_SECRETA.length()];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] += '_';

        }
        ERRORES_POSIBLES = erroresPosibles;
        partidaActiva = true;
        errores = new HashSet<>();
    }

    private boolean[] comprobarLetra() {
        boolean[] resultado = new boolean[PALABRA_SECRETA.length()];
        for (int i = 0; i < PALABRA_SECRETA.length(); i++) {
            if (PALABRA_SECRETA.charAt(i) == intento) {
                resultado[i] = true;
            }
        }
        return resultado;
    }

    public void actualizarTablero() {
        boolean[] comprobacion = comprobarLetra();
        for (int i = 0; i < tablero.length; i++) {
            if (comprobacion[i] == true) {
                tablero[i] = intento;
            }
        }
    }

    public boolean comprobarVictoria() {
        String palabraTablero = "";
        for (char tablero1 : tablero) {
            palabraTablero += String.valueOf(tablero1);
        }
        return PALABRA_SECRETA.equals(palabraTablero);
    }

    public boolean comprobarAcierto() {
        return PALABRA_SECRETA.contains(String.valueOf(intento));
    }
    
    public char[] apostar(char c){
        intento = c;
        actualizarTablero();
        partidaActiva = !(comprobarVictoria());
        if(!comprobarAcierto()){
            erroresString += c;
            errores.add(c);
            if(ERRORES_POSIBLES == erroresString.length()){
                partidaActiva = false;
            }
        }
        return tablero;
    }
    
    public void setIntento(char intento) {
        this.intento = intento;
        
    }

    public String[] getPalabras() {
        return palabras;
    }

    public void setPalabras(String[] palabras) {
        this.palabras = palabras;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public char[] getTablero() {
        return tablero;
    }

    public void setTablero(char[] tablero) {
        this.tablero = tablero;
    }

    public boolean isPartidaActiva() {
        return partidaActiva;
    }

    public void setPartidaActiva(boolean partidaActiva) {
        this.partidaActiva = partidaActiva;
    }

    public char getIntento() {
        return intento;
    }

    public String getPALABRA_SECRETA(){
        return PALABRA_SECRETA;
    }

    public String getErroresString() {
        return erroresString;
    }

    public void setErroresString(String erroresString) {
        this.erroresString = erroresString;
    }
    
    public String getErrores() {
        String resultado="";
        for (char palabra : errores) {
            resultado += palabra;
        }
        return resultado;
    }

    public void setErrores(char errores) {
        this.errores.add(errores);
    }

    public int getERRORES_POSIBLES() {
        return ERRORES_POSIBLES;
    }
    
}
