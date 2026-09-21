#include<bits/stdc++.h>
using namespace std;
// Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
// Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.
// Note: You are not allowed to modify the original array.
// Example 1
// Input: nums = [3, 5, 4, 1, 1]
// Output: [1, 2]
// Explanation:
// 1 appears two times in the array and 2 is missing from nums
// Example 2
// Input: nums = [1, 2, 3, 6, 7, 5, 7]
// Output: [7, 4]
// Explanation:
// 7 appears two times in the array and 4 is missing from nums.

vector<int> brute(vector<int> nums, int n) {
    vector<int> ans;
    for (int i = 1; i <= n; i++) {
        int count = 0;
        for (int j = 0; j < n; j++) {
            if (nums[j] == i) {
                count++;
            }
        }
        if (count == 2) {
            ans.push_back(i);   // duplicate
        }
        else if (count == 0) {
            ans.push_back(i);   // missing
        }
    }
    return ans;
}
vector<int> better(vector<int> nums, int n){
    int hash[n+1] = {0};
    for(int i = 0; i < n; i++){
        hash[nums[i]]++;
    }
    vector<int> ans;
    for(int i = 1; i <= n;i++){
        if(hash[i] == 2){
            ans.push_back(i);
        }else if(hash[i] == 0){
            ans.push_back(i);
        }
    }
    return ans;
}

// sabse pehla 
vector<int> optimal(vector<int> nums, int n) {

    // Expected sum = 1 + 2 + 3 + ... + n
    long long sum = 1LL * n * (n + 1) / 2;

    // Expected sum of squares
    long long sumSq = 1LL * n * (n + 1) * (2 * n + 1) / 6;

    long long exsum = 0;
    long long square_of_exsum = 0;

    for (int i = 0; i < n; i++) {
        exsum += nums[i];
        square_of_exsum += 1LL * nums[i] * nums[i];
    }

    // x - y
    long long diff = exsum - sum;
    // x² - y²
    long long diff_of_square = square_of_exsum - sumSq;
    // x + y
    long long ans = diff_of_square / diff;
    
    // x = ((x-y) + (x+y)) / 2
    long long duplicate = (diff + ans) / 2;

    // y = (x+y) - x
    long long missing = ans - duplicate;

    return {(int)duplicate, (int)missing};
}
int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i  =0; i < n; i++){
        cin >> nums[i];
    }
    return 0;
}