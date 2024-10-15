package com.raghav.t3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    boolean ga=true;
    //0-x
    // 1-O
    //2-null
    int ap=0;
    int[] gs={2,2,2,2,2,2,2,2,2};
    int[][] wp={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void tap(View view)
    {
        ImageView img = (ImageView)view;
        int tapimage = Integer.parseInt(img.getTag().toString());
        if(!ga)
        {
            gamereset(view);
        }
        if(gs[tapimage]==2)
        {
            gs[tapimage]=ap;
            img.setTranslationY(-1000f);
            if(ap==0)
            {
                img.setImageResource(R.drawable.x);
                ap=1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn Tap to continue");
            }
            else
            {
                img.setImageResource(R.drawable.o);
                ap=0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn Tap to continue");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
            //check wining
        for(int[] w: wp)
        {
            if(gs[w[0]]==gs[w[1]]&&gs[w[1]]==gs[w[2]]&&gs[w[0]]!=2)
            {
                String win;
                ga=false;
                if(gs[w[0]]==0)
                {
                    win="X won";
                }
                else
                {
                    win="O won";
                }
                //update status bar for winner
                TextView status = findViewById(R.id.status);
                status.setText(win);
            }
        }

    }

    public void gamereset(View view)
    {
       ga=true;
       ap=0;
       for(int i=0;i<gs.length;i++)
       {
           gs[i]=2;
       }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("O's turn Tap to play");


    }

    public void btn(View view)
    {
        ga=true;
        ap=0;
        for(int i=0;i<gs.length;i++)
        {
            gs[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's turn Tap to play");


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}