#include<bits/stdc++.h>
using namespace std;

int linearsearch(int n, int k , vector<int> nums){
    for(int i = 0; i < n; i++){
        if(nums[i] == k){
            return i;
        }
    }
    return -1;
}
int main(){
    int n;
    int key;
    cin >> n >> key;
    vector<int>  nums(n);

    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    linearsearch(n,key, nums);
    return 0;
}