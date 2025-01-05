package palindromePartitioning;


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
        boolean [][] isPalindrone = mapPalindrone(str, n);


        l.logLnArrr_2D_boolean(isPalindrone);
        int [] dp = new int[n];
      //  Arrays.fill(dp,Integer.MAX_VALUE);
      for (int i = 0; i < n; i++) {
        dp[i] = i; // Max cuts = i (worst case: each character is its own palindrome)
    }


        for(int i =0 ; i<n; i++)
         { 
            if(isPalindrone[0][i])
            {
                l.logLn("when i="+i+" we habve a palindrone. so dp["+i+"]=0");
                dp[i] = 0;
                continue;
            }
            
            l.logLn("when i="+i+" we dont have a palindrone. so we doing the thing");

            for(int j = 1;j<=i; j++)
            {
                l.logLn("doing j="+j+", i="+i);
                l.logLn(str.substring(j,i+1));

                if(!isPalindrone[j][i]) continue;

                l.logLn("when j="+j+" we  have a palindrone. so we doing the deeper thing");
                l.log("dp[j-1]+1:"+(dp[j-1]+1));
                l.logLn(",dp[i]:"+(dp[i]+1));

                dp[i] = Math.min(dp[i], dp[j-1]+1);
            }

        }

        l.logLnArrr_int(dp);

      return dp[n-1];
    }



    public boolean [][] mapPalindrone(String str, int n )
    {
        boolean [][] dp = new boolean[n][n];
        l.logLn("i am starting the map");

     
   
       
          
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
    

         l.logLn("i finished the map");
        
         return dp;

    }
    
}
