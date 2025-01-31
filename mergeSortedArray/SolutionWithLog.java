package mergeSortedArray;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class SolutionWithLog {
 
    LogTool  l = new LogTool();
    
    public void deactivateLog()
    {
        l.turnOff();
    }

    public void activateLog()
    {
        l.turnOn();
    }

    public void solve(int[] nums1, int m, int[] nums2, int n) {
        
        if(n == 0  || nums2.length == 0) return;


        l.logLn("inputs:");
            int []a = nums1;
            int []b = nums2;
         l.logLnArrr_int(a);
         l.logLnArrr_int(b);
            int i = m-1;
            int len = nums1.length;
            int j = n-1; 
            int k =len-1;

        if(m== 0)
        {
            for(i=0;i<len;i++)
            {
                a[i]= b[i];
            }
            return;
        }
 
        while(j>=0 && i>=0)
        {
            if(b[j]>=a[i])
            {
                a[k] = b[j];
                k--;
                j--;
                continue;
            }

            a[k]= a[i];
            i--;

            k--;

        }


        while (k>=0 && j>=0) {
            
            a[k] = b[j];
            k--;
            j--;
        }

    
 

    }


     
    
}