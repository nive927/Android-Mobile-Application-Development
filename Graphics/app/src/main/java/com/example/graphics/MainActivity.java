package com.example.graphics;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView im;
    Paint paint;
    Button b1, b2, b3, b4;
    int clicks = 0;
    int clicksC = 0;

    public void reset_im() {
        im.setScaleX(1);
        im.setScaleY(1);
        im.setRotation(0);
        im.setBackgroundResource(0);
        im.setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        im = findViewById(R.id.imageView);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);

        paint = new Paint();
        paint.setColor(Color.BLUE);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                reset_im();

                Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);

//                canvas.drawLine(0, 0, 100, 100, paint);

//                canvas.drawCircle(50, 50, 20, paint);

//                Square
//                canvas.drawRect(20, 20, 90, 90, paint);

//                Rectangle
//                canvas.drawRect(20, 20, 90, 60, paint);

//                Arc
                RectF a = new RectF(10, 10, 90, 90);
                canvas.drawArc(a, 225, 90, true, paint);

                im.setImageBitmap(bitmap);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset_im();

                Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawRect(20, 20, 90, 60, paint);
                im.setImageBitmap(bitmap);

                if(clicks == 0) {
                    im.setScaleX(0.5f);
                    im.setScaleY(0.5f);
                }
                else if(clicks == 1) {
                    im.setRotation(20f);
                }
                else {
                    im.setScaleX(1.05f);
                    im.setScaleY(1.05f);
                }
                clicks++;
                clicks %= 3;
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bitmap bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                canvas.drawRect(20, 20, 90, 60, paint);
                im.setImageBitmap(bitmap);

                if(clicksC == 0) {
                    paint.setColor(Color.BLUE);
                }
                else if(clicksC == 1) {
                    paint.setColor(Color.YELLOW);
                }
                else {
                    paint.setColor(Color.RED);
                }
                clicksC++;
                clicksC %= 3;

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset_im();

//                under res/drawable/bus.png
                im.setImageResource(R.drawable.bus);

                float x = im.getX();

                ObjectAnimator animCar = ObjectAnimator.ofFloat(im, "x", x + 200);
                animCar.setDuration(1000);

                AnimatorSet a = new AnimatorSet();
                a.play(animCar).before(ObjectAnimator.ofFloat(im, "x", x).setDuration(1000));
                a.start();
            }
        });

    }
}