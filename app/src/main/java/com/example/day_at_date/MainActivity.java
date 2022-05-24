package com.example.day_at_date;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editTextTextPersonName3;
    private EditText editTextTextPersonName2;
    private EditText editTextTextPersonName;
    private TextView textView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);
        editTextTextPersonName3 = findViewById(R.id.editTextTextPersonName3);
        editTextTextPersonName = findViewById(R.id.editTextTextPersonName);
        textView6 = findViewById(R.id.textView6);
    }

    public void calculate(View view) {
        String d = editTextTextPersonName.getText().toString();
        String mo = editTextTextPersonName2.getText().toString();
        String ye = editTextTextPersonName3.getText().toString();
        int date = Integer.parseInt(d);
        int month = Integer.parseInt(mo);
        int year = Integer.parseInt(ye);
        if (((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && date > 31) || (month == 2 && date > 28) || ((month == 4 || month == 6 || month == 9 || month == 11) && date > 30)) {
            textView6.setText("INVALID DATE");
            return;
        }
        if (month > 12) {
            textView6.setText("INVALID DATE");
            return;
        }
        int flag = 0;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            if (month == 2 && date > 29) {
                textView6.setText("INVALID DATE");
                return;
            }
            flag = 1;
        }
        int rem = year % 400;
        int t = 0;
        if (rem > 100 && rem <= 200) {
            t = 5;
            rem = rem - 100;
        } else if (rem > 200 && rem <= 300) {
            t = 3;
            rem = rem - 200;
        } else if (rem > 300) {
            t = 1;
            rem = rem - 300;
        }
        rem--;
        int le = rem / 4;
        int od = rem - le;
        int sp = (le * 2) + od;

        int fi;
        if (flag == 0) {
            int[] arr = {0, 3, 3, 6, 8, 11, 13, 16, 19, 21, 24, 26, 29};
            int su = arr[month - 1];

            date = date % 7;
            int l = (sp + date + su) % 7;
            fi = t + l;
            fi = fi % 7;
        } else {
            int[] arr = {0, 3, 4, 7, 9, 12, 14, 17, 20, 22, 25, 27, 30};
            int su = arr[month - 1];

            date = date % 7;
            int o = (sp + date + su) % 7;
            fi = t + o;
            fi = fi % 7;
        }
        if (fi == 0)
            textView6.setText("SUNDAY");
        else if (fi == 1)
            textView6.setText("MONDAY");
        else if (fi == 2)
            textView6.setText("TUESDAY");
        else if (fi == 3)
            textView6.setText("WEDNESDAY");
        else if (fi == 4)
            textView6.setText("THURSDAY");
        else if (fi == 5)
            textView6.setText("FRIDAY");
        else if (fi == 6)
            textView6.setText("SATURDAY");
    }
}