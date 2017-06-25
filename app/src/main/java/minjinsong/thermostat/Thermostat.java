package minjinsong.thermostat;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import util.*;
import java.net.ConnectException;

import util.HeatingSystem;


public class Thermostat extends AppCompatActivity {
    public static double temp, temp_current, temp_target, temp_day, temp_night;             //this should be retrieved from the server to show the current temp
<<<<<<< HEAD
    TextView tTemp1, dTemp1, nTemp1;
    double tTemp = 18;
    double dTemp, nTemp;
=======
    TextView temp1;
    double tTemp = 18;
>>>>>>> 76e7ee935c6878d6105e74cbdaa630d9efcdfde9
    boolean firstPull = false;

    TextView cTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermostat);
        cTemp = (TextView) findViewById(R.id.cTemp);
<<<<<<< HEAD

        final ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);
        final TextView text1 = (TextView) findViewById(R.id.text1);
        final TextView text2 = (TextView) findViewById(R.id.text2);
        final ToggleButton vacation = (ToggleButton) findViewById(R.id.permChange);
        final Switch dNSwitch = (Switch) findViewById(R.id.dNSwitch);
        final Button applyTemp = (Button) findViewById(R.id.applyTemp);
        final ToggleButton weekState = (ToggleButton)findViewById(R.id.weekState);
=======
        tTemp2 = (TextView) findViewById(R.id.tTemp);

>>>>>>> 76e7ee935c6878d6105e74cbdaa630d9efcdfde9
        final Thread tempsPull = new Thread(new Runnable() {
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
                        }
                    });
                }
            }
        });
        tempsPull.start();

        final Button weekOverview = (Button) findViewById(R.id.WeekOverview);
        weekOverview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WeekOverview.class);
                startActivity(intent);
            }
        });

        final Button WebService = (Button) findViewById(R.id.WebService);
        WebService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WebService.class);
                startActivity(intent);
            }
        });

        /*Button dnTemp = (Button) findViewById(R.id.dnTemp);
        dnTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DayNightSetting.class);
                startActivity(intent);
            }
        });*/

        ImageView bTPlus = (ImageView) findViewById(R.id.bTPlus);
        bTPlus.setImageResource(R.drawable.plus);

        ImageView bTMinus = (ImageView) findViewById(R.id.bTMinus);
        bTMinus.setImageResource(R.drawable.minus);

        tTemp1 = (TextView) findViewById(R.id.tTemp);
        dTemp1 = (TextView) findViewById(R.id.dTemp);
        nTemp1 = (TextView) findViewById(R.id.nTemp);

        weekState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton toggleButton, boolean isChecked) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            if (weekState.isChecked()) {
                                HeatingSystem.put("weekProgramState", "on");
                            } else if (!weekState.isChecked()) {
                                HeatingSystem.put("weekProgramState", "off");
                            }
                        } catch (InvalidInputValueException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });

        bTPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tTemp < 30) {
                    if (vacation.isChecked()) {
                        if (dNSwitch.isChecked()) {
                            nTemp += 0.1f;
                            temp = nTemp;
                        } else {
                            dTemp += 0.1f;
                            temp = dTemp;
                        }
                    } else {
                        tTemp += 0.1f;
                        temp = tTemp;
                    }
                    if (!vacation.isChecked()) {
                        if (dNSwitch.isChecked()) {
                            nTemp += 0.1f;
                            temp = nTemp;
                        } else {
                            dTemp += 0.1f;
                            temp = dTemp;
                        }
                    } else {
                        tTemp += 0.1f;
                        temp = tTemp;
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "You cannot set your temperature over 30" + "\u2103.", Toast.LENGTH_SHORT).show();
                }
                tTemp1.setText(String.format("%.1f", tTemp) + " \u2103");
                if (tTemp >= 30.0) {
                    tTemp = 30.0;
                }
                applyTemp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if (vacation.isChecked()) {
                                        if (dNSwitch.isChecked()) {
                                            HeatingSystem.put("nightTemperature", String.valueOf(temp));
                                        } else {
                                            HeatingSystem.put("dayTemperature", String.valueOf(temp));
                                        }
                                    } else {
                                        HeatingSystem.put("targetTemperature", String.valueOf(temp));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                    }
                });
            }
        });

        bTMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tTemp > 5) {
                    if (vacation.isChecked()) {
                        if (dNSwitch.isChecked()) {
                            nTemp -= 0.1f;
                            temp = nTemp;
                        } else {
                            dTemp -= 0.1f;
                            temp = dTemp;
                        }
                    } else {
                        tTemp -= 0.1f;
                        temp = tTemp;
                    }
                    if (!vacation.isChecked()) {
                        if (dNSwitch.isChecked()) {
                            nTemp -= 0.1f;
                            temp = nTemp;
                        } else {
                            dTemp -= 0.1f;
                            temp = dTemp;
                        }
                    } else {
                        tTemp -= 0.1f;
                        temp = tTemp;
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "You cannot set your temperature below 5" + "\u2103.", Toast.LENGTH_SHORT).show();
                }
                tTemp1.setText(String.format("%.1f", tTemp) + " \u2103");
                if (tTemp <= 5.0) {
                    tTemp = 5.0;
                }
                applyTemp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    if (vacation.isChecked()) {
                                        if (dNSwitch.isChecked()) {
                                            HeatingSystem.put("nightTemperature", String.valueOf(temp));
                                        } else {
                                            HeatingSystem.put("dayTemperature", String.valueOf(temp));
                                        }
                                    } else {
                                        HeatingSystem.put("targetTemperature", String.valueOf(temp));
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                    }
                });
            }
        });
    }
}

