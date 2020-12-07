package revision;
import java.util.*;
//https://leetcode.com/problems/find-and-replace-in-string/submissions/
public class String_lc_find_and_replace_string {
    public String findReplaceString(String s, int[] idx, String[] src, String[] tgt) {
        Data[] arr=new Data[idx.length];
        for(int i=0;i<idx.length;++i) {
            Data t= new Data(idx[i], src[i], tgt[i]);
            arr[i]=t;
        }
        Arrays.sort(arr, Comparator.comparingInt(a->a.idx));
        StringBuilder sb=new StringBuilder();
        int itr=0;
        for(int i=0;i<s.length();++i) {
            while (itr<arr.length && arr[itr].idx<i) {
                ++itr;
            }
            // System.out.println(arr[itr].idx+" "+(itr<arr.length) +" "+ (arr[itr].idx==i) +" "+ ((i+arr[itr].src.length())<=s.length() )+" "+ arr[itr].src.equals(s.substring(i, i+arr[itr].src.length())));
            if (itr<arr.length && arr[itr].idx==i && (i+arr[itr].src.length())<=s.length() && arr[itr].src.equals(s.substring(i, i+arr[itr].src.length()))) {
                sb.append(arr[itr].tgt);
                i+=arr[itr].src.length()-1;
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    class Data{
        int idx;
        String src;
        String tgt;
        public Data(int a, String b, String c) {
            idx=a;
            src=b;
            tgt=c;
        }
    }
}
