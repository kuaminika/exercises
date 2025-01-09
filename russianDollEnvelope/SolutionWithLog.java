package russianDollEnvelope;


import java.util.ArrayList;
import java.util.HashMap;
 

import java.util.Arrays;
import java.util.Comparator;

public class SolutionWithLog {

        /**
     * 
     * Given a string A, partition A such that every substring of the partition is a palindrome.

        Return the minimum cuts needed for a palindrome partitioning of A.
     */
    LogTool  l = new LogTool();
    public int solve(ArrayList<ArrayList<Integer>> matrix) {       

      int n = matrix.size();
      ArrayList<russianDollEnvelope.Envelope> envelopes = new ArrayList<russianDollEnvelope.Envelope>();
        for(int i=0;i< n;i++)
        {
           int height=  matrix.get(i).get(0);
           int width = matrix.get(i).get(1);
        }
         

      return doIt(envelopes);
    }


    public int doIt(ArrayList<russianDollEnvelope.Envelope> envelopes)
    {
        envelopes.sort(Comparator.comparing(env1->env1.height));
       //  Comparator.comparing(person -> person.age)

      int n = envelopes.size();


      int []dp = new int[n];
      int max = 1;
      Arrays.fill(dp,1);

      l.logLn("sorted by height");
      for(int i= 0; i<n ;i++)
      {
         l.log("->"+envelopes.get(i)+"->");
      }

      
      l.logLn("");

      l.logLn("all widths");
      for(int i= 0; i<n ;i++)
      {
         l.log("->"+envelopes.get(i).width+"->");
      }

      l.logLn("");
      for(int i= 0; i<n ;i++)
         {
            l.logLn("i:"+i);
            l.indent = " ";
            for(int j= 0; j<i;j++)
            {
               l.logLn("j:"+j);
               Envelope eI = envelopes.get(i);
               Envelope eJ = envelopes.get(j);

               l.logLn(eI+" and "+ eJ);
               
               l.logLn( eJ.width +"<"+ eI.width+"?:"+( eJ.width < eI.width));
               if( !(eJ.width < eI.width )) continue;

               
               l.log("dp is now:");

               // if arr[j]<arr[i]

               dp[i] = Math.max(dp[i],dp[j]+1);
               l.logLnArrr_int(dp);
               max = Math.max(max, dp[i]);
               l.logLn("max is now:"+max);
            } 
            
            l.indent = "";
            

         }

         return max;
    }
     
    
}
