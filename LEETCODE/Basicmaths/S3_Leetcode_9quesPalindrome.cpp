// Problem Statement: Given an integer N, return true if it is a palindrome else return false.
// A palindrome is a number that reads the same backward as forward. For example, 121, 1331, and 4554 are palindromes because they remain the same when their digits are reversed.

#include<bits/stdc++.h>
using namespace std;

bool ischeck(int n){
    int reverse = 0;
    int original = n;
    while (n != 0)
    {
        int lastdigit = n % 10;
        reverse = reverse * 10 + lastdigit;
        n = n / 10;
    }

    if(reverse == original){
        return true;
    }
    return false;
}
int main(){
    int n; 
    cin >> n; 
    bool res = ischeck(n);
    
    cout << res;
    return 0;
}
