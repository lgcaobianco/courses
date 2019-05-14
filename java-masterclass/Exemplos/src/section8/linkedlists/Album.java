package section8.linkedlists;

import java.util.ArrayList;
import java.util.List;

/**
 * * created by lgcaobianco on 5/13/19
 **/

public class Album {
    private List<Song> album;

    public Album() {
        album = new ArrayList<>();
    }

    public List<Song> getAlbum() {
        return album;
    }

    public void addSongToAlbum(Song song){
        album.add(song);
    }

}
