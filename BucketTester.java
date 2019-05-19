//Allen Yao, 3219474
//Austin Wong, 5387931

import org.junit.*;
import static org.junit.Assert.assertEquals;

//For testing methods and logic of bucket classes
public class BucketTester {
    ArtistBucket ab = new ArtistBucket();
    TitleBucket tb = new TitleBucket();
    
    DigitalTrack d5 = new DigitalTrack("Trap Queen", "length", "Fetty Wap", "album", 5, "bitRate");
    DigitalTrack d6 = new DigitalTrack("I'm the One", "length", "DJ Khaled", "album", 6, "bitRate");
    DigitalTrack d1 = new DigitalTrack("Take Care", "length", "Drake", "album", 1, "bitRate");
    DigitalTrack d2 = new DigitalTrack("The Hills", "length", "The Weeknd", "album", 2, "bitRate");
    DigitalTrack d3 = new DigitalTrack("No Role Models", "length", "J. Cole", "album", 3, "bitRate");
    DigitalTrack d4 = new DigitalTrack("Best Part", "length", "Daniel Caesar", "album", 4, "bitRate");   
    DigitalTrack d7 = new DigitalTrack("Hotline Bling", "length", "Drake", "album", 7, "bitRate");
    DigitalTrack d8 = new DigitalTrack("Forever", "length", "Drake", "album", 8, "bitRate");
    DigitalTrack d9 = new DigitalTrack("Forever", "length", "Chris Brown", "album", 9, "bitRate");

    public String bucketToString(BucketInterface b){
	String output = "";
	if(b.getClass().equals(ArtistBucket.class)){
	    for(int i = 0; i < b.getBuckets().size(); i++){
                for (int j = 0; j < b.getBuckets().get(i).size(); j++){
                    output += b.getBuckets().get(i).get(j).getArtist() + " - " + b.getBuckets().get(i).get(j).getTitle() + "\n";
                }
            }

	    return output;
	}
	else {
	    for(int i = 0; i < b.getBuckets().size(); i++){
                for (int j = 0; j < b.getBuckets().get(i).size(); j++){
                    output += b.getBuckets().get(i).get(j).getTitle() + " - " + b.getBuckets().get(i).get(j).getArtist() + "\n";
                }
            }

	    return output;
	}
    }

    public void addToBucket(BucketInterface b) {
	b.addItem(d1);
	b.addItem(d2);
	b.addItem(d3);
	b.addItem(d4);
	b.addItem(d5);
	b.addItem(d6);
	b.addItem(d7);
	b.addItem(d8);
	b.addItem(d9);
    }
    
    @Test
    public void testabbasic() {
	addToBucket(ab);
	assertEquals(bucketToString(ab), "Chris Brown - Forever\nDaniel Caesar - Best Part\nDJ Khaled - I'm the One\nDrake - Forever\nDrake - Hotline Bling\nDrake - Take Care\nFetty Wap - Trap Queen\nJ. Cole - No Role Models\nThe Weeknd - The Hills\n");	
    }

    @Test
    public void testabduplicate() {
	VinylTrack d10 = new VinylTrack("Bohemian Rhapsody", "5 minutes 55 seconds", "Queen", "A Night at the Opera", 1975, "RPM");
	DigitalTrack d11  = new DigitalTrack("Bohemian Rhapsody", "5 minutes 54 secods", "Queen", "A Night at the Opera", 2011, "bitRate");

	ab.addItem(d10);
	ab.addItem(d11);

        assertEquals(bucketToString(ab), "Queen - Bohemian Rhapsody\nQueen - Bohemian Rhapsody\n");

	assertEquals(ab.getBuckets().get(0).get(0).getYear(), 1975);
	assertEquals(ab.getBuckets().get(0).get(1).getYear(), 2011);
    }

    @Test
    public void testtbbasic(){
	addToBucket(tb);
	assertEquals(bucketToString(tb), "Best Part - Daniel Caesar\nForever - Chris Brown\nForever - Drake\nHotline Bling - Drake\nI'm the One - DJ Khaled\nNo Role Models - J. Cole\nTake Care - Drake\nThe Hills - The Weeknd\nTrap Queen - Fetty Wap\n");	
    }

    @Test
    public void testtbduplicate() {
	VinylTrack d10 = new VinylTrack("Bohemian Rhapsody", "5 minutes 55 seconds", "Queen", "A Night at the Opera", 1975, "RPM");
	DigitalTrack d11  = new DigitalTrack("Bohemian Rhapsody", "5 minutes 54 secods", "Queen", "A Night at the Opera", 2011, "bitRate");

	tb.addItem(d10);
	tb.addItem(d11);

        assertEquals(bucketToString(tb), "Bohemian Rhapsody - Queen\nBohemian Rhapsody - Queen\n");

	assertEquals(tb.getBuckets().get(0).get(0).getYear(), 1975);
	assertEquals(tb.getBuckets().get(0).get(1).getYear(), 2011);
    }

    @Test
    public void testemptybuckets() {
	assertEquals(bucketToString(ab), "");
	assertEquals(bucketToString(tb), "");
    }
}
