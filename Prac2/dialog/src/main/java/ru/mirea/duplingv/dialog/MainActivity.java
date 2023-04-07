package ru.mirea.duplingv.dialog;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar dateAndTime = Calendar.getInstance();
    String currentDateTime;
    ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onClickShowDialog(View view){
        DialogFragment dialogFragment = new DialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "mirea");
    }

    public void onClickShowProgressDialog(View view){
        progressdialog = new ProgressDialog(this);
        progressdialog.setTitle("Please Wait");
        progressdialog.setMessage("Loading");
        progressdialog.setButton(Dialog.BUTTON_POSITIVE,
                "Skip time",
                (dialog, which) -> Snackbar.make(view, "Success", Snackbar.LENGTH_LONG).show());
        progressdialog.show();
    }

    public void onClickShowTimeDialog(View view){
        new TimePickerDialog(MainActivity.this, timeSetListener,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE),
                false)
                .show();
    }

    TimePickerDialog.OnTimeSetListener timeSetListener = (view, hourOfDay, minute) -> {
        dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        dateAndTime.set(Calendar.MINUTE, minute);
        setCurrentDateTime();
    };

    public void setCurrentDateTime(){
        currentDateTime = DateUtils.formatDateTime( this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_TIME | DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR);
    }
    public void onClickShowDateDialog(View view){
        new DatePickerDialog(this, dateSetListener,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    DatePickerDialog.OnDateSetListener dateSetListener = (view, year, month, dayOfMonth) -> {
        dateAndTime.set(Calendar.YEAR, year);
        dateAndTime.set(Calendar.MONTH, month);
        dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        setCurrentDateTime();
    };

}