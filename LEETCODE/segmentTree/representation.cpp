#include<bits/stdc++.h>
using namespace std;

class SegmentTree{
    public:
    vector<int> st;
    SegmentTree(vector<int>& a){
        int n = a.size();
        st.resize(4 * n);
        buildtree(0, 0, n-1, a);
    }
    void buildtree(int i, int low , int high, vector<int>& a){
        if(low == high){
            st[i] = a[low];
            return;
        }
        
        int mid = low + (high - low) /2;

        buildtree(2*i+1,low,mid,a);
        buildtree(2*i+2, mid+1, high,a);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    // array ke index pe mera val daldo 
    // recursive jao last elemt tak 
    // agar mera index chota ho tog left side or bada ho toh right side 

    void update(int index , int val , int i, int low, int high, vector<int>& a){
        if( low == high){
            a[index] = val;
            st[i] = val;
            return;
        }
        int mid = low + (high - low) / 2;

        if(index <= mid){
            update(index, val, 2 * i+1, low, mid, a);
        }else{
            update(index,val ,2* i  + 2, mid + 1, high,a);
        }
        st[i] = st[2*i+1] + st[2 * i + 2];
    }

    int queryRange(int start, int end, int i, int low, int high){
        int mid = low + (high - low) / 2;
        if(high  < start  || low > end ){
            // if both are out of bound 
            return 0;
        }else if(start <= low && end <= high){
            return st[i]; 
        }else{
            // agar over lap 
            return queryRange(start, end, 2 * i + 1, low,mid) + queryRange(start,end, 2 * i + 2, mid + 1, high);

        }
    }
};

int main (){

    return 0;
}