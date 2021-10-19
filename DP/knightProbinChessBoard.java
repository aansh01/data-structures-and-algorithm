class Solution {
    public static boolean inBoard(int n, int i, int j) {
        if (i < n && i >= 0 && j < n && j >= 0)
            return true;
        return false;
    }
    public double knightProbability(int n, int k, int row, int column) {
        double[][] prev = new double[n][n];
        prev[row][column] = 1;
        while (k-- > 0) {
            double[][] curr = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (prev[i][j] != 0) {
                        double prob = prev[i][j] / 8.0;

                        int ci = i - 2, cj = j + 1;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i - 1;
                        cj = j + 2;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i + 1;
                        cj = j + 2;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i + 2;
                        cj = j + 1;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i + 2;
                        cj = j - 1;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i + 1;
                        cj = j - 2;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i - 1;
                        cj = j - 2;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;

                        ci = i - 2;
                        cj = j - 1;
                        if (inBoard(n, ci, cj))
                            curr[ci][cj] += prob;
                    }
                }
            }
            prev = curr;
        }
        double prob = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                prob += prev[i][j];
        return prob;
    }
}
