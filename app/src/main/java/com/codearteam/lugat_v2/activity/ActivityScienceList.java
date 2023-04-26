package com.codearteam.lugat_v2.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import com.codearteam.lugat_v2.R;
import com.codearteam.lugat_v2.adapter.AdapterWordsList;
import com.codearteam.lugat_v2.livemodel.ViewModelWordList;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityScienceList extends AppCompatActivity {

    private ViewModelWordList viewModelWordList;
    private AdapterWordsList adapterWordsList;
    private SharedPreferences sharedPreferences;

    private static String table_name;
    private int lesson_id;

    private SearchView searchView;
    private EditText searchViewText;
    private FloatingActionButton fab;
    AppBarLayout appBarLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science_list);

        Intent intent = getIntent();
        table_name = intent.getExtras().getString("tableName");
        lesson_id = intent.getExtras().getInt("lesson_id");

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        viewModelWordList = ViewModelProviders.of(this).get(ViewModelWordList.class);
        adapterWordsList = new AdapterWordsList(ActivityScienceList.this);

        RecyclerView recipeRecyclerView = findViewById(R.id.rv_word_list);
        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(ActivityScienceList.this));
        recipeRecyclerView.setAdapter(adapterWordsList);

        viewModelWordList.getDataList(lesson_id).observe(this, tableModels -> {
            if (tableModels != null) {
                adapterWordsList.submitList(tableModels);
            }
        });


        TextView title_fan = findViewById(R.id.title_fan);
        title_fan.setText(table_name.toUpperCase());


        appBarLayout = findViewById(R.id.appbar1);

        fab = findViewById(R.id.floatingActionButton);

        searchView = findViewById(R.id.search_view);
        int searchViewTextId = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        searchViewText = searchView.findViewById(searchViewTextId);
        searchViewText.setTextColor(Color.GRAY);
        searchViewText.setHintTextColor(Color.GRAY);
        searchViewText.setTextSize(16);
        searchView.onActionViewExpanded();
        searchView.clearFocus();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                viewModelWordList.setFilter(newText);
                return false;
            }
        });


        ImageView bac_btn = findViewById(R.id.back_btn_1);
        bac_btn.setOnClickListener(v -> onBackPressed());

        fab.setOnClickListener(v -> {
            appBarLayout.setExpanded(true);
            searchView.setFocusable(true);
            keyboard(true);

        });

    }

    private void keyboard(boolean b) {
        InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (b)
            im.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_IMPLICIT_ONLY);
        else
            im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}