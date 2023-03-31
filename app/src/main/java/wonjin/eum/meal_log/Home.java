package wonjin.eum.meal_log;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.home);


        Button btn1 = findViewById(R.id.btn_calender);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, Month.class);
                startActivity(it);
            }
        });

        Button btn2 = findViewById(R.id.btn_profile);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, Profile.class);
                startActivity(it);
            }
        });

        Button btn3 = findViewById(R.id.btn_points);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, Points.class);
                startActivity(it);
            }
        });

        Button btn4 = findViewById(R.id.btn_menu);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, Menu.class);
                startActivity(it);
            }
        });

        Button btn5 = findViewById(R.id.btn_stats);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, Stats.class);
                startActivity(it);
            }
        });

        Button btn6 = findViewById(R.id.btn_amount);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Home.this, Amount.class);
                startActivity(it);
            }
        });



    }
}
