package revision;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//https://practice.geeksforgeeks.org/problems/stock-buy-and-sell/0
import java.util.Scanner;

public class DP_lc_buy_sell_stock_1 {
    //leetcode
    public int maxProfit(int[] prices) {
        if(prices==null|| prices.length==0) return 0;
        int min=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;++i){
            min=Math.min(prices[i],min);
            profit=Math.max(profit, prices[i]-min);
        }
        return profit;
    }

    //gfg
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =Integer.parseInt(sc.nextLine());
        while(t--!=0){
            int len=sc.nextInt();
            int arr[]= new int[len];
            for(int i=0;i<arr.length;++i)
                arr[i]=sc.nextInt();
            System.out.println(buySellStock(arr));
        }
    }

    public static String buySellStock(int arr[]){
        String s="";
        boolean purchased=false;
        for(int i=0;i<arr.length;++i){
            if(purchased && (i==arr.length-1||arr[i]>arr[i+1])){
                s+=i+") ";
                purchased=!purchased;
            }
            else if(!purchased && i!=arr.length-1 && arr[i]<arr[i+1]){
                s+="("+i+" ";
                purchased=!purchased;
            }
        }
        return s.equals("")?"No Profit":s;
    }
}
