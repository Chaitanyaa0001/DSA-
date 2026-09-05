#include<bits/stdc++.h>
using namespace std;


int convert_into_decimal(int n){
    // 1101 - 13
    int power = 0;
    int ans = 0;
    while (n >  0){
        int bit = n % 10;
        // bit * 2 pow 
        ans = ans +  (bit * pow(2,power));
        n = n / 10;
        power++;
        // 1- 1  ans = 1 pow 0
        // 2- 0 ans = 1 pow 1
        // 3  -  ans = 4 pow 2
        // 4 - 1 ans = 8 pow 3
        // 13 
    }
    return ans;
    
}
int main(){
    int n;
    cin >> n;
    convert_into_decimal(n);
    return 0;
}