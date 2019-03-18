package com.example.colebykymxbcalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double coords1[] = new double[2];
    double coords2[] = new double[2];

    private double[] getCoords1(EditText coord1, EditText coord2) {
        coords1[0] = Double.parseDouble(coord1.getText().toString());
        coords1[1] = Double.parseDouble(coord2.getText().toString());
        return coords1;
    }

    private double[] getCoords2(EditText coord1, EditText coord2) {
        coords2[0] = Double.parseDouble(coord1.getText().toString());
        coords2[1] = Double.parseDouble(coord2.getText().toString());
        return coords2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcBtn = (Button) findViewById(R.id.calcBtn);

        final EditText x1EditText = (EditText) findViewById(R.id.x1EditText);
        final EditText x2EditText = (EditText) findViewById(R.id.x2EditText);
        final EditText y1EditText = (EditText) findViewById(R.id.y1EditText);
        final EditText y2EditText = (EditText) findViewById(R.id.y2EditText);

        final TextView slopeResultTextView = (TextView) findViewById(R.id.slopeResultTextView);
        final TextView yIntResultTextView = (TextView) findViewById(R.id.yIntResultTextView);

        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                coords1 = getCoords1(x1EditText,y1EditText);
                coords2 = getCoords2(x2EditText,y2EditText);

                double slope = (coords2[1] - coords1[1]) / (coords2[0] - coords1[0]);

                slopeResultTextView.setText(slope + "");

                yIntResultTextView.setText(coords1[1]-slope*coords1[0] + "");
            }
        });

    }
}

