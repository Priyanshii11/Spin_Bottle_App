package com.priyu.truth_dare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Random random = new Random();
    private int newDirection, lastDirection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageView = findViewById(R.id.imageView);
    }

    public void spin(View view) {
        newDirection = random.nextInt(4000);
        int min = 1000, max = newDirection;
        int ran = (int) (Math.random() * ((max - min) + 1) + min);
        float pivotX = imageView.getWidth() / 2;
        float pivotY = imageView.getHeight() / 2;

        Animation rotate = new RotateAnimation(lastDirection, newDirection, pivotX, pivotY);
        rotate.setDuration(ran);
        rotate.setFillAfter(true);

        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
               imageView.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imageView.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        lastDirection = newDirection;
        imageView.startAnimation(rotate);




    }
}