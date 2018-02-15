package com.example.googleeb.exo1_lists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] list = {
                "name1",
                "name2",
                "name3",
                "name4",
                "name5",
                "name6",
                "name7",
                "name8",
                "name9",
                "name10"
        };

        ListView list1 = findViewById(R.id.list1);
        ImageButton next1 = findViewById(R.id.next1);

        list1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, list2.class));
            }
        });

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
