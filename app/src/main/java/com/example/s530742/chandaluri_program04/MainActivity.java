package com.example.s530742.chandaluri_program04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Double width=0.0;
    private Double height=0.0;
    private Double length=0.0;
    private Double count=0.0;
    private Double costPerGallon=0.0;
    private Double A=0.0;
    private Double isCost=0.0;
    private Double total=0.0;

    TextView c,layer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        c = findViewById(R.id.totalPrice);

    }

   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101)
        {
            width = data.getDoubleExtra("Width",0.0);
            height = data.getDoubleExtra("Heigth",0.0);
            length = data.getDoubleExtra("Length",0.0);
            count = data.getDoubleExtra("Count",0.0);
        }
        if (requestCode == 102)
        {
            costPerGallon = data.getDoubleExtra("Value",0);

        }

       A = 2 * (length*width+length*height+width*height);
       isCost = A /(400) * costPerGallon;
       total = isCost*count;
       c.setText("Area:"+" "+A+"\n");
       c.append("Cost per Wall: "+ Math.round(isCost)+" $"+"\n");
       c.append("Total No of Walls:"+count+"\n");

       c.append("All Walls cost: "+Math.round(total)+"  $"+"\n");
       c.append("Total Cost Range(10%): "+Math.round(total*0.9)+" - "+Math.round(total*1.1));

   }

    public void wallButton(View v)
    {
        Intent wallActivity = new Intent(this,WallActivity.class);
        startActivityForResult(wallActivity, 101);

    }

    public void paintButton(View v)
    {
        Intent paintActivity = new Intent(this,PaintActivity.class);
        startActivityForResult(paintActivity,102);
    }
    public void reset(View v)
    {
        width=0.0;
        height=0.0;
        length=0.0;
        count=0.0;
        costPerGallon=0.0;
        A=0.0;
        isCost=0.0;
        total=0.0;

        c.setText("");
    }

}
