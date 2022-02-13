package com.example.recicleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
List<ListElement> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    public void init(){
        lista=new ArrayList<>();
        lista.add(new ListElement("#756748","Maria","Monterrey","Desconectado"));
        lista.add(new ListElement("#756757","Nestor","Oaxaca","Conectado"));
        lista.add(new ListElement("#756748","Rosa","Chiapas","Conectado"));
        lista.add(new ListElement("#726548","Luz","Veracruz","Desconectado"));
        lista.add(new ListElement("#753748","Roberta","Mexico","Conectado"));
        ListAdapter list=new ListAdapter(lista,this);
        RecyclerView rv=findViewById(R.id.listRecycleView);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(list);
    }
}