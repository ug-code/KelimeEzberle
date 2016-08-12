package com.example.uur.kelimeezberle;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Muhammed on 12.08.2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "kelime_ezberle";

    // Contacts table name
    private static final String TABLE_STATISTICS = "statistics";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_KEYSTR = "key";
    private static final String KEY_KELIME = "kelime";
    private static final String KEY_CEVIRI = "ceviri";
    private static final String KEY_ETIKET = "etiket";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STATISTICS_TABLE = "CREATE TABLE " + TABLE_STATISTICS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_KEYSTR + " TEXT," + KEY_KELIME + " TEXT," + KEY_CEVIRI + " TEXT,"
                + KEY_ETIKET + " TEXT" + ")";
        db.execSQL(CREATE_STATISTICS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STATISTICS);

        // Create tables again
        onCreate(db);
    }

    // Adding new statistic
    public void addStatistic(StatisticsTable statistic) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_KEYSTR, statistic.getKey());
        values.put(KEY_KELIME, statistic.getKelime());
        values.put(KEY_CEVIRI, statistic.getCeviri());
        values.put(KEY_ETIKET, statistic.getEtiket());

        // Inserting Row
        db.insert(TABLE_STATISTICS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single StatisticsTable
    public StatisticsTable getStatisticsTable(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_STATISTICS, new String[] { KEY_ID,
                        KEY_KEYSTR, KEY_KELIME, KEY_KELIME, KEY_ETIKET}, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        StatisticsTable statistic = new StatisticsTable(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4));
        // return contact
        return statistic;
    }

    // Getting All StatisticsTable
    public List<StatisticsTable> getAllStatisticsTable() {

        List<StatisticsTable> statisticsList = new ArrayList<StatisticsTable>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_STATISTICS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                StatisticsTable statistics = new StatisticsTable();
                statistics.setID(Integer.parseInt(cursor.getString(0)));
                statistics.setKey(cursor.getString(1));
                statistics.setKelime(cursor.getString(2));
                statistics.setCeviri(cursor.getString(3));
                statistics.setEtiket(cursor.getString(4));
                // Adding contact to list
                statisticsList.add(statistics);
            } while (cursor.moveToNext());
        }

        // return contact list
        return statisticsList;
    }

    // Getting StatisticsTable Count
    public int getStatisticsTableCount() {

        String countQuery = "SELECT  * FROM " + TABLE_STATISTICS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
    // Updating single StatisticsTable
    public int updateStatisticsTable(StatisticsTable statistic) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_KEYSTR, statistic.getKey());
        values.put(KEY_KELIME, statistic.getKelime());
        values.put(KEY_CEVIRI, statistic.getCeviri());
        values.put(KEY_ETIKET, statistic.getEtiket());

        // updating row
        return db.update(TABLE_STATISTICS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(statistic.getID()) });
    }
}
