package LEETCODE.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;

public class S4_FruitsIntoBasket {
    private static int bruteforce(int[] a){
        int n = a.length;
        int maxlen = 0;
        int len = 0;
        
        for(int i =0;  i < n; i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j = i; j < n; j++){
                set.add(a[j]);
                if(set.size() <= 2){
                    len = j - i + 1;
                    maxlen = Math.max(len,maxlen);
                }else{
                    break;
                }
                
            }
        }
        return maxlen;
    }
    public static int better(int a[]){
        int n = a.length;
        int l = 0; int r = 0; 
        int len = 0; int maxlen = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        while (r < n) {
            map.put(a[r],map.getOrDefault(a[r],0) + 1);

            if(map.size() > 2){
                while (map.size() > 2) {
                    map.put(a[l],map.get(a[l]) - 1);
                    if(map.get(a[l]) == 0){
                        map.remove(a[l]);
                    }
                }
                l++;
                
            }
            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }
        return maxlen;
    }
    public static void main(String[] args) {
        // You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.
        // You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:
        // You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
        // Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
        // Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
        // Given the integer array fruits, return the maximum number of fruits you can pick.
        int a[] = {1,2,3,4,5,6};
        better(a);
        bruteforce(a);
    }
}
