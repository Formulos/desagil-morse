package br.pro.hashi.ensino.desagil.morse;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by the only and one pedro, who was meant to do this incredible and impossible job on 16/04/2017.
 * This was so difficult that almost drove me insane so do not copy pls
 */

public class Library {


    public List<String> premadePhrases;
    public String PhoneNumber = ("+5511957837723");
    public Library(){

        this.premadePhrases = new LinkedList<>();
        this.premadePhrases.add("Preciso ir ao banheiro");
        this.premadePhrases.add("Preciso de água");
        this.premadePhrases.add("Estou com fome");
        this.premadePhrases.add("Preciso IMEDIATAMENTE de...");
        this.premadePhrases.add("Preciso IMEDIATAMENTE falar com...");
    }
}
