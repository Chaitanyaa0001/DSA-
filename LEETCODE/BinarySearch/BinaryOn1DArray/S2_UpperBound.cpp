#include<bits/stdc++.h>
using namespace std;


int ub(int n, int key, vector<int> nums){

    int low = 0;
    int high  = n-1;
    int upper_bound = -1;
    

    while (low <= high){
        /* code */
        int mid  = low + (high - low) / 2;
        if(nums[mid] > key){
            upper_bound = nums[mid];
            high = mid - 1;
        }else if(nums[mid] < key){
            low  = mid + 1;
        }
    }
    return upper_bound;

}

int main(){
    int n ;
    int key;
    cin >> n >> key;

    vector<int> nums(n);
    for(int i =0; i < n; i++){
        cin >> nums[i];
    }
    auto res = ub(n,key,nums);
    cout << res << endl;
}