package revision;
//https://leetcode.com/problems/student-attendance-record-ii/
public class DP_lc_student_attendance_record {
    public int checkRecord(int n) {
        if (n == 0){
            return 0;
        }

        int[] p = new int[n + 1];
        int[] l = new int[n + 1];
        p[0] = 1; p[1] = 1;
        l[0] = 0; l[1] = 1;

        int mod = (int)Math.pow(10, 9) + 7;
        for (int i = 2; i <= n; ++i) {
            p[i] = (p[i - 1] + l[i - 1]) % mod;
            l[i] = (p[i - 1] + p[i - 2]) % mod;
        }

        int c = (p[n] + l[n]) % mod;

        for (int i = 0; i < n; ++i) {
            c = (int)((c + 1L * (p[i] + l[i]) * (p[n - i - 1] + l[n - 1 - i])) % mod);
        }
        return c;
    }

    /* stupid DFS solution
    public int checkRecord(int n) {
        if (n < 1) {
            return 0;
        }
        int[][][] dp = new int[n + 1][2][3];
        return dfsCheckRecord(n, 0, 0, dp);
    }

    public int dfsCheckRecord(int n, int absent, int l, int[][][]dp){
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (dp[n][absent][l] != 0) {
            return dp[n][absent][l];
        }

        int mod = (int)Math.pow(10, 9) + 7;
        long c = 0L;

        // include P
        c += dfsCheckRecord(n - 1, absent, 0, dp);

        // include A
        if (absent == 0) {
            c += dfsCheckRecord(n - 1, 1, 0, dp);
        }

        // include L
        if (l < 2) {
            c += dfsCheckRecord(n - 1, absent, l + 1, dp);
        }
        c = c % mod;
        dp[n][absent][l] = (int)c;
        return (int)c;
    }
     */
}
