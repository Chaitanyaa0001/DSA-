#include<bits/stdc++.h>
using namespace std;


struct TreeNode
{
    /* data */
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int val){
        this->val = val;
        this->left = nullptr;
        this->right = nullptr;
    }
};
vector<vector<int>> verticalTraversal(TreeNode* root) {
    map<int,map<int,vector<int>>> mp;
    queue<pair<int,pair<int,TreeNode*>>> q ;
    q.push({0,{0,root}});
    while (!q.empty()){
        int size = q.size();
        for(int i  = 0; i < size; i++){
            auto curr = q.front();
            q.pop();
            int c = curr.first;
            int r = curr.second.first;
            TreeNode* nde = curr.second.second;
            mp[c][r].push_back(nde->val);

            if(nde->left != nullptr){
                q.push({c-1,{r+1,nde->left}});
            }
            if(nde->right != nullptr){
                q.push({c+1,{r+1,nde->right}});
            }
        }
    }
    vector<vector<int>> ans;

    for (auto& it : mp) {
        vector<int> colValues;

        for (auto& itt : it.second) {
            auto& values = itt.second;
            sort(values.begin(), values.end());

            for (int x : values) {
                colValues.push_back(x);
            }
        }
        ans.push_back(colValues);
    }
    return ans;
    
}
int main(){
    return 0;
}