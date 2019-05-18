//Allen Yao, 3219474
//Austin Wong, 5387931
import java.util.ArrayList;

public interface BucketInterface {

    public abstract void addItem(MusicTrack itemToAdd);
    public abstract ArrayList<ArrayList<MusicTrack>> getBuckets();
    
}