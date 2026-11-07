#include<bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool spaceoptimization(vector<int>& nums, int k){
        int n  = nums.size();
        vector<int> prev(k+1,0);
        prev[0] = true;
        if(nums[0] <= k){
            prev[nums[0]] = true;
        }
        for(int index = 1; index < n; index++){
            vector<int> temp(k+1,-1);
            temp[0] = true;
            for(int target = 1; target <= k; target++){
                bool skip = prev[target];
                bool take = false;
                if(target >=  nums[index]){
                    take = prev[target - nums[index]];
                }
                temp[target] = take || skip;
            }
            prev = temp;
        }
        return prev[k];
    }
    bool canPartition(vector<int>& nums) {
        int sum = 0;
        int n = nums.size();
        for(int i  = 0; i < n; i++){
            sum += nums[i];
        }
        if(sum & 1){
            return false;
        }
        int s1 = sum/2;

        return spaceoptimization(nums,s1);
        
    }
};