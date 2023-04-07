package ru.mirea.duplingv.toastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCreateToast(View view) {
        EditText editText = (EditText)findViewById(R.id.editTextTextPersonName);
        String text = "DUPLIN GLEB 11 BSBO-03-20 Количество символов - " + editText.getText().length();
        Toast toast = Toast.makeText(getApplicationContext(),
                text,
                Toast.LENGTH_LONG);
        toast.show();
    }
}