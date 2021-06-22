package com.solve.java.day3;

// LC Medium 636 :https://leetcode.com/problems/exclusive-time-of-functions/
import java.util.Arrays;
import java.util.List;

public class ExclusiveTimeFunctions {
    class Log {
        int id;
        int time;
        String jobType;

        Log(String log) {
          String[] result = log.split(":");
          this.id = Integer.parseInt(result[0]);
          this.jobType = result[1];
          this.time = Integer.parseInt(result[2]);
        }
    }

    public int[] exclusiveTimeApp2(int n, List<String> logs) {
        if(n==0 || logs.size()==0)
            return null;
        return null;
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        if(n==0 || logs.size()==0)
            return null;
        // declare output array
        int[] result = new int[n];

        String prevJobLog = logs.get(0);
        int prevJobId = Integer.valueOf(prevJobLog.substring(0,1));
        result[prevJobId] = Integer.valueOf(prevJobLog.substring(prevJobLog.length()-1));

        for(int i=1;i<logs.size();i++){

            String jobLog = logs.get(i);
            int curJobId = Integer.valueOf(jobLog.substring(0,1));
            int timeToStart = Integer.valueOf(jobLog.substring(jobLog.length()-1));

            if(prevJobId!=curJobId) {
                if(prevJobLog.contains("start")) {
                    result[prevJobId]+=timeToStart;
                }
            }

            if(jobLog.contains("start")) {
                result[curJobId] +=timeToStart;
            } else {
                result[curJobId] =timeToStart-result[curJobId]+1;
            }
            prevJobLog = jobLog;

        }
        return result;
    }

    public static void main(String[] args){

        String s ="0:start:0";
        int prevJobId = Integer.valueOf(s.substring(0,1));
        int value = Integer.valueOf(s.substring(s.length()-1));

        System.out.println("prevJobId: "+prevJobId);
        System.out.println("value: "+value);
        int n=2;
        String[] array ={"0:start:0","1:start:2","1:end:5","0:end:6"};
        //o/p : 0->7, 1->4
        List strList = Arrays.asList(array);
        ExclusiveTimeFunctions etf = new ExclusiveTimeFunctions();
        int[] result = etf.exclusiveTime(2,strList);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}
