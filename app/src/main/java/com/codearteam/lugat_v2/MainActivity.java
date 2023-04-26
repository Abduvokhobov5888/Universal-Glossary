package com.codearteam.lugat_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.codearteam.lugat_v2.activity.ActivityAbout;
import com.codearteam.lugat_v2.adapter.AdapterSciences;
import com.google.android.material.appbar.AppBarLayout;

public class MainActivity extends AppCompatActivity {

    private static final String[] mNames = {
            "Adabiyot", "AKT", "Fizika", "Geografiya", "Iqtisodiyot", "Matematika", "Psixologiya", "Tarix"
    };

    private static  final int[] mImageUrls = {
            R.drawable.mn_adabiyot, R.drawable.mn_akt, R.drawable.mn_fizika, R.drawable.mn_geografiya,
            R.drawable.mn_iqtisod, R.drawable.mn_matematika, R.drawable.mn_psixologiya, R.drawable.mn_tarix
    };


    private ImageView main_down_up_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();

        ImageView about_button = findViewById(R.id.about_button);
        main_down_up_btn = findViewById(R.id.main_down_up_button);

        about_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_button_intent = new Intent(getApplicationContext(), ActivityAbout.class);
                startActivity(about_button_intent);
            }
        });
    }

    private void initData(){
        RecyclerView recyclerView = findViewById(R.id.rv_sciences);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        AdapterSciences adapter = new AdapterSciences(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }
}