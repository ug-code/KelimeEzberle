package com.example.uur.kelimeezberle;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ingturScnk extends AppCompatActivity implements View.OnClickListener {
    int Wordnumber = 0, TrueCount = 0, FalseCount = 0;
    StringBuilder Soru1;
    JsonRead jread = new JsonRead();
    StringBuilder ilksoru = new StringBuilder();
    StringBuilder soru = new StringBuilder();
    StringBuilder cevap = new StringBuilder();
    StringBuilder key = new StringBuilder();
    final DatabaseHandler db = new DatabaseHandler(this);//database operations
    StringBuilder data;

    String value;
    Button btn, btn2, btn3, btn4;
    TextView textView;
    InputStream is;
    Animation animScale;
    Drawable test;
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
        value = extras.getString("anahat");
        animScale = AnimationUtils.loadAnimation(this, R.anim.anim_databtn1);
        final EditText editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

        is = getResources().openRawResource(R.raw.ujason);


        soru = jread.Jsonread(value, is, 0, "ing");
        textView.setText(soru);
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
        test = btn.getBackground();
        secenek(value, btn, btn2, btn3, btn4, false);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onClick(View v) {
        Soru1 = soru;
        //ilksoru.setLength(0);
        InputStream is = getResources().openRawResource(R.raw.ujason);
        InputStream is1 = getResources().openRawResource(R.raw.ujason);
        InputStream is2 = getResources().openRawResource(R.raw.ujason);
        soru = jread.Jsonread(value, is, Wordnumber + 1, "ing");
        textView.setText(soru);
        cevap = jread.Jsonread(value, is1, Wordnumber, "tur");
        key = jread.Jsonread(value, is2, Wordnumber, "id");

        switch (v.getId()) {
            case R.id.button:
                secenek(value, btn, btn2, btn3, btn4, true);
                break;
            case R.id.button2:
                secenek(value, btn2, btn, btn3, btn4, true);
                break;
            case R.id.button3:
                secenek(value, btn3, btn, btn2, btn4, true);
                break;
            case R.id.button4:
                secenek(value, btn4, btn, btn2, btn3, true);
                break;
        }
        Wordnumber++;
    }

    //String data1 anahat değerimiz
    void secenek(String value, final Button Databtn1, Button Databtn2, Button Databtn3, Button Databtn4, Boolean arg1) {
        Databtn1.setBackgroundDrawable(test);
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
        ArrayList<StringBuilder> list = new ArrayList<StringBuilder>();
        for (int i = 0; i < 4; i++) {
            list.add(Liste[i]);
        }
        Collections.shuffle(list);

        //Rastege Şık bitti
        if (!soru.toString().matches("") && Databtn1.getText().toString().equals(cevap.toString())) {
            //Databtn1.startAnimation(animScale);
            Databtn1.setBackgroundColor(Color.GREEN);
            //Databtn1.setBackgroundDrawable(test);


            // Databtn1.getBackground().setColorFilter(0xFFFF0000, PorterDuff.Mode.MULTIPLY);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms
                    Databtn1.setBackgroundDrawable(test);
                    handler.postDelayed(this, 1000);
                }
            }, 1000);


            TrueCount++;
            Toast toast = Toast.makeText(getApplicationContext(),
                    " " + cevap + " true ",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            db.addStatistic(new StatisticsTable(key.toString(), Soru1.toString(), cevap.toString(), value));
            // Reading all statistics
            Log.d("Reading: ", "Okunuyor");
            List<StatisticsTable> statistics = db.getAllStatisticsTable();

            for (StatisticsTable cn : statistics) {
                String log = "Id: " + cn.getID() + " ,JsonID: " + cn.getKey() + " ,Kelime: " + cn.getKelime() + " ,Ceviri: " + cn.getCeviri() + " ,JSONListe: " + cn.getEtiket();
                // Writing Contacts to log
                Log.d("Name: ", log);
            }

            //////////////////////////////////////////////////////////////////////////

        } else if (soru.toString().matches("") && ilksoru.toString().matches("")) {
            Toast.makeText(getApplicationContext(), "bitti => " + FalseCount + " tane yanlış " + TrueCount + " doğru var", Toast.LENGTH_SHORT).show();
            /**
             * Bunlar sonra kullanılacak;
             */

            // String TrueValue  = TrueCount;
        } else {
            Databtn1.setBackgroundColor(Color.RED);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //Do something after 100ms
                    Databtn1.setBackgroundDrawable(test);
                    handler.postDelayed(this, 1000);
                }
            }, 1000);

            FalseCount++;
            Toast toast = Toast.makeText(getApplicationContext(),
                    " " + cevap + " false",
                    Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        Databtn1.setText(list.get(0));
        Databtn2.setText(list.get(1));
        Databtn3.setText(list.get(2));
        Databtn4.setText(list.get(3));
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

