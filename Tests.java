import java.util.ArrayList;
import java.util.Arrays;

public class Tests{
    private static boolean test1LFU(){
        LFUCache cache = new LFUCache(3);
        if(!(cache.query(1) == false && 
             cache.query(2) == false &&
             cache.query(3) == false &&
             cache.query(1) == true && 
             cache.query(2) == true &&
             cache.query(4) == false)){
            return false;
        }
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,2,4));
        if(!(cache.getCache()).equals(expected)){
            return false;
        }
        return true;
    }

    private static boolean test2LFU(){
        LFUCache cache = new LFUCache(0);
        if(!(cache.query(1)==false)){
            return false;
        }
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList());
        if(!(cache.getCache()).equals(expected)){
            return false;
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println("Testing the LFU cache");
        if(test1LFU()){
            System.out.println("test 1 passed");
        }
        if(test2LFU()){
            System.out.println("test 2 passed");
        }
        System.out.println("Testing the LRU cache");
    }
}