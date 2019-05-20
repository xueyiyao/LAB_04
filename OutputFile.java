//Allen Yao, 3219474
//Austin Wong, 5387931

import java.io.PrintWriter;
import java.io.*;

public class OutputFile implements OutputFileInterface {
    private PrintWriter p;

    public void open(String outputFileName) throws FileNotFoundException
    {
        p = new PrintWriter(outputFileName);
        p.write(String.format("%-40s", "Title"));
        p.write(String.format("%-40s", "Artist"));
        p.write(String.format("%-40s", "Album"));
        p.write("Length ");
        p.write("Year ");
        p.write(String.format("%-40s","ADDITIONAL_INFORMATION"));
        p.write("\n");

    }
    public void writeItem(MusicTrack trackToWrite)
    {
        p.write(String.format("%-40s", trackToWrite.getTitle()));

        p.write(String.format("%-40s", trackToWrite.getArtist()));

        p.write(String.format("%-40s", trackToWrite.getAlbum()));

        p.write(String.format("%-7s", trackToWrite.getLength()));

        p.write(trackToWrite.getYear()+" ");
        if(trackToWrite instanceof DigitalTrack)
        {
            String addInfo = "Digital BitRate: " + trackToWrite.getAdditionalInfo();
            p.write(String.format("%-40s", addInfo));
        }
        else{
            String addInfo = "Vinyl RPM: " + trackToWrite.getAdditionalInfo();
            p.write(String.format("%-40s", addInfo));
        }
        p.write("\n");
    }
    public void close()
    {
        p.close();
    }
}