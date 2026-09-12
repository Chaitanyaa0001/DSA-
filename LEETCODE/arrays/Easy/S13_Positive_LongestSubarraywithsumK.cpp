// Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.
// Example 1
// Input: nums = [10, 5, 2, 7, 1, 9],  k=15
// Output: 4
// Explanation:
// The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4.
// Example 2
// Input: nums = [-3, 2, 1], k=6
// Output: 0
// Explanation:
// There is no sub-array in the array that sums to 6. Therefore, the output is 0.


#include<bits/stdc++.h>
using namespace std;

int  bruteforce(vector<int> nums, int k){
    int n  =nums.size();
    int maxlen = -1;
    for(int i = 0; i < n; i++){
        int sum = 0;
        for(int j = i; j < n; j++){
            sum = sum + nums[j];
            if(sum == k){
                int len =  j - i + 1;
                maxlen = max(maxlen,len); 
            }
        }
    }
    return maxlen;
}
    // it is better when there are only positbve numbers 
int betterapprochusinghashMap(vector<int> nums, int k){
    int n = nums.size();
    unordered_map <int,int> map ;
    int sum = 0;
    int maxlen = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
        if( sum == k ){
         maxlen = i + 1;
        }
        if(map.find(sum -k) != map.end()){
            int j = map[sum-k]; 
            int length = i - j;
            maxlen = max(maxlen, length);
        }
     //    agar mera map mei ek sum already hai to agar vo duabara ata hai t vo uski value update kr deta hai 
     //    to humko sirf tabhi add krna hai jab already sum nhi ho 
        if(map.find(sum) == map.end()) {
            map[sum] = i;
        }
    }
    //    time : O(n)  hashmap is constant 
       return maxlen;
}

int optimal(vector<int> nums, int k){
    int n = nums.size();
    int i = 0; int j = 0;
    int sum = 0;
    int maxlen = 0;
    while (j < n){
        sum += nums[j];

        while( i <= j && sum > k){
            sum -= nums[i];
            i++;
        }
        if(sum == k){
            int len = j - i + 1;
            maxlen = max(len, maxlen);
        }
        j++;
    }
    return maxlen;
    

}

