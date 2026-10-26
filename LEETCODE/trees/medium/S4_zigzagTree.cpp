package LEETCODE.trees.medium;

import LEETCODE.trees.BinaryTree;
import java.util.*;

public class S4_zigzagTree {

    
    private static List<List<Integer>> zigzac(BinaryTree.Node root){

        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        Deque<BinaryTree.Node> dq = new LinkedList<>();
        boolean lefttoright = true;
        dq.addFirst(root);

        while (!dq.isEmpty()) {
            int size = dq.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                if(lefttoright){
                    BinaryTree.Node curr =  dq.removeFirst();
                    level.add(curr.data);
                    if(curr.left != null){
                        dq.addLast(curr.left);
                    }
                    if(curr.right != null){
                        dq.addLast(curr.right);
                    }
                }else{
                    BinaryTree.Node curr = dq.removeLast();
                    level.add(curr.data);
                    if(curr.right != null){
                        dq.addFirst(curr.right);
                    }
                    if(curr.left != null){
                        dq.addFirst(curr.left);
                    }
                }
            }
            lefttoright = !lefttoright;
            ans.add(level);
        }
        return ans;

    }
    public static void main(String[] args) {
        BinaryTree.Node  root = BinaryTree.createTree();
        zigzac(root);

    }
}
