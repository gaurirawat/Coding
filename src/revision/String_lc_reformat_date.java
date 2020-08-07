package revision;
//https://leetcode.com/problems/reformat-date/
public class String_lc_reformat_date {
    public String reformatDate(String date) {
        String s[]=date.split(" ");
        String res="";

        if(Character.isDigit(s[0].charAt(1)))
            res="-"+s[0].substring(0,2);
        else
            res="-0"+s[0].charAt(0);

        String month="";
        if(s[1].equals("Jan")) month="01";
        else if(s[1].equals("Feb")) month="02";
        else if(s[1].equals("Mar")) month="03";
        else if(s[1].equals("Apr")) month="04";
        else if(s[1].equals("May")) month="05";
        else if(s[1].equals("Jun")) month="06";
        else if(s[1].equals("Jul")) month="07";
        else if(s[1].equals("Aug")) month="08";
        else if(s[1].equals("Sep")) month="09";
        else if(s[1].equals("Oct")) month="10";
        else if(s[1].equals("Nov")) month="11";
        else if(s[1].equals("Dec")) month="12";
        res=s[2]+"-"+month+res;
        return res;
    }
}
