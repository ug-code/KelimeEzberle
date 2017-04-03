package com.example.uur.kelimeezberle;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

public class ingturScnk extends AppCompatActivity implements View.OnClickListener {
    int Wordnumber = 0, TrueCount = 0, FalseCount = 0;
    int FirsQuestion =0;
    StringBuilder JsonCount;
    JsonRead jread = new JsonRead();
    StringBuilder ilksoru = new StringBuilder();
    StringBuilder soru = new StringBuilder();
    StringBuilder cevap = new StringBuilder();
    StringBuilder key = new StringBuilder();
    StringBuilder data;
    String Selected_letter;
    Button btn, btn2, btn3, btn4;
    TextView textView;
    InputStream is,tv_question_count_is;
    Animation animScale;
    ArrayList<StringBuilder> list;
    TextView tv_question_count,txt_true;
    Boolean finish_status=false;
    //Android XML Animation
    Animation blinkAnimation;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingtur_scnk);
        Bundle extras = getIntent().getExtras();
        Selected_letter = extras.getString("anahat");
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_databtn1);
        final EditText editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);
        //sağ üsteki textview Sayı için lazım bize
        txt_true = (TextView) findViewById(R.id.txt_true);

        //sol üsteki textview sayı için lazım bize
        tv_question_count_is = getResources().openRawResource(R.raw.ujason);
        tv_question_count = (TextView) findViewById(R.id.tv_question_count);
        JsonCount= jread.JsonreadCount(Selected_letter,tv_question_count_is,"id");
        tv_question_count.setText(1+"/"+JsonCount);
        System.out.println("json Count: "+JsonCount);
        is = getResources().openRawResource(R.raw.ujason);
        soru = jread.Jsonread(Selected_letter, is, 0, "ing");
        //textView.setText(soru);
        //soru.setLength(0);
        //Buton tanımlamaları
        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        System.out.println("button Renk: "+btn.getBackground());
        AnswerOptions(Selected_letter, btn, btn2, btn3, btn4, false);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        //ilksoru.setLength(0);
        tv_question_count.setText(Wordnumber+2+"/"+JsonCount);

        InputStream is = getResources().openRawResource(R.raw.ujason);
        InputStream is1 = getResources().openRawResource(R.raw.ujason);
        InputStream is2 = getResources().openRawResource(R.raw.ujason);
        soru = jread.Jsonread(Selected_letter, is, Wordnumber + 1, "ing");
        //Aşagıda Tread işleminde kullanılmadıysa açılması lazım.
        //textView.setText(soru);
        cevap = jread.Jsonread(Selected_letter, is1, Wordnumber, "tur");
        key = jread.Jsonread(Selected_letter, is2, Wordnumber, "id");

        switch (v.getId()) {
            case R.id.button:
                AnswerOptions(Selected_letter, btn, btn2, btn3, btn4, true);
                break;
            case R.id.button2:
                AnswerOptions(Selected_letter, btn2, btn, btn3, btn4, true);
                break;
            case R.id.button3:
                AnswerOptions(Selected_letter, btn3, btn, btn2, btn4, true);
                break;
            case R.id.button4:
                AnswerOptions(Selected_letter, btn4, btn, btn2, btn3, true);
                break;
        }
        Wordnumber++;
    }

    //String data1 anahat değerimiz
    void AnswerOptions(String value, final Button Databtn1,final Button Databtn2,final Button Databtn3,final Button Databtn4, Boolean arg1) {
        //Tanımlar Başlangıçç
        InputStream is, is1, is2, is3, is4, is5, is6;
        is = getResources().openRawResource(R.raw.ujason);
        is1 = getResources().openRawResource(R.raw.ujason);
        is2 = getResources().openRawResource(R.raw.ujason);
        is3 = getResources().openRawResource(R.raw.ujason);
        is4 = getResources().openRawResource(R.raw.ujason);
        is5 = getResources().openRawResource(R.raw.ujason);
        is6 = getResources().openRawResource(R.raw.ujason);
        //Tanımlar bitiş
        //StringBuilder Şıklar
        if (arg1 == true) {
            data = jread.Jsonread(value, is, Wordnumber + 1, "tur");
        } else {
            data = jread.Jsonread(value, is, Wordnumber, "tur");
        }
        StringBuilder RndData = jread.JsonRandom(is1, is2, "tur");
        StringBuilder RndData1 = jread.JsonRandom(is3, is4, "tur");
        StringBuilder RndData2 = jread.JsonRandom(is5, is6, "tur");
        //StringBuilder Bitiş

        //rastgele Şık düzeni başla
        StringBuilder[] Liste = {data, RndData, RndData1, RndData2};
        list = new ArrayList<StringBuilder>();
        for (int i = 0; i < 4; i++) {
            list.add(Liste[i]);
        }
        Collections.shuffle(list);

        //Rastege Şık bitti
        if (!soru.toString().matches("") && Databtn1.getText().toString().equals(cevap.toString())) {
            //Databtn1.setBackgroundColor(Color.GREEN);
            Databtn1.setBackgroundResource(R.drawable.mytruebutton_radios);
            //blinkAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.btn_blink);
            //Databtn1.startAnimation(blinkAnimation);
            TrueCount++;
            txt_true.setText(String.valueOf(TrueCount));
            /*
            Toast toast = Toast.makeText(getApplicationContext()," " + cevap + " true ",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            */


        } else if (soru.toString().matches("") && ilksoru.toString().matches("")) {
            finish_status=true;
            Toast.makeText(getApplicationContext(), "bitti => " + FalseCount + " tane yanlış " + TrueCount + " doğru var", Toast.LENGTH_SHORT).show();

        } else {
            if( FirsQuestion > 0) {
                //Databtn1.setBackgroundColor(Color.RED);
                Databtn1.setBackgroundResource(R.drawable.myfalsebutton_radios);
            }
            FirsQuestion++;
            FalseCount++;
            /*
            Toast toast = Toast.makeText(getApplicationContext()," " + cevap + " false", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            */
        }

        /*final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Databtn1.clearAnimation();
                handler.postDelayed(this, 100);
            }
        }, 1000);
        */
        if (finish_status==true){
            int[] statistics_intent_result = {Integer.parseInt(JsonCount.toString()), TrueCount, FalseCount};
            Intent intent=new Intent(getApplicationContext(),Statistics.class);
            intent.putExtra("Statistics", statistics_intent_result);
            startActivity(intent);
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(finish_status==false){
                            Databtn1.setBackgroundResource(R.drawable.mybutton_radios);
                            textView.setText(soru);
                            Databtn1.setText(list.get(0));
                            Databtn2.setText(list.get(1));
                            Databtn3.setText(list.get(2));
                            Databtn4.setText(list.get(3));
                        }
                    }
                }, 500);
            }
        });

    }

    void İntentCon(String Liste) {
        Intent intent = new Intent(getApplicationContext(), ingturScnk.class);
        intent.putExtra("anahat", Liste);
        startActivity(intent);
    }
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("ingturScnk Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}

