package section8.linkedlists;

/**
 * * created by lgcaobianco on 5/13/19
 **/

public class Song {
    private String artist;
    private String title;
    private String duration;
    private int minutes;
    private double seconds;

    public Song(String artist, String title, String duration) {
        this.artist = artist;
        this.title = title;
        this.duration = duration;
        int sepIndex = duration.indexOf(":");
        minutes = Integer.parseInt(duration.substring(0, sepIndex));
        seconds = Double.parseDouble(duration.substring(sepIndex+1));
    }

    public String getArtist() {
        return artist;
    }

    public int getMinutes() {
        return minutes;
    }

    public double getSeconds() {
        return seconds;
    }

    public String getTitle() {
        return title;
    }

    public String getDuration() {
        return duration;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object obj) {
        Song song = (Song) obj;
        if (this.artist == song.artist && this.title == song.title) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return artist + " - " + title;
    }
}
