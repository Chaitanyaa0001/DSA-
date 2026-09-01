#include<bits/stdc++.h>

using namespace std;

int maxScore(vector<int>& nums, int k, int n) {
    int total = 0;
    for(int i = 0; i < k; i++){
        total += nums[i];
    }
    int maxp = total;
    int r = n-1;
    for(int i = k -1; i >= 0; i--){
        total = total - nums[i];
        total = total + nums[r];
        r--;
        maxp = max(maxp, total);
    }
    return maxp;
}

int main(){
    int n; 
    int k;
    cin >> n >>k; 
    vector<int> nums(n);
    for(int i = 0 ; i < n; i++){
        cin >> nums[i];
    }
    maxScore(nums,k,n);
    return 0;
}