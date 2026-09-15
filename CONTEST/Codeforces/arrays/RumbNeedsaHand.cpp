#include<bits/stdc++.h>
using namespace std;


int main(){
    int t;
    cin >> t;
    
    while (t--> 0){

        int n; 
        cin >> n;
        vector<int> p(n+1);
        for(int i = 1; i <= n; i++){
            cin >> p[i];
        }

        vector<int> w;
        for(int i = 1; i  <= n; i++ ){
            if(p[i] != i){
                w.push_back(i);
            }
        }   
        if(w.empty()){
            cout << "YES" << endl;
            continue;
        }
        int l = 0; int r = w.size() - 1;

        while (l < r){
            swap(p[w[l]], p[w[r]]);
            l++;
            r--;
        }
        int check = 0;
        for(int i = 1; i <= n; i++){
            if(p[i] != i){
                check = 1;
                break;
            }
        }
        if(check == 0){
            cout << "YES" << endl;
        }else{
            cout << "NO" << endl;
        }
        
    }
    return 0;
}