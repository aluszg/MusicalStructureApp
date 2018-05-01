package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

        //Set the content of the activity to use the activity_main.xml layout file
        setContentView (R.layout.activity_main);

        // Find the View the library category
        Button libraryButton = (Button) findViewById (R.id.library_button);
        // Set a click listener on that View
        libraryButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                //Create a new intent to open the {@link LibrariesActivity}
                Intent librariesIntent = new Intent (MainActivity.this, LibrariesActivity.class);
                //Start the new activity
                startActivity (librariesIntent);
            }
        });
    }
}