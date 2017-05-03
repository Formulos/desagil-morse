package br.pro.hashi.ensino.desagil.morse;

/**
 * Created by jean-low on 26/04/17.
 */

public interface HashipadListener {

    public void onShort();

    public void onLong();

    public void onSwipeUp();

    public void onSwipeRight();

    public void onSwipeDown();

    public void onSwipeLeft();
}
