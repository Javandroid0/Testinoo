package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtAll, edtEmpty, edtwrong, edtcorrect;
    TextView txtba, txtbedon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtcorrect = findViewById(R.id.edtcorrect);
        edtAll = findViewById(R.id.edtAll);
        edtwrong = findViewById(R.id.edtwrong);
        edtEmpty = findViewById(R.id.edtempty);

        txtba = findViewById(R.id.txtba);
        txtbedon = findViewById(R.id.txtbedon);
        txtba.setTextColor(Color.WHITE);
        txtbedon.setTextColor(Color.WHITE);
        txtba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double All = Double.parseDouble(edtAll.getText().toString());
                    double correct = Double.parseDouble(edtcorrect.getText().toString());
                    double wrong = Double.parseDouble(edtwrong.getText().toString());
                    Double Empty = Double.parseDouble(edtEmpty.getText().toString());

                    if ((Empty + wrong + correct) > All || (Empty + wrong + correct) < All) {

                        txtba.setTextColor(Color.RED);
                        txtba.setText("اشتباه");
                    }else {
                        txtba.setTextColor(Color.WHITE);
                        double resultba = ((correct - (wrong / 3)) / All) * 100;
                        txtba.setText(String.format("%.2f%%", resultba));

                        double resultbedon = (correct / All) * 100;
                        txtbedon.setText(String.format("%.2f%%", resultbedon));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}