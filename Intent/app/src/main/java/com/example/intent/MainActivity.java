package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private EditText eti;
private EditText eti1;
private TextView VI1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eti=(EditText) findViewById(R.id.editTextTextPersonName)  ;
        eti1=(EditText)findViewById(R.id.editTextTextPersonName2);
        VI1=(TextView)findViewById(R.id.textView5);
    }
    public void siguiente (View v){
        Intent siguiente = new Intent(this,MainActivity2.class);
        siguiente.putExtra("dato",eti.getText().toString());
        siguiente.putExtra("dato1",eti1.getText().toString());
        startActivityForResult(siguiente,25);
    }
    public void onActivityResult(int requestCode, int resultCode,Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 25) {
            if (resultCode == RESULT_OK) {
                String res = data.getExtras().getString("resultado");
                VI1.setText(VI1.getText().toString() + " " + res);
            }
        }
    }
}