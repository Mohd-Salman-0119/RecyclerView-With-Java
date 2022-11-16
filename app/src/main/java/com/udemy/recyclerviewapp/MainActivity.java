package com.udemy.recyclerviewapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemSelected {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button btnAdd;
    ArrayList<Person> people;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.list);
        recyclerView.setHasFixedSize(true);

        //layoutManager = new LinearLayoutManager(this);
        //layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager = new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                people.add(new Person("Waseem","Ansari","bus"));
                myAdapter.notifyDataSetChanged();
            }
        });

        people = new ArrayList<>();
        people.add(new Person("Salman","Qadri","bus"));
        people.add(new Person("Arman","Raza","plane"));
        people.add(new Person("Arsalan","Qadri","bus"));
        people.add(new Person("Muskan","Hasan","plane"));
        people.add(new Person("Hassan","Raza","bus"));
        people.add(new Person("Hasim","Ansari","plane"));
        people.add(new Person("Salman","Qadri","bus"));
        people.add(new Person("Arman","Raza","plane"));
        people.add(new Person("Arsalan","Qadri","bus"));
        people.add(new Person("Muskan","Hasan","plane"));
        people.add(new Person("Hassan","Raza","bus"));
        people.add(new Person("Hasim","Ansari","plane"));
        people.add(new Person("Salman","Qadri","bus"));
        people.add(new Person("Arman","Raza","plane"));
        people.add(new Person("Arsalan","Qadri","bus"));
        people.add(new Person("Muskan","Hasan","plane"));
        people.add(new Person("Hassan","Raza","bus"));
        people.add(new Person("Hasim","Ansari","plane"));

        myAdapter = new PersonAdapter(this,people);

        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onItemSelected(int index) {
        Toast.makeText(this,"Surname: " + people.get(index).getSurname(), Toast.LENGTH_SHORT).show();
    }
}