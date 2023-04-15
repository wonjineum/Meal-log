package wonjin.eum.meal_log;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Month extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.month);

        DatePicker datePicker = (DatePicker) findViewById(R.id.datePicker);
        Button to2 =(Button) findViewById(R.id.calBtn);
        TextView tv1;


        datePicker.init(2022, 12, 2, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = String.valueOf(year) +" "+ String.valueOf(dayOfMonth);
                to2.setText(date);
            }
        });

        to2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Month.this, Month2.class);
                startActivity(it);
            }
        });


    }
}
