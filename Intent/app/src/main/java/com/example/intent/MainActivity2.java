package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
private TextView v1;
    private TextView v2;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        v1=(TextView) findViewById(R.id.textView3);
        v2=(TextView) findViewById((R.id.textView4));
        ok=(Button)findViewById(R.id.button2);

        //Bundle extras =getIntent().getExtras();
       // String dato=extras.getString("dato");
        //String dato1=extras.getString("dato1");
        String dato=getIntent().getStringExtra("dato");
        String dato1=getIntent().getStringExtra("dato1");
        Toast toast1 = Toast.makeText(getApplicationContext(),
                " "+dato, Toast.LENGTH_SHORT);
        toast1.show();


        v1.setText("Nombre: "+dato);
        v2.setText("Edad: "+dato1);
       ok.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent= new Intent();
               intent.putExtra("resultado","datos correctos");
               setResult(RESULT_OK,intent);
               finish();
           }
       });
    }
   /* public void anterior (View v){
        Intent anterior = new Intent(this,MainActivity.class);

        startActivity(anterior);
    }*/

}