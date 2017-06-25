package minjinsong.thermostat;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;


import org.w3c.dom.Text;

import java.util.Calendar;

/**
 * Created by Minjin Song (Alex) on 2017-06-23.
 */

public class MondaySetting extends AppCompatActivity {
    public static String dSwitchTime;
    public static String nSwitchTime;
    final int DAY_DIALOG_TIME = 1;
    final int NIGHT_DIALOG_TIME = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monday_setting);

        Button b1 = (Button) findViewById(R.id.dEdit);
        Button b2 = (Button) findViewById(R.id.nEdit);
        Button apply = (Button) findViewById(R.id.applyTime);
        Button cancel = (Button) findViewById(R.id.cancel);


        b1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showDialog(DAY_DIALOG_TIME);
            }
        });
        b2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                showDialog(NIGHT_DIALOG_TIME);
            }
        });

        apply.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {

            }

        });

        cancel.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
    } // end of onCreate

    @Override
    @Deprecated
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DAY_DIALOG_TIME:
                TimePickerDialog tpd1 = new TimePickerDialog(MondaySetting.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView dSwitch = (TextView) findViewById(R.id.dSwitch);
                        if (hourOfDay < 10 && minute < 10) {
                            dSwitch.setText("0" + hourOfDay + ":" + "0" + minute);
                        } else if (hourOfDay < 10 && minute >= 10) {
                            dSwitch.setText("0" + hourOfDay + ":" + minute);
                        } else if (hourOfDay >= 10 && minute < 10) {
                            dSwitch.setText(hourOfDay + ":" + "0" + minute);
                        } else {
                            dSwitch.setText(hourOfDay + ":" + minute);
                        }
                        if (hourOfDay < 10 && minute < 10) {
                            Toast.makeText(getApplicationContext(), "You have selected 0" + hourOfDay + ":0" + minute, Toast.LENGTH_SHORT).show();
                        } else if (hourOfDay < 10 && minute >= 10) {
                            Toast.makeText(getApplicationContext(), "You have selected 0" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                        } else if (hourOfDay >= 10 && minute < 10) {
                            Toast.makeText(getApplicationContext(), "You have selected " + hourOfDay + ":0" + minute, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "You have selected " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                        }
                        if (hourOfDay < 10 && minute < 10) {
                            dSwitchTime = ("0" + hourOfDay + ":" + "0" + minute);
                        } else if (hourOfDay < 10 && minute >= 10) {
                            dSwitchTime = ("0" + hourOfDay + ":" + minute);
                        } else if (hourOfDay >= 10 && minute < 10) {
                            dSwitchTime = (hourOfDay + ":" + "0" + minute);
                        } else {
                            dSwitchTime = (hourOfDay + ":" + minute);
                        }
                    }
                }, 12, 00, true);
                return tpd1;
            case NIGHT_DIALOG_TIME:
                TimePickerDialog tpd2 = new TimePickerDialog(MondaySetting.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        TextView nSwitch = (TextView) findViewById(R.id.nSwitch);
                        if (hourOfDay < 10 && minute < 10) {
                            nSwitch.setText("0" + hourOfDay + ":" + "0" + minute);
                        } else if (hourOfDay < 10 && minute >= 10) {
                            nSwitch.setText("0" + hourOfDay + ":" + minute);
                        } else if (hourOfDay >= 10 && minute < 10) {
                            nSwitch.setText(hourOfDay + ":" + "0" + minute);
                        } else {
                            nSwitch.setText(hourOfDay + ":" + minute);
                        }
                        if (hourOfDay < 10 && minute < 10) {
                            Toast.makeText(getApplicationContext(), "You have selected 0" + hourOfDay + ":0" + minute, Toast.LENGTH_SHORT).show();
                        } else if (hourOfDay < 10 && minute >= 10) {
                            Toast.makeText(getApplicationContext(), "You have selected 0" + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                        } else if (hourOfDay >= 10 && minute < 10) {
                            Toast.makeText(getApplicationContext(), "You have selected " + hourOfDay + ":0" + minute, Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "You have selected " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                        }
                        if (hourOfDay < 10 && minute < 10) {
                            dSwitchTime = ("0" + hourOfDay + ":" + "0" + minute);
                        } else if (hourOfDay < 10 && minute >= 10) {
                            dSwitchTime = ("0" + hourOfDay + ":" + minute);
                        } else if (hourOfDay >= 10 && minute < 10) {
                            dSwitchTime = (hourOfDay + ":" + "0" + minute);
                        } else {
                            dSwitchTime = (hourOfDay + ":" + minute);
                        }
                    }
                }, 12, 00, true);
                return tpd2;
        }
        return super.onCreateDialog(id);
    }
}
