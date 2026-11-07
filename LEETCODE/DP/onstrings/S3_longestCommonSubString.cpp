#include<bits/stdc++.h>
using namespace std;


int solve(int i, int j, string s1, string s2){

    if(s1[i] == s2[j]){
        return 1 + solve(i - 1, j - 1, s1, s2);
    }

   
}

// follwo ther tabulation 

int findlenofcommonsubstring(string s1, string s2){
    int n = s1.size();
    int m = s2.size();
    int maxlen  = -1;
    vector<vector<int>> dp(n+1,vector<int>(m+1,0));
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){

            if(s1[i-1] == s2[j-1]){
                dp[i][j] = 1 + dp[i-1][j-1];
            }else {
                dp[i][j] = 0;
            }
            maxlen = max(maxlen, dp[i][j]);
        }
    }
}

int main(){
    string s1 ; 
    string s2;

    cin >> s1 >> s2;
    auto res = findlenofcommonsubstring(s1,s2);
    return 0;
}