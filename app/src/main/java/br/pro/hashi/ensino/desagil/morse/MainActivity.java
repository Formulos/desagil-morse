package br.pro.hashi.ensino.desagil.morse;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

        titleText = (TextView) findViewById(R.id.symbolPreview);
        button = (Button) findViewById(R.id.button);

        MorseTree tree = new MorseTree();
        tree.generateTree(Library.morseTree);
        Library.tree = tree;

        Intent intent= new Intent(this, MorseActivity.class);
        startActivity(intent);

        //Dicionario dick = new Dicionario();
        //dick.generate(tree);



    }
/*
    public void seeTheTruth(View v){

        Utilities.confirm(this,"do you wanna see the truth?");

    }
*/
    public void listenConfirm(boolean answer){

        if(answer){
            //Intent intent= new Intent(this, ConfigActivity.class);
            Intent intent= new Intent(this, MorseActivity.class);
            Log.d("teste","1");

            startActivity(intent);


        }
        else{
            Intent intent= new Intent(this, Dicionario.class);
            startActivity(intent);
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