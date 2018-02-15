package com.example.googleeb.exo1_lists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class list2 extends AppCompatActivity {

    private List<Contact> listData;
    ArrayList<HashMap<String, String>> listName;
    CustomAdapter adapter;
    ArrayList<Integer> listItemSelected;

    RelativeLayout footerList2;
    ListView list2;
    ImageButton next2, prec2;
    ImageButton btnAddContactList2, btnDeleteItemList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);

        listData = new ArrayList<>();
        listItemSelected = new ArrayList<>();

        final String[][] list = {
                {"name1", "10years"},
                {"name2", "20years"},
                {"name3", "30years"},
                {"name4", "40years"},
                {"name5", "50years"},
                {"name6", "60years"},
                {"name7", "70years"}
        };

        footerList2 = findViewById(R.id.footer_list2);
        btnAddContactList2 = footerList2.findViewById(R.id.btn_add_new_item);
        btnDeleteItemList2 = footerList2.findViewById(R.id.btn_dlt_item);
        list2 = findViewById(R.id.list2);
        next2 = findViewById(R.id.next2);
        prec2 = findViewById(R.id.prec2);

        listName = new ArrayList<>();
        HashMap hash;
        for (int i = 0; i < list.length; i++) {
            Contact c = new Contact(list[i][0], list[i][1]);
            listData.add(c);
        }

        /*
        for (int i = 0; i < list.length; i++) {
            hash = new HashMap();
            hash.put("name", list[i][0]);
            hash.put("age", list[i][1]);
            hash.put("image", R.drawable.ic_united_states);
            listName.add(hash);
        }

        list2.setAdapter(new SimpleAdapter(this,
                listName,
                R.layout.list_custm,
                new String[]{"name", "age", "image"},
                new int[]{R.id.name_contact, R.id.age_contact, R.id.image_contact}
        ));*/

        adapter = new CustomAdapter(this, listData, R.layout.list_custm, listItemSelected);
        list2.setAdapter(adapter);

        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                CheckBox checkItem = view.findViewById(R.id.checkbox_text_view_list);
                ImageButton btnEditItem = view.findViewById(R.id.btn_edit_item);
                if (checkItem.isChecked()) {
                    checkItem.setChecked(false);
                } else {
                    checkItem.setChecked(true);
                }
                btnEditItem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "position click is " + position, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        prec2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list2.this, MainActivity.class));
            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(list2.this, list3.class));
            }
        });


        btnDeleteItemList2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listItemSelected.size() > 0){
                    for(int i=0; i<listItemSelected.size(); i++){
                        listData.remove(listItemSelected.get(i)-i);
                    }
                    listItemSelected.clear();
                    adapter.notifyDataSetChanged();

                }
            }
        });


    }
}
