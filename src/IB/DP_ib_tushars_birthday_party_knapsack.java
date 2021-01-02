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
}
