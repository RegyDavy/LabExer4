package com.caampued.labexer4;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView Preview;
    EditText Paragraph;
    Button  Btn_Save, Btn_Clear, Btn_Display;
    SharedPreferences pref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Paragraph = (EditText) findViewById(R.id.Paragraph);
        Preview = (TextView) findViewById(R.id.Preview);
        Btn_Save = (Button) findViewById(R.id.btn_Save);
        Btn_Clear = (Button) findViewById(R.id.btn_Clear);
        Btn_Display = (Button) findViewById(R.id.btn_Display);
        pref = getPreferences(Context.MODE_PRIVATE);
    }

    public void savePar (View view){
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("Context", Paragraph.getText().toString());
        editor.commit();
        Toast.makeText(this, "Paragraph Saved!", Toast.LENGTH_SHORT).show();

    }

    public void showPar (View view){
        String context = pref.getString("Context", "");
        Preview.setText(context);

    }

    public void clearPar (View view){
        Toast.makeText(this, "Paragraph Cleared", Toast.LENGTH_SHORT).show();
        Preview.setText(" ");
        Paragraph.setText(" ");
    }
}
