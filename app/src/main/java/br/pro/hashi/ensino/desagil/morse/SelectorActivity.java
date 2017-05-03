package br.pro.hashi.ensino.desagil.morse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class SelectorActivity extends AppCompatActivity implements UtilityActivity, HashipadListener{

    protected TextView phraseSelector;
    protected List<String> phraseBook;
    protected int phraseIter;

    private Hashipad pad;

    public static SelectorActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        SelectorActivity.setSingle(this);
        setContentView(R.layout.activity_selector);

        phraseSelector= (TextView) findViewById(R.id.phraseSelector);
        phraseBook= (new Library()).premadePhrases;
        phraseIter= 0;
        phraseSelector.setText(phraseBook.get(phraseIter));

        pad = (Hashipad) findViewById(R.id.hashipad);
        pad.setListener(this);


        phraseSelector.setOnTouchListener(new OnSwipeTouchListener(this){
            public void onSwipeTop(){
            }
            public void onSwipeRight(){
            }
            public void onSwipeBottom(){
            }
            public void onSwipeLeft(){
            }
            public void onTest(){
                Utilities.confirm(SelectorActivity.getSingle());
            }
        });
    }

    public void askConfirm(){

        Utilities.confirm(this);
    }

    public void listenConfirm(boolean isConfirmed){

        if (isConfirmed){
            Intent act= new Intent(this, SendActivity.class);
            Log.d(phraseBook.get(phraseIter),"AAA");
            act.putExtra("phrase", phraseBook.get(phraseIter));
            startActivity(act);
        }
    }

    public static void setSingle(SelectorActivity context){
        SelectorActivity.context= context;
    }

    public static UtilityActivity getSingle(){
        return SelectorActivity.context;
    }

    public Context getContext(){
        return SelectorActivity.context;
    }

    @Override
    public void onShort() {
    }

    @Override
    public void onLong() {
    }

    @Override
    public void onSwipeUp() {
        Intent act= new Intent(this, MainActivity.class);
        startActivity(act);
    }

    @Override
    public void onSwipeRight() {
        phraseIter+= 1;
        phraseIter%= phraseBook.size();
        phraseSelector.setText(phraseBook.get(phraseIter));
    }

    @Override
    public void onSwipeDown() {
        Intent act= new Intent(this, SendActivity.class);
        act.putExtra("phrase", phraseSelector.getText().toString().substring(0, phraseSelector.getText().length() - 1));
        startActivity(act);
    }

    @Override
    public void onSwipeLeft() {
        phraseIter+= phraseBook.size() - 1;
        phraseIter%= phraseBook.size();
        phraseSelector.setText(phraseBook.get(phraseIter));
    }
}
