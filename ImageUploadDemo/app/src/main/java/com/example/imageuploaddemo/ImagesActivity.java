package com.example.imageuploaddemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ImagesActivity extends AppCompatActivity {


    RecyclerView mRecyclerView;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("Data");

    }
    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Upload,ViewHolder> firebaseRecycleAdapter =
                new FirebaseRecyclerAdapter<Upload,ViewHolder>(
                        Upload.class,
                        R.layout.image,
                        ViewHolder.class,
                        reference){

                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Upload upload, int i) {
                        viewHolder.setdetails(getApplicationContext(),upload.getTitle(),upload.getImage());
                    }
                };

        mRecyclerView.setAdapter(firebaseRecycleAdapter);

    }
}
