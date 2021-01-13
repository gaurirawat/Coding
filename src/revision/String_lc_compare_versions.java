package revision;

import java.util.Arrays;

public class String_lc_compare_versions {
    public int compareVersion(String version1, String version2) {
        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        int i = 0;
        while(i < a.length || i < b.length) {
            int numa = getNumber(i, a);
            int numb = getNumber(i, b);
            if (numa == numb) {
                ++i;
            } else if (numa < numb) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }

    public int getNumber(int i, String[]nums) {
        return i >= nums.length ? 0 : Integer.parseInt(nums[i]);
    }
}
