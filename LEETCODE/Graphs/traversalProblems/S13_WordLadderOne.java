package LEETCODE.Graphs.traversalProblems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class S13_WordLadderOne {
  
    class Pair{
        String s;
        int t;
        Pair(String s, int t){
            this.s = s;
            this.t = t;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // a transformation sequence form 
        // begin -> hit  end -> cog
        // wordlist -> ["hot","dot","dog","lot","log","cog"]

        HashSet<String> set  = new HashSet<>(wordList);
        Queue<Pair> q = new LinkedList<>();
        int n = wordList.size();
        // merko set mei add krna hai 
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }

        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.s;
            int time = curr.t;

            if(word.equals(endWord)){
                return time;
            }

            for(int i = 0; i <  word.length() ; i++){  // hat 
                char[] arr = word.toCharArray();

                char original = arr[i]; // h 
                for(char j = 'a';  j <= 'z'; j++){
                    arr[i] = j;  // h - a,b,c,d,e,f,g,h,i

                    String newWord = new String(arr);

                    if(set.contains(newWord)){
                        q.offer(new Pair(newWord, time + 1));
                        set.remove(newWord);
                    }
                    arr[i] = original;
                }
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        
    }
}
