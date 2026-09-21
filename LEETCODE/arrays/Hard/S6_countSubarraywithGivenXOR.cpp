#include<bits/stdc++.h>
using namespace std;

// Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.
// Example 1
// Input : nums = [4, 2, 2, 6, 4], k = 6
// Output : 4
// Explanation : The subarrays having XOR of their elements as 6 are [4, 2],  [4, 2, 2, 6, 4], [2, 2, 6], and [6]
// Example 2
// Input :nums = [5, 6, 7, 8, 9], k = 5
// Output : 2
// Explanation : The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
// Now your turn!

int countXOR(vector<int> nums, int k,int n){
    int n = nums.size();
    int count = 0;

    for(int i = 0; i <n; i++){
        int res = 0;
        for(int j = i; j< n; j++){
            res ^= nums[j];
            if(res == k){
                count++;
            }
        }
    }
    return count;
}

int countxor(vector<int> nums, int k){
    int n = nums.size();
    unordered_map<int,int> map;
    map[0] = 1;
    int res = 0;
    int count = 0;
    for(int i = 0; i < n; i++){
        res ^= nums[i];
        int rem  = res - k;
        if(map.find(rem) != map.end()){
            count += map[rem];
        }
        map[res]++;
    }
    return count;
}
int main(){
    int n;
    int k;
    cin >> n >> k;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
      cin >>  nums[i];
    }
    auto res = countXOR(nums,k,n);
    return 0;
}