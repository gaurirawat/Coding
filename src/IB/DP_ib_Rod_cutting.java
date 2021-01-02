package IB;

import java.util.*;

public class DP_ib_Rod_cutting {
    public int[] rodCut(int A, int[] B) {
        ArrayList<Integer> cuts = new ArrayList<Integer>();
        for (int x : B) {
            cuts.add(x);
        }
        Collections.sort(cuts);
        cuts.add(0, 0);
        cuts.add(A);

        CostIndex dp[][] = new CostIndex[cuts.size()][cuts.size()];
        minCostToCutRod(0, cuts.size() - 1, cuts, dp);

        ArrayList<Integer> answer = new ArrayList<Integer>();
        getResult(answer, cuts, dp, 0, cuts.size() - 1);

        int[] answerArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            answerArray[i] = answer.get(i);
        }

        return answerArray;
    }

    public void getResult(ArrayList<Integer> answer, ArrayList<Integer> cuts, CostIndex[][] dp, int l, int r) {
        if (l + 1 == r) {
            return;
        }
        answer.add(cuts.get(dp[l][r].index));
        getResult(answer, cuts, dp, l, dp[l][r].index);
        getResult(answer, cuts, dp, dp[l][r].index, r);
    }

    public int minCostToCutRod(int l, int r, ArrayList<Integer> cuts, CostIndex[][] dp) {
        if (r == l + 1) {
            return 0;
        }

        if (dp[l][r] != null) {
            return dp[l][r].cost;
        }

        int min = Integer.MAX_VALUE;
        int cut = 0;
        for (int i = l + 1; i < r; ++i) {
            int cost = minCostToCutRod(l, i, cuts, dp) + minCostToCutRod(i, r, cuts, dp);
            if (cost < min) {
                min = cost;
                cut = i;
            }
        }

        min += cuts.get(r) - cuts.get(l);
        dp[l][r] = new CostIndex(cut, min);

        return min;
    }
    class CostIndex{
        int index;
        int cost;
        public CostIndex(int x, int y){
            index=x;
            cost=y;
        }
    }
}