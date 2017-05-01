package br.pro.hashi.ensino.desagil.morse;

public class MorseTree {

    private Node[] tree;

    public Node[] generateTree(String[] cores){
        Node[] nodes = new Node[cores.length];
        for (int i = 0; i < cores.length;i++ ){
            nodes[i] = new Node(cores[i],null,null);
        }

        int maxLayer = 7;
        Node[][] temp = new Node[maxLayer][];
        int layer = 0;
        int count = 0;
        while(true){
            if(layer  == maxLayer){
                break;
            }
            temp[layer] = new Node[(int) Math.pow(2,layer)];
            for (int i = 0 ; i < (int) Math.pow(2,layer) ; i ++){
                temp[layer][i] = nodes[count];
                count++;
            }
            layer ++;
        }
        count = 0;
        for (int i = 0; i < maxLayer - 1; i++){
            for(int j = 0; j < temp[i].length;j ++){
                nodes[count].setLeft(temp[i + 1][j * 2]);
                nodes[count].setRight(temp[i + 1][j * 2 + 1]);
                count ++;
            }
        }
        this.tree = nodes;

        //coll way for setting how many layers a regular binary tree have, making the code generic
        int size = nodes.length + 1;
        size = Integer.highestOneBit(size);
        int powTwo = Integer.bitCount(~size); //could I use size -1? yes... I do.
        nodes[0].setLayer(powTwo);
        //E sim Ale, eu sei que eu podia resumir tudo em uma linha...

        return (nodes);
        
    }

    public Node[] getTree(){
        return this.tree;
    }


    public String translate(boolean[] code) {

        Node node = tree[0];
        for (int i = 0; i < code.length; i ++){
            node = code[i] ? node.getRight():node.getLeft();
        }

        return node.getCore() != null ? node.getCore() : "blank";
    }

    public boolean[] getAdress(int index){
        return tree[index].getFullPath();
    }

}
