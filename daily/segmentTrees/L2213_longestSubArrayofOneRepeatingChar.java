package daily.segmentTrees;

public class L2213_longestSubArrayofOneRepeatingChar {

    class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int prefix;
        int suffix;
        int best;
        int length;

        Node(char leftChar, char rightChar,
             int prefix, int suffix,
             int best, int length) {

            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.length = length;
        }
    }

    Node[] tree;

    // Merge two nodes
    private Node merge(Node left, Node right) {

        if (left == null) return right;
        if (right == null) return left;

        Node result = new Node(left.leftChar,right.rightChar,0,0,0,left.length + right.length);

        // Calculate prefix
        result.prefix = left.prefix;

        if (left.prefix == left.length && left.rightChar == right.leftChar) {
            result.prefix = left.length + right.prefix;
        }
        // Calculate suffix
        result.suffix = right.suffix;
        if (right.suffix == right.length &&
            left.rightChar == right.leftChar) {
            result.suffix = right.length + left.suffix;
        }
        // Calculate best
        result.best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {
            result.best = Math.max(result.best,left.suffix + right.prefix);
        }
        return result;
    }
    // Build segment tree
    private void build(int node,int start,int end,char[] arr) {
        // Leaf
        if (start == end) {
            tree[node] = new Node(arr[start],arr[start],1,1,1,1);
            return;
        }

        int mid = start + (end - start) / 2;
        build(2 * node + 1,start,mid,arr);
        build(2 * node + 2,mid + 1,end,arr);

        tree[node] = merge(tree[2 * node + 1],tree[2 * node + 2]);
    }

    // Update one character
    private void update(int node,int start,int end,int index,char ch) {
        // Reached the character
        if (start == end) {
            tree[node] = new Node(ch,ch,1,1,1,1);
            return;
        }
        int mid = start + (end - start) / 2;
        if (index <= mid) {
            update(2 * node + 1,start,mid,index,ch);
        } else {
            update(2 * node + 2,mid + 1,end,index,ch);
        }
        // Recalculate this node
        tree[node] = merge(tree[2 * node + 1],tree[2 * node + 2]);
    }

    public int[] longestRepeating(String s,String q,int[] query) {
        int n = s.length();
        tree = new Node[4 * n];
        char[] arr = s.toCharArray();
        // Build initial tree
        build(0, 0, n - 1, arr);
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            // Perform update
            update(0,0,n - 1,query[i],q.charAt(i));
            // Root contains answer for entire string
            ans[i] = tree[0].best;
        }
        return ans;
    }
}
    public static void main(String[] args) {
        
    }
}
