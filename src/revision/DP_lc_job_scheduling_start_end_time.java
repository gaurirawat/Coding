package revision;
//https://leetcode.com/problems/maximum-profit-in-job-scheduling/submissions/
//reference: https://leetcode.com/problems/maximum-profit-in-job-scheduling/discuss/409009/JavaC%2B%2BPython-DP-Solution

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class DP_lc_job_scheduling_start_end_time {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        Job jobs[]= new Job[startTime.length];
        for(int i=0;i<startTime.length;++i)
            jobs[i]= new Job(startTime[i], endTime[i],profit[i]);
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.e));
        TreeMap<Integer, Integer> map= new TreeMap<Integer,Integer>();
        map.put(0,0);

        for(Job job: jobs){
            int currP=job.p+map.floorEntry(job.s).getValue();
            if(currP>map.lastEntry().getValue())
                map.put(job.e,currP);
        }
        return map.lastEntry().getValue();
    }
    class Job{
        int s,e,p;
        public Job(int s, int e, int p){
            this.s=s;
            this.p=p;
            this.e=e;
        }
    }

//    public static void main(String[] args) {
//        int startTime[] = {2,1,3,2}, endTime[] = {2,3,5,6}, profit[] = {20,10,40,80};
//        System.out.println(jobScheduling(startTime,endTime,profit));
//    }
}


