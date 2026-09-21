#include<bits/stdc++.h>
using namespace std;


vector<int> spiralOrder(vector<vector<int>>& matrix) {
    int m = matrix.size();
    int n = matrix[0].size();
    int top  = 0; 
    int bottom = m - 1;
    int low = 0;
    int high = n - 1;
    vector<int> ans;
    while(low <= high){
    // top 
        for(int i = low ; i <= high; i++){
            ans.push_back(matrix[top][i]);
        }
        top++;
        for(int i = top; i <= bottom; i++){
            ans.push_back(matrix[i][high]);
        }
        high--;
        if(top <= bottom){
            for(int i  = high; i >= low; i--){
                ans.push_back(matrix[bottom][i]);
            }
        bottom--;
        }
        if(low <= high){
            for(int i = bottom; i >= top; i--){
                ans.push_back(matrix[i][low]);
            }
        low++;
        }
    }
    return ans;

}
int main(){
    return 0;
}