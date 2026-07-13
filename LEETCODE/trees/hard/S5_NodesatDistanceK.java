package LEETCODE.trees.hard;

import LEETCODE.trees.BinaryTree;
import java.util.*;

public class S5_NodesatDistanceK {
    private static void buildparent(BinaryTree.Node root,HashMap<BinaryTree.Node, BinaryTree.Node> parent){
        if(root == null){
            return ;
        }
        Queue<BinaryTree.Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTree.Node curr = q.poll();
            if(curr.left != null){
                parent.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parent.put(curr.right, curr);
                q.add(curr.left);
            }
        }
    }
    private static List<Integer> nodesatdistancek(BinaryTree.Node root,BinaryTree.Node target, int k){
        HashMap<BinaryTree.Node,BinaryTree.Node> parent = new HashMap<>();
        buildparent(root, parent);
        HashMap<BinaryTree.Node,Boolean> visited = new HashMap<>();
        Queue<BinaryTree.Node> q = new LinkedList<>();

        q.add(target);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            distance++;
            if(distance == k){
                break;
            }
            for(int i = 0; i < size; i++){
                BinaryTree.Node curr = q.poll();
                // explore left 
                if(curr.left != null &&  visited.get(curr.left) == null){
                    q.add(curr.left);
                    visited.put(curr.left,true);
                }
                // explore right 
                if(curr.right != null && visited.get(curr.right) == null){
                    q.add(curr.right);
                    visited.put(curr.right,true);
                }
                
                // explore parent 
                if(parent.get(curr) != null && visited.get(parent.get(curr)) == null){
                    q.add(parent.get    (curr));
                    visited.put(parent.get(curr),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            BinaryTree.Node curr =  q.poll();
            ans.add(curr.data);
        }
        return ans;
    }
    public static void main(String[] args) {
        BinaryTree.Node root = BinaryTree.createTree();
        nodesatdistancek(root, root, 0);

    }
}
