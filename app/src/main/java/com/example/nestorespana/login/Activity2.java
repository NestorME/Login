package com.example.nestorespana.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    TextView name,contra;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        name=(TextView)findViewById(R.id.textView);
        contra=(TextView) findViewById(R.id.textView2);
        button=(Button) findViewById(R.id.button2);
        name.setText(getIntent().getStringExtra("usuario"));
        contra.setText(getIntent().getStringExtra("contra"));
        button.setOnClickListener(Close);
    }
    View.OnClickListener Close = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

                Intent i = new Intent(Activity2.this,MainActivity.class);
                startActivity(i);
                finish();


        }
    };
}
