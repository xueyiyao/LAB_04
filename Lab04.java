//Allen Yao, 3219474
//Austin Wong, 5387931

public class Lab04 {
    public static void main(String[] args){
        Boolean testing = true;

        if(testing == false){
            MusicManager mm = new MusicManager();
            mm.start();
        }
        else {
        //just some code to test if classes work;
            DigitalTrack d5 = new DigitalTrack("Trap Queen", "length", "Fetty Wap", "album", 5, "bitRate");
            DigitalTrack d6 = new DigitalTrack("I'm the One", "length", "DJ Khaled", "album", 6, "bitRate");
            DigitalTrack d1 = new DigitalTrack("Take Care", "length", "Drake", "album", 1, "bitRate");
            DigitalTrack d2 = new DigitalTrack("The Hills", "length", "The Weeknd", "album", 2, "bitRate");
            DigitalTrack d3 = new DigitalTrack("No Role Models", "length", "J. Cole", "album", 3, "bitRate");
            DigitalTrack d4 = new DigitalTrack("Best Part", "length", "Daniel Caesar", "album", 4, "bitRate");   
            DigitalTrack d7 = new DigitalTrack("Hotline Bling", "length", "Drake", "album", 7, "bitRate");
            DigitalTrack d8 = new DigitalTrack("Forever", "length", "Drake", "album", 8, "bitRate");
            DigitalTrack d9 = new DigitalTrack("Forever", "length", "Chris Brown", "album", 9, "bitRate");

            ArtistBucket ab = new ArtistBucket();
            TitleBucket tb = new TitleBucket();

            ab.addItem(d1);
            ab.addItem(d2);
            ab.addItem(d3);
            ab.addItem(d4);        
            ab.addItem(d5);
            ab.addItem(d6);
            ab.addItem(d7);
            ab.addItem(d8);
            ab.addItem(d9);

            for(int i = 0; i < ab.getBuckets().size(); i++){
                for (int j = 0; j < ab.getBuckets().get(i).size(); j++){
                    System.out.println(ab.getBuckets().get(i).get(j).getArtist() + " - " + ab.getBuckets().get(i).get(j).getTitle());
                }
            }

            System.out.println('\n');

            tb.addItem(d1);
            tb.addItem(d2);
            tb.addItem(d3);
            tb.addItem(d4);       
            tb.addItem(d5);
            tb.addItem(d6);
            tb.addItem(d7);
            tb.addItem(d8);
            tb.addItem(d9);


            for(int i = 0; i < tb.getBuckets().size(); i++){
                for (int j = 0; j < tb.getBuckets().get(i).size(); j++){
                    System.out.println(tb.getBuckets().get(i).get(j).getTitle() + " - " + tb.getBuckets().get(i).get(j).getArtist());
                }
            }
        }

    }
}