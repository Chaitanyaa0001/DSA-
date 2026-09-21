#include<bits/stdc++.h>
using namespace std;


// type 1 given row and col print that element
int factorial(int num){
    int product = 1;
    for(int i = num; i >= 1;i--){
        product *= i;
    }
    return product;
} 
int type1(int row, int col){
    int r = row - 1;
    int c = col - 1;
    int r_factorial = factorial(r);
    int c_factorial = factorial(c);

    return r_factorial / (c_factorial * factorial(r-c));

    
}
// ----------------
// optimal
int ncr(int n, int r){
    int ans = 1;
    for(int i = 0; i < r; i++){
        ans  = ans * (n-1);
        ans = ans / (i+1);    
    }
    return ans;
}
// now type 2 
// print  the entire row 
vector<int> pascal(int row){
    vector<int> ans;
    int res = 1;
    
    ans.push_back(res);
    for(int i = 1; i <= row; i++){
        res  = res * (row - i + 1);
        res = res / i;
        ans.push_back(res);
    }
    return ans;
}

// now to print the whole pascal triangle 
vector<vector<int>> toPrintWholePascalTriangle(int n){
    vector<vector<int>> ans;
    // n == row 
    for(int i = 0 ; i < n; i++){
        auto res = pascal(i);
        ans.push_back(res);
    }
    return ans;
}
int main(){

    return 0;
}