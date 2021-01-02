package revision;

import java.util.List;

//https://leetcode.com/problems/triangle/submissions/

public class DP_lc_min_path_sum_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()==0) {
            return 0;
        }

        for(int i=triangle.size()-2; i>=0; --i) {
            for(int j=0; j<triangle.get(i).size(); ++j) {
                int path = triangle.get(i).get(j)+
                        Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                triangle.get(i).set(j, path);
            }
        }
        return triangle.get(0).get(0);
    }
}
