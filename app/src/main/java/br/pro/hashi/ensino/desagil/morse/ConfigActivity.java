package br.pro.hashi.ensino.desagil.morse;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {
    private EditText numberEdit;
    private Button button;
    public static final String PREFS_NAME = "MyPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);// inicio o sared preferences um arquivo que pode ser lido por todo o aplicativo

        numberEdit = (EditText) findViewById(R.id.numberEdit);}

    public void trocaNumero(View view) {
        SmsManager manager = SmsManager.getDefault();
        String number = numberEdit.getText().toString();

        try {

            // We need an Editor object to make preference changes.
            // All objects are from android.context.Context
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("NumeroCuidador", "+9999999999999999999999999");

            // Commit the edits!
            editor.commit();
            
        }
        catch(IllegalArgumentException exception) {
            Log.e("SendActivity", "number or message empty");
        }
    }

}

