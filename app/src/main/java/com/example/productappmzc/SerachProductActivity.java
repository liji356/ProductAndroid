package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SerachProductActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;

    String getCode,getName,getPrice;

    DatabaseHelper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_product);

        helper=new DatabaseHelper(this);
        helper.getWritableDatabase();

        ed1=(EditText) findViewById(R.id.procode);
        ed2=(EditText) findViewById(R.id.prna);
        ed3=(EditText) findViewById(R.id.pr);
        b1=(AppCompatButton) findViewById(R.id.submit);
        b2=(AppCompatButton) findViewById(R.id.ba);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getCode=ed1.getText().toString();
                getName=ed2.getText().toString();
                getPrice=ed2.getText().toString();

                Cursor c= helper.searchData(getCode);

                if(c.getCount()==0)
                {
                    ed2.setText("");
                    ed3.setText("");
                    Toast.makeText(getApplicationContext(), "Invalid Code", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    while (c.moveToNext())
                    {
                        getName=c.getString(2);
                        getPrice=c.getString(3);
                    }
                    ed2.setText(getName);
                    ed3.setText(getPrice);
                }
            }
        });




        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i);
            }
        });


    }
}