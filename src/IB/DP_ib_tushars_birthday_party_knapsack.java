package IB;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.util.*;

//https://www.interviewbit.com/problems/tushars-birthday-party/
public class DP_ib_tushars_birthday_party_knapsack {
    public int solve(final List<Integer> friends, final List<Integer> cap, final List<Integer> cost) {
        int capacity = Collections.max(friends);

        int[] dp = knapsack(cap, cost, capacity);
        int answer = 0;
        for(int x: friends) {
            answer += dp[x];
        }
        return answer;
    }

    public int[] knapsack(final List<Integer> cap, final List<Integer> cost, int capacity) {
        int[] dp = new int[capacity+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i=1; i<=cap.size(); ++i) {
            for (int j=0; j<=capacity; ++j) {
                if (cap.get(i-1)<=j && dp[j-cap.get(i-1)] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j-cap.get(i-1)] + cost.get(i-1));
                }
            }
        }
        return dp;
    }

    /*
    public int solve(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        if (a.size() == 0) {
            return 0;
        }
        int max = Collections.max(a);
        int[] dp = new int[max + 1];
        coinChange(dp, b, c);

        int answer = 0;
        for (int x : a) {
            answer += dp[x];
        }
        return answer;
    }

    public void coinChange(int[] dp, final List<Integer> b, final List<Integer> c) {
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < b.size(); ++i) {
            int foodCap = b.get(i);
            for (int j = foodCap; j < dp.length; ++j) {
                if (dp[j - foodCap] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - foodCap] + c.get(i));
                }
            }
        }
    }
     */
}
