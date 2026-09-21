#include<bits/stdc++.h>
using namespace std;


bool solve(int i, int n, string s){
    if(i >= n/2){
        return true;
    }
    if(s[i] != s[n - i - 1]){
        return false;
    }
    return solve(i+1, n, s);
}

int main(){
    string n;
    cin >>n;

    return 0;
}