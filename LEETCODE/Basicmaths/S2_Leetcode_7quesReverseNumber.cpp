// Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
// Example 1:
// Input: x = 123
// Output: 321
// Example 2:
// Input: x = -123
// Output: -321
// Example 3:
// Input: x = 120
// Output: 21
#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int reverse(int n){
  int num = 0;
  while(n != 0){
    int l = n % 10;
    num = num * 10 + l;
    if((num > INT_MAX / 10) || (num < INT_MIN/ 10)){
      return 0;
    }
    n = n/10;
  }
  return num;
}
int main(){

  int n ;
  cin >> n;

  int res = reverse(n);
  cout << res;
  return 0;
}