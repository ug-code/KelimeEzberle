package com.example.uur.kelimeezberle;

/**
 * Created by Muhammed on 12.08.2016.
 */
public class StatisticsTable {

        //private variables
        int id;
        String key;//json dosyasındaki id değeri
        String kelime;//yanlış girilen kelime
        String ceviri;//karsiligi
        String etiket;//bulunduğu json listesi

        // Empty constructor
        public StatisticsTable(){

        }
        // constructor
        public StatisticsTable(int id, String key, String kelime, String ceviri, String etiket){
            this.id = id;
            this.key = key;
            this.kelime = kelime;
            this.ceviri = ceviri;
            this.etiket = etiket;
        }

        // constructor
        public StatisticsTable(String key, String kelime, String ceviri, String etiket){
            this.key = key;
            this.kelime = kelime;
            this.ceviri = ceviri;
            this.etiket = etiket;
        }
        // getting ID
        public int getID(){
            return this.id;
        }

        // setting id
        public void setID(int id){
            this.id = id;
        }

        // getting key
        public String getKey(){
            return this.key;
        }

        // setting key
        public void setKey(String key){
            this.key = key;
        }

        // getting kelime
        public String getKelime(){
            return this.kelime;
        }

        // setting kelime
        public void setKelime(String kelime){
            this.kelime = kelime;
        }

        // getting ceviri
        public String getCeviri(){
            return this.ceviri;
        }

        // setting ceviri
        public void setCeviri(String ceviri){
            this.ceviri = ceviri;
        }

        // getting etiket
        public String getEtiket(){
            return this.etiket;
        }

        // setting etiket
        public void setEtiket(String etiket){
            this.etiket = etiket;
        }
    }

