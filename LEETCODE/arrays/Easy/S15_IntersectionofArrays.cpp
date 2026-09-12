// Input:
// nums1 = [1, 2, 2, 3, 4]
// nums2 = [2, 2, 4, 6]

// Output:
// [2, 4]

#include<bits/stdc++.h>
using namespace std;

vector<int> intersection(vector<int> nums1,vector<int> nums2, int n){
    unordered_set<int>  set;
    int n1 = nums1.size();
    int n2 = nums2.size();
    int i = 0, j = 0;
    vector<int> ans;
    while (i < n1 && j < n2){
        if(nums1[i] < nums2[j]){
            i++;
        }else if( nums2[j] < nums1[i]){
            j++;
        }else{
            if(ans.empty() || ans.back() != nums1[i]){
                ans.push_back(nums1[i]);
            } 
            i++;
            j++;
        }
    }
}
int main(){
    int n;
    cin >> n;
    vector<int> v(n);
    for(int i = 0; i < n; i++){
        cin >> v[i];
    }
    return 0;
}