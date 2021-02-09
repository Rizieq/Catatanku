package com.rizieq.catatanku;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.rizieq.catatanku.BarangContract.*;

public class BarangDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "grocerylist.db";
    public static final int DATABASE_VERSION = 1;


    public BarangDBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_GROCERYLIST_TABLE = "CREATE TABLE " +
                BarangEntry.TABLE_NAME + " (" +
                BarangEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                BarangEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                BarangEntry.COLUMN_AMOUNT + " INTEGER NOT NULL, " +
                BarangEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";

        db.execSQL(SQL_CREATE_GROCERYLIST_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + BarangEntry.TABLE_NAME);
        onCreate(db);
    }
}
