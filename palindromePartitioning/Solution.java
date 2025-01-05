package palindromePartitioning;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {

        /**
     * 
     * Given a string A, partition A such that every substring of the partition is a palindrome.

        Return the minimum cuts needed for a palindrome partitioning of A.
     */
    public int solve(String str) {       

        
        int n = str.length();
        boolean [][] isPalindrone = mapPalindrone(str, n);


        int [] dp = new int[n];
      //  Arrays.fill(dp,Integer.MAX_VALUE);
      for (int i = 0; i < n; i++) {
        dp[i] = i; // Max cuts = i (worst case: each character is its own palindrome)
    }


        for(int i =0 ; i<n; i++)
         { 
            if(isPalindrone[0][i])
            {
              
                dp[i] = 0;
                continue;
            }
            
           
            for(int j = 1;j<=i; j++)
            {
             

                if(!isPalindrone[j][i]) continue;

               
                dp[i] = Math.min(dp[i], dp[j-1]+1);
            }

        }


      return dp[n-1];
    }



    public boolean [][] mapPalindrone(String str, int n )
    {
        boolean [][] dp = new boolean[n][n];
      

      /* * for(int i = 0; i<n; i++)
        {
            Arrays.fill(dp[i],true);
        } */

   
       
          
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                }
            }
        }
    

        
         return dp;

    }
    
}
