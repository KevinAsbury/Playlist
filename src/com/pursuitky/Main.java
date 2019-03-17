package com.pursuitky;

import java.sql.SQLOutput;
import java.util.*;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Album> albums = new ArrayList<Album>();
		LinkedList<Song> playlist = new LinkedList<Song>();

		addAlbum("Wonderful", "Awesome Pawsomes", 9, albums, playlist);
		addAlbum("Good", "Greatful Eds", 6, albums, playlist);
		addAlbum("Mediocre", "Average Joes", 12, albums, playlist);
		addAlbum("Bad", "Terrible Terrors", 25, albums, playlist);

		play(playlist);
	}

	private static void play(LinkedList<Song> playlist) {
		if (playlist.isEmpty()) {
			System.out.println("Playlist is empty.");
			return;
		}

		boolean quit = false;
		ListIterator<Song> iterator = playlist.listIterator();
        printMenu();

		while(!quit) {
            int action = scanner.nextInt();

			switch(action) {
				case 0:
                    System.out.println("Goodbye!");
				    quit = true;
					break;
				case 1:
				    changeSong(true, iterator);
					break;
                case 2:
                    changeSong(false, iterator);
                    break;
                case 3:
                    shuffle(playlist);
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
			}
		}
	}

	private static void shuffle(LinkedList<Song> playlist) {
        Collections.shuffle(playlist);
        printList(playlist);
    }

	private static void printList(LinkedList<Song> playlist) {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }

        for (Song song : playlist) {
            System.out.println(song.toString());
        }
    }

	private static void changeSong(boolean forward, ListIterator<Song> iterator) {

        if (forward) {
            if (iterator.hasNext()) {
                System.out.println("Now playing " + iterator.next().toString());
            } else {
                System.out.println("End of playlist.");
            }

        } else {
            if (iterator.hasPrevious()) {
                System.out.println("Now playing " + iterator.previous().toString());
            } else {
                System.out.println("Beginning of playlist.");
            }

        }
    }

	private static void printMenu(){
        System.out.println("Otion 0: Quit");
        System.out.println("Otion 1: Forward");
        System.out.println("Otion 2: Backward");
        System.out.println("Otion 3: Shuffle");
        System.out.println("Otion 4: Playlist");
        System.out.println("Otion 5: Menu");
    }

	private static void addAlbum(String title, String artist, int tracks, ArrayList<Album> albums, LinkedList<Song> playlist) {
		if (title.isEmpty() || artist.isEmpty() || tracks < 1)
			return;

		Album album = new Album("The " + title + " Album", artist);

		for (int i = 1; i<tracks; i++) {
			double r = randomDuration(1.0, 5.0);
			Song song = new Song("A " + title + " Song, Track# " + i, r);
			boolean added = album.addSong(song);

			if (new Random().nextBoolean() && added) {
				song.addToPlaylist(playlist);
			}
		}

		albums.add(album);
	}

	private static double randomDuration(double min, double max) {
		return (Math.random() * ((max - min) + 1)) + min;
	}

}
