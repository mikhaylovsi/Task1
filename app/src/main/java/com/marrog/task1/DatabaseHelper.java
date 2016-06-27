package com.marrog.task1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Сергей on 22.06.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mydatabase.db";
    public static final int DATABASE_VERSION = 2;

    public static final String DATABASE_TABLE = "messages";

    public static final String ID_COLUMN = "_id";
    public static final String MESSAGE_TITTLE_COLUMN = "message_title";
    public static final String MESSAGE_BODY_COLUMN = "message_body";
    public static final String MESSAGE_DATE_COLUMN = "message_date";

    public static final String DATABASE_CREATE_SCRIPT =
            "create table " + DATABASE_TABLE + " (" + ID_COLUMN + " integer primary key autoincrement, " +
                    MESSAGE_TITTLE_COLUMN + " text, " + MESSAGE_BODY_COLUMN + " text, " +
                    MESSAGE_DATE_COLUMN + " integer);";




    DatabaseHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

      db.execSQL(DATABASE_CREATE_SCRIPT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w("SQLite", "Обновляемся с версии " + oldVersion + " на версию " + newVersion);

        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

        onCreate(db);

    }
}
