package template;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class SolutionWithLog {
 
    LogTool  l = new LogTool();
   
    public int solve( String str ) {       

        int [][] isPalindrome = makeIsPalinomialGrid(str);
        int max = 0;
        int n = str.length();
        for(int i =0; i<n; i++)
         for(int j = i;j< n;j++)
         {
            if(!(isPalindrome[i][j] ==1 ) )continue;


            max = Math.max(max, j-i);


         }

        
       return max;
    }




    int[] doLISDP(int [] arr)
    {
        int n = arr.length;
        int[]dp =new int[n];

        Arrays.fill(dp,1);
        for(int i = 0; i<n;i++)
            for(int j = 0; j<i; j++)
            {

                if( !(arr[j]<arr[i])) continue;


                dp[i] = Math.max(dp[i], dp[j]+1);

            }

            return dp;
    }

     int [][] makeIsPalinomialGrid(String str)
     {
        int n = str.length();
        int[][] isPalinomial = new int [n][n];

        for(int i = 0; i< n ;i++)
        {
            isPalinomial[i][i] =  1;
        }

        if(n ==1 ) return  isPalinomial;
        for( int i = 0; i<n-1; i++)
        {
            int j = i+1;
            isPalinomial[i][j] = str.charAt(i) == str.charAt(j)? 1:0;
        }
        if(n==2)return  isPalinomial;
        

        for(int len = 3; len <=n ; len ++)
            for(int i = 0; i <= n-len  ; i++)
            {
                 int j =  i+len - 1;

                 isPalinomial[i][j] = str.charAt(i) == str.charAt(j) && isPalinomial[i+1][j-1] == 1? 1:0;
            }
         return isPalinomial;
     }
    
}