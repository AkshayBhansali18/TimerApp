package edu.msrit.timerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.imageView);
        textView=(TextView)findViewById(R.id.textView);
        editText=(EditText)findViewById(R.id.editText);
        button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=editText.getText().toString();
                if(TextUtils.isEmpty(input))
                {
                    editText.setError("Invalid input");
                }
                else
                {
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("time",editText.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
