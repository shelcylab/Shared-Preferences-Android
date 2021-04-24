package com.alqaraghuli.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    EditText empNameET;
    EditText jobTitleET;
    EditText phoneET;
    Employee employee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        empNameET = findViewById(R.id.et_name);
        jobTitleET = findViewById(R.id.et_job_title);
        phoneET = findViewById(R.id.et_phone);

        employee = new Employee();

        //Load the SharedPref data and populate in object and fields
        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        String json = preferences.getString("EMPLOYEE_DATA","");
        if(json.length()>0) {
            Gson gson = new Gson();
            employee = gson.fromJson(json,Employee.class);
            empNameET.setText(employee.name);
            jobTitleET.setText(employee.jobTitle);
            phoneET.setText(employee.phone);
        }
        
//        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
//        String text = preferences.getString("EDITED_TEXT","No text");
//        et.setText(text);
    }

    public void saveClicked(View view) {
        //Save the ET string into SharedPref
        employee.name = empNameET.getText().toString();
        employee.jobTitle = jobTitleET.getText().toString();
        employee.phone = phoneET.getText().toString();

        Gson gson = new Gson();
        String json = gson.toJson(employee);
        Log.d("aaq", "saveClicked: "+json);

        SharedPreferences preferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("EMPLOYEE_DATA",json);
        editor.apply();
    }
}