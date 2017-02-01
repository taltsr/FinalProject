package example.finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;

public class MainActivity extends AppCompatActivity {
    SharedPreferences pref = null;
    Intent t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("example.finalproject", MODE_PRIVATE);

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (pref.getBoolean("firstrun", true)) {
            pref.edit().putBoolean("firstrun", false).commit();
            Intent t = new Intent(this, Welcome.class);
            startActivity(t);
        } else
            Toast.makeText(this, "Not first run", Toast.LENGTH_LONG).show();

    }

    public void warp(View view) {
        Intent t = new Intent(this, Welcome.class);
        startActivity(t);
    }

    public void res(View view) {
        pref.edit().putBoolean("firstrun", true).commit();
    }

    public void date(View view) {
        Intent t = new Intent(this, Date.class);
        startActivity(t);
    }

    public void movelist(View view) {
        Intent t = new Intent(this, Tests.class);
        startActivity(t);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                Intent t = new Intent(this, MainActivity.class);
                return true;
            case R.id.TestList:
                t = new Intent(this, Tests.class);
                startActivity(t);
                return true;
            case R.id.Schedule:
                Toast.makeText(this, "kys", Toast.LENGTH_LONG).show();
                return true;
            default:
                return true;
        }
    }
}
