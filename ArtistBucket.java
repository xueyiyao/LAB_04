import java.util.ArrayList;

//Allen Yao, 3219474
//Austin Wong, 5387931

public class ArtistBucket implements BucketInterface {
    ArrayList<ArrayList<MusicTrack>> bucket;

    ArtistBucket() {
        bucket = new ArrayList<ArrayList<MusicTrack>>();
    }

    public void addItem(MusicTrack itemToAdd) {
        if(bucket.length() == 0){
            ArrayList<MusicTrack> newList = new ArrayList<MusicTrack>();
            newList.add(itemToAdd);
            bucket.add(newList);
            return;
        }
        
        String inputArtist = itemToAdd.getArtist();
        for(int i = 0; i < bucket.length(); i++){
            ArrayList<MusicTrack> byFirstLetter = bucket.get(i);
            MusicTrack tempTrack = byFirstLetter.get(0);

            //already exists a track with the same first letter in the artist as the track being added
            if(inputArtist.toUpperCase().charAt(0) == tempTrack.getArtist().toUpperCase().charAt(0)){
                for(int j=0; j < byFirstLetter.length(); j++){
                    if(inputArtist.toUpperCase().compareTo(byFirstLetter.get(j).getArtist()) < 0){
                        byFirstLetter.add(j, itemToAdd);
                    }
                    else if(j == byFirstLetter.length() - 1 && inputArtist.toUpperCase().compareTo(byFirstLetter.get(j).getArtist()) > 0){
                        byFirstLetter.add(itemToAdd);
                    }
                    return;
                }
                return;
            } //doesn't already exist a track with the same first letter
            else if(inputArtist.toUpperCase().charAt(0) < tempTrack.getArtist().toUpperCase().charAt(0)){
                ArrayList<MusicTrack> newList = new ArrayList<MusicTrack>();
                newList.add(itemToAdd);
                bucket.add(i, newList);
                return;
            } // reaches the end of arrayList
            else if(i == bucket.length() - 1 && inputArtist.toUpperCase().charAt(0) > tempTrack.getArtist().toUpperCase().charAt(0)) {
                ArrayList<MusicTrack> newList = new ArrayList<MusicTrack>();
                newList.add(itemToAdd);
                bucket.add(newList);
                return;
            }
        }   
    }

    @Override
    public ArrayList<ArrayList<MusicTrack>> getBuckets(){
        return bucket;
    }

}