package distanceNearestCell;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Solution {

   
    public ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A) {

        int n = A.size();

        int m = A.get(0).size();

        Queue<SCell> q = new LinkedList<SCell>();

        int currentLocationRadius = 0;

        for(int i = 0; i <n;i++)
            for(int j = 0; j<m;j++)
            {
                if( A.get(i).get(j) != 1) 
                {
                    A.get(i).set(j,Integer.MAX_VALUE);
                    continue;
                }

                SCell cell = new SCell(i,j ,A);

                A.get(i).set(j,currentLocationRadius); 
                q.add(cell) ;
            
            }
            


            while(!q.isEmpty())
            {

                int levelSize = q.size();
                currentLocationRadius++;
                while(levelSize>0)
                {

                    SCell  cell = q.poll();
                    levelSize--;
                 
                   for(SCell ne : cell.getNeighbors())
                    {
                     
                    int cellValue = A.get(ne.i).get(ne.j); 
                    if( cellValue< currentLocationRadius) continue;


                    A.get(ne.i).set(ne.j,currentLocationRadius);
                    q.add(ne); 

                    }
                }

            }   

        return A;
    }



    class SCell{

        public int i;
        public int j;

        ArrayList<ArrayList<Integer>>  map; 
        
        public SCell(int i, int j, ArrayList<ArrayList<Integer>> map)
        {
            this.map = map;
            this.i = i;
            this.j = j;
        }


       

        ArrayList<SCell> getNeighbors()
        {
            ArrayList<SCell>  result = new ArrayList<SCell>();
            
            // getting the top neighbor

            int n = map.size();
            int m = map.get(0).size();

            int [][] directions = {{-1,0},{1,0},{0,-1},{0,1}};


            for(int[] direction : directions)
            {
                int newI = i+direction[0];
                int newJ = j+direction[1];
      
                if(newJ>= m || newJ<0 || newI>=n|| newI<0) continue;

                result.add(new SCell(newI,newJ,map));
            }
            
            return result;

        // 

        }


        public String toString()
        {
            return String.format("[i=%d,j=%d]", i,j);
        }
        

    }


    
}