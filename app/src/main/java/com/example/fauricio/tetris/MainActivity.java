package com.example.fauricio.tetris;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    public int eje_y = 2;
    public int eje_x = 5;
    public int rotate;
    public int aux;
    public Controlador controlador;
    public static boolean estado=true;
    public int[][] prueba= {{},{},{}};

    public void left_click(View view){
        aux = eje_x-1;
        if(aux>0 && aux<11){
            eje_x = eje_x - 1;
            controlador.mover_izq(eje_y,eje_x,0,6);
            controlador.actualiza_tablero();
            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        }
    }

    public void right_click(View view){
        aux = eje_x+1;
        if(aux>0 && aux<11){
            eje_x = eje_x + 1;
            controlador.mover_der(eje_y,eje_x,0,6);
            controlador.actualiza_tablero();
            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        }
    }

    public void down_click(View view){
        aux = eje_y + 1;
        if(aux > 0 && aux < 21){
            eje_y = eje_y + 1;
            controlador.baja_pieza(eje_y,eje_x,0,6);
            controlador.actualiza_tablero();
            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        }
    }

    public void rotate_click(View view){
        /*
        aux = rotate + 1;

        if(aux > 4){
            rotate = 0;
        }else{
            rotate = rotate + 1;
            controlador.rotar_pieza(eje_y,eje_x,0,6,rotate);
            controlador.actualiza_tablero();
            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        } */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.tablero_gui);
        controlador = Controlador.getInstance();

        controlador.actualiza_tablero();
        gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        /*
        new Runnable() {
            @Override
            public void run() {
                CountDownTimer timer_aux = new CountDownTimer(42000, 2000){
                    public void onTick(long millisUntilFinished){
                        controlador.baja_pieza(counter,f,0,6);
                        gridView.setAdapter(new ImageAdapter(getApplicationContext()));

                        if(counter<20){
                            counter++;
                        }else{
                            onStop();
                        }
                        /*if(counter==1){
                            // f : numero de columna | counter : numro de fila
                            controlador.imageIDs[(12*counter)+f]=R.drawable.blue;
                            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                            counter++;
                        }else{
                            controlador.imageIDs[(12*(counter-1))+f]=R.drawable.black;
                            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                            controlador.imageIDs[(12*counter)+f]=R.drawable.blue;
                            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                            counter++;
                        }*/
        /*
                    }
                    public void onFinish(){
                        Log.i("TIMER","finish");
                        counter=1;
                        f++;
                        estado=false;
                        onStop();
                    }
                }.start();
            }
        }.run();
        */
    }

    public class ImageAdapter extends BaseAdapter
    {
        private Context context;
        public ImageAdapter(Context c)
        {
            context = c;
        }
        public int getCount() {
            return controlador.imageIDs.length;
        }
        public Object getItem(int position) {
            return position;
        }
        public long getItemId(int position) {
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent)
        {
            ImageView imageView;
            if (convertView == null) {
                imageView = new ImageView(context);
                imageView.setLayoutParams(new GridView.LayoutParams(36, 36));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(1, 1, 1, 1);
            } else {
                imageView = (ImageView) convertView;
            }
            imageView.setImageResource(controlador.imageIDs[position]);
            return imageView;
        }
    }
}
