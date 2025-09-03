package hashing.hashmap;
import java.util.HashMap;


public class HashMapdemo {
    public static void main(String[] args) {
        // to create a has map 
       HashMap<String, Integer> hm = new HashMap<>();
    //    to insert 
        hm.put("India", 150);
        hm.put("china", 130);

        System.out.println(hm);

        // to get 
        int pop = hm.get("India");
        System.out.println(pop);

        // contains key 
        boolean cm = hm.containsKey("Indonasia");
        System.out.println(cm);

        // remove 
        hm.remove("India");
        // is empty  to check weather hasmap is eempty or not 
        hm.isEmpty();
        // size() to check the size of hashmap 
        hm.size();


    }
}
