package jwiktoruk.org.runner;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class SetCyclesActivity extends AppCompatActivity {

    EditText runEditText,walkEditText,cycleEditText;

    public static int runTime = 0;
    public static int walkTime = 0;
    public static int cycleCount = 0;

    public static final String preferences = "Ostatni zapis";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_cycles);

        runEditText = findViewById(R.id.runEditText);
        runEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count>0)
                    runTime = Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        walkEditText = findViewById(R.id.walkEditText);
        walkEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count>0)
                    walkTime = Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        cycleEditText = findViewById(R.id.cycleEditText);
        cycleEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(count>0)
                    cycleCount = Integer.parseInt(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        sharedPreferences = getSharedPreferences(preferences, Context.MODE_PRIVATE);

        findViewById(R.id.cyclesView_layout).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                return true;
            }
        });


    }

    private boolean isValuesChanges(){
        if(runTime==0 & walkTime==0 & cycleCount==0) return false;
        else return true;
    }

    private void saveData(){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("Run",runTime);
        editor.putInt("Walk",walkTime);
        editor.putInt("Cycle",cycleCount);

        editor.commit();
        Toast.makeText(SetCyclesActivity.this,"Zapisano",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isValuesChanges())
            saveData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(isValuesChanges())
            saveData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isValuesChanges())
            saveData();
    }
}
