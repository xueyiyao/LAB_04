//Allen Yao, 3219474
//Austin Wong, 5387931

import org.junit.Test;

import jdk.jfr.Timestamp;

import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.*;
import java.io.*;
import java.net.URL; 

public class MusicLibraryTests
{
    @Before // Executed before each test in this class
    public void executeBeforeEachTest() {
        System.out.println("@Before: new test beginning\n");
    }

    @Test
    public void artistTestLibrary()
    {
            DigitalTrack d5 = new DigitalTrack("Trap Queen", "length", "Fetty Wap", "album", 5, "bitRate");
            DigitalTrack d6 = new DigitalTrack("I'm the One", "length", "DJ Khaled", "album", 6, "bitRate");
            DigitalTrack d1 = new DigitalTrack("Take Care", "length", "Drake", "album", 1, "bitRate");
            DigitalTrack d2 = new DigitalTrack("The Hills", "length", "The Weeknd", "album", 2, "bitRate");
            DigitalTrack d3 = new DigitalTrack("No Role Models", "length", "J. Cole", "album", 3, "bitRate");
            DigitalTrack d4 = new DigitalTrack("Best Part", "length", "Daniel Caesar", "album", 4, "bitRate");   
            DigitalTrack d7 = new DigitalTrack("Hotline Bling", "length", "Drake", "album", 7, "bitRate");
            DigitalTrack d8 = new DigitalTrack("Forever", "length", "Drake", "album", 8, "bitRate");
            DigitalTrack d9 = new DigitalTrack("Forever", "length", "Chris Brown", "album", 9, "bitRate");

	        VinylTrack d10 = new VinylTrack("Bohemian Rhapsody", "5 minutes 55 seconds", "Queen", "A Night at the Opera", 1975, "RPM");
	        DigitalTrack d11  = new DigitalTrack("Bohemian Rhapsody", "5 minutes 54 secods", "Queen", "A Night at the Opera", 2011, "bitRate");

            ArtistBucket ab = new ArtistBucket();

            ab.addItem(d1);
            ab.addItem(d2);
            ab.addItem(d3);
            ab.addItem(d4);        
            ab.addItem(d5);
            ab.addItem(d6);
            ab.addItem(d7);
            ab.addItem(d8);
            ab.addItem(d9);
            ab.addItem(d10);
            ab.addItem(d11);

            String[] titles = new String[11];
            int n = 0;

            for(int i = 0; i < ab.getBuckets().size(); i++){
                for (int j = 0; j < ab.getBuckets().get(i).size(); j++){
                    titles[n] = ab.getBuckets().get(i).get(j).getTitle();
                    n++;
                }
            }
            String[] controlTitles = {"Forever", "Best Part", "I'm the One", "Forever", "Hotline Bling", "Take Care", "Trap Queen", "No Role Models", "Bohemian Rhapsody", "Bohemian Rhapsody", "The Hills"};

            assertArrayEquals(titles, controlTitles);
            System.out.println("Artist Bucket Tests Pass\n");

            
        
    }

