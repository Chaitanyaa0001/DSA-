#include<bits/stdc++.h>
using namespace std;

// we can delte anything and we can insert any things 
// given 2 strings s1 and s2 and we need to find how many operation we can do to make our string equal in one time we can do at max 1 onepration 


int lcs(string s1, string s2){
    int n  = s1.size();
    int m = s2.size();
    vector<int> prev(m+1);
    vector<int> curr(m+1);

    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(s1[i-1] == s2[j-1]){
                curr[j] = 1 + prev[j-1];
            }else{
                curr[j] = max(prev[j], curr[j-1]);
            }
        }
        prev  = curr;
    }
    return prev[m];
}
int func(string s1, string s2){
    int n = s1.size();
    int m  = s2.size();
    int res = lcs(s1,s2);
    int a = n - res;
    int b = m - res;

    return a + b;
}

int main(){
    string s1, s2;
    cin >> s1 >> s2;

    int ans = func(s1,s2);
    return 0;
}