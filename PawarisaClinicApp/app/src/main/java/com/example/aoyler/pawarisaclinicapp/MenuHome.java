package com.example.aoyler.pawarisaclinicapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by aoyler on 7/4/2559.
 */
public class MenuHome extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_home);
        final ImageView btn1 = (ImageView) findViewById(R.id.imageView6);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), com.example.aoyler.pawarisaclinicapp.Calendar_female.class);
                startActivity(intent1);
            }
        });

        final ImageView btn2 = (ImageView) findViewById(R.id.imageView7);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), com.example.aoyler.pawarisaclinicapp.Notifications.class);
                startActivity(intent2);

            }
        });
        final ImageView btn3 = (ImageView) findViewById(R.id.imageView8);
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), Search.class);
                startActivity(intent3);

            }
        });
        /*final Button btn1 = (Button) findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");
                startActivity(intent);

            }


        });*/
    }

    public void onBackPressed() {

        Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent1);
        finish();


    }
}
