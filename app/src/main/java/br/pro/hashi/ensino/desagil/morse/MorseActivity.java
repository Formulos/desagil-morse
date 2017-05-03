package br.pro.hashi.ensino.desagil.morse;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by alexandre on 02/05/17.
 */

public class MorseActivity extends AppCompatActivity implements UtilityActivity, HashipadListener {

    private TextView titleText;
    private TextView subText;
    private TextView message;
    private TextView charText;

    private Hashipad pad;
    private MorseTree tree;
    private int morsepath;
    private int copy;
    private String temp;
    private Node parent;
    private Node current;
    Toast toast;

    private int charCount;
    private final int charCountMax= 140;

    public static MorseActivity context;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MorseActivity.setSingle(this);
        setContentView(R.layout.activity_morse);

        titleText = (TextView) findViewById(R.id.symbolPreview);
        subText = (TextView) findViewById(R.id.morsePreview);
        message = (TextView) findViewById(R.id.messageBody);
        charText= (TextView) findViewById(R.id.charView);
        message.setText("<");

        pad = (Hashipad) findViewById(R.id.pad);
        pad.setListener(this);

        toast = Toast.makeText(this, "Combinação Morse digitada não é válida", Toast.LENGTH_SHORT);

        MorseTree tree = new MorseTree();
        tree.generateTree(Library.morseTree);

        parent= tree.getTree()[0];
        current= parent;
        tree.generateTree(Library.morseTree);

        morsepath= 1;
        charCount= charCountMax;

    }

    public static void setSingle(MorseActivity context){
        MorseActivity.context= context;
    }

    public static MorseActivity getSingle(){
        return MorseActivity.context;
    }

    public Context getContext(){
        return MorseActivity.context;
    }

    public void listenConfirm(boolean answer){

        if(answer){
            Intent intent= new Intent(this, ConfigActivity.class);
            Log.d("teste","1");

            startActivity(intent);


        }
        else{
            titleText.setText("ok then");
        }
    }

    @Override
    public void onShort() {
        morsepath*=2;

        if (current.getLeft()!=null && current.getLeft().getCore()!=null){
            current = current.getLeft();

            morsify();
            printMorse();
        }else{
            toast.show();
        }
    }

    @Override
    public void onLong() {
        morsepath*=2;
        morsepath+=1;

        if (current.getRight()!=null && current.getRight().getCore()!=null){
            current = current.getRight();

            morsify();
            printMorse();
        }else{
            toast.show();
        }
    }

    public void onSwipeRight(){

        Intent act= new Intent(this, SendActivity.class);
        act.putExtra("phrase", message.getText().toString().substring(0, message.getText().length() - 1));
        startActivity(act);
    }

    public void onSwipeLeft(){
        Log.d("Swipe", "Left");

        Intent intent= new Intent(this, SelectorActivity.class);
        startActivity(intent);

    }

    public void onSwipeUp(){

        if (morsepath!=1){

            clear();
        }else {
            if (charCount!=charCountMax) {
                message.setText(message.getText().toString().substring(0, message.getText().length() - 2));
                message.setText(message.getText() + "<");
                charCount+=1;
            }
        }

        charText.setText(String.valueOf(charCount)+" caracter(es)");
    }

    public void onSwipeDown(){
        //Envia as letras para o texto principal

        if (charCount!=0) {
            if (current.getCore() != null) {
                message.setText(message.getText().toString().substring(0, message.getText().length() - 1));
                message.setText(message.getText() + current.getCore() + "<");
            } else {
                message.setText(message.getText().toString().substring(0, message.getText().length() - 1));
                message.setText(message.getText() + " <");
            }

            charCount-=1;
        }

        clear();

        charText.setText(String.valueOf(charCount)+" caracter(es)");
    }

    public void morsify() {

        titleText.setText(current.getCore());
    }

    private void clear(){

        titleText.setText("");
        subText.setText("");
        current=parent;
        morsepath= 1;
    }

    public void printMorse(){
        temp= "";

        copy= morsepath;

        while (copy != 1){
            if (copy%2==1){
                temp="−"+temp;
            }else{
                temp="·"+temp;
            }
            copy/=2;
        }

        subText.setText(temp);
    }

    public void goToDictionaryActivity(View v){
        Intent intent= new Intent(this, Dicionario.class);
        startActivity(intent);
    }

    public void goToConfigActivity(View v){
        Intent intent= new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }
}
