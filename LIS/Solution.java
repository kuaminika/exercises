package template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
 
/**
 * 
 * Find the longest increasing subsequence of a given array of integers, A.

In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.

In this case, return the length of the longest increasing subsequence.
 * 
 */
public class Solution {
    LogTool l = new LogTool();
    public int solve(ArrayList<Integer> A, int B) {       

        if (A == null || A.isEmpty()) {
            return 0;
        }
        
        int n = A.size();
        l.logLn(n+"");

        int [] dp = new int[n];
        int max = 1;
        Arrays.fill(dp, 1); // Initialize LIS for every index as 1

        for(int i =1;i<n ; i++)
        {
            for (int j=0 ; j< i; j++ )
            {
               int ith =  A.get(i);
               int jth = A.get(j);
               if(jth<ith)
                dp[i]= Math.max(dp[i], dp[j]+1);              
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}


class LogTool {
    private boolean on;


    String indent = "";
    
    public LogTool()
    {
        on = true;
    }
    public void turnOn()
    {
        this.on = true;
    }

    public void turnOff()
    {
        this.on = false;
    }



    public void log(String str)
    {
        if(!on) return;
        System.out.print(indent+str);
    }


    public void logLn(String str)
    {
        if(!on) return;
        System.out.println(indent+str);
    }


}