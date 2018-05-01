package com.example.android.musicalstructureapp;

        import android.app.Activity;
        import android.content.Intent;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.TextView;

        import java.util.ArrayList;

public class LibraryAdapter extends ArrayAdapter<Library> {

    public LibraryAdapter(Activity context, ArrayList<Library> libraries) {
        super (context, 0, libraries);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from (getContext ()).inflate (
                    R.layout.list_item, parent, false);
        }

        //Get the {@link Library} object located at this position in the list
        final Library currentLibrary = getItem (position);

        //Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById (R.id.image_view);
        imageView.setImageResource (currentLibrary.getImageResourceId ());

        //Find the TextView in the list_item.xml with the name of artist text view
        TextView artistsTextView = (TextView) listItemView.findViewById (R.id.artist_text_view);
        artistsTextView.setText (currentLibrary.getArtist ());

        //Find the TextView in the list_item.xml with the name of album text view
        TextView albumsTextView = (TextView) listItemView.findViewById (R.id.album_text_view);
        albumsTextView.setText (currentLibrary.getAlbum ());

        //Find the TextView in the list_item.xml with the name of song text view
        TextView songsTextView = (TextView) listItemView.findViewById (R.id.song_text_view);
        songsTextView.setText (currentLibrary.getSong ());

        //Find the TextView in the list_item.xml with the name of year text view
        TextView yearTextView = (TextView) listItemView.findViewById (R.id.year_text_view);
        yearTextView.setText (currentLibrary.getYear ());

        //Return the whole list item layout (containing 4 TextViews) so that it can be shown in the ListView.
        return listItemView;
    }
}
