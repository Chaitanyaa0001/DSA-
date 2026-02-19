package LEETCODE.strings.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class S1_Leetcode_CountFreqofCharAndArrangeInDesOrder {
    class Pair{
        char character;
        int freq;
        Pair(char character, int freq){
            this.character = character;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        // ek map create kiya usme char or uski freq store 
        HashMap<Character,Integer> map = new HashMap<>();
        for(char i : s.toCharArray()){
            // put,get TC : o(1)
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // max heap priority queue jo freq ko decending mei store karega 
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.freq - a.freq);
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            // TC: o(klog k) 
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        // ab string build karo 
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            // poll Tc : log k
            Pair p = pq.poll();
            // o(n)
            for(int i = 0; i < p.freq; i++){
                
                
                sb.append(p.character);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

    }
}
