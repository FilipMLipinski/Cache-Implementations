public class MyPair implements Comparable{
        public int freq;
        public int val;
        public MyPair(Integer _freq, Integer _val){
            freq = _freq;
            val = _val;
        }
        public int compareTo(Object o){
            MyPair other = (MyPair) o;
            if(other.freq < freq || (other.freq==freq && other.val < val)){
                return 1;
            }
            else if(other.freq > freq || (other.freq==freq && other.val > val)){
                return -1;
            }
            else{
                return 0;
            }
        }
        public boolean equalsTo(Object o){
            if(o==this){
                return true;
            }
            if(!(o instanceof MyPair)){
                return false;
            }
            MyPair other = (MyPair)o;
            return other.freq==freq && other.val==val;
        }

        public String toString(){
            return "(" + String.valueOf(freq) + ", " + String.valueOf(val) + ")";
        }

    }