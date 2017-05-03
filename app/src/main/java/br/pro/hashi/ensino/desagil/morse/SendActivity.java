package br.pro.hashi.ensino.desagil.morse;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SendActivity extends AppCompatActivity implements HashipadListener {
    Library lib = new Library();
    private Hashipad pad;
    private String message;
    private Toast success;
    private Toast failure;
    private Toast invalid;
    private final int PLEASE_WORK_SMS_I_BEG_OF_YOU= 7243;
    private Toast toast;

    private TextView symbol;
    private TextView morse;
    private TextView phone;


    private int charCount;
    private final int charCountMax= 16;
    private Node parent;
    private Node current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        Intent intent = getIntent();
        message = intent.getStringExtra("phrase");
        TextView phrase= (TextView) findViewById(R.id.phrase);
        phrase.setTextSize(24);
        phrase.setText(message);

        pad = (Hashipad) findViewById(R.id.pad);
        pad.setListener(this);

        toast = Toast.makeText(this, "Combinação Morse digitada não é válida", Toast.LENGTH_SHORT);

        MorseTree tree = new MorseTree();
        tree.generateTree(Library.morseTree);

        symbol= (TextView) findViewById(R.id.symbolPreview);
        morse= (TextView) findViewById(R.id.morsePreview);
        phone= (TextView) findViewById(R.id.phoneNumber);
        phone.setText(lib.phoneNumber);

        parent= tree.getTree()[0];
        current= parent;
        tree.generateTree(Library.morseTree);

        success= Toast.makeText(this, "Mensagem enviada com sucesso!", Toast.LENGTH_SHORT);
        failure= Toast.makeText(this, "Não foi possível enviar a mensagem, faltam as permissões necessárias", Toast.LENGTH_SHORT);
        invalid= Toast.makeText(this, "Número de telefone não aparenta ser válido", Toast.LENGTH_SHORT);

        charCount= charCountMax-(phone.getText().length()-1);



    }

    public void onShort(){

        if (current.getLeft()!=null && current.getLeft().getCore()!=null){
            current = current.getLeft();

            symbol.setText(current.getCore());
            morse.setText(morse.getText()+"·");
        }else{
            toast.show();
        }
    }

    public void onLong(){

        if (current.getRight()!=null && current.getRight().getCore()!=null){
            current = current.getRight();

            symbol.setText(current.getCore());
            morse.setText(morse.getText()+"−");
        }else{
            toast.show();
        }
    }

    public void onSwipeLeft(){
        finish();
    }

    public void onSwipeRight(){
        sendMessage();
    }

    public void onSwipeUp(){

        if (!morse.getText().toString().equals("")){

            clear();
        }else {
            if (charCount!=charCountMax) {
                phone.setText(phone.getText().toString().substring(0, phone.getText().length() - 1));
                lib.phoneNumber= phone.getText().toString();
                charCount+=1;
            }
        }
    }

    public void onSwipeDown(){

        if (charCount!=0) {
            if (current.getCore() != null) {
                phone.setText(phone.getText() + current.getCore());
            } else {
                phone.setText(phone.getText() + "0");
            }

            lib.phoneNumber= phone.getText().toString();
            charCount-=1;
        }

        clear();
    }

    private void clear(){

        symbol.setText("");
        morse.setText("");
        current=parent;
    }

    public void sendMessage() {

        if (!PhoneNumberUtils.isGlobalPhoneNumber(lib.phoneNumber)){

            invalid.show();
            return;
        }


        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS);

        if (permissionCheck== PackageManager.PERMISSION_GRANTED) {
            SmsManager manager = SmsManager.getDefault();
            try {

                //SharedPreferences mPrefs = getSharedPreferences("IDvalue",0); // abre o arquivo SharedPreferences onde esta o numero
                //String numero = (mPrefs.getString("Numero",""));// é um dicionario
                //Log.d("numero","Mandou " + numero);

                //String numero= lib.phoneNumber;

                manager.sendTextMessage(lib.phoneNumber, null, message, null, null);

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

                        manager.sendTextMessage(lib.phoneNumber, null, message, null, null);

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
