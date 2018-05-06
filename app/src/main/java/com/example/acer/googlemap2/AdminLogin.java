package com.example.acer.googlemap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText txtUsername,txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        txtUsername=(EditText) findViewById(R.id.txtUsername);
        txtPassword=(EditText) findViewById(R.id.txtPassword);

        Button btnLogin=(Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(txtUsername.getText().toString().equals("admin")&&txtPassword.getText().toString().equals("admin")){
                    Intent i=new Intent(AdminLogin.this,AdminDashboard.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(AdminLogin.this, "Username and Password Incorrect", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
