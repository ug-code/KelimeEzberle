package com.example.uur.kelimeezberle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;




public class Statistics extends AppCompatActivity {
    TextView rightanswer,wronganswer,yourscore;
    Double percent_correct;
    ImageView changeRating;
    Button play_again;
    int[] Quiz_resutl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        Bundle extras = getIntent().getExtras();
        Quiz_resutl = extras.getIntArray("Statistics");
        System.out.println("Right Answer :"+Quiz_resutl);
        System.out.println("Toplam:"+Quiz_resutl[0]+"dogru cevap"+Quiz_resutl[1]+"yanlış cevap:"+Quiz_resutl[2]);

        //Varriable Defination
        rightanswer   = (TextView) findViewById(R.id.rightanswer);
        wronganswer   = (TextView) findViewById(R.id.wronganswer);
        yourscore     = (TextView) findViewById(R.id.yourscore);
        changeRating  = (ImageView) findViewById(R.id.changeRating);
        percent_correct = ((double)Quiz_resutl[1]/(double)Quiz_resutl[0])*5;

        switch ((int) Math.round(percent_correct)) {
            case 1:
                changeRating.setImageResource(R.drawable.fiverating);
                break;
            case 2:
                changeRating.setImageResource(R.drawable.fiverating);
                break;
            case 3:
                changeRating.setImageResource(R.drawable.fiverating);
                break;
            case 4:
                changeRating.setImageResource(R.drawable.fiverating);
                break;
            case 5:
                changeRating.setImageResource(R.drawable.fiverating);
                break;
            default:
                break;
        }


        play_again   = (Button) findViewById(R.id.play_again);

        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Statistics.this,HarfSec.class));
            }
        });



        rightanswer.setText("Right Answer : "+Quiz_resutl[1]);
        wronganswer.setText("Wrong Answer : "+Quiz_resutl[2]);
        yourscore.setText("Your Score is "+Quiz_resutl[1]);

    }
}
