package revision;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://practice.geeksforgeeks.org/problems/minimize-the-heights/0
public class Greedy_gfg_minimize_height {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- != 0) {
            int k = Integer.parseInt(sc.nextLine());
            int len = Integer.parseInt(sc.nextLine());
            String s[] = sc.nextLine().split(" ");
            int arr[] = new int[len];
            for (int i = 0; i < len; ++i)
                arr[i] = Integer.parseInt(s[i]);
            System.out.println(minDiff(arr, k));
        }
    }

    public static int minDiff(int arr[], int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int min2 = Integer.MAX_VALUE, max2 = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] - min >= max - arr[i])
                arr[i] -= k;
            else
                arr[i] += k;
            min2 = Math.min(min2, arr[i]);
            max2 = Math.max(max2, arr[i]);
        }
        return max2 - min2 > max - min ? max - min : max2 - min2;

    }
}