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

public class MainCourseActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView mainCourseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Beginn mein Code
        mainCourseList = (ListView) findViewById(R.id.mainCourseListView);
        mainCourseList.setBackgroundColor(Color.BLACK);
        ListAdapter adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.entriesMainCourse, android.R.layout.simple_list_item_1);
        mainCourseList.setAdapter(adapter);
        mainCourseList.setOnItemClickListener(this);
    }


    public void onItemClick(AdapterView<?> lV, View view, int pos, long id) {
        switch (pos) {
            case 0:
                // Fade Suppe
                Toast.makeText(this, "Fade Suppe hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 1:
                // Kässpätzle
                Toast.makeText(this, "Kässpätzle hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 2:
                // Maultaschen
                Toast.makeText(this, "Maultaschen hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 3:
                // Schupfnudeln
                Toast.makeText(this, "Schupfnudeln hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 4:
                // Knödel mit Gulasch
                Toast.makeText(this, "Knödel mit Gulasch hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            case 5:
                // Knödel mit Pilzsauce
                Toast.makeText(this, "Knödel mit Pilzsauce hinzugefügt.", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
