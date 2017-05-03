package br.pro.hashi.ensino.desagil.morse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by jean-low on 26/04/17.
 */

public class Hashipad extends View {

    private HashipadListener listener;
    private long time;
    private float originX;
    private float originY;
    private Paint myPaint;

    private final float SWIPE_THRESH= 10;
    private final long TIME_THRESH= 200;
    private final long SWIPE_TIME_THRESH= 1200;

    public Hashipad(Context context, AttributeSet attrs) {
        super(context, attrs);


        myPaint = new Paint();
        myPaint.setStyle(Paint.Style.FILL);
        myPaint.setColor(Color.parseColor("#B0BEC5"));
    }


    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);
        switch(action) {
            case (MotionEvent.ACTION_DOWN):
                time= System.currentTimeMillis();
                originX= event.getX();
                originY= event.getY();
                break;
            case (MotionEvent.ACTION_UP):
                //Log.d("teste time", String.valueOf((System.currentTimeMillis() - time)));
                originX= event.getX() - originX;
                originX= 100*originX/this.getWidth();

                originY= event.getY() - originY;
                originY= 100*originY/this.getWidth();

                //Log.d("X: ", String.valueOf(originX));
                //Log.d("Y: ", String.valueOf(originY));

                time= System.currentTimeMillis() - time;
                if (time <= SWIPE_TIME_THRESH && originX> SWIPE_THRESH && originX>originY){

                    listener.onSwipeRight();
                }else if(time <= SWIPE_TIME_THRESH && originX<- SWIPE_THRESH && originX<originY){

                    listener.onSwipeLeft();
                }else if(time <= SWIPE_TIME_THRESH && originY> SWIPE_THRESH && originY>originX){

                    listener.onSwipeDown();
                }else if(time <= SWIPE_TIME_THRESH && originY<- SWIPE_THRESH && originY<originX){

                    listener.onSwipeUp();
                }else if (time <= TIME_THRESH){

                    //toquecurto
                    listener.onShort();
                }else {

                    //toque longo
                    listener.onLong();
                }
                break;
            default:
                //a princípio não vou usar
                break;
        }
        //return super.onTouchEvent(event);
        return true;
    }

    public void setListener(HashipadListener listener){

        this.listener = listener;
    }


    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), myPaint);
    }

}

