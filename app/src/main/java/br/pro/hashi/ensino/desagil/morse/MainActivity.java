package br.pro.hashi.ensino.desagil.morse;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements UtilityActivity {
    private TextView titleText;
    private Button button;

    public static MainActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.setSingle(this);
        setContentView(R.layout.activity_main);

        titleText = (TextView) findViewById(R.id.titleText);
        button = (Button) findViewById(R.id.button);
        System.out.println("Teste");


    }

    public void seeTheTruth(View v){

        Utilities.confirm(this,"do you wanna see the truth?");

    }

    public void listenConfirm(boolean answer){

        if(answer){
            Intent intent= new Intent(this, ConfigActivity.class);

            startActivity(intent);

        }
        else{
            titleText.setText("ok then");
        }

    }

    public static void setSingle(MainActivity context){
        MainActivity.context= context;
    }

    public static MainActivity getSingle(){
        return MainActivity.context;
    }

    public Context getContext(){
        return MainActivity.context;
    }

}