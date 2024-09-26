public class Tests{
    private static boolean test1(){
        Cache cache = new Cache(3);
        cache.query(1);
        cache.query(2);
        cache.query(3);
        cache.query(1);
        cache.query(2);
        cache.query(4);
        System.out.println(cache);
        return cache.toString() == "{1=2, 2=2, 4=1}";
    }
    public static void main(String args[]){
        if(test1()){
            System.out.println("test 1 pased");
        }
    }
}