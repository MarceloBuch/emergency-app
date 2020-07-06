package com.example.controleemer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Bundle extras = getIntent().getExtras();
        String name = null;
        String rg = null;
        String state = null;
        TextView result = findViewById(R.id.txtResult);
        if(extras != null){
            name = extras.getString(MainActivity.EXTRA_MESSAGE_NAME);
            rg = extras.getString(MainActivity.EXTRA_MESSAGE_RG);
            state = extras.getString(MainActivity.EXTRA_MESSAGE_STATE);
            String textRes = String.format("Suas informações são essas:\n Nome: %s\n Rg: %s\n Estado de emergência: %s\n"+name,rg,state);
            result.setText(textRes);
        }
    }
}
