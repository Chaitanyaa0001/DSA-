// Given an integer array nums, return the number of reverse pairs in the array.
// A reverse pair is a pair (i, j) where:
// 0 <= i < j < nums.length and
// nums[i] > 2 * nums[j].
// Example 1:
// Input: nums = [1,3,2,3,1]
// Output: 2
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
// Example 2:
// Input: nums = [2,4,3,5,1]
// Output: 3
// Explanation: The reverse pairs are:
// (1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
// (2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
// (3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
// Constraints:
// 1 <= nums.length <= 5 * 104
// -231 <= nums[i] <= 231 - 1

#include<bits/stdc++.h>
using namespace std;


int bruteforce(vector<int> nums){
    int n = nums.size();
    int count = 0;
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            if(nums[i] > (2*nums[j])){
                count++;
            }
        }
    }
    return count;
}

int mergealgo(vector<int> nums, int start, int mid , int end){
    int n = nums.size();
    int i = start;
    int j = mid + 1;
    vector<int> temp;
    while (i < n){
        if(nums[i] <= nums[j]){
            temp.push_back(nums[i]);
            i++;
        }else{
            temp.push_back(nums[j]);
        }
    }
    while (i < mid)
    {
        temp.push_back(nums[i]);
        i++;
    }
    while (j < end)
    {
        temp.push_back(nums[j]);
        j++;
    }

    for(int i = start ; i <= end; i++){
        nums[i] = temp[i - start];
    }
}
int countPairs(vector<int> nums, int start, int mid, int end){
    int j = mid + 1;
    
}
int algorithm(vector<int> nums, int start, int end){
    if(start >= end){
        return 0;
    }
    int mid = start + (end - start) / 2;
    algorithm(nums, start, mid);
    algorithm(nums,mid+1, end);
    countPairs(nums,)
    mergealgo(nums, start, mid, end);
}
int optimal(vector<int> nums, int n){
    return algorithm(nums,0,n-1);
}
int main(){

    return 0;
}