package wonjin.eum.meal_log;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Points extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Button btn1 = findViewById(R.id.btn_submit2);
        String num = String.valueOf(db.collection("verify").get());
        String inputNum = String.valueOf(findViewById(R.id.inputText));
        TextView tv1 = findViewById(R.id.num);

        db.collection("verify")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d("VERIFY >>>", document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w("VERIFY >>>", "Error getting documents.", task.getException());
                        }
                    }
                });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                db.collection("meal").document("20230331");
                        //.set(verify)
                if (num == inputNum) {
                    String points = "1";
                    tv1.setText(points);
                }
            }
        });




        setContentView(R.layout.points);
    }
}
