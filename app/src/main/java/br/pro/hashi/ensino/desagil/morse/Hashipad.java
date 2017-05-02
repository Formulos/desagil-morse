package br.pro.hashi.ensino.desagil.morse;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jean-low on 26/04/17.
 */

public class Hashipad extends View {

    private HashipadListener listener;
    private long time;

    public Hashipad(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        long timethreshold= 1200;
        int action = MotionEventCompat.getActionMasked(event);

        switch(action) {
            case (MotionEvent.ACTION_DOWN) :
                time= System.currentTimeMillis();
                break;
            case (MotionEvent.ACTION_UP) :
                if ((System.currentTimeMillis() - time) > timethreshold){
                    //toque longo
                    listener.onShort();
                }else{
                    //toquecurto
                    listener.onLong();
                }
                break;
            default:
                //a princípio não vou usar
                break;
        }
        return super.onTouchEvent(event);
    }

    public void setListener(HashipadListener listener){

        this.listener = listener;
    }

}
