#include<bits/stdc++.h>
using namespace std;



class Solution {
public:
    vector<vector<int>> ans;
    void solve(int index, vector<int> nums, int k, vector<int> ds){
        if( k == 0){
            ans.push_back(ds);
            return ;
        }
        if(k < 0){
            return;
        }
        for(int i = index; i < nums.size(); i++){
            ds.push_back(nums[i]);
            solve(i,nums, k - nums[i], ds);
            ds.pop_back();
        }

    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        //your code goes here
        // {2,2} {2} different 
        vector<int> ds;
        int n = candidates.size();
        solve(0,candidates,target,ds);
        return ans;
    }
};

int main(){
    int n,k;
    cin >> n >> k;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    return 0;
}