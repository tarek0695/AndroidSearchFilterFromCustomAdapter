package com.pixelhubllc.searchfiltercustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class ListActivity extends AppCompatActivity {

    String conversation_cat= "category";

    SharedPref sharedPref;
    public static int lastPosition;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        sharedPref = new SharedPref(this);
        lastPosition = sharedPref.loadListViewPos();


        EditText editText = findViewById(R.id.edit_query);

        String[] title = getResources().getStringArray(R.array.categories);

        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(title));
        listView = findViewById(R.id.list_item);



        ListAdapter listAdapter = new ListAdapter(this, arrayList, conversation_cat);



        listView.setAdapter(listAdapter);

        listView.setSelection(lastPosition);

        /**when we searching , new arraylist create with new id, that's why listview selected position
        color don't work properly. You need search in databse for this bug fix */

        listAdapter.setSelectedIndex(lastPosition);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.e("itemclick", "onItemClick: " + position );
                sharedPref.setListViewPos(position);
                Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
                intent.putExtra("title", title[position]);
                intent.putExtra("cat", conversation_cat);
                startActivity(intent);

            }
        });





    }
}