import java.util.ArrayList;
import java.util.Collections;

//Allen Yao, 3219474
//Austin Wong, 5387931

public class TitleBucket implements BucketInterface {
    ArrayList<ArrayList<MusicTrack>> bucket;

    TitleBucket() {
        bucket = new ArrayList<ArrayList<MusicTrack>>();
    }

    public void addItem(MusicTrack itemToAdd) {
        //if no tracks have been added to the bucket
        if(bucket.size() == 0){
            ArrayList<MusicTrack> newList = new ArrayList<MusicTrack>();
            newList.add(itemToAdd);
            bucket.add(newList);
            return;
        }
        
        String inputTitle = itemToAdd.getTitle();
        for(int i = 0; i < bucket.size(); i++){
            ArrayList<MusicTrack> byFirstLetter = bucket.get(i);
            MusicTrack tempTrack = byFirstLetter.get(0);

            //already exists a track with the same first letter in the title as the track being added
            if(inputTitle.toUpperCase().charAt(0) == tempTrack.getTitle().toUpperCase().charAt(0)){
                for(int j=0; j < byFirstLetter.size(); j++){
                    if(inputTitle.toUpperCase().compareTo(byFirstLetter.get(j).getTitle().toUpperCase()) < 0){
                        byFirstLetter.add(j, itemToAdd);
                        return;
                    }
                    else if(j == byFirstLetter.size() - 1 && inputTitle.toUpperCase().compareTo(byFirstLetter.get(j).getTitle().toUpperCase()) > 0){
                        byFirstLetter.add(itemToAdd);
                        return;
                    }
                    else if(inputTitle.toUpperCase().compareTo(byFirstLetter.get(j).getTitle().toUpperCase()) == 0){
                        if(itemToAdd.getArtist().toUpperCase().compareTo(byFirstLetter.get(j).getArtist().toUpperCase()) < 0){
                            byFirstLetter.add(j, itemToAdd);
                            return;
                        }
                        else if(itemToAdd.getArtist().toUpperCase().compareTo(byFirstLetter.get(j).getArtist().toUpperCase()) > 0){
                            byFirstLetter.add(j+1, itemToAdd);
                            return;
                        }//Exact same song???
                        else{
                            return;
                        }
                    }
                }
                return;
            } //doesn't already exist a track with the same first letter
            else if(inputTitle.toUpperCase().charAt(0) < tempTrack.getTitle().toUpperCase().charAt(0)){
                ArrayList<MusicTrack> newList = new ArrayList<MusicTrack>();
                newList.add(itemToAdd);
                bucket.add(i, newList);
                return;
            } // reaches the end of arrayList
            else if((i == bucket.size() - 1) && inputTitle.toUpperCase().charAt(0) > tempTrack.getTitle().toUpperCase().charAt(0)) {
                ArrayList<MusicTrack> newList = new ArrayList<MusicTrack>();
                newList.add(itemToAdd);
                bucket.add(newList);
                return;
            }
        }   
    }
    public ArrayList<ArrayList<MusicTrack>> getBuckets() {
        return bucket;
    }

}