package br.pro.hashi.ensino.desagil.morse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

public class SelectorActivity extends AppCompatActivity implements UtilityActivity{

    protected TextView phraseSelector;
    protected List<String> phraseBook;
    protected int phraseIter;

    protected TextView HintSelector;
    protected List<String> HintBook;
    protected int HintIter;

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

        HintSelector= (TextView) findViewById(R.id.HintView);
        HintBook= (new Library()).HintList;
        HintIter = 0;
        HintSelector.setText(HintBook.get(HintIter));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                NextHint();
            }
        }, 1000);


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

    public void NextHint(){
        HintIter+= 1;
        HintSelector.setText(HintBook.get(HintIter));
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
}
