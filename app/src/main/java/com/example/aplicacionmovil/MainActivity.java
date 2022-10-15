package com.example.aplicacionmovil;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private ImageView btngoogle;
    private ImageView btnfacebook;
    private ImageView btntwitter;

    String _urlgoogle = "https://www.google.com/?hl=es";
    String _urlfacebook ="https://www.facebook.com/";
    String _urltwitter = "https://twitter.com/home?lang=es";

    public void NextActivity(View view) {
        Intent intent = new Intent(this, activity_registro.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btngoogle = findViewById(R.id.google);
        btnfacebook = findViewById(R.id.facebook);
        btntwitter = findViewById(R.id.twitter);

        btngoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri linkgoogle = Uri.parse(_urlgoogle);
                Intent i = new Intent(Intent.ACTION_VIEW,linkgoogle);
                startActivity(i);

            }
        });
        btnfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri linkfacebook = Uri.parse(_urlfacebook);
                Intent i = new Intent(Intent.ACTION_VIEW,linkfacebook);
                startActivity(i);
            }
        });
        btntwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri linktwitter = Uri.parse(_urltwitter);
                Intent i = new Intent(Intent.ACTION_VIEW,linktwitter);
                startActivity(i);
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.item1){
   NextActivity1();
        }else if (id == R.id.item2){
            NextActivity2();
        }else if (id == R.id.item3){
        NextActivity3();
    }
return super.onOptionsItemSelected(item);
    }
    public void NextActivity1(){
        Intent intent = new Intent(this, Activityitem1.class);
        startActivity(intent);
    }
    public void NextActivity2(){
        Intent intent = new Intent(this, Activityitem2.class);
        startActivity(intent);
    }
    public void NextActivity3(){
        Intent intent = new Intent(this, Activityitem3.class);
        startActivity(intent);
    }
 



}

