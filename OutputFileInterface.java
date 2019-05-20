//Allen Yao, 3219474
//Austin Wong, 5387931

import java.io.FileNotFoundException;

public interface OutputFileInterface {
    public abstract void open(String outputFileName) throws FileNotFoundException;
    public abstract void writeItem(MusicTrack trackToWrite);
    public abstract void close();
}