package com.example.homefan;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    ObjectAnimator rotateAnimator;
    ImageView ImageView;
    Switch switchButton;
    SeekBar seekBar;
    final int SPEED[] = {0, 5000, 3000, 1000};
    GradientDrawable gd = new GradientDrawable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        ImageView  = findViewById(R.id.van);
        switchButton =  findViewById(R.id.Light);
        seekBar = findViewById(R.id.load);

        rotateAnimator = ObjectAnimator.ofFloat(ImageView, "rotation", 0, 360);
        rotateAnimator.setDuration(1000);
        rotateAnimator.setDuration(ValueAnimator.INFINITE);
        rotateAnimator.setInterpolator(new LinearInterpolator());


        toggleButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (toggleButton.isChecked()) {
                    rotateAnimator.setDuration(SPEED[1]);
                    rotateAnimator.start();
                } else {
                    rotateAnimator.end();
                }
            }
        });


        gd.setShape(GradientDrawable.RECTANGLE);
        gd.setGradientType(GradientDrawable.RADIAL_GRADIENT);
        gd.setGradientRadius(330);

        switchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                if (switchButton.isChecked()) {
                    gd.setColors(new int[]{Color.GREEN, Color.TRANSPARENT});
                    ImageView.setBackground(gd);
                } else {
                    ImageView.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        });
 seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
     @Override
     public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
         if (fromUser) {
             rotateAnimator.setDuration(SPEED[progress]);
             rotateAnimator.start();

         } else {
             rotateAnimator.end();
         }

     }

     @Override
     public void onStartTrackingTouch(SeekBar seekBar) {

     }

     @Override
     public void onStopTrackingTouch(SeekBar seekBar) {

     }
 });



    }
}