package com.marrog.task1;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper mDataBaseHelper;
    private SQLiteDatabase mdb;
    private Cursor mCursor;
    private SimpleCursorAdapter mSCAdapter;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
           super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_main);

           mDataBaseHelper = new DatabaseHelper(this);
           mdb = mDataBaseHelper.getWritableDatabase();

          // ContentValues values = new ContentValues();
           // Задайте значения для каждого столбца
//           values.put(DatabaseHelper.MESSAGE_TITTLE_COLUMN, "Test");
//           values.put(DatabaseHelper.MESSAGE_BODY_COLUMN, "Test");
//           values.put(DatabaseHelper.MESSAGE_DATE_COLUMN, 5);
//           // Вставляем данные в таблицу
//           mdb.insert(DatabaseHelper.DATABASE_TABLE, null, values);

//                   ContentValues values = new ContentValues();
//           // Задайте значения для каждого столбца
//           values.put(DatabaseHelper.MESSAGE_TITTLE_COLUMN, "Test1");
//           values.put(DatabaseHelper.MESSAGE_BODY_COLUMN, "Test");
//           values.put(DatabaseHelper.MESSAGE_DATE_COLUMN, 5);
//           // Вставляем данные в таблицу
//           mdb.update(DatabaseHelper.DATABASE_TABLE,values, DatabaseHelper.MESSAGE_TITTLE_COLUMN + " = ?", new String[]{"Test"});


//           Cursor cursor = mdb.query(DatabaseHelper.DATABASE_TABLE,
//                   new String[]{DatabaseHelper.MESSAGE_TITTLE_COLUMN, DatabaseHelper.MESSAGE_BODY_COLUMN},
//                   null, null, null, null, null);

            mCursor = mdb.query(DatabaseHelper.DATABASE_TABLE,
                   new String[]{DatabaseHelper.ID_COLUMN, DatabaseHelper.MESSAGE_TITTLE_COLUMN, DatabaseHelper.MESSAGE_BODY_COLUMN},
                   null, null, null, null, null);



//           cursor.moveToFirst();
//           while(cursor.moveToNext()){
//
//               System.out.println(cursor.getString(0));
//
//           }

//           SimpleCursorAdapter mSCAdapter = new SimpleCursorAdapter(this, R.layout.item, cursor,
//                   new String[]{DatabaseHelper.MESSAGE_TITTLE_COLUMN, DatabaseHelper.MESSAGE_BODY_COLUMN},
//                   new int[]{R.id.message_title, R.id.message_body}, 1);

                       mSCAdapter = new SimpleCursorAdapter(this, R.layout.item, mCursor,
                   new String[]{DatabaseHelper.MESSAGE_TITTLE_COLUMN, DatabaseHelper.MESSAGE_BODY_COLUMN},
                   new int[]{R.id.message_title, R.id.message_body}, 0);

           ListView listView = (ListView)findViewById(R.id.listView);

           listView.setAdapter(mSCAdapter);



       }

    public void onClick(View view) {


         ContentValues values = new ContentValues();
       //  Задайте значения для каждого столбца
           values.put(DatabaseHelper.MESSAGE_TITTLE_COLUMN, "Опа");
           values.put(DatabaseHelper.MESSAGE_BODY_COLUMN, "Опапа");
           values.put(DatabaseHelper.MESSAGE_DATE_COLUMN, 5);
           // Вставляем данные в таблицу
           mdb.insert(DatabaseHelper.DATABASE_TABLE, null, values);


    }
}
