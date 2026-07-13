package LEETCODE.trees.hard;

import java.util.LinkedList;
import java.util.Queue;

public class S7_SentralizeAndDesentralize {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
        // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr == null) {
                s.append("&,");
                continue;
            }
            s.append(curr.val).append(",");
            q.offer(curr.left);
            q.offer(curr.right);
        }
        return s.toString();
    }
        // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("")){
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        String[] arr = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.add(root);
        for(int i = 1; i < arr.length; i++){
            TreeNode curr = q.poll();
            if(!arr[i].equals("&")){
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                curr.left = left;
                q.add(left);
            }
            i++;
            if(!arr[i].equals("&")){
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                curr.right = right;
                q.add(right);
            }
        }
        return root;
    }
    

    public static void main(String[] args) {

        
    }
}