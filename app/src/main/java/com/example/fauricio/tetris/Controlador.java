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
    private static final int[][][] matriz_eje_x = {
            {{0,-1,-1,-2}}
    };
    private static final int[][][] matriz_eje_y = {
            {{0,0,1,1}}
    };

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

    public void baja_pieza(int x,int y,int tipoPieza){
        int x1,x2,x3,y1,y2,y3;
        switch (tipoPieza){
            case 0:{//Cuadrado
                x1 = matriz_eje_x[0][0][1] + x;
                x2 = matriz_eje_x[0][0][2] + x;
                x3 = matriz_eje_x[0][0][3] + x;
                y1 = matriz_eje_y[0][0][1] + y;
                y2 = matriz_eje_y[0][0][2] + y;
                y3 = matriz_eje_y[0][0][3] + y;
                if(tablero[x3-1][y3]==-1) {
                    imageIDs[(12 * x) + y] = R.drawable.red;
                    imageIDs[(12 * x) + (y + 1)] = R.drawable.black;
                    imageIDs[(12 * x1) + y1] = R.drawable.red;
                    imageIDs[(12 * (x1 - 1)) + y1] = R.drawable.black;
                    imageIDs[(12 * x2) + y2] = R.drawable.red;
                    imageIDs[(12 * x3) + y3] = R.drawable.red;
                }else{
                    imageIDs[(12 * x) + y] = R.drawable.red;
                    imageIDs[(12 * x) + (y + 1)] = R.drawable.black;
                    imageIDs[(12 * x1) + y1] = R.drawable.red;
                    imageIDs[(12 * (x1 - 1)) + y1] = R.drawable.black;
                    imageIDs[(12 * x2) + y2] = R.drawable.red;
                    imageIDs[(12 * x3) + y3] = R.drawable.red;
                    imageIDs[(12 * (x3-1) + y3)] = R.drawable.black;
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
