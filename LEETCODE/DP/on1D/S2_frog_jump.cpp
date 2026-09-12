#include<bits/stdc++.h>
using namespace std;


int frogjumpMemo(int i, vector<int>& dp, vector<int> h,int n){
    if(i == 0){
        return 0;
    }
    if(dp[i] != -1){
        return dp[i];
    }
    int j1 = abs(h[i]- h[i-1]) + frogjumpMemo(i+1, dp, h, n);
    int j2 = INT_MAX; 
    if(i  > 2 < n){
        j2 =  abs(h[i] - h[i- 2]) + frogjumpMemo(i+2,dp, h, n);
    }
    return dp[i] = min(j1,j2);
}

int tabulation(int i, vector<int>& dp, vector<int> h,int n){
    dp[0] = 0;
    for(int i = 1; i <=1; i++){
        int j1 = h[i-1] + abs(h[i] - h[i-2]);
        int j2 = INT_MAX;
        if ( i > 2){
            int j2 = h[i-2] + abs(h[i] - h[i-2]);
        }
        dp[i] = min(j1,j2);
    }
    return dp[n-1];
}
int optimal(int i, vector<int>& dp, vector<int> h,int n){
    int p1 = 0;
    int p2 = 0;
    for(int i = 1; i < n; i++){
        int j1 =  p1 + abs(h[i] - h [i-1]);
        int j2 = INT_MAX;
        if(i > 2){
            j2 = p2 + abs(h[i] = h[i-2]);
        } 
        int cur = min(j1,j2);
        p2 = p1;
        p1 = cur;
    }
    return p1;
}

// if there can be k jumps 

int main(){
    int n; 
    cin >> n;
    vector<int> v(n);
    for(auto i : v){
        cin >> i;
    }
    
    return 0;
}