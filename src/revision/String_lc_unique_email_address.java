package revision;

import java.util.HashSet;

//https://leetcode.com/problems/unique-email-addresses/submissions/
public class String_lc_unique_email_address {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set=new HashSet<String>();
        for(String email: emails){
            String[] arr=email.split("@");
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<arr[0].length();++i) {
                if(arr[0].charAt(i)=='+'){
                    break;
                }
                else if(arr[0].charAt(i)=='.'){
                    continue;
                }
                else{
                    sb.append(arr[0].charAt(i));
                }
            }
            sb.append('@'+arr[1]);
            set.add(sb.toString());
        }
        return set.size();
    }
}
