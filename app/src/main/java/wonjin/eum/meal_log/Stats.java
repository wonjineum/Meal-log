package wonjin.eum.meal_log;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class Stats extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.stats);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        TextView tv1 = findViewById(R.id.display);

        db.collection("meal")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("STATS >>>", document.getId() + " => " + document.getData());

                                //textView에 data display
                                 Map display = document.getData();
                                 String display2 = display.
                                 tv1.setText(display);
                            }
                        } else {
                            Log.w("STATS >>>", "Error getting documents.", task.getException());
                        }
                    }
                });

        //add data
        /*
        Map<String, Object> meal = new HashMap<>();
        meal.put("breakfast", "");
        meal.put("lunch", "");
        meal.put("dinner", "");

        db.collection("meal")
                .add(meal)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("HI", "DocumentSnapshot added with ID:" + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("HELLO", "Error adding document", e);
                    }
                });
        */
    }
}
