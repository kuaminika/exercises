package MatrixAbsoluteDifference;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class SolutionWithLog {
 
    LogTool  l = new LogTool();
   
      public int solve(int A, int B, ArrayList<ArrayList<Integer>> C) {

        l.log_matrixLn_int_int(C);;
        int minimumK= 1;
        int maximumK = minimumK;



        for(int i =0 ; i<A; i++)
        {
            for(int j=0 ; j< B; j++)
            {
                int v =   C.get(i).get(j);

                minimumK = Math.min(minimumK,v);
                maximumK = Math.max(maximumK,v);
            }
        }


            int mid = minimumK +(maximumK - minimumK)/2;
            int candidate = mid;

        while(minimumK<=maximumK)
        {
            l.logLn("----");
            mid = minimumK +(maximumK - minimumK)/2;
            
            l.logLn(String.format("min:%d,max:%d, mid:%d ",minimumK,maximumK,mid));
            int k = mid;

            boolean itSucceeded = doBFS(C,A,B,k);            


            if(itSucceeded) // k might be too high
            {
                maximumK = mid-1;
                candidate = mid;
                 l.logLn(String.format("-->min:%d,max:%d ",minimumK,maximumK));
                continue;
            }


            minimumK = mid+1; 


            l.logLn(String.format("-->min:%d,max:%d ",minimumK,maximumK));

        }

        return candidate;

    }


     boolean doBFS( ArrayList<ArrayList<Integer>> C ,int n,int m, int k)
     {
        String indentToken =  "     ";
        l.indent= indentToken;
        l.logLn("starting BFS with k:"+k);

        Queue<Node> q = new LinkedList<Node>();
        int i = 0;
        int j = 0;
        int v = C.get(i).get(j);
        Node startingNode = new Node (i, j,v );
        boolean[][] visiteds = new boolean[n][m];
        
        q.add(startingNode);

       visiteds[i][j] = true;

        l.turnOff();
        while(!q.isEmpty())
        {

            l.logLn("--"+q);

            l.indent= indentToken+indentToken;
            Node node = q.poll();
            l.logLn("doing node:"+node);
            ArrayList<Node> neighbors =  node.getNeighbors(n,m,C);

            

            for(Node neighbor: neighbors)
            {
                l.logLn("with neighbor:"+neighbor);
                if(  visiteds[neighbor.i][neighbor.j]) continue;

                int abs = Math.abs(neighbor.v- node.v);
                l.logLn("abs:"+abs);
                if(abs>k) continue;
                l.logLn("neighbor:"+neighbor+" will be added in q");
                visiteds[neighbor.i][neighbor.j] = true;
                q.add(neighbor);             
            }     
            
            
            l.indent= indentToken;
        }
        l.turnOn();
        l.logLn(String.format("with k=%d, we have this:", k));

        l.logLnArrr_2D_boolean(visiteds);

        for(boolean[] attendanceRow: visiteds)
        {
            for(boolean visited: attendanceRow)
            {
                if(!visited) return false;
            }
        }

        l.indent= "";
        return true;
     }


     class Node
     {
         int i; 
         int j; 
         int v;  
         public Node(int i, int j, int v)
         {
             this.i = i;
             this.j = j;
             this.v = v; 
         }

         public String toString()
         {
            return String.format("[%d,%d]=%d", i,j,v);
         }

         ArrayList<Node> getNeighbors(int n, int m, ArrayList<ArrayList<Integer>> grid )
         {
             int[] di= {+1,-1,0, 0 };
             int[] dj = {0,0, +1,-1};

              ArrayList<Node>  result = new  ArrayList<Node> ();

            for(int i =0; i<4;i++)
            {
                int newI = this.i+di[i];
                int newJ = this.j +dj[i];


                boolean newCoordinatesAreValid = newI<n && newI>=0 && newJ<m && newJ >=0;

                if(!newCoordinatesAreValid) continue;

                int val = grid.get(newI).get(newJ);
                l.logLn(String.format("adding neighbor %d",val));
                result.add(new Node(newI, newJ,val));
            }

            return result;
         }
     }




     
    
}