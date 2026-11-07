#include<bits/stdc++.h>
using namespace std;


int lcs(string s1, string s2){
    int n = s1.size();
    int m = s2.size();
    
    vector<int> curr(n+1);
    vector<int> prev(n+1);
    int ans = 0;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){

            if(s1[i-1] == s2[j-1]){
                curr[j] = 1 + prev[j-1];
            }else {
                curr[j] = max(prev[j], curr[j-1]);
            }
        }
        prev = curr;
    }
    return prev[n];
}
int long_pal_sub(string s){
    string s1 = s;
    reverse(s.begin(), s.end());

    return lcs(s1,s);
}
int min_insertion_to_make_string_palindrome(string s){
    int n = s.size();
    return  n - long_pal_sub(s);
}
int main(){

    string s;
    cin >> s;

    int ans = min_insertion_to_make_string_palindrome(s);
    cout << ans << endl;

    return 0;
}