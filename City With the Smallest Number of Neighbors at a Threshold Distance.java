class Solution {
      int findCity(int n, int m, int[][] edges,int distanceThreshold)
      {
           int[][] distanceMatrix = new int[n][n];
        for (int[] row : distanceMatrix)
            Arrays.fill(row, 10001);
        for (int i = 0; i < n; i++)
            distanceMatrix[i][i] = 0;
        for (int[] edge : edges)
            distanceMatrix[edge[0]][edge[1]] = distanceMatrix[edge[1]][edge[0]] = edge[2];
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    distanceMatrix[i][j] = Math.min(distanceMatrix[i][j], distanceMatrix[i][k] + distanceMatrix[k][j]);
        int cityWithMinCities = -1, minReachableCities = n + 1;
        for (int i = 0; i < n; i++) {
            int reachableCities = (int) Arrays.stream(distanceMatrix[i]).filter(dist -> dist <= distanceThreshold).count();
            if (reachableCities <= minReachableCities) {
                minReachableCities = reachableCities;
                cityWithMinCities = i;
            }
        }
        return cityWithMinCities;
      }
}
