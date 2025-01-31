package removeElement;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class SolutionWithLog {
 
    public LogTool  l = new LogTool();
   
    public int solve(int[] nums, int val) {

        int n = nums.length;
        int p1 = 0;
        int p2 = n-1;   
        int [] a = nums;        
        
        while(a[p2]==val && p2>=0)
            p2--;

        while(p1<p2)
        {
            l.logLn(String.format("starting while  with p1=%d, p2=%d",p1,p2 ));
            l.logLnArrr_int(a);
            l.logLn("--- a[p1] == val && a[p2] != val:"+(a[p1] == val && a[p2] != val));
            if(a[p1] == val && a[p2] != val)
                {swap (a, p1,p2);
                    p2--;
                }
           

            if(a[p1]== val && a[p2] == val)
            {   p2--;
            continue;
            }
            l.logLn(String.format("leaving while  with p1=%d, p2=%d",p1,p2 ));
            l.logLnArrr_int(a);
                p1++;
             //   p2--;
        }

        int len = 0;
        for(int i = 0; i< n ;i++)
        {
            if ( a[i]== val ) break;

            len++;

        }
     
        l.logLnArrr_int(a);
        return len;       
        
    }


    void swap(int [] a , int x, int y)
    {

        int z = a[x]; 
        a[x] = a[y];
        a[y] = z;

    }

     
    
}