package br.pro.hashi.ensino.desagil.morse;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by the only and one pedro, who was meant to do this incredible and impossible job on 16/04/2017.
 * This was so difficult that almost drove me insane so do not copy pls
 */

public class Library {

    public List<String> premadePhrases;
    public List<String> HintList;
    
    public String phoneNumber = ("+5511957837723"); // inutil agora

    public Library(){

        this.premadePhrases = new LinkedList<>();
        this.premadePhrases.add("Preciso ir ao banheiro");
        this.premadePhrases.add("Preciso de água");
        this.premadePhrases.add("Estou com fome");
        this.premadePhrases.add("Estou com dor");

    }

    public static MorseTree tree;

    public static String[] morseTree = {null, "E","T","I","A","N","M","S","U","R","W","D","K","G","O","H","V","F","blank","L","blank","P"
            ,"J","B","X","C","Y","Z","Q","blank","blank","5","4","blank","3","blank",null,"D","2",null,"blank","blank",null,null,"blank","J"
            ,"1","6","blank","blank",null,"blank","blank","blank",null,"7","blank","blank","blank","8",null,"9","0",null,null,null,null
            ,null,null,null,null,null,null,null,null,"blank","blank",null,null,null,null,"blank",null,null,"blank",null,null,null,null
            ,"blank",null,null,null,"blank",null,null,"blank",null,null,null,null,null,null,null,null,"blank","blank",null,"blank",null,null
            ,null,null,null,"blank",null,null,null,null,"blank",null,null,null,null,null,null,null
    };

    public static String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
}

