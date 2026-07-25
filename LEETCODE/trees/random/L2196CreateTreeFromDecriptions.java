package LEETCODE.trees.random;

import java.util.HashMap;
import java.util.HashSet;

public class L2196CreateTreeFromDecriptions { 
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static class Pair{
        TreeNode parent;
        TreeNode leftchild;
        TreeNode rightchild;
        Pair(TreeNode parent,TreeNode leftchild,TreeNode rightchild){
            this.parent = parent;
            this.leftchild =  leftchild;
            this.rightchild = rightchild;
        }
    }
    private static  TreeNode createBinaryTree(int[][] dd) {
        HashMap<Integer,TreeNode> map = new HashMap<>(); // kon kon ki node bangyi 
        HashSet<Integer> set = new HashSet<>(); // child ko track krne ke liye 
        // tree bana diya 
        for(int d[] : dd){
            int parent = d[0];
            int child = d[1];
            int isleft = d[2];
            // parent 
            if(!map.containsKey(parent)){
                map.put(parent,new TreeNode(parent));
            }
            // child bnao 
            if(!map.containsKey(child)){
                map.put(child,new TreeNode(child));
            }
            // ab jodna hai 
            TreeNode p = map.get(parent);
            TreeNode c = map.get(child);
            if(isleft == 1){
                p.left = c;
            }else{
                p.right = c;
            }
            set.add(child);
        }
        // ab root check krna hai 
        for(int[] d : dd){
            if(!set.contains(d[0])){
                return map.get(d[0]);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        

        int arr[][] = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        createBinaryTree(arr);

    }
}
