#include<bits/stdc++.h>
using namespace std;
// You are given an integer n. You need to check whether it is an armstrong number or not. Return true if it is an armstrong number, otherwise return false.
// An armstrong number is a number which is equal to the sum of the digits of the number, raised to the power of the number of digits.
// Example 1
// Input: n = 153
// Output: true
// Explanation: Number of digits : 3.
// 13 + 53 + 33 = 1 + 125 + 27 = 153.
// Therefore, it is an Armstrong number.
// Example 2
// Input: n = 12
// Output: false
// Explanation: Number of digits : 2.
// 12 + 22 = 1 + 4 = 5.
// Therefore, it is not an Armstrong number.


bool armstrong(int n){
    int digits = (int)(log10(n)+1);
    int o = n;
    int num = 0;
   while (n != 0)
   {
    int lastdigit = n % 10;
    num = num + (int)pow(lastdigit,digits);
     n = n / 10;
   }

   if(num == 0){
    return true;
   }
   return false;
}
int main(){

    int n ;
    cin >> n;
    bool res = armstrong(n);
    return 0;
}