class Solution {
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {

        
        long totalSum = 0,leftSum = 0;
        for (int i = 0; i < n; i++) totalSum += arr[i];
        
        for(int i = 0; i<n; i++){
            long rightSum = totalSum - leftSum - arr[i];
            if(leftSum == rightSum)return i+1;
            leftSum += arr[i];
        }
        return -1;
    }
}
