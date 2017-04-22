package br.pro.hashi.ensino.desagil.morse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.List;

public class SelectorActivity extends AppCompatActivity implements UtilityActivity{

    protected TextView phraseSelector;
    protected List<String> phraseBook;
    protected int phraseIter;

    public static SelectorActivity context;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        SelectorActivity.setSingle(this);
        setContentView(R.layout.activity_selector);

        phraseSelector= (TextView) findViewById(R.id.phraseSelector);
        phraseBook= (new Library()).premadePhrases;

        phraseIter= 0;

        phraseSelector.setOnTouchListener(new OnSwipeTouchListener(this){
            public void onSwipeTop(){
                //nada
            }

            public void onSwipeRight(){
                phraseIter+= 1;
                phraseIter%= phraseBook.size();
                phraseSelector.setText(phraseBook.get(phraseIter));
            }

            public void onSwipeBottom(){
                //nada
            }

            public void onSwipeLeft(){
                phraseIter+= phraseBook.size() - 1;
                phraseIter%= phraseBook.size();
                phraseSelector.setText(phraseBook.get(phraseIter));
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
}
