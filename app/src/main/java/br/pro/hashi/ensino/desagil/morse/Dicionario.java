package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Dicionario extends AppCompatActivity {


    private TextView BinaryStage1;
    private TextView BinaryStage2;

    private int lineCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);

        BinaryStage1 = (TextView) findViewById(R.id.Binary1);
        BinaryStage2 = (TextView) findViewById(R.id.Binary2);
        generate(Library.tree);

    }

    public void generate(MorseTree tree){
        for (Node node: tree.getTree()) { // goes in the tree by adress size sorting.
            if (node.getCore() != null && !node.getCore().equals("")) {
                print(node.getFullPath(), node.getCore(), lineCounter < 19 ? BinaryStage1:BinaryStage2);
                lineCounter ++;
            }
        }
        lineCounter = 0;
        System.out.println("------------------------see whats hashi likes the most-----------------------------------");

        for (String letter: Library.alphabet){
            //print(tree.getCode(letter), letter);
        }
    }

    private void print(boolean[] lista, String core,TextView stage){
        //this function needs to instantiate a new TextViwer for each node that isn't blank or null
        String out = " ";

        for (boolean i:lista){
            out += i ? "−":"·";
        }
        out += " : " + core;
        stage.setText(stage.getText() + "\n" + out);

        //System.out.println(out);
    }
    public void Swap(View V) {
        Intent intent= new Intent(this, Dicionario2.class);
        startActivity(intent);
    }
    public void Back(View V) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
