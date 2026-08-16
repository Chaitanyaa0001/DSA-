package LEETCODE.Graphs.traversalProblems;
import java.util.*;

public class S14_WordLevelTwo {
    
    private static List<List<String>> wordlevel(String b, String e, String[] wordList){
        List<List<String>> ans = new ArrayList<>();

        
        HashSet<String> set  = new HashSet<>();
        Queue<List<String>> q = new LinkedList<>();
        
        for(String s : wordList){
            set.add(s);
        }
        if(set.contains(b)){
            set.remove(b);
        }

        List<String> seq = new ArrayList<>();
        seq.add(b);
        q.add(seq);
        List<String> usedonlevel=  new ArrayList<>();
        int level = 0;


        while (!q.isEmpty()) {
            int size = q.size();
            List<String> list = q.poll();

            if(list.size()  > level){
                level++;
                for(String i : usedonlevel){
                    set.remove(i);
                }
            }

            String word = list.get(list.size()-1);
            int len = word.length();

            for(int i = 0; i < len; i++){

                char[] arr = word.toCharArray();
                char original = arr[i]; // h

                for(char ch = 'a'; ch <= 'z'; ch++){
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){

                        list.add(newWord);
                        q.offer(new ArrayList<>(list));
                        usedonlevel.add(newWord);
                        list.remove(list.size() -1);
                    }
                }
                arr[i] = original;
            }

            

        }
        
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
