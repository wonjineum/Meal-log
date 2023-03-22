package wonjin.eum.meal_log;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.firestore.FirebaseFirestore;

public class Month2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.month_2);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        //read data , users 를 meal 로 바꾸기

    }
}
