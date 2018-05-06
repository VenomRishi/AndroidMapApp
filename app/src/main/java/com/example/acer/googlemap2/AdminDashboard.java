package com.example.acer.googlemap2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        Button btnSeeRecords=(Button) findViewById(R.id.btnSeeRecords);
        btnSeeRecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AdminDashboard.this,AdminSeeRecords.class);
                startActivity(i);
            }
        });
    }
}
