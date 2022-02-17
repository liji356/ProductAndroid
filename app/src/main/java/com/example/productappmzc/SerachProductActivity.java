package com.example.productappmzc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SerachProductActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    AppCompatButton b1,b2;

    String getCode,getName,getPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serach_product);
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

                Toast.makeText(getApplicationContext(),getCode, Toast.LENGTH_SHORT).show();
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