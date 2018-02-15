package com.example.googleeb.exo1_lists;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

public class EditeContact extends AppCompatActivity {

    EditText name, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edite_contact);

        name = findViewById(R.id.edit_name);
        age = findViewById(R.id.edit_age);

        Contact c = (Contact) getIntent().getParcelableExtra("contact");
        if(c != null){
            name.setText(c.getName());
            age.setText(c.getAge());
        }else{
            Toast.makeText(this, "name ERRROR", Toast.LENGTH_SHORT).show();
        }



    }
}
