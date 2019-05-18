//Allen Yao, 3219474
//Austin Wong, 5387931

public abstract class MusicTrack implements MusicTrackInterface {
    private String title;
    private String length;
    private String artist;
    private String album;
    private int release_date;

    //constructor
    public MusicTrack(String title, String length, String artist, String album, int release_date) {
        this.title = title;
        this.length = length;
        this.artist = artist;
        this.album = album;
        this.release_date = release_date;
    }

    public String getTitle() {
        return this.title;
    }
    public String getLength() {
        return this.length;
    }
    public String getArtist() {
        return this.artist;
    }
    public String getAlbum() {
        return this.album;
    }
    public int getYear() {
        return this.release_date;
    }
    public abstract String getAdditionalInfo();
}