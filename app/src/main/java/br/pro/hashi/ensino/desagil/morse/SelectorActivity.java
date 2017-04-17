package br.pro.hashi.ensino.desagil.morse;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class SelectorActivity extends UtilityActivity {

    protected TextView phraseSelector= (TextView) findViewById(R.id.phraseSelector);
    protected List phraseBook = (new Library()).premadePhrases;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);

        protected int phraseIter= 0;

        phraseSelector.setOnTouchListener(new OnSwipeTouchListener(SelectorActivity)){
            public void onSwipeTop(){
                //nada
            }
            public void onSwipeRight(){
                phraseIter+= 1;
                phraseIter%= phraseBook.size();
                phraseSelector.setText();
            }
            public void onSwipeBottom(){
                //nada
            }
            public void onSwipeUp(){
                phraseIter+= phraseBook.size() - 1;
                phraseIter%= phraseBook.size();
                phraseSelector.setText();
            }
        }
    }


    public void askConfirm(View view) {

        Utilities.confim(this);
    }

    public void listenConfirm(boolean isConfirmed){

        if (isConfirmed){
            //puxar o sendmessage
        }
    }
}
