package LEETCODE.trees.hard;

import java.util.LinkedList;
import java.util.Queue;

import LEETCODE.trees.BinaryTree;

public class S3_widthOfABinaryTree {
    static class Pair{
        BinaryTree.Node node ; 
        int i;
        Pair(BinaryTree.Node node , int i){
            this.node = node;
            this.i = i;
        }
    }
    private static int width(BinaryTree.Node root){

        Queue<Pair> q  = new LinkedList<>();
        q.add( new Pair(root, 0));
        int maxwidth = 0;
        
        
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().i; 
            int first = 0; 
            int last  = 0;  
            for(int j  = 0; j < size; j++){
                Pair curr = q.poll(); // 3 
                int index = curr.i;   // 1
                index = index - min;
                if(j == 0){
                    first = index
                    ;
                }
                if(j == size - 1){
                    last = index;
                }
                if(curr.node.left != null){
                    q.add(new Pair(curr.node.left, 2 * index + 1));
                }
                if(curr.node.right != null){
                    q.add(new Pair(curr.node.right,2 * index + 2));
                }
            }
            maxwidth = Math.max(maxwidth, last - first + 1);
        }
        return maxwidth;

    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        width(root);
    }
}
