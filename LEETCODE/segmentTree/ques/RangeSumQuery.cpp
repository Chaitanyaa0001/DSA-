#include<bits/stdc++.h>
using namespace std;

class SegmentTree{
public :
    vector<int> s;
    vector<int> nums;
    int n;
    SegmentTree(vector<int>& nums){
        this->nums = nums;
        n = nums.size();
        s.resize(4 * n);
        bt(1, 0,n-1,nums);
        
    }
    void bt(int i, int low, int high, vector<int>& nums){
        if(low == high){
            s[i] = nums[low];
            return;
        }
        int mid = low + (high- low) / 2;
        bt(2 * i, low, high, nums);
        bt(2 * i + 1, mid+1, high,nums);
        s[i] = s[2*i] + s[2* i +1];
    }

    void update(int index, int val){
        internal_update(index, val , 1, 0, n-1, nums);
    }
    int checkSum(int left, int right){
        return Internal_requestQuery(left,right,1,0,n-1,nums);
    }
    private :
    void internal_update(int index, int val, int i, int low, int high, vector<int>& nums){
        if(low == high){
            nums[index] = val;
            s[i] = val;
            return ;
        }
        int mid = low + (high - low) / 2;
        if(index <= mid){
            internal_update(index, val, 2*i, low, mid,nums);
        }else{
            internal_update(index,val, 2 * i + 1, mid+1, high,nums);
        }
        s[i] = s[2 * i] + s[2 * i + 1];
    }
    int Internal_requestQuery(int left, int right, int i , int low, int high, vector<int>& nums){
        int mid = low + (high - low)/2;
        // 1 
        if(low > right || left > high){
            return 0;
        }else if(left <= low && high <= right){
            return s[i];
        }else{
            return Internal_requestQuery(left,right,2*i,low,mid,nums)+ Internal_requestQuery(left,right,2*i+1,mid+1,high,nums);
        }
    }
};

class Solution {
  public:
    vector<int> querySum(vector<int>& arr, vector<vector<int>>& q) {
        int n = q.size();
        vector<int> ans;
        SegmentTree st(arr);
        
        for(int i =0; i < n; i++){
           int u = q[i][0];
           int v = q[i][1];
           int res = st.requestQuery()
        }
    }
};