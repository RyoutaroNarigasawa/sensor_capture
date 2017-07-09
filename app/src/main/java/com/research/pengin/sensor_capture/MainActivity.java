package com.research.pengin.sensor_capture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText tester;
    Spinner hand,course,threshold,number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button capturebtn = (Button) findViewById(R.id.capture);//マスタデータ登録フォーム遷移用ボタン

        hand      = (Spinner)findViewById(R.id.hand);
        course    = (Spinner)findViewById(R.id.course);
        tester    = (EditText)findViewById(R.id.tester);
        number    = (Spinner)findViewById(R.id.number);

        capturebtn.setOnClickListener(new OnClickListener() {//マスタデータ登録フォーム遷移用ボタン押下時の動作
            public void onClick(View v) {
                if(tester.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this,"名前が入力されていません",Toast.LENGTH_SHORT).show();
                }else{

                    Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                    intent.putExtra("tester",tester.getText().toString());
                    intent.putExtra("hand", (String) hand.getSelectedItem());
                    intent.putExtra("course", (String) course.getSelectedItem());
                    intent.putExtra("number",(String)number.getSelectedItem());
                    startActivity(intent);
                }
            }
        });

    }
}
