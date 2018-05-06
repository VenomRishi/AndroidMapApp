package com.example.acer.googlemap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MedicalRecord extends AppCompatActivity {
    EditText txtAllergies,txtMedCond,txtMedication,txtPregnent,txtMedAll,txtMFCI;
    Spinner spinnerSL;
    Button btnSaveNext2;
    TextView txtFullname;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_record);

        databaseReference= FirebaseDatabase.getInstance().getReference("register");

        txtAllergies=(EditText) findViewById(R.id.txtAllergies);
        txtMedCond=(EditText) findViewById(R.id.txtMedCond);
        txtMedication=(EditText) findViewById(R.id.txtMedication);
        txtPregnent=(EditText) findViewById(R.id.txtPregnent);
        txtMedAll=(EditText) findViewById(R.id.txtMedAll);
        txtMFCI=(EditText) findViewById(R.id.txtMFCI);
        spinnerSL=(Spinner) findViewById(R.id.spinnerSL);
        btnSaveNext2=(Button) findViewById(R.id.btnSaveNext2);

        txtFullname=(TextView) findViewById(R.id.txtFullname);
        Intent i=getIntent();
        String fname=i.getStringExtra("fname");
        String lname=i.getStringExtra("lname");

        txtFullname.setText("Welcome: "+fname+" "+lname);


        btnSaveNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMedRecord();
            }
        });
    }
    public void addMedRecord(){
        String allergies=txtAllergies.getText().toString();
        String medcond=txtMedCond.getText().toString();
        String medication=txtMedication.getText().toString();
        String pregnent=txtPregnent.getText().toString();
        //ma=medicineAllergies mfci=MedForChronicIllness
        String ma=txtMedAll.getText().toString();
        String mfci=txtMFCI.getText().toString();
        String language=spinnerSL.getSelectedItem().toString();

        if(!TextUtils.isEmpty(allergies)) {
            //String id=databaseReference.push().getKey();
            Intent i = getIntent();
            String id = i.getStringExtra("id");
            String fname = i.getStringExtra("fname");
            String lname = i.getStringExtra("lname");
            String dob = i.getStringExtra("dob");
            String gen = i.getStringExtra("gen");
            String mobile = i.getStringExtra("mobile");
            String altmobile = i.getStringExtra("altmobile");
            String email = i.getStringExtra("email");
            String bg = i.getStringExtra("bg");
            String password = i.getStringExtra("password");
            MedRegister mdRegister = new MedRegister(allergies, medcond, medication, pregnent, ma, mfci, language);
            databaseReference.child(id).child("Medical Record").setValue(mdRegister);
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
            Intent i2=new Intent(MedicalRecord.this,MapActivity.class);
            i2.putExtra("fname",fname);
            i2.putExtra("lname",lname);
            startActivity(i2);
        }
    }
}

