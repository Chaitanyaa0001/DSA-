import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LEETCODE.trees.BinaryTree;


public class LeverOrderTraversal {
    // in this we wil queue data stricture 
    private static List<List<Integer>> lot(BinaryTree.Node root){
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<BinaryTree.Node> queue  = new LinkedList<>();

        // time: O(n) space : O(n) 
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i =0; i < size; i++){
                BinaryTree.Node curr = queue.poll();
                level.add(curr.data);    
                if(curr.left !=  null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            ans.add(level);
        }
        return ans;
    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        lot(root);
    }
}
