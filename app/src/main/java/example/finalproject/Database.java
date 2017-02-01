package example.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.widget.LinearLayoutCompat;

import static example.finalproject.TestsList.COLOR;
import static example.finalproject.TestsList.DAY;
import static example.finalproject.TestsList.KEY_ID;
import static example.finalproject.TestsList.MONTH;
import static example.finalproject.TestsList.NAME;
import static example.finalproject.TestsList.TABLE_NAME;
import static example.finalproject.TestsList.YEAR;

/**
 * Created by user on 09/01/2017.
 */

public class Database extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "tal.db";
    String strCreate;
    String strDelete;
    public static String name;

    public Database(Context context) { super(context, DATABASE_NAME, null, 1); };

    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate =  "CREATE TABLE " + TABLE_NAME;
        strCreate += " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, ";
        strCreate += COLOR + " TEXT,";
        strCreate += NAME + " TEXT,";
        strCreate += DAY + " TEXT,";
        strCreate += MONTH + " TEXT,";
        strCreate += YEAR + " TEXT);";
        db.execSQL(strCreate);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        strDelete="DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(strDelete);
    }
}
