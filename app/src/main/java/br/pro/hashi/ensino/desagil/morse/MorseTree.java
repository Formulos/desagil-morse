package br.pro.hashi.ensino.desagil.morse;

import org.w3c.dom.Node;
//https://www.w3.org/2003/01/dom2-javadoc/org/w3c/dom/Node.html documentacao do Node

public class MorseTree {
    public char translate(String code) {
        return '?';
    }

    private Node[] nodes;
    private String[] MorseTree = {null, "E","T","I","A","N","M","S","U","R","W","D","K","G","O","H","V","F","Ü","L","Ä","P"
            ,"J","B","X","C","Y","Z","Q","Ö","CH","5","4","S","3","É",null,"D","2",null,"È","+",null,null,"À","J"
            ,"1","6","=","/",null,"Ç",null,"7",null,"G","Ñ","8",null,"9","0","S","U","R","S","U","R",null,null,null,null
            ,null,null,null,null,null,null,null,null,"?","_",null,null,null,null,"''",null,null,".",null,null,null,null
            ,"@",null,null,null,"'",null,null,"-",,null,null,null,null,null,null,null,null,";","!",null,"()",,null,null
            ,null,null,null,",",null,null,null,null,":",null,null,null,null,null,null,null};

}
