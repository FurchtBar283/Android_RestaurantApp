package de.michael.therestaurantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String firstname = "Vorname";
    String lastname = "Nachname";
    String tablenumber = "Tischnummer";
    String paymentMethod = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Beginn meines Codes

        referenceTextfields();
        referenceSpinnerAndButton();
    }

    // Intent um zur SpeiseKarte-Acitivity zu wechseln
    public void confirmButtonPressed(){
        String errMsg = "";

        if((firstname == "") || (firstname.equals("Vorname"))) {
            errMsg = "Vorname vergessen";
            Toast.makeText(LoginActivity.this, errMsg, Toast.LENGTH_LONG).show();
        } else if ((lastname == "") || (lastname.equals("Nachname"))) {
            errMsg = "Nachname vergessen";
            Toast.makeText(LoginActivity.this, errMsg, Toast.LENGTH_LONG).show();
        } else if ((tablenumber == "") || (tablenumber.equals("Tischnummer"))){
            errMsg = "Tischnummer vergessen";
            Toast.makeText(LoginActivity.this, errMsg, Toast.LENGTH_LONG).show();
        } else if (paymentMethod == "None") {
            errMsg = "Bitte Zahlungsart wählen";
            Toast.makeText(LoginActivity.this, errMsg, Toast.LENGTH_LONG).show();
        } else {
            Intent switchToCategories = new Intent(this, CarteActivity.class);
            switchToCategories.putExtra("firstname", firstname);
            switchToCategories.putExtra("lastname", lastname);
            switchToCategories.putExtra("tablenumber", tablenumber);
            switchToCategories.putExtra("paymentMethod", paymentMethod);
            startActivity(switchToCategories);
        }
    }

    // Implementierte Funktion des Interfaces
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        //Toast.makeText(LoginActivity.this, "Pos Nr: " + pos + " " + parent.getItemAtPosition(pos), Toast.LENGTH_SHORT).show();

        if (pos != 0){
            paymentMethod = (String) parent.getItemAtPosition(pos);
        } else {
            paymentMethod = "None";
        }

        System.out.println("Zahlungsart: " + paymentMethod);
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

    // Referenzen auf Textfelder erzeugen und Listener hinzufügen
    public void referenceTextfields(){
        // Referenz auf Textfelder erstellen und Listener hinzufügen
        final EditText firstnameTextfield = (EditText) findViewById(R.id.firstName);
        firstnameTextfield.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND){
                    firstname = firstnameTextfield.getText().toString();
                    System.out.println("Vorname: " + firstname);
                }
                return false;
            }
        });
        final EditText lastnameTextfield = (EditText) findViewById(R.id.lastName);
        lastnameTextfield.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND){
                    lastname = lastnameTextfield.getText().toString();
                    System.out.println("Nachname: " + lastname);
                }
                return false;
            }
        });
        final EditText tablenumberTextfield = (EditText) findViewById(R.id.tableNumber);
        tablenumberTextfield.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEND){
                    tablenumber = tablenumberTextfield.getText().toString();
                    System.out.println("Tischnummer: " + tablenumber);
                }
                return false;
            }
        });
    }

    public void referenceSpinnerAndButton(){
        // Referenz auf Spinner erstellen
        Spinner paymentStyle = (Spinner) findViewById(R.id.paymentWay);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.paymentMethods, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentStyle.setAdapter(adapter);
        paymentStyle.setOnItemSelectedListener(this);

        // Referenz auf Bestätigen-Button erstellen
        Button confirm = (Button) findViewById(R.id.confirmButton);
        // Dem Button einen Listener hinzufügen
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmButtonPressed();
            }
        });
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
            Toast.makeText(this, "Bitte melden Sie sich zuerst an", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.call_waiter) {
            Toast.makeText(this, "Bitte melden Sie sich zuerst an", Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
