package minjinsong.thermostat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Minjin Song (Alex) on 2017-06-23.
 */

public class DayNightSetting extends AppCompatActivity {
    TextView temp1;
    TextView temp2;
    double dTemp = 18;
    double nTemp = 23;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.day_and_night);

        ImageView bDPlus = (ImageView) findViewById(R.id.bDPlus);
        bDPlus.setImageResource(R.drawable.plus);

        ImageView bDMinus = (ImageView) findViewById(R.id.bDMinus);
        bDPlus.setImageResource(R.drawable.plus);

        ImageView bNPlus = (ImageView) findViewById(R.id.bNPlus);
        bDPlus.setImageResource(R.drawable.plus);

        ImageView bNMinus = (ImageView) findViewById(R.id.bNMinus);
        bDPlus.setImageResource(R.drawable.plus);

        temp1 = (TextView) findViewById(R.id.dTemp);
        temp2 = (TextView) findViewById(R.id.nTemp);

        bDPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dTemp = dTemp + 0.1f;
                if(dTemp >= 30.0) {
                    dTemp = 30.0;
                }
                temp1.setText(String.format("%.1f", dTemp) + " \u2103");
            }
        });

        bDMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dTemp = dTemp - 0.1f;
                if(dTemp <= 5.0) {
                    dTemp = 5.0;
                }
                temp1.setText(String.format("%.1f", dTemp) + " \u2103");
            }
        });
        bNPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nTemp = nTemp + 0.1f;
                if(nTemp >= 30.0) {
                    nTemp = 30.0;
                }
                temp2.setText(String.format("%.1f", nTemp) + " \u2103");
            }
        });

        bNMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nTemp = nTemp - 0.1f;
                if(nTemp <= 5.0) {
                    nTemp = 5.0;
                }
                temp2.setText(String.format("%.1f", nTemp) + " \u2103");
            }
        });

        /*Button applyTemp = (Button)findViewById(R.id.WeekOverview);
        Button applyPerm = (Button)findViewById(R.id.WebService);*/
    }
}
