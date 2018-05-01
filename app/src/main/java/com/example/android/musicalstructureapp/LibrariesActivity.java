package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Parcelable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LibrariesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_library);

        //Create an arrayList of playlist
        final ArrayList<Library> libraries = new ArrayList<Library> ();
        libraries.add (new Library (R.drawable.image_1, "Artist 1", "Album 1", "Song 1", "Year 1", R.raw.song_file_1));
        libraries.add (new Library (R.drawable.image_2, "Artist 2", "Album 2", "Song 2", "Year 2", R.raw.song_file_2));
        libraries.add (new Library (R.drawable.image_3, "Artist 3", "Album 3", "Song 3", "Year 3", R.raw.song_file_3));
        libraries.add (new Library (R.drawable.image_4, "Artist 4", "Album 4", "Song 4", "Year 4", R.raw.song_file_4));
        libraries.add (new Library (R.drawable.image_5, "Artist 5", "Album 5", "Song 5", "Year 5", R.raw.song_file_5));
        libraries.add (new Library (R.drawable.image_6, "Artist 6", "Album 6", "Song 6", "Year 6", R.raw.song_file_6));
        libraries.add (new Library (R.drawable.image_7, "Artist 7", "Album 7", "Song 7", "Year 7", R.raw.song_file_7));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings.
        LibraryAdapter adapter =
                new LibraryAdapter (this, libraries);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = findViewById (R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        listView.setAdapter (adapter);

        listView.setOnItemClickListener (new AdapterView.OnItemClickListener () {
                                             @Override
                                             public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                                 Library library = libraries.get (position);
                                                 //Create a new intent to open the {@link LibrariesActivity}
                                                 Intent intent = new Intent (LibrariesActivity.this, PlayNowActivity.class);
                                                 intent.putExtra ("", libraries.get (position));
                                                 //Start the new activity
                                                 startActivity (intent);
                                             }
                                         }
        );
    }
}


