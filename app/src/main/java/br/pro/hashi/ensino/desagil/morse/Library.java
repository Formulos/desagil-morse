package br.pro.hashi.ensino.desagil.morse;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by the only and one pedro, who was meant to do this incredible and impossible job on 16/04/2017.
 * This was so difficult that almost drove me insane so do not copy pls
 */

public class Library {

    public static List<String> premadePhrases;
    
    public static String phoneNumber = ("+5511957837723"); // inutil agora

    public Library(){

        this.premadePhrases = new LinkedList<>();
        this.premadePhrases.add("Preciso ir ao banheiro ");
        this.premadePhrases.add("Preciso de água ");
        this.premadePhrases.add("Estou com fome ");
        this.premadePhrases.add("Estou com dor ");

    }

    public static MorseTree tree;

    public static String[] morseTree = {null, "E","T","I","A","N","M","S","U","R","W","D","K","G","O","H","V","F","","L","","P"
            ,"J","B","X","C","Y","Z","Q","","","5","4","","3","",null,"D","2",null,"","",null,null,"","J"
            ,"1","6","","",null,"","","",null,"7","","","","8",null,"9","0",null,null,null,null
            ,null,null,null,null,null,null,null,null,"","",null,null,null,null,"",null,null,"",null,null,null,null
            ,"",null,null,null,"",null,null,"",null,null,null,null,null,null,null,null,"","",null,"",null,null
            ,null,null,null,"",null,null,null,null,"",null,null,null,null,null,null,null
    };

    public static String[] alphabet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","1","2","3","4","5","6","7","8","9","0"};
}

