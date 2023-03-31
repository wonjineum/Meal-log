package wonjin.eum.meal_log;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;




public class Amount extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.amount);
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Map<String, Object> meal = new HashMap<>();
        meal.put("waste_weight", "");
        meal.put("date", "");
        //meal.put("dinner", "");



        long mNow;
        Date mDate;
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyyMMdd");

        Date currentDate = Calendar.getInstance().getTime();


        Button btn1 = findViewById(R.id.btn_submit);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("meal")
                        .add(meal)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("AMOUNT >>>", "DocumentSnapshot added with ID:" + documentReference.getId());

                                String date = documentReference.getId(); //??
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("AMOUNT >>>", "Error adding document", e);
                            }
                        });
            }
        });

    }
}
