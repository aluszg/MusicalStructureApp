package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlayNowActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_play_now);

        Intent intent = getIntent ();
        Library library = intent.getParcelableExtra ("");

        int imageResourceId = library.getImageResourceId ();
        String artist = library.getArtist ();
        String album = library.getAlbum ();
        String song = library.getSong ();
        String year = library.getYear ();
        int audioResourceId = library.getAudioResourceId ();


        ImageView imageView = findViewById (R.id.image_now_play);
        imageView.setImageResource (imageResourceId);

        TextView textViewArtist = findViewById (R.id.artist_now_play);
        textViewArtist.setText (artist);

        TextView textViewAlbum = findViewById (R.id.album_now_play);
        textViewAlbum.setText (album);

        TextView textViewSong = findViewById (R.id.song_now_play);
        textViewSong.setText (song);

        TextView textViewYear = findViewById (R.id.year_now_play);
        textViewYear.setText (year);

        //Release the media player if it currently exists.
        releaseMediaPlayer ();

        // Find the View of media player
        final MediaPlayer mediaPlayer = MediaPlayer.create (PlayNowActivity.this, audioResourceId);

        // Find the View of play button
        Button playButton = (Button) findViewById (R.id.play_button);
        // Set a click play button
        playButton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                //Start the audio file
                mediaPlayer.start ();
                //Setup a listener on the media player, so that we can stop and release.
                mediaPlayer.setOnCompletionListener (new MediaPlayer.OnCompletionListener () {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer ();
                    }
                });
            }
        });

        // Find the View of pause button
        Button pauseButton = (Button) findViewById (R.id.pause_button);
        // Set a click pause button
        pauseButton.setOnClickListener (new View.OnClickListener () {
            public void onClick(View view) {
                mediaPlayer.pause ();
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources
     */
    private void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release ();
            mediaPlayer = null;
        }
    }
}