package com.example.s530742.chandaluri_program04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PaintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
    }
    public void premium(View v)
    {
        Intent main = new Intent(this,MainActivity.class);
        Double premium = 70.0;
        main.putExtra("Value",premium);
        setResult(102,main);
        finish();

        //  startActivityForResult(main,111);

    }
    public void standard(View v)
    {
        Intent main = new Intent(this,MainActivity.class);
        Double standard = 50.0;
        main.putExtra("Value",standard);
        setResult(102,main);
        finish();

//        startActivityForResult(main,111);
    }
    public void economy(View v)
    {
        Intent main = new Intent(this,MainActivity.class);
        Double economy = 30.0;
        main.putExtra("Value",economy);
        setResult(102,main);
        finish();

//        startActivityForResult(main,111);

    }
}
