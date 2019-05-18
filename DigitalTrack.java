//Allen Yao, 3219474
//Austin Wong, 5387931

public class DigitalTrack extends MusicTrack implements MusicTrackInterface {
    String bitRate;

    public DigitalTrack(String title, String length, String artist, String album, int release_date, String bitRate) {
        super(title, length, artist, album, release_date);
        this.bitRate = bitRate;
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
        return this.bitRate;
    }

}