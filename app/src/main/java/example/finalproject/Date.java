package example.finalproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class Date extends AppCompatActivity {
    DatePicker d;
    TextView tv;
    TimePicker time;
    int day,month,year,hour,min;
    AlertDialog.Builder adbd, adbt;
    AlertDialog add, adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        d = new DatePicker(this);
        time = new TimePicker(this);
        tv = (TextView)findViewById(R.id.tvdate);
        //Date alert dialog
        adbd = new AlertDialog.Builder(this);
        adbd.setView(d);
        d.setCalendarViewShown(false);
        adbd.setNeutralButton("Proceed",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                day = d.getDayOfMonth();
                month = d.getMonth() + 1;
                year = d.getYear();
                tv.setText(d.getDayOfMonth() + "/" + (d.getMonth() + 1) + "/" + d.getYear());
            }
        });
        add = adbd.create();
        //Time alert dialog
        adbt = new AlertDialog.Builder(this);
        adbt.setView(time);
        adbt.setPositiveButton("Proceed",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
            }
        });
        adt = adbt.create();
    }

    public void setDate(View view) {
        add.show();
    }

    public void setTime(View view) { adt.show();}
}
