package com.pixelhubllc.searchfiltercustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    String conversation_cat= "category";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView;
        EditText editText = findViewById(R.id.edit_query);

        String[] title = getResources().getStringArray(R.array.categories);

        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(title));
        listView = findViewById(R.id.list_item);

        ListAdapter listAdapter = new ListAdapter(this, arrayList, conversation_cat);

        listView.setAdapter(listAdapter);

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

    }
}