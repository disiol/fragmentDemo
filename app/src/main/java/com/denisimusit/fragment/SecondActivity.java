package com.denisimusit.fragment;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Получим индекс из намерения активности
        Intent intent = getIntent();
        int buttonIndex = intent.getIntExtra("buttonIndex", -1);
        if (buttonIndex != -1) {
            FragmentManager fragmentManager = getFragmentManager();
            Fragment2 fragment2 = (Fragment2) fragmentManager.findFragmentById(R.id.fragment2);
            fragment2.setDescription(buttonIndex);
        }
    }
}
