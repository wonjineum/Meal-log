package wonjin.eum.meal_log;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

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
        String it = getIntent().getStringExtra("UID");

        long mNow;
        Date mDate;
        SimpleDateFormat mFormat = new SimpleDateFormat("yyyyMMdd");
        Date currentDate = Calendar.getInstance().getTime();

        EditText edt = findViewById(R.id.edt_amount);
        Button btn1 = findViewById(R.id.btn_submit);

        Map<String, Object> meal = new HashMap<>();
        meal.put("waste_weight", "60");

        db.collection("meal").document("20230331")
                .set(meal)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.w("INPUT >>>", "success");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("INPUT >>>", "Error adding document", e);
                    }
                });
        // Log.w
        //meal.put("dinner", "");







        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.collection("meal").document("041223")
                        .set(meal)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Log.w("AMOUNT >>>", "success");
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("AMOUNT >>>", "Error adding document", e);
                            }
                        });

                /*
                db.collection("meal")
                        .add(Integer.valueOf())
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("WASTE >>>", "DocumentSnapshot added with ID: " + documentReference.getId());
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w("WASTE >>>", "Error adding document", e);
                            }
                        });

                 */
            }
        });

    }
}
