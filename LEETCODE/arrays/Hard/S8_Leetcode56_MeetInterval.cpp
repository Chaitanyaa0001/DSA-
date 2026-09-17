#include<bits/stdc++.h>
using namespace std;


vector<vector<int>> mergeIntervals(vector<vector<int>> nums){
    int n = nums.size();
    vector<vector<int>> ans;

    sort(nums.begin(), nums.end());
    for(int i = 0; i < n-1; i++){
        if(ans.empty() || nums[i][0] < nums[i+1][1]){
            ans.push_back(nums[i]);
        } else{
            // overlaping 
            if(ans.back()[1] > nums[i][0]){
                ans.back()[1] = max(nums[i][1], ans.back()[1]);
            }
        }
    }
}
int main(){
    int n;
    int m;
    cin >> n >> m ;
    vector<vector<int>> nums(n,vector<int>(m));
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            cin >> nums[i][j];
        }
    }

    return 0;
}