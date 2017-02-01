package example.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static example.finalproject.TestsList.TABLE_NAME;

public class Tests extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listo;
    int day,month,year;
    DatePicker d1;
    Database hlp;
    Cursor c;
    ArrayList<String> tbl = new ArrayList<String>();
    SQLiteDatabase db;
    AlertDialog.Builder adb;
    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        adb = new AlertDialog.Builder(this);
        d1 = new DatePicker(this);
        adb.setView(d1);
        d1.setCalendarViewShown(false);
        listo = (ListView)findViewById(R.id.lv);
        //ArrayList<Sub> arr = new ArrayList<Sub>();
        hlp = new Database(this);
        db = hlp.getWritableDatabase();
        Cursor c = db.query(TABLE_NAME,null,null,null,null,null,null);
        int col1 = c.getColumnIndex("_id");
        int col2 = c.getColumnIndex("Color");
        int col3 = c.getColumnIndex("Name");
        int col4 = c.getColumnIndex("Day");
        int col5 = c.getColumnIndex("Month");
        int col6 = c.getColumnIndex("Year");
        c.moveToFirst();
        while (!c.isAfterLast()){
            int Color = c.getInt(col2);
            String Name = c.getString(col3);
            day = c.getInt(col4);
            month = c.getInt(col5);
            year = c.getInt(col6);
            String temp = Name + "," + Color + "," + day + "," + month + "," + year;
            tbl.add(temp);
            c.moveToNext();
        }
        c.close();
        db.close();

        /*arr.add(new Sub(0,20,06,1999,"English test"));
        arr.add(new Sub(0,10,05,1990,"Math test"));
        arr.add(new Sub(0,30,04,2007,"Sport test"));*/

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,tbl);
        listo.setAdapter(adp);
        listo.setChoiceMode(listo.CHOICE_MODE_SINGLE);
        listo.setOnItemClickListener(this);

        adb.setNeutralButton("Proceed",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                day = d1.getDayOfMonth();
                month = d1.getMonth() + 1;
                year = d1.getYear();
                goToast();
            }
        });
        ad = adb.create();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView tv = (TextView)view;
        tv.setTextColor(Color.RED);
    }

    public void add(View view) {
        Intent t = new Intent(this,Date.class);
        startActivity(t);
    }

    private void goToast() {
        Toast.makeText(this,day + "/" + month + "/" + year,Toast.LENGTH_LONG).show();
    }
}
