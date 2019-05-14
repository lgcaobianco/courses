package section8.linkedlists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * * created by lgcaobianco on 5/13/19
 **/

public class Playlist {
    LinkedList<Song> songs;
    Song songPlayingNow;


    public Playlist() {
        songs = new LinkedList<>();
    }

    public void addToPlaylist(Song song) {
        songs.add(song);
    }

    public LinkedList<Song> getSongs() {
        return songs;
    }

    public void displaySongs() {
        int position = 1;
        Iterator it = songs.listIterator();
        int minutes = 0;
        double seconds = 0D;
        while (it.hasNext()) {
            Song song = (Song) it.next();
            System.out.println(position++ + " ~ " + song);
            minutes += song.getMinutes();
            seconds += song.getSeconds();
        }

        if (seconds >= 60) {
            minutes += seconds / 60;
            seconds = seconds % 60;
        }
        System.out.println("Playlist has a length of " + minutes + " minutes and " + seconds + " seconds.");

    }

    public void beginPlaylist() {
        Iterator it = songs.listIterator();
        if (it.hasNext()) {
            songPlayingNow = (Song) it.next();
        } else {
            System.out.println("Your playlist is empty!! Try adding a song first.");
        }
    }

    public static Playlist setUp() {
        Playlist playlist = new Playlist();
        playlist.addToPlaylist(new Song("Zac", "Chicken  Fried", "2:23"));
        playlist.addToPlaylist(new Song("imagine dragons", "believer", "3:32"));
        playlist.addToPlaylist(new Song("imagine dragons", "whatever it takes", "4:23"));
        System.out.println("Playlist has length: " + playlist.getSongs().size());
        return playlist;
    }

    public void nowPlaying() {
        System.out.println("Now playing: " + songPlayingNow);
    }

    public void skipForward() {
        Iterator iterator = songs.listIterator();
        while (iterator.hasNext()) {
            Song song = (Song) iterator.next();
            if (song.equals(songPlayingNow)) {
                if (iterator.hasNext()) {
                    songPlayingNow = (Song) iterator.next();
                } else {
                    System.out.println("This is the last song of the playlist! Try adding a song.");
                }
            }
        }
    }

    public void skipBackwards() {
        ListIterator iterator = songs.listIterator();
        boolean goingForward = true;
        findSong:
        while (iterator.hasNext()) {
            Song song = (Song) iterator.next();
            if (song.equals(songPlayingNow)) {
                if (iterator.hasPrevious()) {
                    iterator.previous();
                    songPlayingNow = (Song) iterator.previous();
                    break findSong;
                } else {
                    System.out.println("There aren't songs before the first one.");
                    break findSong;
                }
            }
        }
    }

    public void playNext(Song song) {
        ListIterator iterator = songs.listIterator();
        while (iterator.hasNext()) {
            Song songOnPlaylist = (Song) iterator.next();
            if (songOnPlaylist.equals(songPlayingNow)) {
                System.out.println("we found the song.");
                iterator.add(song);
                System.out.println(song + " added as next song.");
            }
        }
    }

    public void removeSongBeingPLayed() {
        ListIterator iterator = songs.listIterator();
        while (iterator.hasNext()) {
            Song song = (Song) iterator.next();
            if (song.equals(songPlayingNow)) {
                iterator.remove();
                songPlayingNow = (Song) iterator.next();
                System.out.println("Song has been removed.");
                nowPlaying();
            }
        }
    }
}