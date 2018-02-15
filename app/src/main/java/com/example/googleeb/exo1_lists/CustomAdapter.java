package com.example.googleeb.exo1_lists;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enkre on 2/14/2018.
 */

public class CustomAdapter extends BaseAdapter {

    private List<Contact> listData;
    private LayoutInflater layoutInflater;
    private Context context;
    private int layout;
    private ArrayList<Integer> listItemIsChecked;

    public CustomAdapter(Context aContext,  List<Contact> listData, int layout, ArrayList<Integer> listItemIsChecked) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
        this.layout = layout;
        this.listItemIsChecked = listItemIsChecked;
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {

        TextView name,age;
        ImageView image;
        ImageButton btnEdit;
        CheckBox checkItem;

        final int x = position;

        v = layoutInflater.inflate(layout, null);

        btnEdit = v.findViewById(R.id.btn_edit_item);
        checkItem = v.findViewById(R.id.checkbox_text_view_list);
        image = v.findViewById(R.id.image_contact);
        name = v.findViewById(R.id.name_contact);
        age = v.findViewById(R.id.age_contact);

        Contact prr = this.listData.get(position);
        name.setText(prr.getName());
        age.setText(prr.getAge());
        image.setImageResource(R.drawable.ic_united_states);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentContact = new Intent(context,EditeContact.class);
                intentContact.putExtra("contact",listData.get(x));
                context.startActivity(intentContact);
            }
        });

        checkItem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("check ","checkbox");
                if(isChecked){
                    listItemIsChecked.add(new Integer(x));
                }else{
                    listItemIsChecked.remove(new Integer(x));
                }
                for(int i=0; i<listItemIsChecked.size(); i++){
                    Log.d("item"+i, ""+listItemIsChecked);
                }
            }
        });

        return v;
    }
}
