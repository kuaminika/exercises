package russianDollEnvelope;


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

        
      int n = A.size();
      ArrayList<NVlope> envlopes = new ArrayList<NVlope> ();

      for(int i= 0; i <n ;i++)
      {
          int h = A.get(i).get(0);
          int w = A.get(i).get(1);
          envlopes.add(new NVlope(h,w));
      }

      // sorting by width


   envlopes.sort((a,b)->{
       if(a.height == b.height ) return b.width - a.width;

       return a.height - b.height;

   });

      // doing the LIS width
      int [] dp = new int[n];
      Arrays.fill(dp,1);
      int max = 1;
      for(int i = 0;i<n ; i++)
        {  for(int j = 0; j< i ;j++)
          {
              boolean condition = envlopes.get(i).width >  envlopes.get(j).width ;
              if(!condition) continue;
              dp[i] = Math.max(dp[i], dp[j]+1);

          }

          max = Math.max(dp[i],max);
        }
      return max;
  }

  class NVlope
  {
      int height; 
      int width;


      public NVlope(int h, int w)
      {
           height = h;
           width = w;
      }

  }
    


    
}