package com.example.acer.googlemap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminSeeRecords extends AppCompatActivity {

    private static final String TAG = "AdminSeeRecords";
    DatabaseReference databaseReference;

    ListView listViewRegister;

    List<Register> registerList;
    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                registerList.clear();

                for(DataSnapshot registerSnapshot:dataSnapshot.getChildren()){
                    Register register=registerSnapshot.getValue(Register.class);

                    registerList.add(register);
                }

                RegisterList adapter=new RegisterList(AdminSeeRecords.this,registerList);
                listViewRegister.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: Database Error ");
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_see_records);

        databaseReference= FirebaseDatabase.getInstance().getReference("register");

        listViewRegister=(ListView) findViewById(R.id.listViewRegister);

        registerList=new ArrayList<>();

    }
}
