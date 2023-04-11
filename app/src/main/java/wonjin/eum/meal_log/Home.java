package wonjin.eum.meal_log;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Home extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 123;
    ImageView click_image_id;
    ImageView click_image_id1;
    ImageView click_image_id2;

    private static final int pic_id = 123;
    private static final int pic_id1 = 1234;
    private static final int pic_id3 = 12345;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        TextView userId = findViewById(R.id.username);

        String it = getIntent().getStringExtra("UID");
        if (it == null){
            userId.setText("Welcome! please login");
        }else {userId.setText(it);
        }

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
                //Intent it = new Intent(Home.this, Menu.class);
                Uri webpage = Uri.parse("https://stevensonschool.flikisdining.com/menu/stevenson-school");
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                startActivity(intent);
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
        click_image_id = findViewById(R.id.pic_id);
        TextView tv6 = findViewById(R.id.textView4);
        Button btn7 = findViewById(R.id.btn_photo1);
        btn7.setOnClickListener(v -> {
            btn7.setVisibility(View.GONE);
            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(500,500);
            click_image_id.setLayoutParams(parms);
            tv6.setVisibility(View.GONE);
            actionCam(pic_id);
        });
        click_image_id1 = findViewById(R.id.pic_id1);
        TextView tv66 = findViewById(R.id.textView5);
        Button btn77 = findViewById(R.id.btn_photo2);
        btn77.setOnClickListener(v -> {
            btn77.setVisibility(View.GONE);
            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(500,500);
            click_image_id1.setLayoutParams(parms);
            tv66.setVisibility(View.GONE);
            actionCam(pic_id1);
        });
        click_image_id2 = findViewById(R.id.pic_id3);
        TextView tv666 = findViewById(R.id.textView6);
        Button btn777 = findViewById(R.id.btn_photo3);
        btn777.setOnClickListener(v -> {
            btn777.setVisibility(View.GONE);
            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(500,500);
            click_image_id2.setLayoutParams(parms);
            tv666.setVisibility(View.GONE);
            actionCam(pic_id3);
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Match the request 'pic id with requestCode
        if (requestCode == pic_id) {
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            click_image_id.setImageBitmap(photo);
        }else if (requestCode == pic_id1){
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            click_image_id1.setImageBitmap(photo);
        }else if (requestCode == pic_id3){
            // BitMap is data structure of image file which store the image in memory
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            // Set the image in imageview for display
            click_image_id2.setImageBitmap(photo);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void actionCam(int id){
        if (ContextCompat.checkSelfPermission(Home.this,
                Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //권한이 부여되면 PERMISSION_GRANTED 거부되면 PERMISSION_DENIED 리턴

//권한 요청 할 필요가 있는가?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Home.this,
                    Manifest.permission.CAMERA)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                //권한 요청을 해야할 필요가 있는 경우(사용자가 DONT ASK ME AGIAN CHECK + DENY 선택)

                ActivityCompat.requestPermissions(Home.this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                //requestPermissions 메소드는 비동기적으로 동작한다. 왜냐면 이 권한 검사 및 요청 메소드는
                //메인 액티비티에서 동작하기떄문에(메인쓰레드) 사용자 반응성이 굉장히 중요한 파트이다. 여기서 시간을
                //오래 끌어버리면 사람들이 답답함을 느끼게 된다. requestPermissions의 결과로 콜백 메소드인
                //onRequestPermissionsResult()가 호출된다. 오버라이딩 메소드이다. Ctrl+O

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }
        // Create the camera_intent ACTION_IMAGE_CAPTURE it will open the camera for capture the image
        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Start the activity with camera_intent, and request pic id
        switch (id){
            case pic_id:
                startActivityForResult(camera_intent, pic_id);
                break;
            case pic_id1:
                startActivityForResult(camera_intent, pic_id1);
                break;
            case pic_id3:
                startActivityForResult(camera_intent, pic_id3);
                break;
        }


    }

}
