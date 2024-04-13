
class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        if (M == null || R == 0 || C == 0) {
            return 0;
        }
        
        int maxSum = Integer.MIN_VALUE;
        
        // Iterate over each column pair (c1, c2)
        for (int c1 = 0; c1 < C; c1++) {
            int[] rowSum = new int[R]; // Stores the sum of elements from row i to row j for column range (c1, c2)
            for (int c2 = c1; c2 < C; c2++) {
                // Update rowSum for the current column pair (c1, c2)
                for (int r = 0; r < R; r++) {
                    rowSum[r] += M[r][c2];
                }
                
                // Apply Kadane's algorithm to rowSum to find maximum sum subarray
                int maxSubarraySum = kadane(rowSum);
                maxSum = Math.max(maxSum, maxSubarraySum);
            }
        }
        
        return maxSum;
    }
    
    // Kadane's algorithm for 1D array
    private int kadane(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
}
