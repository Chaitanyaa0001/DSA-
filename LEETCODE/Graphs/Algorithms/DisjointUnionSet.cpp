package LEETCODE.Graphs.Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * DisjointUnionSet
 */
public class DisjointUnionSet {

    static class DisJointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public  DisJointSet(int n){
            for(int i = 0; i <= n; i++){
                rank.add(0);
                parent.add(i);
            }
        }
        public int findparent(int node){ // 5
            if(parent.get(node) == node){
                return node;
            }
            int ans = findparent(parent.get(node));
            parent.set(node,ans);
            return parent.get(node);
        }

        public void unionbyrank(int u, int v){
            int ultimate_parent_of_u = findparent(u);
            int ultimate_parent_of_V = findparent(v);

            if(ultimate_parent_of_V == ultimate_parent_of_u){
                return;  // agar dono ka  parent same ho jesa 7 or 8 ka parent 4 hogya to dono same component m alreafy attach hai 
            }
            if(rank.get(ultimate_parent_of_u)  < rank.get(ultimate_parent_of_V)){
                parent.set(ultimate_parent_of_u, ultimate_parent_of_V);
            }else if(rank.get(ultimate_parent_of_V) < rank.get(ultimate_parent_of_u)){
                parent.set(ultimate_parent_of_V, ultimate_parent_of_u);
            }else{
                parent.set(ultimate_parent_of_V,ultimate_parent_of_u);
                int r  = rank.get(ultimate_parent_of_u);
                r++;
                rank.set(ultimate_parent_of_u,r);
            }
        }
    }

    public static void main(String[] args) {
        DisJointSet ds = new DisJointSet(6);
        ds.unionbyrank(1, 2);
        ds.unionbyrank(2, 3);
        ds.unionbyrank(4, 5);
        ds.unionbyrank(6, 7);
        ds.unionbyrank(5, 6);
        ds.unionbyrank(1, 2);
        
    }
}