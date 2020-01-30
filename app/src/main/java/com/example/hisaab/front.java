package com.example.hisaab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class front extends AppCompatActivity implements View.OnClickListener{

    private int i,e,b,ina,exa;
    private TextView income,expense,balance;
    private ImageButton add;
    private AlertDialog.Builder alert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);
        ina = loadIncome();
        exa = loadExpense();
        b = loadBalance();
        Bundle bundle = getIntent().getExtras();
        Bundle bundle1 = getIntent().getExtras();
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        income = findViewById(R.id.income);
        expense = findViewById(R.id.expense);
        balance = findViewById(R.id.balance);
        if(bundle!=null){
            String v1 = bundle.getString("value1");
            if(v1!=null) {
                i = Integer.valueOf(v1);
                b += i;
                ina += i;
            }
        }
        if(bundle1!=null){
            String v2 = bundle1.getString("value2");
            if(v2!=null) {
                i = Integer.valueOf(v2);
                b -= i;
                exa += i;
            }
        }
        income.setText("Income: "+ina);
        expense.setText("Expense: "+exa);
        balance.setText("Balance: "+b);
        saveBalance(b);
        saveExpense(exa);
        saveIncome(ina);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.add){
            alert = new AlertDialog.Builder(this);
            alert.setMessage("Choose an option:");
            alert.setPositiveButton("Expenses", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent =  new Intent(front.this,gridview.class);
                    startActivity(intent);
                }
            });
            alert.setNegativeButton("Income", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent =  new Intent(front.this,incomeGrid.class);
                    startActivity(intent);
                }
            });
            AlertDialog alertDialog = alert.create();
            alertDialog.show();
        }
    }

    private void saveIncome(int in){
        SharedPreferences sharedPreferences = getSharedPreferences("f", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("come",in);
        editor.apply();
    }
    private void saveExpense(int in){
        SharedPreferences sharedPreferences = getSharedPreferences("s", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("go",in);
        editor.apply();
    }
    private void saveBalance(int in){
        SharedPreferences sharedPreferences = getSharedPreferences("t", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("stay",in);
        editor.apply();
    }
    private int loadIncome(){
        SharedPreferences sharedPreferences = getSharedPreferences("f", Context.MODE_PRIVATE);
        int x = sharedPreferences.getInt("come",0);
        return x;
    }
    private int loadExpense(){
        SharedPreferences sharedPreferences = getSharedPreferences("s", Context.MODE_PRIVATE);
        int x = sharedPreferences.getInt("go",0);
        return x;
    }
    private int loadBalance(){
        SharedPreferences sharedPreferences = getSharedPreferences("t", Context.MODE_PRIVATE);
        int x = sharedPreferences.getInt("stay",0);
        return x;
    }
}
