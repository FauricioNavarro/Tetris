package com.example.fauricio.tetris;

import android.util.Log;

/**
 * Created by fauricio on 04/03/18.
 */

class Controlador {
    private static final Controlador ourInstance = new Controlador();
    public int[][] tablero;
    public static Integer[] imageIDs = new Integer[264];
    private int[] piezas = {1,2,3,4,5,6,7,8};
    private String[] colores = {"negro","gris","azul","verde","morado","rosado","rojo","amarillo"};
    private static final int[][][] matriz_eje_y = {
            {{0,-1,-1,-2}}
    };
    private static final int[][][] matriz_eje_x = {
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

    public void mover_der(int y,int x,int tipoPieza,int color){
        int x1,x2,x3,y1,y2,y3;
        switch (tipoPieza){
            case 0:{//Cuadrado
                x1 = matriz_eje_x[0][0][1] + x;
                x2 = matriz_eje_x[0][0][2] + x;
                x3 = matriz_eje_x[0][0][3] + x;
                y1 = matriz_eje_y[0][0][1] + y;
                y2 = matriz_eje_y[0][0][2] + y;
                y3 = matriz_eje_y[0][0][3] + y;
                Log.i("Cordenadas IZQ -> ", "x:" +Integer.toString(x)+" / y: " + Integer.toString(y));
                Log.i("Cordenadas IZQ -> ", "x:" +Integer.toString(x1)+" / y: " + Integer.toString(y1));
                Log.i("Cordenadas IZQ -> ", "x:" +Integer.toString(x2)+" / y: " + Integer.toString(y2));
                Log.i("Cordenadas IZQ -> ", "x:" +Integer.toString(x3)+" / y: " + Integer.toString(y3));
                Log.i("Cordenadas IZQ -> ", "-------------------------------------");
                if((x<11 && x>0) && (x1>0 && x1<11) && (x2>0 && x2<11) && (x3>0 && x3<11)){
                    if(tablero[y3-1][x3]==-1) {
                        tablero[y][x-1] = 0;
                        tablero[y1][x1-1] = 0;
                        tablero[y2][x2-1] = 0;
                        tablero[y3][x3-1] = 0;
                        tablero[y][x] = 6;
                        tablero[y1][x1] = 6;
                        tablero[y2][x2] = 6;
                        tablero[y3][x3] = 6;
                        /*imageIDs[(12 * y) + x] = R.drawable.red;
                        //imageIDs[(12 * y) + (x + 1)] = R.drawable.black;
                        imageIDs[(12 * y1) + x1] = R.drawable.red;
                        //imageIDs[(12 * (y1 - 1)) + x1] = R.drawable.black;
                        imageIDs[(12 * y2) + x2] = R.drawable.red;
                        imageIDs[(12 * y3) + x3] = R.drawable.red;
                        */
                    }else{
                        tablero[y][x-1] = 0;
                        tablero[y1][x1-1] = 0;
                        tablero[y2][x2-1] = 0;
                        tablero[y3][x3-1] = 0;

                        tablero[y][x] = 6;
                        tablero[y1][x1] = 6;
                        tablero[y2][x2] = 6;
                        tablero[y3][x3] = 6;
                    }
                }
            }
        }
    }

    public void mover_izq(int y,int x,int tipoPieza,int color){
        int x1,x2,x3,y1,y2,y3;
        switch (tipoPieza){
            case 0:{//Cuadrado
                x1 = matriz_eje_x[0][0][1] + x;
                x2 = matriz_eje_x[0][0][2] + x;
                x3 = matriz_eje_x[0][0][3] + x;
                y1 = matriz_eje_y[0][0][1] + y;
                y2 = matriz_eje_y[0][0][2] + y;
                y3 = matriz_eje_y[0][0][3] + y;
                Log.i("Cordenadas IZQ -> ", "x:" +Integer.toString(x)+" / y: " + Integer.toString(y));
                Log.i("Cordenadas IZQ -> ", "x:" +Integer.toString(x1)+" / y: " + Integer.toString(y1));
                Log.i("Cordenadas IZQ -> ", "x:" +Integer.toString(x2)+" / y: " + Integer.toString(y2));
                Log.i("Cordenadas IZQ -> ", "x:" +Integer.toString(x3)+" / y: " + Integer.toString(y3));
                Log.i("Cordenadas IZQ -> ", "-------------------------------------");
                if((x<11 && x>0) && (x1>0 && x1<11) && (x2>0 && x2<11) && (x3>0 && x3<11)){
                    if(tablero[y3-1][x3]==-1) {
                        tablero[y][x] = 6;
                        tablero[y1][x1] = 6;
                        tablero[y2][x2] = 6;
                        tablero[y3][x3] = 6;
                        tablero[y][x-1] = 0;
                        tablero[y1][x1-1] = 0;
                        tablero[y2][x2-1] = 0;
                        tablero[y3][x3-1] = 0;
                        /*imageIDs[(12 * y) + x] = R.drawable.red;
                        //imageIDs[(12 * y) + (x + 1)] = R.drawable.black;
                        imageIDs[(12 * y1) + x1] = R.drawable.red;
                        //imageIDs[(12 * (y1 - 1)) + x1] = R.drawable.black;
                        imageIDs[(12 * y2) + x2] = R.drawable.red;
                        imageIDs[(12 * y3) + x3] = R.drawable.red;
                        */
                    }else{
                        tablero[y][x+1] = 0;
                        tablero[y1][x1+1] = 0;
                        tablero[y2][x2+1] = 0;
                        tablero[y3][x3+1] = 0;

                        tablero[y][x] = 6;
                        tablero[y1][x1] = 6;
                        tablero[y2][x2] = 6;
                        tablero[y3][x3] = 6;
                    }
                }
            }
        }
    }

    public void baja_pieza(int y,int x,int tipoPieza,int color){
        int x1,x2,x3,y1,y2,y3;
        switch (tipoPieza){
            case 0:{//Cuadrado
                x1 = matriz_eje_x[0][0][1] + x;
                x2 = matriz_eje_x[0][0][2] + x;
                x3 = matriz_eje_x[0][0][3] + x;
                y1 = matriz_eje_y[0][0][1] + y;
                y2 = matriz_eje_y[0][0][2] + y;
                y3 = matriz_eje_y[0][0][3] + y;
                Log.i("Cordenadas -> ", "x:" +Integer.toString(x)+" / y: " + Integer.toString(y));
                Log.i("Cordenadas -> ", "x:" +Integer.toString(x1)+" / y: " + Integer.toString(y1));
                Log.i("Cordenadas -> ", "x:" +Integer.toString(x2)+" / y: " + Integer.toString(y2));
                Log.i("Cordenadas -> ", "x:" +Integer.toString(x3)+" / y: " + Integer.toString(y3));
                Log.i("Cordenadas -> ", "-------------------------------------");
                if((x<11 && x>0) && (x1>0 && x1<11) && (x2>0 && x2<11) && (x3>0 && x3<11)){
                    if(tablero[y3-1][x3]==-1) {
                        tablero[y][x] = 6;
                        tablero[y1][x1] = 6;
                        tablero[y2][x2] = 6;
                        tablero[y3][x3] = 6;
                        tablero[y][x-1] = 0;
                        tablero[y1][x1-1] = 0;
                        tablero[y2][x2-1] = 0;
                        tablero[y3][x3-1] = 0;
                        /*imageIDs[(12 * y) + x] = R.drawable.red;
                        //imageIDs[(12 * y) + (x + 1)] = R.drawable.black;
                        imageIDs[(12 * y1) + x1] = R.drawable.red;
                        //imageIDs[(12 * (y1 - 1)) + x1] = R.drawable.black;
                        imageIDs[(12 * y2) + x2] = R.drawable.red;
                        imageIDs[(12 * y3) + x3] = R.drawable.red;
                        */
                    }else{
                        tablero[y-1][x] = 0;
                        tablero[y1-1][x1] = 0;
                        tablero[y2-1][x2] = 0;
                        tablero[y3-1][x3] = 0;

                        tablero[y][x] = 6;
                        tablero[y1][x1] = 6;
                        tablero[y2][x2] = 6;
                        tablero[y3][x3] = 6;
                        /*imageIDs[(12 * y-1) + x] = R.drawable.black;
                        imageIDs[(12 * y1-1) + x1] = R.drawable.black;
                        imageIDs[(12 * y2-1) + x2] = R.drawable.black;
                        imageIDs[(12 * y3-1) + x3] = R.drawable.black;
                        imageIDs[(12 * (y3-1) + x3)] = R.drawable.black;
                        //---------------------------------
                        imageIDs[(12 * y) + x] = R.drawable.red;
                        imageIDs[(12 * y1) + x1] = R.drawable.red;
                        imageIDs[(12 * y2) + x2] = R.drawable.red;
                        imageIDs[(12 * y3) + x3] = R.drawable.red;
                        imageIDs[(12 * (y3-1) + x3)] = R.drawable.black;
                        */
                    }
                }
            }
        }
    }

    public void actualiza_tablero(){
        // i = filas / j = columnas
        for(int i=0;i<22;i++){
            for(int j=0;j<12;j++){
                switch (tablero[i][j]){
                    case 0:{//Color negro
                        imageIDs[(12 * i) + j] = R.drawable.black;
                    }break;
                    case -1:{//Color gris
                        imageIDs[(12 * i) + j] = R.drawable.gray;
                    }break;
                    case 2:{//Color azul

                    }break;
                    case 3:{//Color verde

                    }break;
                    case 4:{//Color morado

                    }break;
                    case 5:{//Color rosado

                    }break;
                    case 6:{//Color rojo
                        imageIDs[(12 * i) + j] = R.drawable.red;
                    }break;
                    case 7:{//Color amarillo

                    }break;
                }
            }
        }
    }
}
