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
    public int counter=1;
    public int f =1;
    public int limite = 0;
    public Controlador controlador;
    public static boolean estado=true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.tablero_gui);
        controlador = Controlador.getInstance();
        int base= 12;
        for(int i=0;i<22;i++){
            for(int j=0;j<12;j++){
                if(controlador.tablero[i][j]==-1){
                    controlador.imageIDs[(base*i)+j] = R.drawable.gray;
                }else{
                    controlador.imageIDs[(base*i)+j] = R.drawable.black;
                }
                /*if(j==0||j==11){
                    controlador.imageIDs[(base*i)+j] = R.drawable.gray;
                }else if(i==0 || i==21){
                    controlador.imageIDs[(base*i)+j] = R.drawable.gray;
                }else{
                    controlador.imageIDs[(base*i)+j] = R.drawable.black;
                }*/
            }
        }

        new Runnable() {
            @Override
            public void run() {
                CountDownTimer timer_aux = new CountDownTimer(42000, 2000){
                    public void onTick(long millisUntilFinished){
                        if(counter==1){
                            controlador.imageIDs[(12*counter)+f]=R.drawable.blue;
                            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                            counter++;
                        }else{
                            controlador.imageIDs[(12*(counter-1))+f]=R.drawable.black;
                            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                            controlador.imageIDs[(12*counter)+f]=R.drawable.blue;
                            gridView.setAdapter(new ImageAdapter(getApplicationContext()));
                            counter++;
                        }
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
    }

    public class ImageAdapter extends BaseAdapter
    {

        private Context context;

        public ImageAdapter(Context c)
        {
            context = c;
        }

        //---returns the number of images---
        public int getCount() {
            return controlador.imageIDs.length;
        }

        //---returns the ID of an item---
        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        //---returns an ImageView view---
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
