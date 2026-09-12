#include<bits/stdc++.h>
using namespace std;
int functionnumber(vector<int>nums){
    int n = nums.size();
    int actualsum = n * (n+1) /2;
    int sum = 0;
    for(int i = 0; i < n; i++){
        sum += nums[i];
    };
    return actualsum - sum;
}
int withzor(vector<int> nums){
    int result = 0; 
    for(int num : nums){
        result ^= num;
    }
    return result;
}
    
int main(){
    
    return 0;
}
    
    

