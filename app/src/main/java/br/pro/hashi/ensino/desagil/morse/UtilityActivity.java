package br.pro.hashi.ensino.desagil.morse;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by jean-low on 17/04/17.
 */

interface UtilityActivity{

    public abstract void listenConfirm(boolean isConfirmed);

    public abstract Context getContext();
}
