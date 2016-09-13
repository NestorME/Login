package com.example.nestorespana.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     Button button;
     EditText user,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        user=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        button.setOnClickListener(iniciar);
    }

    View.OnClickListener iniciar= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            final String name=user.getText().toString();
            final String code=pass.getText().toString();


            if(name.equals("") || code.equals("")) {
                Toast.makeText(MainActivity.this, "ingrese un usuario y una contraseña",Toast.LENGTH_SHORT).show();
            }else{
                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra("usuario",name);
                i.putExtra("contra",code);
                startActivity(i);
                finish();

            }
        }
    };

}
