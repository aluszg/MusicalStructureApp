package com.example.android.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;

public class Library implements Parcelable {
    //** Image of the album ID*/
    private int mImageResourceId;
    //** Artists name*/
    private String mArtist;
    //** Albums name*/
    private String mAlbum;
    //** Songs title*/
    private String mSong;
    //** Year of the album*/
    private String mYear;
    //** Music of song*/
    private int mAudioResourceId;

    /**
     * Create a new artist object.
     *
     * @param imageResourceId is the image of album.
     * @param artists         is the artists name.
     * @param albums          is the albums name.
     * @param songs           is the title of song.
     * @param year            is the year of the album.
     * @param audioResourceId is song of the artist
     */
    public Library(int imageResourceId, String artists, String albums, String songs, String year, int audioResourceId) {
        mImageResourceId = imageResourceId;
        mArtist = artists;
        mAlbum = albums;
        mSong = songs;
        mYear = year;
        mAudioResourceId = audioResourceId;
    }

    protected Library(Parcel in) {
        mImageResourceId = in.readInt ();
        mArtist = in.readString ();
        mAlbum = in.readString ();
        mSong = in.readString ();
        mYear = in.readString ();
        mAudioResourceId = in.readInt ();
    }

    public static final Creator<Library> CREATOR = new Creator<Library> () {
        @Override
        public Library createFromParcel(Parcel in) {
            return new Library (in);
        }

        @Override
        public Library[] newArray(int size) {
            return new Library[size];
        }
    };

    /**
     * Get the name of artist.
     */
    public String getArtist() {
        return mArtist;
    }

    /**
     * Get the name of album.
     */
    public String getAlbum() {
        return mAlbum;
    }

    /**
     * Get the title of song.
     */
    public String getSong() {
        return mSong;
    }

    /**
     * Get the year of the album.
     */
    public String getYear() {
        return mYear;
    }

    /**
     * Get the image of the album.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Open music of the song.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt (mImageResourceId);
        parcel.writeString (mArtist);
        parcel.writeString (mAlbum);
        parcel.writeString (mSong);
        parcel.writeString (mYear);
        parcel.writeInt (mAudioResourceId);
    }
}
