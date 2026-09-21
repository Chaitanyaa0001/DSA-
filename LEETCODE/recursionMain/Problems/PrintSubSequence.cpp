#include<bits/stdc++.h>
using namespace std;



void print_subsequence(int index,vector<int>& ds ,vector<int> nums, int n){

    if(index >= n){
        for(int i = 0; i < ds.size(); i++){
            cout << ds[i] ;
        }
        return;
    }

    ds.push_back(nums[index]);
    print_subsequence(index + 1, ds, nums, n);
    ds.pop_back();
    print_subsequence(index+1, ds,nums, n);

}
int solve(vector<int> nums, int n){

}
int main(){
    int n; 
    cin >> n;
    vector<int> nums(n);

    for(int i = 0; i < n; i++){
        cin >> nums[i];
    }
    solve(nums,n);
    return 0;
}