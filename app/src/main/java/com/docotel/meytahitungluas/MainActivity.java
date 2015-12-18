package com.docotel.meytahitungluas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView title, var1, var2, result;
    EditText numb1, numb2;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onViewCreated();

        loadHitungPersegi();
    }

    void onViewCreated() {
        title = (TextView) findViewById(R.id.title_bar);
        var1 = (TextView) findViewById(R.id.var_1);
        var2 = (TextView) findViewById(R.id.var_2);
        numb1 = (EditText) findViewById(R.id.numb_1);
        numb2 = (EditText) findViewById(R.id.numb_2);
        result = (TextView) findViewById(R.id.result);

        submit = (Button) findViewById(R.id.btn_submit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_persegi) {
            loadHitungPersegi();
        } else if (id == R.id.action_segitiga) {
            loadHitungSegitiga();
        }

        checked(item);

        return super.onOptionsItemSelected(item);
    }

    private void checked(MenuItem item) {
        if(item.isChecked())
            item.setChecked(false);
        else
            item.setChecked(true);
    }

    private void loadHitungPersegi() {
        title.setText("Hitung Luas Persegi/Persegi Panjang");
        var1.setText("Panjang");
        var2.setText("Lebar");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(numb1) || isEmpty(numb2)) {
                    Toast.makeText(MainActivity.this, "Field is required", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Double.parseDouble(numb1.getText().toString());
                    double num2 = Double.parseDouble(numb2.getText().toString());
                    double res = num1 * num2;
                    result.setText(String.valueOf(res));
                }
            }
        });
    }

    private void loadHitungSegitiga() {
        title.setText("Hitung Luas Segitiga");
        var1.setText("Alas");
        var2.setText("Tinggi");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmpty(numb1) || isEmpty(numb2)) {
                    Toast.makeText(MainActivity.this, "Field is required", Toast.LENGTH_SHORT).show();
                } else {
                    double num1 = Double.parseDouble(numb1.getText().toString());
                    double num2 = Double.parseDouble(numb2.getText().toString());
                    double res = 0.5 * num1 * num2;
                    result.setText(String.valueOf(res));
                }
            }
        });
    }

    private boolean isEmpty(EditText editText) {
        return editText.getText().toString().equals("");
    }
}
