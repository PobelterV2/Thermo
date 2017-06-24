package minjinsong.thermostat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by Minjin Song (Alex) on 2017-06-21.
 */

public class WeekOverview extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_overview);

        Button monday = (Button) (findViewById(R.id.Monday));
        Button tuesday = (Button) (findViewById(R.id.Tuesday));
        Button wednesday = (Button) (findViewById(R.id.Wednesday));
        Button thursday = (Button) (findViewById(R.id.Thursday));
        Button friday = (Button) (findViewById(R.id.Friday));
        Button saturday = (Button) (findViewById(R.id.Saturday));
        Button sunday = (Button) (findViewById(R.id.Sunday));

        monday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MondaySetting.class);
                startActivity(intent);
            }
        });
        tuesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TuesdaySetting.class);
                startActivity(intent);
            }
        });
        wednesday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WednesdaySetting.class);
                startActivity(intent);
            }
        });
        thursday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ThursdaySetting.class);
                startActivity(intent);
            }
        });
        friday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), FridaySetting.class);
                startActivity(intent);
            }
        });
        saturday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SaturdaySetting.class);
                startActivity(intent);
            }
        });
        sunday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), SundaySetting.class);
                startActivity(intent);
            }
        });
    }
}