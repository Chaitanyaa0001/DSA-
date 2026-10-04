#include<bits/stdc++.h>
using namespace std;


int partial_sum(vector<int>& nums){
    int n = nums.size();

    int totalsum = 0;
    for(int i = 0; i < n; i++){
        totalsum += nums[i];
    }
    
    vector<int> prev(totalsum + 1,false);
    prev[0] = true;
    int k = totalsum;
    if(nums[0] <= k){
        prev[nums[0]] = true;
    }

    for(int i = 1; i < n; i++){
        vector<int> temp(k+1, false);
        temp[0] = true;

        for(int target = 1;target <= k; target++){
            bool skip = prev[target];
            bool pick = 0;
            if(nums[i] <= target){
                pick = prev[target-nums[i]];
            }
            temp[target] = pick || skip;
        }
        prev = temp;
    }

    

    int ans = INT_MAX;
    for(int i = 1; i <= k; i++){
        if(prev[i] == true){
            int s1 = i;
            int s2 = totalsum - s1;
            ans = min(ans,abs(s2-s1));
        }
    }
   return ans;
}
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    return 0;
}