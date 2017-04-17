package br.pro.hashi.ensino.desagil.morse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends UtilityActivity {
    private TextView titleText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleText = (TextView) findViewById(R.id.titleText);
        button = (Button) findViewById(R.id.button);

    }

    public void seeTheTruth(View v){
        Utilities.confirm(this,"do you wanna se the truth?");
    }

    public void listenConfirm(boolean answer){

        if(answer){
            titleText.setText("Welcome to my world of pain!");
        }
        else{
            titleText.setText("ok then");
        }

    }
}
