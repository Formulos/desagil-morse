package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Dicionario extends AppCompatActivity {


    private TextView Binary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);

        Binary = (TextView) findViewById(R.id.Binary);
        generate(Library.tree);

    }

    public void generate(MorseTree tree){
        for (Node node: tree.getTree()) { // goes in the tree by adress size sorting.
            if (node.getCore() != null) {
                if (!node.getCore().equals("blank")) {
                    print(node.getFullPath(), node.getCore());
                }
            }
        }

        System.out.println("------------------------see whats hashi likes the most-----------------------------------");

        for (String letter: Library.alphabet){
            print(tree.getCode(letter), letter);
        }
    }

    private void print(boolean[] lista, String core){
        //this function needs to instantiate a new TextViwer for each node that isn't blank or null
        String out = "   ";
        out += core + " : ";
        for (boolean i:lista){
            out += i ? "-":".";

        }

        //create new text view
        //set text view text to out
        Binary.setText(Binary.getText() + "\n"+ out );
        System.out.println(out);
    }
}
