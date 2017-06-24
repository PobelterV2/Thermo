package minjinsong.thermostat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.net.ConnectException;

import util.HeatingSystem;


public class Thermostat extends AppCompatActivity {
    public static double temp, temp_current, temp_target, temp_day, temp_night;             //this should be retrieved from the server to show the current temp
    TextView temp1;
    double tTemp=18;
    boolean firstPull = false;

    TextView cTemp;
    TextView tTemp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);
        final TextView cTemp = (TextView)findViewById(R.id.cTemp);
        final TextView tTemp2 = (TextView)findViewById(R.id.tTemp);

        /*final Thread tempsPull = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        temp_current = Double.parseDouble(HeatingSystem.get("currentTemperature"));
                        if (!firstPull) {       //only retrieve these temps once at start
                            firstPull = true;
                            temp = temp_target;
                        }
                    } catch (ConnectException e) {
                        e.printStackTrace();
                    }

                    cTemp.post(new Runnable() {
                        @Override
                        public void run() {
                            cTemp.setText(String.valueOf(temp_current) + "\u2103");
                            tTemp2.setText(String.valueOf(temp) + " \u2103");
                        }
                    });
                }
            }
        });
        tempsPull.start();*/

        Button weekOverview = (Button) findViewById(R.id.WeekOverview);
        weekOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        Button WebService = (Button) findViewById(R.id.WebService);
        WebService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WebService.class);
                startActivity(intent);
            }
        });

        Button dnTemp = (Button) findViewById(R.id.dnTemp);
        dnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DayNightSetting.class);
                startActivity(intent);
            }
        });

        ImageView bTPlus = (ImageView) findViewById(R.id.bTPlus);
        bTPlus.setImageResource(R.drawable.plus);

        ImageView bTMinus = (ImageView) findViewById(R.id.bTMinus);
        bTMinus.setImageResource(R.drawable.minus);

        temp1 = (TextView) findViewById(R.id.tTemp);

        bTPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tTemp = tTemp + 0.1f;
                if (tTemp >= 30.0) {
                    tTemp = 30.0;
                }
                temp1.setText(String.format("%.1f", tTemp) + " \u2103");

            }
        });
        bTMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tTemp = tTemp - 0.1f;
                if (tTemp <= 5.0) {
                    tTemp = 5.0;
                }
                temp1.setText(String.format("%.1f", tTemp) + " \u2103");
            }
        });

    }
}
