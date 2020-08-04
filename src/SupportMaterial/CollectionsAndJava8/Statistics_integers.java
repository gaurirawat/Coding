package SupportMaterial.CollectionsAndJava8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;

public class Statistics_integers {
    public static void main(String[] args) {
        List numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> (int) x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

        OptionalInt y= numbers.stream().mapToInt(a->(int)a).max();
        int max=y.getAsInt();

    }
}
