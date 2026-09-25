#include <bits/stdc++.h>
using namespace std;

void solve() {
    int n, m;
    cin >> n >> m;
    cout << "Yes\n";

    // 1D cases
    if (n == 1 || m == 1) {
        int len = max(n, m);
        string s;
        if (len == 1) s = "0";
        else if (len == 2) s = "11";
        else if (len == 3) s = "110";
        else if (len == 4) s = "0110";
        else if (len == 5) s = "11011";
        else {
            // repeat "110" and fix tail
            for (int i = 0; i < len; i++) s += '1';
            for (int i = 2; i < len; i += 3) s[i] = '0';
            if (len % 3 == 1) s[len-1] = '0', s[len-2] = '1';
            if (len % 3 == 2) s[len-1] = '0';
        }
        if (n == 1) cout << s << "\n";
        else for (char c : s) cout << c << "\n";
        return;
    }

    // n, m >= 2
    if (n == 2 && m == 2) {
        cout << "22\n22\n";
        return;
    }

    // Universal pattern for n,m >= 2 (except 2x2)
    // Place 0 at (0,0), 1s at (1,1),(1,2),(2,1), and 2s elsewhere
    // Then fix remaining cells using a safe fill
    vector<string> g(n, string(m, '2'));
    g[0][0] = '0';
    if (n >= 2 && m >= 2) {
        g[0][1] = '2';
        g[1][0] = '2';
    }
    // Handle small cases specially
    if (n == 2 && m == 3) {
        cout << "122\n122\n";
        return;
    }
    if (n == 3 && m == 2) {
        cout << "11\n22\n22\n";
        return;
    }
    if (n == 3 && m == 3) {
        cout << "222\n202\n222\n";
        return;
    }
    // For larger grids, use the pattern:
    // 0 at (0,0), 1 at (1,1),(1,2),(2,1), rest 2
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (i == 0 && j == 0) cout << '0';
            else if (i == 1 && j == 1) cout << '1';
            else if (i == 1 && j == 2) cout << '1';
            else if (i == 2 && j == 1) cout << '1';
            else cout << '2';
        }
        cout << "\n";
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) solve();
    return 0;
}