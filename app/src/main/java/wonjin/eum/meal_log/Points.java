package wonjin.eum.meal_log;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.util.Assert;

import java.util.Objects;

public class Points extends AppCompatActivity {
    public String num;
    public String inputNum;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.points);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Button btn1 = findViewById(R.id.btn_submit2);
        TextView tv1 = findViewById(R.id.num);
        EditText edt = findViewById(R.id.edt);
        //TextInputEditText edt1 = findViewById(R.id.btn_submit3);
        //define edittext object



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputNum = '[' + edt.getText().toString() + ']'; //edittext text
                Log.d("inputnum >>>", inputNum);
                db.collection("verify")
                        .get()
                        .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if (task.isSuccessful()) {
                                    for (QueryDocumentSnapshot document : task.getResult()) {
                                        Log.d("VERIFY >>>", document.getId() + " => " + document.getData());
                                        num = document.getData().values().toString();
                                        if (num == null){
                                            Log.e("NUM >> ", num);
                                            break;
                                        }

                                        Log.d("num >>>", num);
                                        if (num.equals( inputNum)) {
                                            Log.d("IF >>>", "entered if statement");
                                            Integer temp = Integer.parseInt((String) tv1.getText().toString())+1;
                                            //+1 tv1.getText();
                                            tv1.setText(String.valueOf(temp));

                                        }

                                    }
                                } else {
                                    Log.w("VERIFY >>>", "Error getting documents.", task.getException());
                                }
                            }
                        });


            }
        });





    }
}
