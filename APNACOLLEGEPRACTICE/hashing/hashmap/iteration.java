package hashing.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class iteration {
    public static void main(String[] args) {
        // HashMap<String,Number> hm = new HashMap<>();
        // hm.put("India", 150);
        // hm.put("China", 120);
        // hm.put("Pakisatan", 0);
        // hm.put("America", 10);
        

        // iteration on hashmap 
          // for (Entry<String, Number> keys : hm.entrySet()) {
          //   System.out.println(keys.getKey() + "->" + keys.getValue());
          // };
          

          HashSet<String> set = new HashSet<String>();

          set.add("ram ");
          set.add("shyam");
          set.add("lakshman");
          set.add("bharat");
          set.add("shatrughan");
          
          Iterator it = set.iterator();

          // while (it.hasNext()) {
          //   System.out.println(it.next());
          // }


          
          for (String city : set) {
            System.out.println(city);
          }
    }
} 
