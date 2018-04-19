package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    String msg = "Android : ";
    Button b1,b2;


    /*Called when the activity is first created*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.example.com"));
                startActivity(i);
            }
        });

        b2 = (Button)findViewById(R.id.button6);
        b2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,CustomActivity.class);
                startActivity(i);
            }
        });

        Log.d(msg,"The onCreate() event");
    }

    public void onClickAddName(View view){
        //Add new student record

        ContentValues values = new ContentValues();
        values.put(StudentProvider.NAME,
                ((EditText)findViewById(R.id.editText2)).getText().toString());
        values.put(StudentProvider.GRADE,
                ((EditText)findViewById(R.id.editText3)).getText().toString());

        Uri uri = getContentResolver().insert(StudentProvider.CONTENT_URI,values);
        Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_LONG).show();

    }

    public void onClickRetriveStudents(View view){
        String URL = "content://com.example.user.myapplication.StudentProvider";

        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students,null,null,null,"name");

        if (c.moveToFirst()){
            do{
                Toast.makeText(this,
                c.getString(c.getColumnIndex(StudentProvider._ID))+
                        ", "+c.getString(c.getColumnIndex(StudentProvider.NAME))+
                        ", "+c.getString(c.getColumnIndex(StudentProvider.GRADE)),
                Toast.LENGTH_SHORT).show();
            }while(c.moveToNext());
        }
    }

    public void startService(View view){
        startService(new Intent(getBaseContext(),MyService.class));
    }

    public void stopService(View view){
        stopService(new Intent(getBaseContext(),MyService.class));
    }

    /*Called when the activity is about to become visible*/
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg,"The onStart() event");
    }

    /*Called when the activity has become visible*/
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg,"The onResume() event");
    }

    /*Called when another activity has become visible*/
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg,"The onPause() event");
    }

    /*Called when the activity is no longer visible*/
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg,"The onStop() event");
    }

    /*Called just before the activity is destroyed*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(msg,"The onStop() event");
    }
}

