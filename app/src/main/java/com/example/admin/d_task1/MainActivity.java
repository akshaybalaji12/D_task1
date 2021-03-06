package com.example.admin.d_task1;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int r=0;
    int b=0;
    int g=0;
    public static final String pref="Mypref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        SharedPreferences save = getApplicationContext().getSharedPreferences(pref,0);
        r=save.getInt("red",0);
        g=save.getInt("green",0);
        b=save.getInt("blue",0);

      fn(r,g,b);
        }

    public void fn(int red,int green,int blue)
    {   View la = findViewById(R.id.layout);
        la.setBackgroundColor(Color.rgb(red,green,blue));

        TextView t1= (TextView) findViewById(R.id.textView4);
        TextView t2= (TextView) findViewById(R.id.textView5);
        TextView t3= (TextView) findViewById(R.id.textView6);
        t1.setText(String.valueOf(r));
        t2.setText(String.valueOf(g));
        t3.setText(String.valueOf(b));
        t1.setTextColor(Color.rgb(255-r,255-g,255-b));
        t2.setTextColor(Color.rgb(255-r,255-g,255-b));
        t3.setTextColor(Color.rgb(255-r,255-g,255-b));



    }
    public void dec(View view) {
         r=r-5;
        if(r<0)
        {r=255;
        fn(r, g, b);}
        else fn(r, g, b);

    }

    public void dec3(View view) {
        g -= 5;
        if(g<0) {g=255;
        fn(r, g, b);}
        else fn(r, g, b);

    }

    public void dec2(View view) {
        b=b-5;
        if(b<0)
        {b=255; fn(r, g, b);}
        else fn(r, g, b);

    }

    public void inc3(View view) {
         b=b+5;
         if(b>255)
         {b=0;
          fn(r, g, b);}
         else {fn(r,g,b);}
    }

    public void inc2(View view) {
        g=g+5;
        if(g>255)
        {g=0;
         fn(r, g, b);
        }
        else {fn(r,g,b);}
    }

    public void inc(View view) {
        r=r+5;
        if(r>255)
        {r=0;
         fn(r, g, b);
        }
        else {fn(r,g,b);}
    }

    public void reset(View view) {
        r=0;
        b=0;
        g=0;
        fn(r,g,b);
    }
    @Override
    public void onStop(){
        super.onStop();
        SharedPreferences save = getSharedPreferences(pref,0);
        SharedPreferences.Editor editor= save.edit();
        editor.putInt("red",r);
        editor.putInt("green",g);
        editor.putInt("blue",b);
        editor.commit();
    }
}
