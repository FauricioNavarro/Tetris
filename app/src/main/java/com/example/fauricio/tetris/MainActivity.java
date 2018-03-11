package com.example.fauricio.tetris;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
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
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    public int eje_y = 2;
    public int eje_x = 5;
    public int rotate = 0;
    public int aux;
    public Controlador controlador;
    public int pieza_actual;
    public int color_actual;
    public final Random rand = new Random();
    public final Random rand1 = new Random();

    public void left_click(View view){
        aux = eje_x-1;
        if(aux>0 && aux<11){
            eje_x = eje_x - 1;
            controlador.mover_izq(eje_y,eje_x,pieza_actual,color_actual,rotate);
            controlador.actualiza_tablero();
            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        }
    }

    public void right_click(View view){
        aux = eje_x+1;
        if(aux>0 && aux<11){
            eje_x = eje_x + 1;
            controlador.mover_der(eje_y,eje_x,pieza_actual,color_actual,rotate);
            controlador.actualiza_tablero();
            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        }
    }

    public void down_click(View view){
        aux = eje_y + 1;
        if(aux > 0 && aux < 21){
            eje_y = eje_y + 1;
            controlador.baja_pieza(eje_y,eje_x,pieza_actual,color_actual,rotate);
            controlador.actualiza_tablero();
            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        }
    }

    public void rotate_click(View view){
        if(pieza_actual!=6 && pieza_actual!=7){
            if(rotate == 3){
                if(pieza_actual==3 || pieza_actual==4 || pieza_actual==5){
                    rotate = controlador.rotar_pieza(eje_y,eje_x,pieza_actual,color_actual,rotate);
                    controlador.actualiza_tablero();
                    gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                    rotate = 0;
                }
                rotate = 0;
            }else{
                rotate = controlador.rotar_pieza(eje_y,eje_x,pieza_actual,color_actual,rotate);
                controlador.actualiza_tablero();
                gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                rotate = rotate + 1;
            }
        }else{
            rotate = 0;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.tablero_gui);
        controlador = Controlador.getInstance();
        controlador.actualiza_tablero();
        gridView.setAdapter(new ImageAdapter(getApplicationContext()));
        pieza_actual = rand.nextInt(8);
        color_actual = rand1.nextInt(6)+1;

        new CountDownTimer(330000000, 33000){
            public void onTick(long millisUntilFinished){
                Log.i("TIMER","Comienzo: "+eje_x);
                eje_y = 2;
                eje_x = 5;//counter=1;
                pieza_actual = rand.nextInt(8);
                color_actual = rand1.nextInt(6)+1;
                new CountDownTimer(33000, 1500){
                    public void onTick(long millisUntilFinished){
                        aux = eje_y + 1;
                        if(aux > 0 && aux < 21){
                            eje_y = eje_y + 1;
                            controlador.baja_pieza(eje_y,eje_x,pieza_actual,color_actual,rotate);
                            controlador.actualiza_tablero();
                            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                        }else if(aux==21){
                            Log.i("TIMER","finish: "+eje_x);
                            cancel();
                        }
                    }
                    public void onFinish(){
                        Log.i("TIMER","finish: "+eje_x);
                    }
                }.start();
            }
            public void onFinish(){
                Log.i("TIMER","finish principal");
            }
        }.start();
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
