package br.pro.hashi.ensino.desagil.morse;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jean Low on 23/04/2017.
 */

public class Node {

    private static int layer = 0;
    private static LinkedList<Boolean> adress = new LinkedList<Boolean>() {
    };
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

    public boolean[] getFullPath(){
        adress = new LinkedList<Boolean>();

        adress.add(this.firstPath());

        int count = 0;
        boolean[] lista = new boolean[adress.size()];
        for (boolean i:
             adress) {
            lista[count] = i;
            count ++;
        }

        return lista;
    }

    private boolean firstPath(){
        if(parent.core != null){
            adress.add(parent.firstPath());
        }
        return this.path;
    }

}
