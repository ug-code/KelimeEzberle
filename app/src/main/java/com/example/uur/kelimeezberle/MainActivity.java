package com.example.uur.kelimeezberle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;//silinecek
import android.view.View;
import android.widget.Button;

import java.util.List;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnnewgame= (Button) findViewById(R.id.btningtur);

        btnnewgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HarfSec.class));


            }
        });

        //////////////////////////////////////////////////////////dboperations/////////////////////////

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */
        // Inserting statistics
        /*
        Log.d("Insert: ", "Ekleniyor ..");
        db.addStatistic(new StatisticsTable("1", "run", "koşmak", "Rlist"));
        db.addStatistic(new StatisticsTable("2", "study", "çalışmak", "SList"));
        db.addStatistic(new StatisticsTable("5", "work", "iş", "WList"));
        db.addStatistic(new StatisticsTable("6", "bird", "kuş", "Blist"));

        // Reading all statistics
        Log.d("Reading: ", "Okunuyor");
        List<StatisticsTable> statistics = db.getAllStatisticsTable();

        for (StatisticsTable cn : statistics) {
            String log = "Id: " + cn.getID() + " ,JsonID: " + cn.getKey() + " ,Kelime: " + cn.getKelime() + " ,Ceviri: " + cn.getCeviri() + " ,JSONListe: " + cn.getEtiket();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }



*/

        //////////////////////////////////////////////////////////////////////////////////////////////




    }


}
