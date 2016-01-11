package de.michael.therestaurantapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AppetizerActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView appetizerList;
    // Zählvariablen für gewählte Vorspeisen
    int vesperTeller = 0;
    int kleinerSalat = 0;
    int großerSalat = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appetizer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Beginn mein Code
        appetizerList = (ListView) findViewById(R.id.appetizerListView);
        appetizerList.setBackgroundColor(Color.BLACK);
        ListAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.entriesAppetizer, android.R.layout.simple_list_item_1);
        appetizerList.setAdapter(adapter);
        appetizerList.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> lV, View view, int pos, long id) {
        switch (pos) {
            case 0:
                // Vesper-Teller
                Toast.makeText(this, "Vesper-Teller hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 1:
                // Kleiner Salat
                Toast.makeText(this, "Kleiner Salat hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 2:
                // Großer Salat
                Toast.makeText(this, "Großer Salat hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }

}
