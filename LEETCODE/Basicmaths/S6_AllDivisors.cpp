#include<bits/stdc++.h>
using namespace std;

// Problem Statement: Given an integer N, return all divisors of N.
// A divisor of an integer N is a positive integer that divides N without leaving a remainder. In other words, if N is divisible by another integer without any remainder, then that integer is considered a divisor of N.

vector<int> divisors(int n){

    vector<int> v;
    for(int i = 0 ; i < n ; i++){
        if((n % i) == 0){
            v.push_back(i);
        }
    }
    return v;
}
// now optimal 

vector<int> div(int n){
    vector<int> v;

    for(int i = 1;  i * i <= n; i++){
        if(n % i == 0){
            v.push_back(i);

            if((n / i) != i){
                v.push_back(n/i);
            }
        }
    }
    return v;
}

int main(){
    int n;
    cin >> n ;

    return 0;
}