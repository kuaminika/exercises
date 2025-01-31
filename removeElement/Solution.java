package removeElement;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

class Solution {
    public int solve(int[] nums, int val) {

        int n = nums.length;
        int p1 = 0;
        int p2 = n-1;   
        int [] a = nums;
        
        while(p2>=0 && a[p2]==val )
            p2--;

        while(p1<p2)
        {
            if(a[p1] == val && a[p2] != val)
              {   
                swap (a, p1,p2);
              p2--;
              }
          
            if(a[p1]== val && a[p2] == val)
             {   p2--;
             continue;
             }
            p1++;
           //     p2--;
        }

        int len = 0;
        for(int i = 0; i< n ;i++)
        {
            if ( a[i]== val ) break;

            len++;

        }
     

        return len;       
        
    }


    void swap(int [] a, int i , int j)
    {

        int z = a[i];
        a[i] = a[j];
        a[j] = z;
    }
}