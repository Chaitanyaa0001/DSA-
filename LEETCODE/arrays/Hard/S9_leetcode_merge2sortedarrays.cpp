#include<bits/stdc++.h>
using namespace std;

vector<int> mergesortedList(vector<int> nums1, vector<int> nums2){
    int n = nums1.size();
    int m = nums2.size();
    int i = 0; 
    int j = 0;
    vector<int> ans(n+m);
    
    while (i < n && j < m){
        if(nums1[i] <= nums2[j]){
            ans.push_back(nums1[i]);
            i++;
        }else{
            ans.push_back(nums2[j]);
            j++;
        }
    }
    while (i < n){
        ans.push_back(nums1[i]);
        i++;
    }

    while (j < m ){
        ans.push_back(nums2[j]);
        j++;
    }
    for(int i = 0; i < n+m; i++){

        if( i < n){
            nums1[i] = ans[i];
        }else{
            nums2[i - n] = ans[i];
        }
    }
    return ans;
}

int main(){

    int n;
    int m;
    cin >> n >> m;
    vector<int> nums1(n);
    for(int i = 0; i < n; i++){
        cin >> nums1[i];
    };
    vector<int> nums2(n);
    for(int i = 0; i < n; i++){
        cin >> nums2[i];
    }
    return 0;
}