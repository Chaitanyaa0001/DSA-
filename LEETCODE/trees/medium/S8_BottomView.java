package LEETCODE.trees.medium;

import LEETCODE.trees.BinaryTree;
import java.util.*;


public class S8_BottomView {
    static class Pair{
        int num;
        BinaryTree.Node node; 
        Pair(int num, BinaryTree.Node node){
            this.node = node;
            this.num = num;
        }
    }

    private static List<Integer> bottomview(BinaryTree.Node root){
        List<Integer> res = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.num;

            // map.put(x, curr.node.data);  we can also write this as  condition is always true 
            if(!map.containsKey(x) || map.containsKey(x)){
                map.put(x, curr.node.data);
            }

            if(curr.node.left != null){
                q.add(new Pair(x-1,curr.node.left));
            }
            if(curr.node.right != null){
                q.add(new Pair(x+1, curr.node.right));
            }
        }

        for(Map.Entry<Integer,Integer> Map : map.entrySet()){
            res.add(Map.getValue());
        }
        return res;
    }
    
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        bottomview(root);
    }

}
