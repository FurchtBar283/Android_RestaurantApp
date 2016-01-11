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

public class DessertActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView dessertList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dessert);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Beginn mein Code
        dessertList = (ListView) findViewById(R.id.dessertListView);
        dessertList.setBackgroundColor(Color.BLACK);
        ListAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.entriesDessert, android.R.layout.simple_list_item_1);
        dessertList.setAdapter(adapter);
        dessertList.setOnItemClickListener(this);
    }


    public void onItemClick(AdapterView<?> lV, View view, int pos, long id) {
        switch (pos) {
            case 0:
                // Erdbeer-Eis
                Toast.makeText(this, "Erdbeer-Eis hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 1:
                // Schokoladen-Eis
                Toast.makeText(this, "Schokoladen-Eis hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 2:
                // Straciatella-Eis
                Toast.makeText(this, "Straciatella-Eis hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 3:
                // Gemischter Eisbecher
                Toast.makeText(this, "Gemischter Eisbecher hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 4:
                // Vanille-Pudding
                Toast.makeText(this, "Vanille-Pudding hinzugefügt.", Toast.LENGTH_LONG).show();
            default:
                break;
        }
    }
}
