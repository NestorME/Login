package com.example.nestorespana.login;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginFrg.OnFragmentInteractionListener,RegistroFrg.OnFragmentInteractionListener {

    Button btnfr1,btnfr2;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnfr1 =(Button) findViewById(R.id.logFra);
        btnfr2 = (Button) findViewById(R.id.regFra);
        db=openOrCreateDatabase("LoginDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,password VARCHAR);");


                btnfr2.setOnClickListener(this);
        btnfr1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.logFra:
                LoginFrg fragmento1 = new LoginFrg();
                FragmentTransaction transaction=  getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.contenedor,fragmento1);
                transaction.commit();
                break;

            case R.id.regFra:
                RegistroFrg fragmento3 = new RegistroFrg();
                FragmentTransaction transaction1=  getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.contenedor,fragmento3);
                transaction1.commit();

                break;

        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
