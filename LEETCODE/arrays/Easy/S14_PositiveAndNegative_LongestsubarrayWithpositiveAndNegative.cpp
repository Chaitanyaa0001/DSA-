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