#include<iostream>
#include<math.h>
#include<bits/stdc++.h>
using namespace std;

int main(){
    int n ;
    cin >> n;
    int arr[n];
    // to take input in arraty 

    for(int i = 0; i < n; i++){
        cin >> arr[i];
    }
    // now for string 
    string s;
    getline(cin,s);
    // 2d arrat 
    // not recommended use vectors 
    int nums[n][n];
    for(int i = 0; i < n; i++){
        for(int j = 0; i < n; j++){
            cin >> nums[i][j];
        }
    }
    // ------------------------------------------

    // vector<vector<int>> nums(n,vector<int>(n));  // for 2d array 
    // now for vecot dec 
    vector<int> v(19); // with size for without remove this 19
    // to access 
    cout << v[2];
    int len = v.size(); // to get len of vectir 
    // push back 
    

    return 0;
}