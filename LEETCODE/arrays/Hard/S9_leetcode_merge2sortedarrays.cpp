#include<bits/stdc++.h>
using namespace std;

vector<int> mergesortedList(vector<int> nums1, vector<int> nums2){
    int n = nums1.size();
    int m = nums2.size();
    int i = 0; 
    int j = 0;
    vector<int> ans;
    
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

void  optimal(vector<int>& nums1, vector<int>& nums2){
    int n  = nums1.size();
    int m = nums2.size();
    int i = n - 1;
    int j =  0;
    while (j < m && i >= 0){
        if(nums1[i] > nums2[j]){
            swap(nums1[i], nums2[j]);
            i--;
            j++;
        }else if(nums1[i] < nums2[j]){
            break;
        }
    }
    sort(nums1.begin(), nums1.end());
    sort(nums2.begin(), nums2.end());
}

void swapIfGreator(vector<int>& nums1, vector<int>& nums2, int index1, int index2){
    if(nums1[index1] >nums2[index2]){
        swap(nums1[index1], nums2[index2]);
    }
}
    void optimal2(vector<int>& nums1, vector<int>& nums2){
        int n = nums1.size();
        int m = nums2.size();
        long long gap = (n + m) / 2 + (n+m) % 2;
        int len = n + m;
        while (gap > 0){
            int left = 0;
            int right = gap + left;
            // agar mera dono array m s hai n1 and n2 
            while (left < len){
                /* code */
                
                if(left < n && right >= n){
                    swapIfGreator(nums1, nums2,left, right-n);
                }else if(left >= n){
                    swapIfGreator(nums1,nums2,left - n, right - n);
                }else{
                    swapIfGreator(nums1,nums2, left, right);
                }
                left++;
                right++;
            }
            if(gap == 1){
                break; 
            }
          gap = gap / 2 + gap % 2;       
        }
        
    }

int main(){

    int n;
    int m;
    cin >> n >> m;
    vector<int> nums1(n);
    for(int i = 0; i < n; i++){
        cin >> nums1[i];
    };
    vector<int> nums2(m);
    for(int i = 0; i < m; i++){
        cin >> nums2[i];
    }
    return 0;
}