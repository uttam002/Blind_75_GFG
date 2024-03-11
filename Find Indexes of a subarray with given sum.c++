class Solution
{
    public:
    //Function to find a continuous sub-array which adds up to a given number.
    vector<int> subarraySum(vector<int>arr, int n, long long s)
    {
        if(s==0) return {-1};
        long long sum = 0;
        int i = 0;
        int j = 0;
        while(j<n){
           if(sum<s){
               sum+=arr[j];
           }
           while(sum>s){
               sum-=arr[i];
               i++;
           }
           if(sum == s){
               return {i+1 , j+1};
           }
           j++;
        }
        return {-1};
    }
};
