package com.example.e_vet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Hayvanvermek extends AppCompatActivity {
    CheckBox c1,c2,c3,c4,c5;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference("İlanlar");
    Member member;
    int i = 0;
    Button b;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvanvermek);
        reference = database.getInstance().getReference().child("Tür");
        member = new Member();
        b = findViewById(R.id.ilanver);
        c1 = findViewById(R.id.cbkedi);
        c2 = findViewById(R.id.cbkopek);
        String d1 = "Kedi";
        String d2 =  "Köpek";
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    i = (int)snapshot.getChildrenCount();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (c1.isChecked()){
                    member.setTur(d1);
                    reference.child(String.valueOf(i+1)).setValue(member);


                }
                else {}
                if(c2.isChecked()){
                    member.setTur(d2);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }
                else{}
            }
        });
    }
}