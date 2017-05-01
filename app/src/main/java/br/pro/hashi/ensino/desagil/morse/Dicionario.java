package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Dicionario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dicionario);

    }

    public void generate(MorseTree tree){
        for (Node node: tree.getTree()) { // goes in the tree by adress size sorting.
            if(node != null && !node.getCore().equals("blank") ){
                print(node.getFullPath(),node.getCore());
            }
        }

        System.out.println("------------------------see whats hashi likes the most-----------------------------------");

        int layers = tree.getTree()[0].getLayer();
        int max = (int) Math.pow(2,layers);

        for (String letter : Library.alphabet){
            for (int i = 0; i < max; i ++) {
                String rawPath = Integer.toBinaryString(i);
                boolean[] temp = new boolean[rawPath.length()];
                int count = 0;
                for (Character c : rawPath.toCharArray()) {
                    temp[count] = c.equals('1') ? true: false;
                    count ++;
                }
                if(tree.translate(temp).equals(letter)) {
                    print(temp , letter);
                    break;
                }
            }
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

        System.out.println(out);
    }
}
