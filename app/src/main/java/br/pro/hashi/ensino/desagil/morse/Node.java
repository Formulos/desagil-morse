package br.pro.hashi.ensino.desagil.morse;

/**
 * Created by Jean Low on 23/04/2017.
 */

public class Node {

    private static int layer = 0;
    private String core;
    private Node left;
    private Node right;
    private Node parent;
    private boolean last;
    private boolean path;

    public Node(String core, Node left, Node right){
        this.core = core;
        this.left = left;
        this.right = right;

    }

    private void checkLast(){
        if(left == null && right == null){
            this.last = false;
        } else{
            this.last = true;
        }
    }

    public void setLayer(int n){
        this.layer = n;
    }
    public void incLayer(){
        this.layer ++;
    }

    public void setRight(Node node){
        this.right = node;
        node.setParent(this);
        node.setPath(true);
        checkLast();
    }
    public void setLeft(Node node){
        this.left = node;
        node.setParent(this);
        node.setPath(false);
        checkLast();
    }
    public  void setParent(Node node){
        this.parent = node;
    }
    public void setPath(boolean path) {
        this.path = path;
    }

    public String getCore(){
        return this.core;
    }
    public Node getRight(){
        return this.right;
    }
    public Node getLeft(){
        return this.left;
    }
    public Node getParent(){
        return this.parent;
    }

    public boolean getPath(){
        return this.path;
    }
    /* Deixem isso comigo, gostei do problema -- jean
    public boolean[] getFullPath(){
        boolean[] lista = getFullPath(new Boolean[])
        return lista
    }
    */

}
