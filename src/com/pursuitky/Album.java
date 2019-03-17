package com.pursuitky;

import java.util.ArrayList;

public class Album {
    private String title;
    private String artist;
    private ArrayList<Song> tracks;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
        this.tracks = new ArrayList<Song>();
    }

    public boolean addSong(Song song) {
        if (!tracks.contains(song)) {
            tracks.add(song);
            return true;
        }

        return false;
    }

    public boolean addSong(String title, double duration) {
        Song song = new Song(title, duration);
        if (!tracks.contains(song)) {
            tracks.add(song);
            return true;
        }
        return false;
    }
}
