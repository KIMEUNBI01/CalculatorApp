package com.example.tab_201126;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    TextView addResult, subResult, mulResult, divResult;
    Button addButton, subButton, mulButton, divButton, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        addButton = (Button) findViewById(R.id.addButton);
        subButton = (Button) findViewById(R.id.subButton);
        mulButton = (Button) findViewById(R.id.mulButton);
        divButton = (Button) findViewById(R.id.divButton);
        resetButton = (Button) findViewById(R.id.resetButton);
        addResult = (TextView) findViewById(R.id.addResult);
        subResult = (TextView) findViewById(R.id.subResult);
        mulResult = (TextView) findViewById(R.id.mulResult);
        divResult = (TextView) findViewById(R.id.divResult);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                int sum = Integer.parseInt(number1.getText().toString()) + Integer.parseInt(number2.getText().toString());
                addResult.setText(Integer.toString(sum));
                Toast.makeText(getApplicationContext(), "덧셈의 결과는?", Toast.LENGTH_SHORT).show();
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = Integer.parseInt(number1.getText().toString()) - Integer.parseInt(number2.getText().toString());
                subResult.setText(Integer.toString(sum));
                Toast.makeText(getApplicationContext(), "뺄셈의 결과는?", Toast.LENGTH_SHORT).show();
            }
        });

        mulButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = Integer.parseInt(number1.getText().toString()) * Integer.parseInt(number2.getText().toString());
                mulResult.setText(Integer.toString(sum));
                Toast.makeText(getApplicationContext(), "곱셈의 결과는?", Toast.LENGTH_SHORT).show();
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = Integer.parseInt(number1.getText().toString()) / Integer.parseInt(number2.getText().toString());
                divResult.setText(Integer.toString(sum));
                Toast.makeText(getApplicationContext(), "나눗셈의 결과는?", Toast.LENGTH_SHORT).show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("제목");
                builder.setMessage("숫자를 리셋하겠습니까?");
                builder.setNeutralButton("취소", null);
                builder.setNegativeButton("아니요", null);
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        number1.setText("");
                        number2.setText("");

                        addResult.setText("");
                        subResult.setText("");
                        mulResult.setText("");
                        divResult.setText("");

                        Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_LONG).show();
                            }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
    }
}