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

public class DrinksActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView drinksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Beginn mein Code
        drinksList = (ListView) findViewById(R.id.drinksListView);
        drinksList.setBackgroundColor(Color.BLACK);
        ListAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.entriesDrinks, android.R.layout.simple_list_item_1);
        drinksList.setAdapter(adapter);
        drinksList.setOnItemClickListener(this);
    }


    public void onItemClick(AdapterView<?> lV, View view, int pos, long id) {
        switch (pos) {
            case 0:
                // Mineralwasser
                Toast.makeText(this, "Mineralwasser hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 1:
                // Apfelsaft
                Toast.makeText(this, "Apfelsaft hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 2:
                // Coca-Cola
                Toast.makeText(this, "Coca-Cola hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 3:
                // Fanta
                Toast.makeText(this, "Fanta hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 4:
                // Radler
                Toast.makeText(this, "Radler hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 5:
                // Selbstgebrautes Bier
                Toast.makeText(this, "Selbstgebrautes Bier hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 6:
                // Most
                Toast.makeText(this, "Most hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
