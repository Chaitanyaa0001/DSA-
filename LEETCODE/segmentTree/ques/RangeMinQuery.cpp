#include<bits/stdc++.h>
using namespace std;

class SegmentTree{
public:
    vector<int> nums;
    int n;
    vector<int> s;
    SegmentTree(vector<int>& nums){
        n = nums.size();
        this->nums = nums;
        s.resize(4 * n);
    }

    void buildTree(int i, int low , int high, vector<int>& nums){
        if(low == high){
            s[i] = nums[low];
            return;
        }
        int mid = low + (high - low) / 2;
        buildTree(2 * i + 1, low, mid, nums);
        buildTree(2 * i + 2, mid+1, high, nums);
        s[i] = min(s[2*i + 1], s[2 * i + 2]);
    }

    int findmin(int left, int right){
        return  internal_find_min(left, right, 0, 0, n-1, nums);
    }
    private: 
    int internal_find_min(int left, int right, int i, int low , int high, vector<int>& nums){
        //  1 if mera vo out of bound ho agar 
        int mid = low + (high - low) / 2;
        if( right < low ||  high < left){
            return INT_MAX;
        }else if(left <= low && high <= right){
            return s[i];
        }else{
            return min(internal_find_min(left, right, 2 * i + 1, low, mid, nums), internal_find_min(left, right, 2 * i + 2, mid+1, high, nums));
        }
    }
};

class Solution {
  public:
    vector<int> rangeMinQuery(vector<int>& arr, vector<vector<int>>& queries) {
        int n = queries.size();
        SegmentTree tree(arr);
        vector<int> ans;
        for(int i = 0; i < n; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            int res = tree.findmin(u,v);
            ans.push_back(res);
        }
        return ans;
    }
};