    @Test
    public void titleTestLibrary()
    {
            DigitalTrack d5 = new DigitalTrack("Trap Queen", "length", "Fetty Wap", "album", 5, "bitRate");
            DigitalTrack d6 = new DigitalTrack("I'm the One", "length", "DJ Khaled", "album", 6, "bitRate");
            DigitalTrack d1 = new DigitalTrack("Take Care", "length", "Drake", "album", 1, "bitRate");
            DigitalTrack d2 = new DigitalTrack("The Hills", "length", "The Weeknd", "album", 2, "bitRate");
            DigitalTrack d3 = new DigitalTrack("No Role Models", "length", "J. Cole", "album", 3, "bitRate");
            DigitalTrack d4 = new DigitalTrack("Best Part", "length", "Daniel Caesar", "album", 4, "bitRate");   
            DigitalTrack d7 = new DigitalTrack("Hotline Bling", "length", "Drake", "album", 7, "bitRate");
            DigitalTrack d8 = new DigitalTrack("Forever", "length", "Drake", "album", 8, "bitRate");
            DigitalTrack d9 = new DigitalTrack("Forever", "length", "Chris Brown", "album", 9, "bitRate");

	        VinylTrack d10 = new VinylTrack("Bohemian Rhapsody", "5 minutes 55 seconds", "Queen", "A Night at the Opera", 1975, "RPM");
	        DigitalTrack d11  = new DigitalTrack("Bohemian Rhapsody", "5 minutes 54 secods", "Queen", "A Night at the Opera", 2011, "bitRate");

            TitleBucket tb = new TitleBucket();
            
            tb.addItem(d1);
            tb.addItem(d2);
            tb.addItem(d3);
            tb.addItem(d4);       
            tb.addItem(d5);
            tb.addItem(d6);
            tb.addItem(d7);
            tb.addItem(d8);
            tb.addItem(d9);
            tb.addItem(d10);
            tb.addItem(d11);

            String[] titles = new String[11];
            int n = 0;
            for(int i = 0; i < tb.getBuckets().size(); i++){
                for (int j = 0; j < tb.getBuckets().get(i).size(); j++){
                    titles[n] = tb.getBuckets().get(i).get(j).getTitle();
                    n++;
                }
            }

            String[] controlTitles = {"Best Part", "Bohemian Rhapsody", "Bohemian Rhapsody", "Forever", "Forever", "Hotline Bling", "I'm the One", "No Role Models", "Take Care", "The Hills", "Trap Queen"};

            assertArrayEquals(titles, controlTitles);
            System.out.println("Titles Bucket Tests Pass\n");


    }

    @Test
    public void outputFileTests() throws FileNotFoundException
    {
        //test if format outputted to files match expected
        DigitalTrack d5 = new DigitalTrack("Trap Queen", "1:20", "Fetty Wap", "album", 5, "bitRate");
        DigitalTrack d6 = new DigitalTrack("I'm the One", "2:45", "DJ Khaled", "album", 6, "bitRate");
        DigitalTrack d1 = new DigitalTrack("Take Care", "3:45", "Drake", "album", 1, "bitRate");
        DigitalTrack d2 = new DigitalTrack("The Hills", "2:30", "The Weeknd", "album", 2, "bitRate");
        DigitalTrack d3 = new DigitalTrack("No Role Models", "1:59", "J. Cole", "album", 3, "bitRate");
        DigitalTrack d4 = new DigitalTrack("Best Part", "2:35", "Daniel Caesar", "album", 4, "bitRate");   
        DigitalTrack d7 = new DigitalTrack("Hotline Bling", "4:31", "Drake", "album", 7, "bitRate");
        DigitalTrack d8 = new DigitalTrack("Forever", "2:54", "Drake", "album", 8, "bitRate");
        DigitalTrack d9 = new DigitalTrack("Forever", "1:34", "Chris Brown", "album", 9, "bitRate");

        VinylTrack d10 = new VinylTrack("Bohemian Rhapsody", "5:55", "Queen", "A Night at the Opera", 1975, "RPM");
        DigitalTrack d11  = new DigitalTrack("Bohemian Rhapsody", "5:54", "Queen", "A Night at the Opera", 2011, "bitRate");

        TitleBucket tb = new TitleBucket();
        
        tb.addItem(d1);
        tb.addItem(d2);
        tb.addItem(d3);
        tb.addItem(d4);       
        tb.addItem(d5);
        tb.addItem(d6);
        tb.addItem(d7);
        tb.addItem(d8);
        tb.addItem(d9);
        tb.addItem(d10);
        tb.addItem(d11);

        ArrayList<ArrayList<MusicTrack>> arr = tb.getBuckets();

        OutputFile file = new OutputFile();
        file.open("testFileOutputs.txt");

        for (int i = 0; i < arr.size(); i++)
        {
            for(int j = 0; j < arr.get(i).size(); j++)
            {
                file.writeItem(arr.get(i).get(j));
            }
        }

        file.close();

        File testFile = new File("testFileOutputs.txt");
        File controlFile = new File("testFileControlOutputs.txt");
        Scanner sTestFile = new Scanner(testFile);
        Scanner sControlFile = new Scanner(testFile);

        while(sTestFile.hasNextLine() && sControlFile.hasNextLine())
        {
            assertEquals(sTestFile.nextLine(), sControlFile.nextLine());
        }

        System.out.println("File Output Tests Pass");
    }

    @After
    public void afterEveryTest(){
    }
}