import java.util.HashMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Collections;

class LFUCache{
    private TreeSet<MyPair> set = new TreeSet<MyPair>();
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); 
    private Integer maxsize;
    private Integer cursize = 0;
    public static void sayHello(){
        System.out.println("hello cache");
    }

    public LFUCache(Integer _maxsize){
        maxsize = _maxsize;
    }

    public boolean query(Integer q){
        if(maxsize==0){
            return false;
        }
        Integer freq = map.get(q);
        if(freq!=null){
            MyPair old = new MyPair(freq, q);
            MyPair newp = new MyPair(freq+1, q);
            set.remove(old);
            set.add(newp);
            map.put(q, freq+1);
            return true;
        }
        else{
            if(cursize==maxsize){
                // kick out least frequently used.
                MyPair f = set.first();
                set.remove(f);
                map.remove(f.val);
                cursize--;
            }
            map.put(q, 1);
            MyPair newp = new MyPair(1, q);
            set.add(newp);
            cursize++;
            return false;
        }
    }

    public ArrayList<Integer> getCache(){
        ArrayList<Integer> v = new ArrayList<>();
        for(MyPair p : set){
            v.add(p.val);
        }
        Collections.sort(v);
        return v;
    }
}