#include<bits/stdc++.h>
using namespace std;


void brute(int n,vector<int> nums,vector<vector<int>> ans, vector<int>& map, vector<int>& ds){

    if(ds.size() == n){
        ans.push_back(ds);
        return ;
    }

    for(int i = 0; i < n; i++){
        if(map[i] == 0){
            ds.push_back(nums[i]);
            map[i] = 1;
            brute(n,nums,ans,map,ds);
            map[i] = 0;
            ds.pop_back();
        }
    }
}

void optimal(int index,int n ,vector<int>& nums, vector<vector<int>>& ans, vector<int>& ds){

    if(index == n ){
        ans.push_back(nums);
        return ;
    }
    for(int i = index ; i < nums.size(); i++){
        swap(nums[index],nums[i]);
        optimal(index + 1, n, nums, ans,ds);
        swap(nums[index], nums[i]);
    }
}
int main(){
    
    return 0;
}