// Function to return minimum number of jumps to end of array

class Solution{
  public:
    int minJumps(int arr[], int n){
        // Your code here..
        int ans = 0,End = 0,Far = 0;
        for (int i = 0; i < n - 1; i++) {
        Far = max(Far, i + arr[i]);
        
        if (i == End) {
            ans++;
            End = Far;
        }
        
    }
    if(End<n-1) return -1;
    return ans;
    }
};
