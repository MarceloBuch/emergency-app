package com.example.controleemer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public final static String EXTRA_MESSAGE_NAME = "com.example.controleemer.NAME";
    public final static String EXTRA_MESSAGE_RG = "com.example.controleemer.RG";
    public final static String EXTRA_MESSAGE_STATE = "com.example.conrtoleemer.STATE";
    String spinnerSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.spinner_states, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        spinnerSelected = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Cadas(View view){
        EditText txtName = findViewById(R.id.txtName);
        String name = txtName.getText().toString();
        EditText txtRg = findViewById(R.id.txtRg);
        String rg = txtRg.getText().toString();
        String state = spinnerSelected;

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra(EXTRA_MESSAGE_NAME, name);
        intent.putExtra(EXTRA_MESSAGE_RG, rg);
        intent.putExtra(EXTRA_MESSAGE_STATE, state);
        startActivity(intent);
    }

}
