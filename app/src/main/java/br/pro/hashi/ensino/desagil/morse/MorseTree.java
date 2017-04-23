package br.pro.hashi.ensino.desagil.morse;


public class MorseTree {

    public void generateTree(String[] cores){
        Node[] nodes = new Node[cores.length];
        for (int i = 0; i < cores.length;i++ ){
            nodes[i] = new Node(cores[i],null,null);
        }

        int maxLayer = 7;
        Node[][] tree = 
        int layer = 0;
        while(true){
            if(layer  == maxLayer){
                break;
            }



            layer ++;
        }
    }


    public char translate(boolean[] code) {
        return '?';
    }

}
