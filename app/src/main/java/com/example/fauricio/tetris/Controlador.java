package com.example.fauricio.tetris;

/**
 * Created by fauricio on 04/03/18.
 */

class Controlador {
    private static final Controlador ourInstance = new Controlador();
    public int[][] tablero;
    public static Integer[] imageIDs = new Integer[264];
    private int[] piezas = {1,2,3,4,5,6,7,8};
    private String[] colores = {"negro","gris","azul","verde","morado","rosado","rojo","amarillo"};

    static Controlador getInstance() {
        return ourInstance;
    }

    private Controlador() {
        tablero = new int[22][12];
        for(int i=0;i<22;i++){
            for(int j=0;j<12;j++){
                if(j==0||j==11){
                    tablero[i][j]=-1;
                }else if(i==0 || i==21){
                    tablero[i][j]=-1;
                }else{
                    tablero[i][j]=0;
                }
            }
        }
    }

    public void baja_pieza(int x,int y,int tipoPieza,int aux){
        int y1 = y+1;
        switch (tipoPieza){
            case 0:{//Cuadrado pequeño
                if(aux == 1){
                    tablero[x][y] =  2;
                }else{
                    tablero[x-1][y] = 0;
                    tablero[x][y] =  2;
                }

            }
        }
    }

    public void actualiza_tablero(){
        for(int i=0;i<22;i++){
            for(int j=0;j<12;j++){

            }
        }
    }
}
