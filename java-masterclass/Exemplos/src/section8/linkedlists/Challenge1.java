package section8.linkedlists;

/**
 * * created by lgcaobianco on 5/7/19
 **/


// Create a program that implements a playlist for songs
// Create a Song class having Title and Duration for a song.
// The program will have an Album class containing a list of songs.
// The albums will be stored in an ArrayList
// Songs from different albums can be added to the playlist and will appear in the list in the order
// they are added.
// Once the songs have been added to the playlist, create a menu of options to:-
// Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
// List the songs in the playlist
// A song must exist in an album before it can be added to the playlist (so you can only play songs that
// you own).
// Hint:  To replay a song, consider what happened when we went back and forth from a city before we
// started tracking the direction we were going.
// As an optional extra, provide an option to remove the current song from the playlist
// (hint: listiterator.remove()
public class Challenge1 {
    public static void main(String[] args) {
        Playlist playlist = Playlist.setUp();
        playlist.displaySongs();
        playlist.beginPlaylist();
        playlist.nowPlaying();
        playlist.skipForward();
        playlist.nowPlaying();
        playlist.skipForward();
        playlist.nowPlaying();
        playlist.skipForward();
        playlist.skipBackwards();
        playlist.nowPlaying();
        playlist.skipBackwards();
        playlist.nowPlaying();
        playlist.playNext(new Song("Luke Combs", "hurricane", "3:23"));
        playlist.nowPlaying();
        playlist.displaySongs();
    }
}
