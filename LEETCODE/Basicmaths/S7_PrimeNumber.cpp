#include<bits/stdc++.h>
using namespace std;


// Check if a number is prime or not
// 14
// Problem Statement: Given an integer N, check whether it is prime or not. A prime number is a number that is only divisible by 1 and itself and the total number of divisors is 2..

bool ischeck(int n){
    int count = 0;
    for(int i = 1; i <= n; i++){
        if(n % i == 0){
            count++;
            if((n / i) != i){
                count++;
            }
        }
    }
    if(count == 2){
        return true;
    }else{
        return false;
    }

}
int main(){
    int n; 
    cin >> n;

    return 0;
}