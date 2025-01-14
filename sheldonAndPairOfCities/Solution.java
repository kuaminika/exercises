package sheldonPairOfCities;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Solution {

    LogTool  l = new LogTool();
   
    public ArrayList<Integer> solve(int A, int B, int C, ArrayList<Integer> D, ArrayList<Integer> E, ArrayList<Integer> F, ArrayList<Integer> G, ArrayList<Integer> H) {
    
    
        int edgeCount = B;
        int queryCount = C;
        // prepare for floyd_warshallMatrix
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        int n = A+1;
        for(int i = 0; i< n; i++)
        {
            a.add(new ArrayList<Integer>());
            for(int j = 0;j<n;j++ )
            {
                a.get(i).add(Integer.MAX_VALUE);            
            }
        } 

        for (int i = 1; i <= A; i++) {
            a.get(i).set(i, 0);
        }

        ArrayList<Integer> is= D;
        ArrayList<Integer> js= E;
        ArrayList<Integer> ws= F;



        for(int i= 0; i<edgeCount;i++)
        {
           int u  = is.get(i);
           int v = js.get(i);
           int w = ws.get(i);

           a.get(u).set(v,Math.min(a.get(u).get(v), w));
           a.get(v).set(u,Math.min(a.get(v).get(u), w));

        }

        ArrayList<ArrayList<Integer>>  grid =   floyd_warshallMatrix(a);
 
        ArrayList<Integer> shortestPaths = new ArrayList<Integer>();
        
        is = G;
        js = H;
        for(int i= 0; i<queryCount;i++)
        {
           int u  = is.get(i);
           int v = js.get(i); 
        int w =  grid.get(u).get(v); 
            w = w== Integer.MAX_VALUE?-1:w;
            shortestPaths.add(w);
        }


       return shortestPaths;
    
    
    }

    public ArrayList<ArrayList<Integer>> floyd_warshallMatrix(ArrayList<ArrayList<Integer>> A) {

        int n = A.size();
        
         for(int k = 0; k < n;k++)
            for(int i = 0;i<n;i++)
               for(int j = 0;j<n;j++)
               {
                  int u =i;
                  int v = j;                 
                  int d_uv = A.get(u).get(v);
           
                  int d_uk = A.get(u).get(k);
                  if(d_uk== Integer.MAX_VALUE) continue;
                  int d_kv = A.get(k).get(v);   
                  if(d_kv== Integer.MAX_VALUE) continue;



                  int shortest_UV = Math.min(d_uk+d_kv,d_uv);
                  A.get(u).set(v,shortest_UV);
                  A.get(v).set(u,shortest_UV);

               }


       return A;
    }
    
}