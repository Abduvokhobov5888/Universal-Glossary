package com.codearteam.lugat_v2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codearteam.lugat_v2.R;

public class ActivityAboudWord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboud_word);



        Intent intent = getIntent();

        TextView title = findViewById(R.id.info_title);
        TextView allText = findViewById(R.id.info_text);
        final ImageView back_button = findViewById(R.id.info_activity_back_btn);

        title.setText(intent.getExtras().getString("atama"));
        allText.setText(intent.getExtras().getString("izoh"));

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}