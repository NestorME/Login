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
    String nom,pass;
    TextView name,contra;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        nom=getIntent().getStringExtra("usuario");
        pass=getIntent().getStringExtra("contra");
        name=(TextView)findViewById(R.id.textView);
        contra=(TextView) findViewById(R.id.textView2);
        button=(Button) findViewById(R.id.button2);
        name.setText(nom);
        contra.setText(pass);
        button.setOnClickListener(cerrar);
    }
    View.OnClickListener cerrar= new View.OnClickListener() {
        @Override
        public void onClick(View view) {

                Intent i = new Intent(Activity2.this,MainActivity.class);
                startActivity(i);
                finish();


        }
    };
}
