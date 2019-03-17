package com.pursuitky;

import java.util.LinkedList;

public class Song {
    private String title;
    private double duration;


    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void addToPlaylist(LinkedList<Song> playlist) {
        if (!playlist.contains(this)) {
            playlist.add(this);
        }
    }

    @Override
    public String toString() {
        return String.format(this.title + ", Duration: %.2f", this.duration);
    }
}
