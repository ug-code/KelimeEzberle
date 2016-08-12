package com.example.uur.kelimeezberle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HarfSec extends AppCompatActivity implements View.OnClickListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_harf_sec);
        Button a   = (Button) findViewById(R.id.abtn);
        Button b   = (Button) findViewById(R.id.bbtn);
        Button c   = (Button) findViewById(R.id.cbtn);
        Button d   = (Button) findViewById(R.id.dbtn);
        Button e   = (Button) findViewById(R.id.ebtn);
        Button f   = (Button) findViewById(R.id.fbtn);
        Button g   = (Button) findViewById(R.id.gbtn);
        Button h   = (Button) findViewById(R.id.hbtn);
        Button i   = (Button) findViewById(R.id.ibtn);
        Button jk  = (Button) findViewById(R.id.jkbtn);
        Button l   = (Button) findViewById(R.id.lbtn);
        Button m   = (Button) findViewById(R.id.mbtn);
        Button no  = (Button) findViewById(R.id.nobtn);
        Button p   = (Button) findViewById(R.id.pbtn);
        Button qr  = (Button) findViewById(R.id.qrbtn);
        Button s   = (Button) findViewById(R.id.sbtn);
        Button t   = (Button) findViewById(R.id.tbtn);
        Button uv  = (Button) findViewById(R.id.uvbtn);
        Button wyz = (Button) findViewById(R.id.wyzbtn);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        jk.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        no.setOnClickListener(this);
        p.setOnClickListener(this);
        qr.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        uv.setOnClickListener(this);
        wyz.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.abtn:
                İntentCon("Alist");
                break;
            case R.id.bbtn:
                İntentCon("Blist");
                break;
            case R.id.cbtn:
                İntentCon("Clist");
                break;
            case R.id.dbtn:
                İntentCon("Dlist");
                break;
            case R.id.ebtn:
                İntentCon("Elist");
                break;
            case R.id.fbtn:
                İntentCon("Flist");
                break;
            case R.id.gbtn:
                İntentCon("Glist");
                break;
            case R.id.hbtn:
                İntentCon("Hlist");
                break;
            case R.id.ibtn:
                İntentCon("Ilist");
                break;
            case R.id.jkbtn:
                İntentCon("JKlist");
                break;
            case R.id.lbtn:
                İntentCon("Llist");
                break;
            case R.id.mbtn:
                İntentCon("Mlist");
                break;
            case R.id.nobtn:
                İntentCon("NOlist");
                break;
            case R.id.pbtn:
                İntentCon("Plist");
                break;
            case R.id.qrbtn:
                İntentCon("QRlist");
                break;
            case R.id.sbtn:
                İntentCon("Slist");
                break;
            case R.id.tbtn:
                İntentCon("Tlist");
                break;
            case R.id.uvbtn:
                İntentCon("UVlist");
                break;
            case R.id.wyzbtn:
                İntentCon("WYZlist");
                break;



        }
    }


    void İntentCon(String Liste){
        Intent intent=new Intent(getApplicationContext(),ingturScnk.class);
        intent.putExtra("anahat",Liste);
        startActivity(intent);
    }
}
