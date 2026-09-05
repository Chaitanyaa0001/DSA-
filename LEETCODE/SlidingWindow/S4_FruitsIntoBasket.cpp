#include<bits/stdc++.h>
using namespace std;

int fruitsIntoBaskets(int n, vector<int> nums){
    int i = 0; int j = 0;
    int maxlen = 0;
    unordered_map<int, int> freq;

    while(j < n){
        freq[nums[j]]++;

        while(freq.size() > 2){
            freq[nums[i]]--;
            if(freq[nums[i]] == 0){
                freq.erase(nums[i]);
            }
            i++;
        }
        int len = j - i + 1;
        maxlen = max(maxlen, len);
        j++;
    }
}

int main(){
    int n;
    cin >> n;
    vector<int> nums(n);
    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    fruitsIntoBaskets(n,nums);
    return 0;
}