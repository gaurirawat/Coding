package revision;
//https://leetcode.com/problems/gas-station/submissions/
public class Greedy_lc_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totGas = 0;
        int totCost = 0;
        int l = 0;

        int currGas = 0;
        for (int i = 0; i < cost.length; ++i) {
            currGas += gas[i] - cost[i];
            if (currGas < 0) {
                currGas = 0;
                l = i + 1;
            }
            totGas += gas[i];
            totCost += cost[i];
        }

        if (l == cost.length + 1 || totGas < totCost) {
            return -1;
        }
        else {
            return l;
        }
    }
}