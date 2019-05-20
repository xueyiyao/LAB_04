//Allen Yao, 3219474
//Austin Wong, 5387931

import java.util.*;
import java.io.*;
import java.net.URL; 
import java.net.MalformedURLException; 

public class MusicManager {
    TitleBucket TitleBucket;
    ArtistBucket ArtistBucket;
    Scanner userInput;
    public MusicManager() {
        TitleBucket = new TitleBucket();
        ArtistBucket = new ArtistBucket();
    }

    private void readFile() throws MalformedURLException, FileNotFoundException, IOException
    {
        System.out.print("Enter \'D\' to read the music file from your local disk or \'W\' to read the music file from the web: ");
        //insert logic
        String in = userInput.next().toUpperCase();
        switch(in)
        {
            case "D":
                File file = new File("MusicList.txt");
                Scanner fileInput = new Scanner(file);
                MusicTrack dtrack;
                while(fileInput.hasNextLine())
                {
                    String[] trackInfo = fileInput.nextLine().split(";");
                    if(trackInfo[5].equals("V"))
                    {
                        dtrack = new VinylTrack(trackInfo[0], trackInfo[1], trackInfo[2], trackInfo[3], Integer.parseInt(trackInfo[4]), trackInfo[6]);
                    }
                    else{
                        dtrack = new DigitalTrack(trackInfo[0], trackInfo[1], trackInfo[2], trackInfo[3], Integer.parseInt(trackInfo[4]), trackInfo[6]);
                    }
                    TitleBucket.addItem(dtrack);
                    ArtistBucket.addItem(dtrack);
                }
                fileInput.close();
                break;
            case "W":
                URL url = new URL("https://sites.cs.ucsb.edu/~richert/cs56/misc/lab04/MusicList.txt");
                Scanner urlInput = new Scanner(url.openStream());
                MusicTrack wtrack;
                while(urlInput.hasNextLine())
                {
                    String[] trackInfo = urlInput.nextLine().split(";");
                    if(trackInfo[5].equals("V"))
                    {
                        wtrack = new VinylTrack(trackInfo[0], trackInfo[1], trackInfo[2], trackInfo[3], Integer.parseInt(trackInfo[4]), trackInfo[6]);
                    }
                    else{
                        wtrack = new DigitalTrack(trackInfo[0], trackInfo[1], trackInfo[2], trackInfo[3], Integer.parseInt(trackInfo[4]), trackInfo[6]);
                    }
                    TitleBucket.addItem(wtrack);
                    ArtistBucket.addItem(wtrack);
                }
                urlInput.close();
                break;
            default:
                System.out.println("Invalid Input.");
                readFile();
                break;
                

        }
    }

    private void outFile() throws MalformedURLException, FileNotFoundException
    {
        System.out.print("Enter \'A\' to output tracks by Artists of 'T' to output tracks by Title. Enter 'Q' to quit: ");
        //insert logic
        String in = userInput.next().toUpperCase();
        
        switch(in)
        {
            case "Q":
                userInput.close();
                System.exit(0);
                break;
            case "A":
                OutputFile artOut = new OutputFile();
                artOut.open("artistOutput.txt");
                ArrayList< ArrayList<MusicTrack> > artArr = ArtistBucket.getBuckets();
                writeFile(artOut, artArr);
                artOut.close();
                outFile();
                break;

            case "T":
                OutputFile titleOut = new OutputFile();
                titleOut.open("titleOutput.txt");
                ArrayList< ArrayList<MusicTrack> > titleArr = TitleBucket.getBuckets();
                writeFile(titleOut, titleArr);
                titleOut.close();
                outFile();
                break;
            default:
                System.out.println("Invalid Input.");
                outFile();
                break;
        }

    }

    public void writeFile(OutputFile file, ArrayList<ArrayList<MusicTrack>> arr)
    {
        for (int i = 0; i < arr.size(); i++)
        {
            for(int j = 0; j < arr.get(i).size(); j++)
            {
                file.writeItem(arr.get(i).get(j));
            }
        }
    }

    public void start() throws MalformedURLException, FileNotFoundException, IOException {
        userInput = new Scanner(System.in);
        System.out.println("Welcome to the Music Library Application!");
        readFile();
        outFile();
    }

}