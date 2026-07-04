package LEETCODE.trees.medium;

import LEETCODE.trees.BinaryTree;
import java.util.*;

public class S6_VerticalOrderTraversal {
    //       1  
        // /   \
        // 2    3
    //   /  \   / \
    //  4    5  6  7
    static class Pair{
        BinaryTree.Node node; 
        int col;
        int level;
        Pair(BinaryTree.Node node, int col, int level){
            this.node = node;
            this.col = col;
            this.level = level;
        }
    }
    private static List<List<Integer>> verticaltravrsalBFS(BinaryTree.Node root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        q.add(new Pair(root, 0, 0));
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int c = curr.col;
            int lev = curr.level;

            if(!map.containsKey(c)){
                map.put(c, new TreeMap<>());
            }
            if(!map.get(c).containsKey(lev)){
                map.get(c).put(lev, new PriorityQueue<>());
            }
            map.get(c).get(lev).add(curr.node.data);

            if(curr.node.left != null){
                q.add(new Pair(curr.node.left, c - 1, lev+1));
            }
            if(curr.node.right != null){
                q.add(new Pair(curr.node.right, c + 1, lev+1));
            }
        }

        // BUild ans  
        for(Map.Entry <Integer,TreeMap<Integer,PriorityQueue<Integer>>> col : map.entrySet()){
            List<Integer> list  = new ArrayList<>();
            for(Map.Entry <Integer,PriorityQueue<Integer>> level : col.getValue().entrySet()){
                PriorityQueue<Integer> pq = level.getValue();
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }

    private static void dfs(BinaryTree.Node root,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map, int col, int level){
        if(root == null){
            return ;
        }
        if(!map.containsKey(col)){
            map.put(col, new  TreeMap<>());
        }
        if(!map.get(col).containsKey(level)){
            map.get(col).put(level, new PriorityQueue<>());
        }
        map.get(col).get(level).add(root.data);

        dfs(root.left, map, col - 1, level + 1);
        dfs(root.right, map, col + 1, level + 1);

    }
    private static List<List<Integer>> veriticalDFS(BinaryTree.Node root){

        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }        
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();


        dfs(root, map, 0, 0);
        for(Map.Entry <Integer,TreeMap<Integer,PriorityQueue<Integer>>> col : map.entrySet()){
            List<Integer> list  = new ArrayList<>();
            for(Map.Entry <Integer,PriorityQueue<Integer>> level : col.getValue().entrySet()){
                PriorityQueue<Integer> pq = level.getValue();
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        verticaltravrsalBFS(root);
        veriticalDFS(root);

    }
}
