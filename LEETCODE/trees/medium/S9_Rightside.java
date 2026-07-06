package LEETCODE.trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


import LEETCODE.trees.BinaryTree;

public class S9_Rightside {

    public static List<Integer> rightSideView(BinaryTree.Node root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<BinaryTree.Node> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                BinaryTree.Node curr = q.poll();
                level.add(curr.data);
                if(curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
            }
            //  level = {2,3}
            int n = level.size();
            res.add(level.get(n-1));
        }
        return res;
    }
    public static void main(String[] args) {
        BinaryTree.Node  root  = BinaryTree.createTree();
        rightSideView(root);

    }
}
