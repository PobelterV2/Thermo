package minjinsong.thermostat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import util.*;

public class WebService extends AppCompatActivity{
    Button getdata;
    TextView cTemp, tTemp, time, day, programState, dTemp, nTemp;
    String getParam, getParam1, getParam2, getParam3, getParam4, getParam5, getParam6, oldv, newv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_service);

        /* Use BASE_ADDRESS dedicated for your group,
		 * change 100 to you group number
		 */
        HeatingSystem.BASE_ADDRESS = "http://wwwis.win.tue.nl/2id40-ws/46";
        HeatingSystem.WEEK_PROGRAM_ADDRESS = HeatingSystem.BASE_ADDRESS + "/weekProgram";

        getdata = (Button) findViewById(R.id.getData);
        cTemp = (TextView) findViewById(R.id.cTempServer);
        tTemp = (TextView) findViewById(R.id.tTempServer);
        time = (TextView) findViewById(R.id.timeServer);
        day = (TextView) findViewById(R.id.day);
        programState = (TextView) findViewById(R.id.weekProgramStateServer);
        dTemp = (TextView) findViewById(R.id.dTemp);
        nTemp = (TextView) findViewById(R.id.nTemp);

        /* When the user clicks on GET Data button the value of the corresponding parameter is read from the server
        and displayed in TextView data1
         */
        getdata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        getParam = "";
                        try {
                            getParam = HeatingSystem.get("currentTemperature");
                            getParam1 = HeatingSystem.get("targetTemperature");
                            getParam2 = HeatingSystem.get("day");
                            getParam3 = HeatingSystem.get("time");
                            getParam4 = HeatingSystem.get("weekProgramState");
                            getParam5 = HeatingSystem.get("dayTemperature");
                            getParam6 = HeatingSystem.get("nightTemperature");

                            cTemp.post(new Runnable() {
                                @Override
                                public void run() {
                                    cTemp.setText(getParam + "\u2103");
                                }
                            });
                            tTemp.post(new Runnable() {
                                @Override
                                public void run() {
                                    tTemp.setText(getParam1 + "\u2103");
                                }
                            });
                            day.post(new Runnable() {
                                @Override
                                public void run() {
                                    day.setText(getParam2);
                                }
                            });
                            time.post(new Runnable() {
                                @Override
                                public void run() {
                                    time.setText(getParam3);
                                }
                            });
                            programState.post(new Runnable() {
                                @Override
                                public void run() {
                                    programState.setText(getParam4);
                                }
                            });
                            dTemp.post(new Runnable() {
                                @Override
                                public void run() {
                                    dTemp.setText(getParam5 + "\u2103");
                                }
                            });
                            nTemp.post(new Runnable() {
                                @Override
                                public void run() {
                                    nTemp.setText(getParam6 + "\u2103");
                                }
                            });

                        } catch (Exception e) {
                            System.err.println("Error from getdata " + e);
                        }
                    }
                }).start();
            }
        });

        /* When the user clicks on PUT Data button the old value of the corresponding parameter is read from the server
        and displayed in TextView data1, the new uploaded value is displayed in TextView data2
         */
    }
}