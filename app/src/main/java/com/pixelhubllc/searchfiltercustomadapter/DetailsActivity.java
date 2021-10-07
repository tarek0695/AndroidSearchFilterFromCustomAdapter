package com.pixelhubllc.searchfiltercustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView titletv = findViewById(R.id.title);
        TextView cattv = findViewById(R.id.category);

        String titleString = getIntent().getStringExtra("title").toString();
        String descriptionString = getIntent().getStringExtra("cat").toString();

        titletv.setText(titleString);
        cattv.setText(descriptionString);


    }
}