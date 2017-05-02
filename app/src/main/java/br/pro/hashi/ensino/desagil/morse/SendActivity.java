package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SendActivity extends AppCompatActivity {
    Library lib = new Library();
    private EditText messageEdit;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        Intent intent = getIntent();
        message = intent.getStringExtra("phrase");
        Log.d(message, "BBB");
        TextView phrase= (TextView) findViewById(R.id.phraseSelector);
        phrase.setTextSize(40);
        phrase.setText(message);

        Intent intenticus = getIntent();
        message = intenticus.getStringExtra("hint");
        Log.d(message, "BBB");
        TextView hint= (TextView) findViewById(R.id.HintView);
        hint.setTextSize(40);
        hint.setText(message);


        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        //layout.addView(textView);


    }

    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();



        try {

            SharedPreferences mPrefs = getSharedPreferences("IDvalue",0); // abre o arquivo SharedPreferences onde esta o numero
            String numero = (mPrefs.getString("Numero",""));// é um dicionario
            Log.d("numero","Mandou " + numero);

            manager.sendTextMessage(numero, null, message, null, null);



            Toast toast = Toast.makeText(this, "Mensagem enviada ao número", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch(IllegalArgumentException exception) {
            Log.e("SendActivity", "número ou mensagens vazios");
        }
    }
}
