package com.example.googleeb.exo1_lists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckedTextView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class list3 extends AppCompatActivity {

    List<Contact> listData;
    ArrayList<Integer> listItemSelected;
    int index = 0;
    RelativeLayout footerList3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list3);

        listData = new ArrayList<>();
        listItemSelected = new ArrayList<>();

        String[][] list = {
                {"name1", "10years"},
                {"name2", "20years"},
                {"name3", "30years"},
                {"name4", "40years"},
                {"name5", "50years"},
                {"name6", "60years"},
                {"name7", "70years"}
        };


        footerList3 = findViewById(R.id.footer_list3);
        ListView list3 = findViewById(R.id.list3);
        final ImageButton prec2 = findViewById(R.id.prec3);

        for (int i = 0; i < list.length; i++) {
            Contact c = new Contact(list[i][0], list[i][1]);
            listData.add(c);
        }

        CustomAdapter2 adapter = new CustomAdapter2(this,listData, R.layout.list_custm2, listItemSelected);
        list3.setAdapter(adapter);

        /*final ArrayList<HashMap<String, String>> listName = new ArrayList<>();
        HashMap hash;
        for (int i = 0; i < list.length; i++) {
            hash = new HashMap();
            hash.put("name", list[i][0]);
            hash.put("age", list[i][1]);
            hash.put("image", R.drawable.ic_united_states);
            listName.add(hash);
        }

        list3.setAdapter(new SimpleAdapter(this,
                listName,
                R.layout.list_custm2,
                new String[]{"name", "age", "image"},
                new int[]{R.id.name_contact, R.id.age_contact, R.id.image_contact}
        ));*/

        index = listData.size() + 1;

        list3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RadioButton checkTest = view.findViewById(R.id.radio_text_view_list);
                if (index != position) {
                    if (index != listData.size() + 1) {
                        View v = parent.getChildAt(index);
                        RadioButton checkTest1 = v.findViewById(R.id.radio_text_view_list);
                        checkTest1.setChecked(false);
                    }
                    checkTest.setChecked(true);
                    index = position;
                }

            }
        });

        prec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list3.this, list2.class));
            }
        });

    }
}
