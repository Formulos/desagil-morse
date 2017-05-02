package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dicionario2 extends AppCompatActivity {

    private TextView AlphaStage1;
    private TextView AlphaStage2;

    private int lineCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario2);

        AlphaStage1 = (TextView) findViewById(R.id.Alpha1);
        AlphaStage2 = (TextView) findViewById(R.id.Alpha2);
        generate(Library.tree);

    }

    public void generate(MorseTree tree){


        for (String letter: Library.alphabet){
            print(tree.getCode(letter), letter, lineCounter < 18 ? AlphaStage1:AlphaStage2);
            lineCounter++;
        }
        lineCounter = 0;
    }

    private void print(boolean[] lista, String core,TextView stage){
        //this function needs to instantiate a new TextViwer for each node that isn't blank or null
        String out = " ";
        out += core + " : ";
        for (boolean i:lista){
            out += i ? "−":"·";
        }

        stage.setText(stage.getText() + "\n" + out);

        //System.out.println(out);
    }
    public void Swap(View V) {
        Intent intent= new Intent(this, Dicionario.class);
        startActivity(intent);
    }
}