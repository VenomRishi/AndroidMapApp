package com.example.acer.googlemap2;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity {

    EditText txtFname,txtLname,txtDate,txtMobile,txtAltMobile,txtEmail,txtPassword;
    Spinner spinnerGender,spinnerBG;
    Button btnSaveNext1, btnSeeRecord;
    DatabaseReference databaseRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        databaseRegister= FirebaseDatabase.getInstance().getReference("register");

        txtFname=(EditText) findViewById(R.id.txtFname);
        txtLname=(EditText) findViewById(R.id.txtLname);
        txtDate=(EditText) findViewById(R.id.txtDate);
        txtMobile=(EditText) findViewById(R.id.txtMobile);
        txtAltMobile=(EditText) findViewById(R.id.txtAltMobile);
        txtEmail=(EditText) findViewById(R.id.txtEmail);
        txtPassword=(EditText) findViewById(R.id.txtPassword);
        spinnerGender=(Spinner) findViewById(R.id.spinnerGender);
        spinnerBG=(Spinner) findViewById(R.id.spinnerBG);
        btnSaveNext1=(Button) findViewById(R.id.btnSaveNext1);

        btnSaveNext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addRegister();
            }
        });
        Button btnAdminLogin=(Button) findViewById(R.id.btnAdminLogin);
        btnAdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Home.this,AdminLogin.class);
                startActivity(i);
            }
        });
    }
    public void addRegister()
    {
        String fname=txtFname.getText().toString().trim();
        String lname=txtLname.getText().toString().trim();
        String dob=txtDate.getText().toString().trim();
        String gen=spinnerGender.getSelectedItem().toString();
        String mobile=txtMobile.getText().toString().trim();
        String altmobile=txtAltMobile.getText().toString().trim();
        String email=txtEmail.getText().toString().trim();
        String bg=spinnerBG.getSelectedItem().toString();
        String password=txtPassword.getText().toString().trim();

        if(!TextUtils.isEmpty(fname))
        {
            String id=databaseRegister.push().getKey();
            Register reg=new Register(id,fname, lname, dob,gen,mobile,altmobile,email,bg,password);
            databaseRegister.child(id).setValue(reg);
            Toast.makeText(this,"Record Forwarded", Toast.LENGTH_LONG).show();

            Intent i=new Intent(Home.this,MedicalRecord.class);
            i.putExtra("id",id);
            i.putExtra("fname",fname);
            i.putExtra("lname",lname);
            i.putExtra("dob",dob);
            i.putExtra("gen",gen);
            i.putExtra("mobile",mobile);
            i.putExtra("altmobile",altmobile);
            i.putExtra("email",email);
            i.putExtra("bg",bg);
            i.putExtra("password",password);

            startActivity(i);
        }
        else {
            Toast.makeText(this, "You should enter all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
