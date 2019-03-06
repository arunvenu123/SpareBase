package com.arunvenuvyahoo.sparebase;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class tab1Fragment extends Fragment {


    public tab1Fragment() {
        // Required empty public constructor
    }
ListView listViewMotor;
DatabaseReference dbMotor;
List<Motor> motorList;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1,container,false);
        listViewMotor = (ListView) view.findViewById(R.id.listViewMotor);
        dbMotor = FirebaseDatabase.getInstance().getReference("Motor");
        motorList = new ArrayList<>();

        FloatingActionButton addMotorButton = view.findViewById(R.id.addMotorButton);
        addMotorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), addmotor.class);
                startActivity(i);

            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        dbMotor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                motorList.clear();
                for (DataSnapshot motorSnapshot : dataSnapshot.getChildren())
                {
                    Motor motor = motorSnapshot.getValue(Motor.class);
                    motorList.add(motor);
                }
                MotorList adapter = new MotorList(getActivity(), motorList);
                listViewMotor.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
