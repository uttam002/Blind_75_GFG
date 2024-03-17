class Solution{
public:
    //Function to find the days of buying and selling stock for max profit.
    vector<vector<int> > stockBuySell(vector<int> A, int n){
        vector<vector<int>>ans;
        int p=0;
        for(int i=1;i<n;i++)
        {
            if(A[i]>A[i-1])
            {
              vector<int>v;
              v.push_back(i-1);
              v.push_back(i);
              ans.push_back(v);
            }
        }
        return ans;
    }
};
