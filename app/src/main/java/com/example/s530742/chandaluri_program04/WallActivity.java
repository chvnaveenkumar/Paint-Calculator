package com.example.s530742.chandaluri_program04;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.sql.Types.NULL;

public class WallActivity extends AppCompatActivity {

    EditText editWidth,editHeight,editLength,editCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall);
         editWidth = (EditText)findViewById(R.id.editWidth);
        editHeight = (EditText) findViewById(R.id.editHeight);
        editLength = (EditText) findViewById(R.id.editLength);
        editCount = (EditText) findViewById(R.id.editCount);

    }
    public void done(View v)
    {
        if(!editWidth.getText().toString().isEmpty() && !editLength.getText().toString().isEmpty() && !editHeight.toString().isEmpty() && !editCount.toString().isEmpty() &&
                Double.parseDouble(editWidth.getText().toString()) != 0 && Double.parseDouble(editHeight.getText().toString()) !=0 && Double.parseDouble(editLength.getText().toString()) !=0 &&  Double.parseDouble(editCount.getText().toString()) !=0 )
        {
            Double width = Double.parseDouble(editWidth.getText().toString());
            Double height = Double.parseDouble(editHeight.getText().toString());
            Double length = Double.parseDouble(editLength.getText().toString());
            Double count = Double.parseDouble(editCount.getText().toString());

            Intent main = new Intent();
            main.putExtra("Width",width);
            main.putExtra("Heigth",height);
            main.putExtra("Length",length);
            main.putExtra("Count",count);
            setResult(101,main);
            finish();
        }else
        {
            AlertDialog alertDialog = new AlertDialog.Builder(WallActivity.this).create();
            alertDialog.setTitle("Error Alert!!");
            alertDialog.setMessage("Above fields should not be empty or zero!!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

}
