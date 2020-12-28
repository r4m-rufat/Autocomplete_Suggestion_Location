package com.example.autocomplete_suggestion_location;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AutoCompleteTextView;

import com.example.autocomplete_suggestion_location.adapter.PlaceAutoSuggestionAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoComplete);

        autoCompleteTextView.setAdapter(new PlaceAutoSuggestionAdapter(getBaseContext(), android.R.layout.simple_list_item_1));


    }
}