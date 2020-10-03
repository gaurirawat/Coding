package revision;
//https://leetcode.com/problems/crawler-log-folder/
public class String_lc_crawler_log_folder {
    public int minOperations(String[] logs) {
        int x=0;
        for(int i=0;i<logs.length;++i){
            if(logs[i].equals("./"))continue;
            else if(logs[i].equals("../"))
                --x;
            else ++x;
            if(x<0)
                x=0;
        }
        return x;
    }
}
