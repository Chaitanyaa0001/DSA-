#include<bits/stdc++.h>
using namespace std;
// Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays. The elements in the union must be in ascending order.
// The union of two arrays is an array where all values are distinct and are present in either the first array, the second array, or both.
// Example 1
// Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
// Output: [1, 2, 3, 4, 5, 7]
// Explanation:
// The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2

vector<int> unionfind(vector<int>nums1, vector<int> nums2){
    int n1 = nums1.size();
    int n2 = nums2.size(); 
    int i = 0; int j = 0; 
    vector<int> ans;
    while (i < n1 && j < n2){
        if(nums1[i] < nums2[j]){
            if(ans.empty() || ans.back() != nums1[i]){
                ans.push_back(nums1[i]);
            }
            i++;
        }else if(nums2[j] < nums1[i]){
            if(ans.empty() || ans.back() != nums2[j]){
                ans.push_back(nums2[j]);
            }
            j++;
        }else{
            // a[i]  == b[j]
            if(ans.empty() || ans.back() != nums1[i]){
                ans.push_back(nums1[i]);
            }
            i++;
            j++;
        }
    }

    while(i < n1){
        if(ans.empty() || ans.back() != nums1[i]){
            ans.push_back(nums1[i]);
        }
        i++;
    }
    while(j < n2){
        if(ans.empty() || ans.back() != nums2[j]){
            ans.push_back(nums2[j]);
        }
        j++;
    }
    return ans;
    
}
int main(){
    int n1;
    int n2;
    cin >> n1 >> n2;
    vector<int> nums1(n1);
    vector<int> nums2(n2);
    for(int i = 0; i <n1; i++){
        cin >> nums1[i];
    } 
    for(int i = 0; i <n2; i++){
        cin >> nums2[i];
    } 
    vector<int> ans = unionfind(nums1,nums2);
    for(int x : ans){
        cout << x  << " ";
    }
    return 0;
}