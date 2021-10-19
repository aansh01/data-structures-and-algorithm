class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++)
            dp[i] = i;
        for(int e = 2; e <= k; e++){
            int[] dp2 = new int[n + 1];
            int x = 1;
            for(int f = 1; f <= n; f++){
                while(x < f && Math.max(dp[x - 1], dp2[f - x]) > Math.max(dp[x], dp2[f - x - 1]))
                    x++;
                dp2[f] = Math.max(dp[x - 1], dp2[f - x]) + 1;
            }
            dp = dp2;
        }
        return dp[n];
    }
}
