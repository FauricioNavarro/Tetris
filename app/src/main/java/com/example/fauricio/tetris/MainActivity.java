package com.example.fauricio.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private GridLayout gridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout = findViewById(R.id.tablero_gui);
        for(int i=0;i<22;i++){
            for(int j=0;j<12;j++){
                ImageView imageView = new ImageView(this);
                if((i==0 || i==21)&&(j==0||j==11)){
                    imageView.setImageResource(R.drawable.gray);
                    gridLayout.addView(imageView,i,j);
                }else{
                    imageView.setImageResource(R.drawable.black);
                    gridLayout.addView(imageView,i,j);
                    GridLayout.LayoutParams param =new GridLayout.LayoutParams();
                    param.height = GridLayout.LayoutParams.WRAP_CONTENT;
                    param.width = GridLayout.LayoutParams.WRAP_CONTENT;
                    param.rightMargin = 5;
                    param.topMargin = 5;
                    param.setGravity(Gravity.CENTER);
                    param.columnSpec = GridLayout.spec(j);
                    param.rowSpec = GridLayout.spec(i);
                    gridLayout.setLayoutParams (param);
                }

            }
        }
    }
}
