package LEETCODE.trees.medium;

import java.util.LinkedList;
import java.util.Queue;


import LEETCODE.trees.BinaryTree;

public class S1_MaximumDepth {

    
    public static int findmaxdeptOfaNodeRECURSIVE(BinaryTree.Node root){
        if(root == null){
            return 0;
        }
        int left = findmaxdeptOfaNodeBFS(root.left);
        int right = findmaxdeptOfaNodeBFS(root.right);
        
        return 1+ Math.max(left, right);
    }
    // --------------------------------------------------------

    private static int findmaxdeptOfaNodeBFS(BinaryTree.Node root){
       if(root == null){
           return 0;
       }
       Queue<BinaryTree.Node> queue = new LinkedList<>();
       int count = 0; 
       queue.add(root);
       
       while(!queue.isEmpty()){
           int size = queue.size();
           for(int i = 0; i < size; i++){
               BinaryTree.Node curr = queue.poll();
               if(curr.left != null){
                   queue.add(curr.left);
               }
               if(curr.right != null){
                   queue.add(curr.right);
               }
           }
           count++;
       }
       return count;
    }

    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        findmaxdeptOfaNodeBFS(root);
        findmaxdeptOfaNodeRECURSIVE(root);
    }
}
