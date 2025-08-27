package hashing.hashmap;
import java.util.HashMap;


public class HashMapdemo {
    public static void main(String[] args) {
        // to create a has map 
       HashMap<String, Integer> hm = new HashMap<>();

        hm.put("Apple", 3);
        hm.put("Banana", 5);

        System.out.println(hm);
    }
}
