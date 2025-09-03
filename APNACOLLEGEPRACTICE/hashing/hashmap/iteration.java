package hashing.hashmap;

import java.util.HashMap;
import java.util.Set;

public class iteration {
    public static void main(String[] args) {
        HashMap<String,Number> hm = new HashMap<>();
        hm.put("India", 150);
        hm.put("China", 120);
        hm.put("Pakisatan", 0);
        hm.put("America", 10);

        // set 
        // entryset 
        Set<String> keys =hm.keySet();
        System.out.println(keys);

        for(String k : keys){
            // System.out.println(k +" " + "Value:" + hm.get(k) );
            System.out.println(hm.entrySet());
        }
    }
}
