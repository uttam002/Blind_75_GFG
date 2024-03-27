class Solution {
    static boolean check(int i, int j, int[][] mat) {
        if (i - 1 >= 0 && mat[i - 1][j] == 0) return false;
        if (i + 1 < mat.length && mat[i + 1][j] == 0) return false;
        if (j - 1 >= 0 && mat[i][j - 1] == 0) return false;
        if (j + 1 < mat[0].length && mat[i][j + 1] == 0) return false;

        return true;
    }

    static int solve(int i, int j, int[][] mat, int[][] vis, int[][] dp) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || vis[i][j] == 1 || mat[i][j] == 0)
            return Integer.MAX_VALUE;

        if (dp[i][j] != -1) return dp[i][j];

        if (!check(i, j, mat)) return Integer.MAX_VALUE;

        if (j == 0) return mat[i][0];

        vis[i][j] = 1;

        int left = solve(i, j - 1, mat, vis, dp);
        int up = solve(i - 1, j, mat, vis, dp);
        int down = solve(i + 1, j, mat, vis, dp);

        if (left != Integer.MAX_VALUE) left += mat[i][j];
        if (up != Integer.MAX_VALUE) up += mat[i][j];
        if (down != Integer.MAX_VALUE) down += mat[i][j];

        vis[i][j] = 0;

        return dp[i][j] = Math.min(left, Math.min(up, down));
    }

    static int findShortestPath(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            mini = Math.min(mini, solve(i, m - 1, mat, vis, dp));
        }

        if (mini == Integer.MAX_VALUE) return -1;
        else return mini;
    }
}
