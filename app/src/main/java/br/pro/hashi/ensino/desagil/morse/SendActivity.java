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
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        //layout.addView(textView);
    }

    public void sendMessage(View view) {
        SmsManager manager = SmsManager.getDefault();



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
