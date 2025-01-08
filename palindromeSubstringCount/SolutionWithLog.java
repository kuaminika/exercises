package palindromeSubstringCount;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class SolutionWithLog {

        /**
     * 
     * Given a string A, partition A such that every substring of the partition is a palindrome.

        Return the minimum cuts needed for a palindrome partitioning of A.
     */
    LogTool  l = new LogTool();
    public int solve(String str) {       

      int n = str.length();


      if(n==1) return 1;


      if(n==2 )
      {
         if(str.charAt(0) ==  str.charAt(1)) return 3;

         return 2;
      }


      boolean [][] dp = new boolean[n][n];
      int count =0;
      l.logLn("starting, count="+count);;


      for(int i =0;i<n;i++)
      {
         count++;
         int j = i;
         dp[i][j] = true;
      }

      l.logLn("checked substrings of len=1");
      for(int i=0; i<n-1;i++)
      {         
         boolean twoCharsSame = str.charAt(i)== str.charAt(i+1);  
         if(!twoCharsSame) continue;
         int j = i+1;
         dp[i][j] = true;
         count++;
      }

      l.logLn("checked substrings of len=2");
    

      l.logLn("first part over");
      l.logLnArrr_2D_boolean(dp);
      l.logLn("count:"+count);
    //   if(n<=3) return count;


      for(int k = 3; k<=n;k++)
      {
         for(int i = 0; i<=n-k;i++)
         {
            int j = i+k-1;

            boolean endsTheSame = str.charAt(i)== str.charAt(j);  
        
            dp[i][j] = endsTheSame && dp[i+1][j-1];

            if(dp[i][j]) count++;
            
            l.logLn(" endsTheSame="+endsTheSame+"  && dp[i+1][j-1]="+dp[i+1][j-1]+" count=>"+count+ " -->"+ str.substring(i, j+1));


                  
                  
            l.logLnArrr_2D_boolean(dp);
            l.logLn("");

         }
      }



   

         l.logLnArrr_2D_boolean(dp);

      return count;
    }



     
    
}