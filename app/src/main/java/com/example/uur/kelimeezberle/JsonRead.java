package com.example.uur.kelimeezberle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by uur on 30.7.2016.
 */
public class JsonRead {

    StringBuilder Jsonread(String DataName, InputStream is, int i,String data) {
        StringBuilder sb=new StringBuilder();
        try {
            byte buffer[] = new byte[is.available()];
            while (is.read(buffer) != -1) ;

            String jsonVerisi = new String(buffer);
            JSONObject jsonObject = new JSONObject(jsonVerisi);
            JSONArray list = jsonObject.getJSONArray(DataName);
            if (i < list.length()) {
                JSONObject object = list.getJSONObject(i);
                String arg = object.getString(data);
                sb.append(arg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb;
    }

    StringBuilder JsonRandom(InputStream is,InputStream is1,String data) {

        String[] Liste={"Alist","Blist","Clist","Dlist","Elist","Flist","Glist","Hlist","Ilist","JKlist","Llist","Mlist","NOlist","Plist","QRlist","Slist","Tlist","UVlist","WYZlist"};
        Random rand = new Random();
        String RandList=Liste[rand.nextInt(18)];
        int JCount=0;
        StringBuilder sb=new StringBuilder();
        try {

            byte buffer[] = new byte[is.available()];
            while (is.read(buffer) != -1) ;

            String jsonVerisi = new String(buffer);
            JSONObject jsonObject = new JSONObject(jsonVerisi);
            JSONArray list = jsonObject.getJSONArray(RandList);
            JCount=Integer.parseInt(JsonreadCount(RandList,is1,"id").toString());
            //testing
            Random rand1 = new Random();
            int  Randomnumber=rand.nextInt(JCount-1);
            JSONObject object = list.getJSONObject(Randomnumber);
            String arg = object.getString(data);
            sb.append(arg);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb;
    }

    StringBuilder JsonreadCount(String DataName, InputStream is,String data) {
        StringBuilder sb=new StringBuilder();
        try {
            byte buffer[] = new byte[is.available()];
            while (is.read(buffer) != -1) ;

            String jsonVerisi = new String(buffer);
            JSONObject jsonObject = new JSONObject(jsonVerisi);
            JSONArray list = jsonObject.getJSONArray(DataName);

                JSONObject object = list.getJSONObject(list.length()-1);
                String arg = object.getString(data);
                sb.append(arg);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return sb;
    }
}

