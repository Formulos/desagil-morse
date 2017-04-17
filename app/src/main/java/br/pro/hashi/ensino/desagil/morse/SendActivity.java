package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendActivity extends AppCompatActivity {
    Library lib = new Library();
    private EditText messageEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
    }

    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();

        String message = messageEdit.getText().toString();

        try {
            manager.sendTextMessage(lib.PhoneNumber, null, message, null, null);

            Toast toast = Toast.makeText(this, "Menssagem enviada ao número", Toast.LENGTH_SHORT);
            toast.show();
        }
        catch(IllegalArgumentException exception) {
            Log.e("SendActivity", "número ou mensagens vazios");
        }
    }
}
