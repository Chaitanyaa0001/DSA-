#include<iostream>
using namespace std;
#include<vector>
#include<bits/stdc++.h>



int largest(int n, vector<int> v){
    int maxi = INT_MIN;
    for(int i = 0; i < n; i++){
        if(v[i] > maxi){
            maxi = v[i];
        }
    }
    return maxi;
}
int main(){
    int n;
    cin >> n;
    
    vector<int> v(n);
    for(int i = 0 ; i < n; i++){
        cin >> v[i];
    }
    largest(n,v);
    return 0;
}