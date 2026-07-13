package LEETCODE.trees.hard;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import LEETCODE.trees.BinaryTree;

public class S6_BurnigOfaBinaryTree {
    private static void buildparent(BinaryTree.Node root,HashMap<BinaryTree.Node,BinaryTree.Node> map){
        if(root == null){
            return ;
        }
        if(root.left != null){
            map.put(root.left, root);
        }
        if(root.right != null){
            map.put(root.right, root);
        }
        buildparent(root.left, map);
        buildparent(root.right, map);
    }
    private static BinaryTree.Node findTargetNode(BinaryTree.Node root, int target){
        if(root == null){
            return  null;
        }
        if(root.data == target){
            return root;
        }
        BinaryTree.Node left = (findTargetNode(root.left, target));
        if(left != null){
            return left;
        }

        BinaryTree.Node right = findTargetNode(root.right, target);
        if(right != null){
            return right;
        }
        return null;
    }

    private static int mincostoburn(BinaryTree.Node root, int target){
        HashMap<BinaryTree.Node, BinaryTree.Node> map = new HashMap<>();
        buildparent(root, map);
        BinaryTree.Node t = findTargetNode(root, target);
        Queue<BinaryTree.Node>  q = new LinkedList<>();
        HashMap<BinaryTree.Node,Boolean> visited = new HashMap<>();
        q.add(t);
        int sec = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burned = false;
            for(int i = 0 ; i < size; i++){
                BinaryTree.Node  curr = q.poll();
                
                if(curr.left != null && visited.get(curr.left) == null){
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.left != null && visited.get(curr.left) == null){
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }

                if(map.get(curr) != null && visited.get(map.get(curr)) == null){
                    // current node ka parent agar marked nhi hai to mark krdo 
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }
            }
            if(burned){
                sec++;
            }
        }
        return sec;
    }

    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        mincostoburn(root, 0);
    }
}
