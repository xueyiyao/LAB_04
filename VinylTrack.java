//Allen Yao, 3219474
//Austin Wong, 5387931

public class VinylTrack extends MusicTrack implements MusicTrackInterface {
    String rpm;

    public VinylTrack(String title, String length, String artist, String album, int release_date, String rpm) {
        super(title, length, artist, album, release_date);
        this.rpm = rpm;
    }

    public String getTitle() {
        return super.getTitle();
    }
    public String getLength() {
        return super.getLength();
    }
    public String getArtist() {
        return super.getArtist();
    }
    public String getAlbum() {
        return super.getAlbum();
    }
    public int getYear() {
        return super.getYear();
    }
    public String getAdditionalInfo() {
        return this.rpm;
    }

}