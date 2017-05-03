package br.pro.hashi.ensino.desagil.morse;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
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
    private String number;
    private String message;
    private Toast success;
    private Toast failure;
    private final int PLEASE_WORK_SMS_I_BEG_OF_YOU= 7243;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        Intent intent = getIntent();
        message = intent.getStringExtra("phrase");
        TextView phrase= (TextView) findViewById(R.id.phrase);
        phrase.setTextSize(24);
        phrase.setText(message);

        success= Toast.makeText(this, "Mensagem enviada com sucesso!", Toast.LENGTH_SHORT);
        failure= Toast.makeText(this, "Não foi possível enviar a mensagem, faltam as permissões necessárias", Toast.LENGTH_SHORT);

        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        //layout.addView(textView);


    }

    public void sendMessage(View view) {
        number= lib.phoneNumber;


        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);

        if (permissionCheck== PackageManager.PERMISSION_GRANTED) {
            SmsManager manager = SmsManager.getDefault();
            try {

                //SharedPreferences mPrefs = getSharedPreferences("IDvalue",0); // abre o arquivo SharedPreferences onde esta o numero
                //String numero = (mPrefs.getString("Numero",""));// é um dicionario
                //Log.d("numero","Mandou " + numero);

                //String numero= lib.phoneNumber;

                manager.sendTextMessage(number, null, message, null, null);

                success.show();
            } catch (Exception e) {
                Log.e("SendActivity", e.getMessage());
            }
        }else if(permissionCheck== PackageManager.PERMISSION_DENIED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},
                    PLEASE_WORK_SMS_I_BEG_OF_YOU);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PLEASE_WORK_SMS_I_BEG_OF_YOU: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay!

                    SmsManager manager = SmsManager.getDefault();
                    try {

                        manager.sendTextMessage(number, null, message, null, null);

                        success.show();
                    } catch (Exception e) {
                        Log.e("SendActivity", e.getMessage());
                    }


                } else {

                    // permission denied, boo!
                    failure.show();

                }
                return;
            }
        }
    }
}
