class Solution {
    public int maximumBridges(int n, int m, int[] a, int[] b) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return lcs(a, b, n - 1, m - 1, dp);
    }

    private int lcs(int[] a, int[] b, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (a[i] == b[j]) {
            dp[i][j] = 1 + lcs(a, b, i - 1, j - 1, dp);
        } else {
            dp[i][j] = Math.max(lcs(a, b, i - 1, j, dp), lcs(a, b, i, j - 1, dp));
        }
        return dp[i][j];
    }
}
