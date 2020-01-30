package com.example.hisaab;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button date;
    private ImageButton done;
    private DatePickerDialog datePickerDialog;
    private EditText amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        date = findViewById(R.id.date);
        date.setOnClickListener(this);
        amount = findViewById(R.id.amount);
        done = findViewById(R.id.done);
        done.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.done){
            String a = amount.getText().toString();
            Intent intent = new Intent(this,front.class);
            intent.putExtra("value1",a);
            startActivity(intent);
            Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
            finish();
        }
        if(v.getId()==R.id.date) {
            DatePicker datePicker = new DatePicker(this);
            int currentday = datePicker.getDayOfMonth();
            int currentmonth = datePicker.getMonth();
            int currentyear = datePicker.getYear();

            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                }
            }, currentyear, currentmonth, currentday);
            datePickerDialog.show();
        }
    }
}
