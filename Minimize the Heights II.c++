// User function template for C++

class Solution {
  public:
    int getMinDiff(int arr[], int n, int k) {
        
        int MAX,MIN,ans;
        sort(arr , arr+n);
         
        MAX = arr[n-1];
        MIN = arr[0];
        ans = arr[n-1]-arr[0];
            
         for(int i = 1 ; i< n ; i++){

            if(arr[i]-k <0) continue;

             MAX = max(arr[i-1]+k , arr[n-1]-k);

             MIN = min(arr[0]+k , arr[i] -k);

             ans = min(ans , MAX-MIN);

         }
         return ans;
    }
};
