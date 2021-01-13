package revision;
//https://leetcode.com/problems/longest-common-prefix/
public class String_lc_longest_common_prefix {
    public String longestCommonPrefix(String[] list) {
        if (list.length == 0) {
            return "";
        }
        int l = 0;
        outer: for (int i = 0; i < list[0].length(); ++i) {
            boolean inc = true;
            char ch = list[0].charAt(i);
            for (int j = 1; j < list.length; ++j) {
                if (list[j].length() == i || ch != list[j].charAt(i)) {
                    break outer;
                }
            }
            l++;
        }
        return list[0].substring(0, l);
    }
}
