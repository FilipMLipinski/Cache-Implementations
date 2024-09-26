import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class LRUCache{
    private Node head;
    private Node tail;
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private Integer maxsize;
    private Integer cursize = 0;

    private void listAddFront(Node n){
        Node first = head.next;
        head.next = n;
        n.next = first;
        n.prev = head;
        first.prev = n;
        cursize++;
    }

    private void listRemove(Node n){
        Node pre = n.prev;
        Node nex = n.next;
        pre.next = nex;
        nex.prev = pre;
        cursize--;
    }

    private Integer listPeekBack(){
        return tail.prev.val;
    }

    public LRUCache(Integer _maxsize){
        maxsize = _maxsize;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public boolean query(Integer q){
        if(maxsize==0){
            return false;
        }
        Node cachedNode = map.get(q);
        if(cachedNode==null){
            if(cursize==maxsize){
                Integer outgoing = listPeekBack();
                listRemove(map.get(outgoing));
                map.remove(outgoing);
            }
            Node n = new Node();
            n.val = q;
            listAddFront(n);
            map.put(q, n);
            return false;
        }
        else{
            listRemove(cachedNode);
            listAddFront(cachedNode);
            return true;
        }
    }

    public ArrayList<Integer> getCache(){
        ArrayList<Integer> ret = new ArrayList<>();
        Node currnode = head.next;
        while(currnode!=tail){
            ret.add(currnode.val);
            currnode = currnode.next;
        }
        Collections.sort(ret);
        return ret;
    }
}