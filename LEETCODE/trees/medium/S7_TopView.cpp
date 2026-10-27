package LEETCODE.trees.medium;

import java.util.*;

import LEETCODE.trees.BinaryTree;

public class S7_TopView {
    static class Pair {
        BinaryTree.Node node ;
        int num;
        Pair(BinaryTree.Node node, int num){
            this.node = node;
            this.num = num;
        }
    }
    private static List<Integer> topviewBFS(BinaryTree.Node root){
        ArrayList<Integer> res = new ArrayList<>();

        if(root == null){
            return  res;
        }
        TreeMap<Integer,Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int x = curr.num;
            
            map.putIfAbsent(x,curr.node.data);

            if(curr.node.left != null){
                q.add(new Pair(curr.node.left, x-1));
            }
            if(curr.node.right != null){
                q.add(new Pair(curr.node.right, x+1));
            }
        }

        for(Map.Entry <Integer,Integer> tm : map.entrySet()){
            res.add(tm.getValue());   
        }
        return res;
     

    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();


        topviewBFS(root);
    }
}
