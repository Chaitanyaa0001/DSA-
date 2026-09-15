#include<bits/stdc++.h>
using namespace std;

int maxLen_brute(vector<int> nums, int n){
    int count = 0;
    int sum = 0;
    for(int i = 0; i < n; i++){
        for(int j = i; j < n; j++){
            sum += nums[j];
            if(sum == 0){
                count++;
            }
        }
    }
    return count;
}
int maxLen(vector<int> nums, int n){
    unordered_map<int,int> map;
    int sum = 0;
    int maxlen = INT_MIN;
    for(int i = 0; i < n; i++){
        sum += nums[i];

        if( sum == 0){
            maxlen = i+1;
        }else{
            if(map.find(sum) != map.end()){
                int j = map[sum];
                int len = i - j;
                maxlen = max(maxlen, len);
            }else{
                
                map[sum] = i;
            }
        }
    }
    return maxlen;
}
int main(){

    return 0;
}
