import java.util.ArrayList;
import java.util.Arrays;

public class Tests{
    private static boolean test1(){
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

    private static boolean test2(){
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
        if(test1()){
            System.out.println("test 1 passed");
        }
        if(test2()){
            System.out.println("test 2 passed");
        }
    }
}