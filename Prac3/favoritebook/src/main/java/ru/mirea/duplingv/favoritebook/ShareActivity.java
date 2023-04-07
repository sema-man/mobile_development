package ru.mirea.duplingv.favoritebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ShareActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            TextView textViewBook = findViewById(R.id.textView);
            String bookName = getIntent().getExtras().getString(MainActivity.KEY);
            textViewBook.setText(String.format("Моя любимая книга: %s", bookName));
        }

    }

    public void onClickSendData(View view) {
        Intent data = new Intent();
        EditText editText = (EditText) findViewById(R.id.editTextBookName);
        data.putExtra(MainActivity.USER_MESSAGE, String.format("Название вашей любимой книги: %s",
                editText.getText().toString()));
        setResult(Activity.RESULT_OK, data);
        finish();
    }
}