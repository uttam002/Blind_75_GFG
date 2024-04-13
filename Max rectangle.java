

/*Complete the function given below*/
class Solution {
    public int maxArea(int M[][], int n, int m) {
        if (M == null || n == 0 || m == 0) {
            return 0;
        }
        int[] heights = new int[m];
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                heights[j] = M[i][j] == 1 ? heights[j] + 1 : 0;
            }

            for (int j = 0; j < m; j++) {
                int height = heights[j];
                int width = 1;
                for (int k = j - 1; k >= 0 && heights[k] >= height; k--) {
                    width++;
                }
                for (int k = j + 1; k < m && heights[k] >= height; k++) {
                    width++;
                }
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
}
