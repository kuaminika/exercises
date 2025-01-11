package floyd_warshall;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {

    public  ArrayList<ArrayList<Integer>>  solve(ArrayList<ArrayList<Integer>> A) {       

      int n = A.size();
        
         for(int k = 0; k < n;k++)
            for(int i = 0;i<n;i++)
               for(int j = 0;j<n;j++)
               {
                  int u =i;
                  int v = j;


                  
                  int d_uv = A.get(u).get(v);
         
                  d_uv = d_uv <0? Integer.MAX_VALUE :d_uv;

                  int d_uk = A.get(u).get(k);
                  if(d_uk<0) continue;
                  int d_kv = A.get(k).get(v);   
                  if(d_kv<0) continue;



                  int shortest_UV = Math.min(d_uk+d_kv,d_uv);
                  A.get(u).set(v,shortest_UV);

               }


       return A;
    }


    
}