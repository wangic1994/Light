package com.wangic.light;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import Entry.LightModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button add_light;
    private Button entertainment;
    private ListView listView;

    private ArrayList<LightModel> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences(Constance.SP, MODE_APPEND);
        boolean aBoolean = sharedPreferences.getBoolean(Constance.SP_LOGIN_STATUS, false);
        if (!aBoolean) {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            this.finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_light = (Button) findViewById(R.id.add_light);
        entertainment = (Button) findViewById(R.id.entertainment);
        listView = (ListView) findViewById(R.id.list);
        add_light.setOnClickListener(this);
        entertainment.setOnClickListener(this);
        for (int i = 0; i < 10; i++) {
            arrayList.add(new LightModel());
        }
        LightListAdapter lightListAdapter = new LightListAdapter(this,arrayList);
        listView.setAdapter(lightListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_light:

                break;
            case R.id.entertainment:

                break;
            default:
                break;

        }
    }
}
