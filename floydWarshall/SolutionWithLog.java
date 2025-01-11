package floyd_warshall;


import java.util.ArrayList;
import java.util.HashMap;



import java.util.Arrays;

public class SolutionWithLog {

 
    LogTool  l = new LogTool();
    String indent = " ";
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {       
      l.indent =indent;
      l.logLn("start solve");
    //  l.turnOff();

      ArrayList<ArrayList<Integer>> distanceMap = A;//new ArrayList<ArrayList<Integer>>();
      int n = A.size();
       
        for(int k= 0; k<n ; k++)
        {   
            l.indent =indent+indent;
            l.logLn("k:"+k);
       
            for(int i  = 0; i< n ; i ++) 
            {
              
               
               l.indent =indent+indent+indent;
               l.logLn("i:"+i);

               //if(k==i) continue;

               for(int j = 0; j<n; j++)
               {
                l.indent =indent+indent+indent+indent;
                l.logLn("---------");
                l.logLn(String.format("i:%d,j:%d,k:%d",i,j,k));
                  
                  int d_ij = distanceMap.get(i).get(j);
                  d_ij = d_ij <0 ? Integer.MAX_VALUE:d_ij;
                  l.logLn(String.format("distance of [i,j]= [%d,%d]=%d",i,j, d_ij));
                  if(i==j) continue;

                  // l.logLn("should i leavbe because its -1:"+(d_ij<0));
                  
                  // if(d_ij<0 ) continue;
                  int d_ik =   distanceMap.get(i).get(k);

                  l.logLn(String.format("distance of [i,k]= [%d,%d]=%d",i,k, d_ik));


                  int d_kj = distanceMap.get(k).get(j);
                  l.logLn(String.format("distance of [k,j]= [%d,%d]=%d",k,j, d_kj));

                  l.logLn("should i leavbe because its -1:"+((d_ik<0)|| (d_kj<0)));
                  
                  if((d_ik<0)|| (d_kj<0)) continue;




                  int shortest_IJ = Math.min(d_ij,d_ik+d_kj);
                  l.logLn("in the end shortest_IJ:"+shortest_IJ);
                  distanceMap.get(i).set(j, shortest_IJ);
               }
            }
            l.logLn("with k="+k+" it ends like this:");
            l.log_matrixLn_int_int(distanceMap);
            
          }
        
      

      return  distanceMap;
    }



     
    
}