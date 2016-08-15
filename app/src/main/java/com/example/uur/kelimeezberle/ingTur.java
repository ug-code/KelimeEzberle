package com.example.uur.kelimeezberle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.List;
import java.util.Random;

public class ingTur extends AppCompatActivity {
    JsonRead jread = new JsonRead();

    StringBuilder soru = new StringBuilder();
    StringBuilder cevap = new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ing_tur);
        final DatabaseHandler db = new DatabaseHandler(this);//database operations

        Bundle extras = getIntent().getExtras();
        final String value = extras.getString("anahat");

        final EditText editText = (EditText) findViewById(R.id.editText);
        final TextView textView = (TextView) findViewById(R.id.textView);

        InputStream is = getResources().openRawResource(R.raw.ujason);

        soru =jread.Jsonread(value,is, 0,"ing" );
        textView.setText(soru);

        //testing
        InputStream isx = getResources().openRawResource(R.raw.ujason);
        InputStream isx1 = getResources().openRawResource(R.raw.ujason);
        StringBuilder RndData= jread.JsonRandom(isx,isx1,"ing");
        //end testing

        //json dosyasının kaynağını gösteriyoruz.
        Button btn= (Button)findViewById(R.id.button);
        //max kelime a harfinda 65
        //ing or tur
        btn.setOnClickListener(new View.OnClickListener() {
            int Wordnumber=0;
            int TrueCount=0;
            int FalseCount=0;
            @Override
            public void onClick(View v) {

                InputStream is = getResources().openRawResource(R.raw.ujason);
                InputStream is1 = getResources().openRawResource(R.raw.ujason);
                String Getedittext = editText.getText().toString();
                soru =jread.Jsonread(value,is, Wordnumber+1,"ing" );
                textView.setText(soru);

                cevap =jread.Jsonread(value,is1, Wordnumber,"tur" );

                if(!soru.toString().matches("") && Getedittext.equals(cevap.toString())){
                    TrueCount++;
                    //Toast.makeText(getApplicationContext(), Getedittext+" " +cevap+" true ",Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(getApplicationContext(),
                            Getedittext+" " +cevap+" true ",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                else if(soru.toString().matches(""))
                {
                    Toast.makeText(getApplicationContext(), "bitti => "+FalseCount+" tane yanlış "+TrueCount+" doğru var",Toast.LENGTH_SHORT).show();

                }
                else{
                    FalseCount++;

                    //Toast.makeText(getApplicationContext(), Getedittext+" " +cevap+" false",Toast.LENGTH_SHORT).show();

                    Toast toast = Toast.makeText(getApplicationContext(),
                            Getedittext+" " +cevap+" false",
                            Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    ///////////////////////////////////test/////////////////////////////

                    Log.d("Insert: ", "Ekleniyor ..");
                    db.addStatistic(new StatisticsTable("1", soru.toString(), cevap.toString(), "Rlist"));

                    // Reading all statistics
                    Log.d("Reading: ", "Okunuyor");
                    List<StatisticsTable> statistics = db.getAllStatisticsTable();

                    for (StatisticsTable cn : statistics) {
                        String log = "Id: " + cn.getID() + " ,JsonID: " + cn.getKey() + " ,Kelime: " + cn.getKelime() + " ,Ceviri: " + cn.getCeviri() + " ,JSONListe: " + cn.getEtiket();
                        // Writing Contacts to log
                        Log.d("Name: ", log);
                    }

                    //////////////////////////////////////////////////////////////////////////
                }
                Wordnumber++;
                editText.setText("");

            }
        });

    }


}
