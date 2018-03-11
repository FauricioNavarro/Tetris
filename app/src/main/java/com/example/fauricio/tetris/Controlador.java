package com.example.fauricio.tetris;

import android.util.Log;

/**
 * Created by fauricio on 04/03/18.
 */

class Controlador {
    private static final Controlador ourInstance = new Controlador();
    public int[][] tablero;
    public static Integer[] imageIDs = new Integer[264];
    public static boolean estado=true;
    private static final int[][][] matriz_eje_y = {
            {{0,-1,-1,-2},{-1,-1,0,0},{0,-1,-1,-2},{-1,-1,0,0}},
            {{0,-1,-1,-2},{0,-1,-1,0},{0,-1,-1,-2},{0,-1,-1,0}},
            {{0,-1,-2,-3},{0,0,0,0},{0,-1,-2,-3},{0,0,0,0}},
            {{0,0,-1,-2},{0,-1,-1,-1},{-2,0,-1,-2},{0,-1,0,0},{0,0,-1,-2}},
            {{0,0,-1,-2},{0,0,-1,0},{-2,0,-1,-2},{0,-1,-1,-1},{0,0,-1,-2}},
            {{0,-1,-1,-1},{0,-1,0,1},{0,1,1,1},{0,0,-1,1},{0,-1,-1,-1}},
            {{0,1,0,1}},
            {{0,0,0,0}}
    };
    private static final int[][][] matriz_eje_x = {
            {{0,0,1,1},{-1,0,0,1},{0,0,1,1},{-1,0,0,1}},
            {{0,0,-1,-1},{-2,-1,0,-1},{0,0,-1,-1},{-2,-1,0,-1}},
            {{0,0,0,0},{0,-1,-2,-3},{0,0,0,0},{0,-1,-2,-3}},
            {{0,-1,-1,-1},{-2,-1,-2,0},{-2,-1,-1,-1},{0,0,-1,-2},{0,-1,-1,-1}},
            {{0,1,1,1},{0,-1,-1,1},{0,0,0,1},{1,1,0,-1},{0,1,1,1}},
            {{0,-1,0,1},{0,1,1,1},{0,-1,0,1},{0,-1,-1,-1},{0,-1,0,1}},
            {{0,0,-1,-1}},
            {{0,0,0,0}}
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

    public void mover_der(int y,int x,int tipoPieza,int color,int dir){
        int x1,x2,x3,x4,y1,y2,y3,y4;
        x1 = matriz_eje_x[tipoPieza][dir][0] + x;
        x2 = matriz_eje_x[tipoPieza][dir][1] + x;
        x3 = matriz_eje_x[tipoPieza][dir][2] + x;
        x4 = matriz_eje_x[tipoPieza][dir][3] + x;
        y1 = matriz_eje_y[tipoPieza][dir][0] + y;
        y2 = matriz_eje_y[tipoPieza][dir][1] + y;
        y3 = matriz_eje_y[tipoPieza][dir][2] + y;
        y4 = matriz_eje_y[tipoPieza][dir][3] + y;
        if((x4<11 && x4>0) && (x1>0 && x1<11) && (x2>0 && x2<11) && (x3>0 && x3<11) &&
        (y4<21 && y4>0) && (y1>0 && y1<21) && (y2>0 && y2<21) && (y3>0 && y3<21)){
            borra_pieza(x1,x2,x3,x4,y1,y2,y3,y4,1,dir,2);
            tablero[y1][x1] = color;
            tablero[y2][x2] = color;
            tablero[y3][x3] = color;
            tablero[y4][x4] = color;
        }
    }

    public void mover_izq(int y,int x,int tipoPieza,int color,int dir){
        int x1,x2,x3,x4,y1,y2,y3,y4;
        x1 = matriz_eje_x[tipoPieza][dir][0] + x;
        x2 = matriz_eje_x[tipoPieza][dir][1] + x;
        x3 = matriz_eje_x[tipoPieza][dir][2] + x;
        x4 = matriz_eje_x[tipoPieza][dir][3] + x;
        y1 = matriz_eje_y[tipoPieza][dir][0] + y;
        y2 = matriz_eje_y[tipoPieza][dir][1] + y;
        y3 = matriz_eje_y[tipoPieza][dir][2] + y;
        y4 = matriz_eje_y[tipoPieza][dir][3] + y;
        if((x4<11 && x4>0) && (x1>0 && x1<11) && (x2>0 && x2<11) && (x3>0 && x3<11) &&
        (y4<21 && y4>0) && (y1>0 && y1<21) && (y2>0 && y2<21) && (y3>0 && y3<21)){
            if (x3 + 1 > 10) {
                tablero[y1][x + 1] = 0;
                tablero[y2][x1 + 1] = 0;
                tablero[y1][x2 + 1] = -1;
                tablero[y2][x3 + 1] = -1;
            } else {
                borra_pieza(x1, x2, x3, x4, y1, y2, y3, y4, tipoPieza, dir, 1);
            }

            tablero[y1][x1] = color;
            tablero[y2][x2] = color;
            tablero[y3][x3] = color;
            tablero[y4][x4] = color;
        }


    }

    public void baja_pieza(int y,int x,int tipoPieza,int color,int dir){
        int x1,x2,x3,x4,y1,y2,y3,y4;
        x1 = matriz_eje_x[tipoPieza][dir][0] + x;
        x2 = matriz_eje_x[tipoPieza][dir][1] + x;
        x3 = matriz_eje_x[tipoPieza][dir][2] + x;
        x4 = matriz_eje_x[tipoPieza][dir][3] + x;
        y1 = matriz_eje_y[tipoPieza][dir][0] + y;
        y2 = matriz_eje_y[tipoPieza][dir][1] + y;
        y3 = matriz_eje_y[tipoPieza][dir][2] + y;
        y4 = matriz_eje_y[tipoPieza][dir][3] + y;
        if((x4<11 && x4>0) && (x1>0 && x1<11) && (x2>0 && x2<11) && (x3>0 && x3<11) &&
                (y4<21 && y4>0) && (y1>0 && y1<21) && (y2>0 && y2<21) && (y3>0 && y3<21)){
            if(y4-1 == 0){
                tablero[y1-1][x1] = 0;
                tablero[y2-1][x2] = 0;
                tablero[y3-1][x3] = 0;
            }else{
                borra_pieza(x1,x2,x3,x4,y1,y2,y3,y4,tipoPieza,dir,0);
            }
            tablero[y1][x1] = color;
            tablero[y2][x2] = color;
            tablero[y3][x3] = color;
            tablero[y4][x4] = color;

        }
    }

    public int rotar_pieza(int y,int x,int tipoPieza,int color,int dir){
        int x1,x2,x3,x4,y1,y2,y3,y4;
        int x1_aux,x2_aux,x3_aux,x4_aux,y1_aux,y2_aux,y3_aux,y4_aux;
        x1 = matriz_eje_x[tipoPieza][dir+1][0] + x;
        x2 = matriz_eje_x[tipoPieza][dir+1][1] + x;
        x3 = matriz_eje_x[tipoPieza][dir+1][2] + x;
        x4 = matriz_eje_x[tipoPieza][dir+1][3] + x;
        y1 = matriz_eje_y[tipoPieza][dir+1][0] + y;
        y2 = matriz_eje_y[tipoPieza][dir+1][1] + y;
        y3 = matriz_eje_y[tipoPieza][dir+1][2] + y;
        y4 = matriz_eje_y[tipoPieza][dir+1][3] + y;
        if((x4<11 && x4>0) && (x1>0 && x1<11) && (x2>0 && x2<11) && (x3>0 && x3<11) &&
                (y4<21 && y4>0) && (y1>0 && y1<21) && (y2>0 && y2<21) && (y3>0 && y3<21)) {
            x1_aux = matriz_eje_x[tipoPieza][dir][0] + x;
            x2_aux = matriz_eje_x[tipoPieza][dir][1] + x;
            x3_aux = matriz_eje_x[tipoPieza][dir][2] + x;
            x4_aux = matriz_eje_x[tipoPieza][dir][3] + x;
            y1_aux = matriz_eje_y[tipoPieza][dir][0] + y;
            y2_aux = matriz_eje_y[tipoPieza][dir][1] + y;
            y3_aux = matriz_eje_y[tipoPieza][dir][2] + y;
            y4_aux = matriz_eje_y[tipoPieza][dir][3] + y;
            borra_pieza(x1_aux,x2_aux,x3_aux,x4_aux,y1_aux,y2_aux,y3_aux,y4_aux,0,5,0);
            tablero[y1][x1] = color;
            tablero[y2][x2] = color;
            tablero[y3][x3] = color;
            tablero[y4][x4] = color;
            return dir;
        }else{
            return dir-1;
        }

    }


    public void borra_pieza(int x1,int x2,int x3,int x4,int y1,int y2,int y3,int y4,int tipoPieza,int dir,int mov){
        if(dir<=4){
            if(mov==0){
                tablero[y1-1][x1] = 0;
                tablero[y2-1][x2] = 0;
                tablero[y3-1][x3] = 0;
                tablero[y4-1][x4] = 0;
            }else if(mov==1){//Izq
                tablero[y1][x1+1] = 0;
                tablero[y2][x2+1] = 0;
                tablero[y3][x3+1] = 0;
                tablero[y4][x4+1] = 0;
            }else{//Der
                tablero[y1][x1-1] = 0;
                tablero[y2][x2-1] = 0;
                tablero[y3][x3-1] = 0;
                tablero[y4][x4-1] = 0;
            }
        }else{
            tablero[y1][x1] = 0;
            tablero[y2][x2] = 0;
            tablero[y3][x3] = 0;
            tablero[y4][x4] = 0;
        }
    }

    public void actualiza_tablero(){
        // i = filas / j = columnas
        for(int i=0;i<22;i++){
            for(int j=0;j<12;j++){
                if(j==0||j==11){
                    tablero[i][j]=-1;
                }else{
                    if(i==0 || i==21){
                        tablero[i][j]=-1;
                    }
                }
                switch (tablero[i][j]){
                    case 0:{//Color negro
                        imageIDs[(12 * i) + j] = R.drawable.black;
                    }break;
                    case -1:{//Color gris
                        imageIDs[(12 * i) + j] = R.drawable.gray;
                    }break;
                    case 1:{//Color azul
                        imageIDs[(12 * i) + j] = R.drawable.blue;
                    }break;
                    case 2:{//Color verde
                        imageIDs[(12 * i) + j] = R.drawable.green;
                    }break;
                    case 3:{//Color morado
                        imageIDs[(12 * i) + j] = R.drawable.purple;
                    }break;
                    case 4:{//Color rosado
                        imageIDs[(12 * i) + j] = R.drawable.pink;
                    }break;
                    case 5:{//Color rojo
                        imageIDs[(12 * i) + j] = R.drawable.red;
                    }break;
                    case 6:{//Color amarillo
                        imageIDs[(12 * i) + j] = R.drawable.yellow;
                    }break;
                }
            }
        }
    }
}