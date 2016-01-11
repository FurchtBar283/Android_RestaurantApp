package de.michael.therestaurantapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CarteActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView carteList;

    // Via Intent übergebene Strings
    /*
    String givenFirstname = "";
    String givenLastname = "";
    String givenTablenumber = "";
    String givenPaymentMethod = "";
    */
    String[] loginData = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Beginn mein Code
        // Abholen der Strings, die vom Intent übergeben wurden
        Intent fromLogin = getIntent();
        /*
        givenFirstname = fromLogin.getStringExtra("firstname");
        givenLastname = fromLogin.getStringExtra("lastname");
        givenTablenumber = fromLogin.getStringExtra("tablenumber");
        givenPaymentMethod = fromLogin.getStringExtra("paymentMethod");
        */
        loginData[0] = fromLogin.getStringExtra("firstname");
        loginData[1] = fromLogin.getStringExtra("lastname");
        loginData[2] = fromLogin.getStringExtra("tablenumber");
        loginData[3] = fromLogin.getStringExtra("paymentMethod");


        // Textfeld mit dem übergebenen Namen befüllen
        TextView customerName = (TextView) findViewById(R.id.yournameTextView);
        //customerName.setText(givenFirstname + " " + givenLastname);
        customerName.setText(loginData[0] + " " + loginData[1]);

        // ViewAdapter mit ListView verbinden
        carteList = (ListView) findViewById(R.id.carteListView);
        carteList.setBackgroundColor(Color.BLACK);
        ListAdapter adapter = ArrayAdapter.createFromResource (getApplicationContext(), R.array.entriesCarte, android.R.layout.simple_list_item_1);
        carteList.setAdapter(adapter);
        carteList.setOnItemClickListener(this);
    }

    public void onItemClick(AdapterView<?> lV, View view, int pos, long id) {
        switch (pos) {
            case 0:
                // Getränke
                Intent switchToDrinks = new Intent(this, DrinksActivity.class);
                startActivity(switchToDrinks);
                break;
            case 1:
                // Vorspeise
                Intent switchToAppetizer = new Intent(this, AppetizerActivity.class);
                startActivity(switchToAppetizer);
                break;
            case 2:
                // Hauptgang
                Intent switchToMainCourse = new Intent(this, MainCourseActivity.class);
                startActivity(switchToMainCourse);
                break;
            case 3:
                // Dessert
                Intent switchToDessert = new Intent(this, DessertActivity.class);
                startActivity(switchToDessert);
                break;
            default:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // Intent zur aktuellen Bestellung
            Intent switchToCurrentOrder = new Intent(this, CurrentOrderActivity.class);
            startActivity(switchToCurrentOrder);
            return true;
        }

        if (id == R.id.call_waiter) {
            Toast.makeText(this, "Der Kellner ist sofort bei Ihnen.", Toast.LENGTH_LONG).show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
