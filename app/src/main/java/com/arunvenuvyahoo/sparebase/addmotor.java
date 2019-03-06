package com.arunvenuvyahoo.sparebase;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class addmotor extends AppCompatActivity {

    Toolbar toolbar1;
    EditText motorMAke;
    EditText motorLocation;
    EditText motorDetails;
    Spinner machine;
    Button buttonSave;
    DatabaseReference dbMotor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addmotor);

        motorMAke = (EditText)findViewById(R.id.motorMake);
        motorLocation = (EditText)findViewById(R.id.motorLocation);
        motorDetails = (EditText)findViewById(R.id.motorDetails);
        machine = (Spinner)findViewById(R.id.machine);
        buttonSave = (Button)findViewById(R.id.buttonSave);


        dbMotor = FirebaseDatabase.getInstance().getReference("Motor");


        toolbar1 = findViewById(R.id.toolbar1);
        toolbar1.setTitle("Motor details");
        setSupportActionBar(toolbar1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                motor();
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void motor(){
        String make = motorMAke.getText().toString().trim();
        String location = motorLocation.getText().toString().trim();
        String details = motorDetails.getText().toString().trim();
        String mc = machine.getSelectedItem().toString();

        if (!TextUtils.isEmpty(make)&& !TextUtils.isEmpty(location)&&!TextUtils.isEmpty(details)){
            String id = dbMotor.push().getKey();

            Motor motor = new Motor(make,location,details,mc);
            dbMotor.child(id).setValue(motor);
            Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Enter all fields", Toast.LENGTH_LONG).show();
        }
    }
}
