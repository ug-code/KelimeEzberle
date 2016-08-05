package com.example.uur.kelimeezberle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

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

    StringBuilder JsonRandom(String DataName, InputStream is, int i,String data) {
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


}
