package br.pro.hashi.ensino.desagil.morse;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
            Log.d("teste","Entrou no try");

            // We need an Editor object to make preference changes.
            // All objects are from android.context.Context
            SharedPreferences settings = getSharedPreferences("IDvalue", 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString("Numero", "+"+ number);


            // Commit the edits!
            editor.commit();


            String numero = settings.getString("Numero",null); // pega o numero
            Log.d("numero","outcome = " + numero); // printa o numero no log para ver se esta certo


            finish(); //volta para o main


            /*
            Intent intent= new Intent(this, SelectorActivity.class);
            startActivity(intent); */
            
        }
        catch(IllegalArgumentException exception) {
            Log.e("SendActivity", "number or message empty");
        }
    }
    public void Back(View V) {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

