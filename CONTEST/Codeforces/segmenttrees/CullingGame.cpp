// #include<bits/stdc++.h>
// using namespace std;

// int main(){
//     int t;
//     cin >> t;

//     while (t --> 0){
//         int n;
//         cin >> n;
//         vector<int> skill(n+1);
//         vector<int> per(n+1);
//         for(int i = 1; i <= n; i++){
//             cin >> skill[i];
//         }
//         for(int i = 1; i <= n; i++){
//             cin >> per[i];
//         }

//         vector<bool> vis(n+1,false);

//         for(int s = 0; s < n; s++){
//             long curr_champ = 0;
//             bool first = true;
//             int f = 0;

//             for(int j = 1; j <= n; j++){
//                 if(vis[j]){
//                     continue;
//                 }
//                 if(first == true){
//                     curr_champ = skill[j];
//                     first = false;
//                     continue;
//                 }
//                 if(curr_champ < skill[j]){
//                     f++;
//                     curr_champ = skill[j];
//                 }else{
//                     curr_champ += skill[j];
//                 }
//             }
//             cout << f << endl;
//             if(s < n-1){
//                 vis[per[s + 1]] = true;
//             }

//         }
//         return 0;
//     }
    
// }
#include <bits/stdc++.h>
using namespace std;

class FenwickTree {
public:
    int n;
    vector<long long> tree;

    FenwickTree(int n) : n(n), tree(n + 1, 0) {}

    void update(int i, long long val) {
        while (i <= n) {
            tree[i] += val;
            i += i & (-i);
        }
    }

    long long p(int i) {
        long long s = 0;
        while (i > 0) {
            s += tree[i];
            i -= i & (-i);
        }
        return s;
    }

    long long query(int l, int r) {
        if (l > r) return 0;
        return p(r) - p(l - 1);
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;

        vector<long long> skill(n + 1);
        vector<int> per(n + 1);

        for (int i = 1; i <= n; i++) cin >> skill[i];
        for (int i = 1; i <= n; i++) cin >> per[i];

        FenwickTree fw(n);
        set<int> blocks;       
        vector<int> ans(n);    

        for (int step = n; step >= 1; step--) {
            int pos = per[step];
            long long x = skill[pos];

            fw.update(pos, x);

            int s = -1;
            auto it = blocks.upper_bound(pos);
            if (it != blocks.begin()) {
                --it;
                s = *it;
            }

            int cur_s;
            if (s == -1) {
                cur_s = pos;
                blocks.insert(pos);
            } else {
                long long sumBefore = fw.query(s, pos - 1);
                if (sumBefore < x) {
                    // pos starts a new block
                    cur_s = pos;
                    blocks.insert(pos);
                } else {
                    // pos absorbed into block s
                    cur_s = s;
                }
            }

            while (true) {
                auto it2 = blocks.upper_bound(cur_s);
                if (it2 == blocks.end()) break;
                int nxt = *it2;
                long long blockSum = fw.query(cur_s, nxt - 1);
                if (blockSum >= skill[nxt]) {
                    blocks.erase(it2);   // merge
                } else {
                    break;
                }
            }

            ans[step - 1] = (int)blocks.size() - 1;
        }
        for (int i = 0; i < n; i++) {
            cout << ans[i] << (i + 1 == n ? '\n' : ' ');
        }
    }

    return 0;
}