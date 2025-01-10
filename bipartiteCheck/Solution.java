package template;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class Solution {

   public int solve(int A, ArrayList<ArrayList<Integer>> B) {

      HashMap<Integer,ArrayList<Integer>> graph = makeGraph(B,A);

      

      // doing BFS


      Queue<Integer> q = new LinkedList<Integer>();
      
      HashMap<Integer,Boolean> colorOf = new HashMap<Integer,Boolean>();
      HashSet<Integer> visiteds = new HashSet<Integer>();

  //    int initialNode = B.get(0).get(0);
    
     
     for(int node : graph.keySet())
     {
         if(visiteds.contains(node)) continue;


           q.add(node);
          colorOf.put(node,false);


            while(!q.isEmpty())
             {
                 int levelSize = q.size();

                 while(levelSize>0)
                 {
                     levelSize --;
                     int currentNode = q.poll();

                     visiteds.add(currentNode);
                     boolean currentColor = colorOf.get(currentNode);

                     ArrayList<Integer> neighbours = graph.get(currentNode);

                     for(int i =0 ; i<neighbours.size(); i++)
                     {
                         int neighbour = neighbours.get(i);


                         boolean colored  = colorOf.containsKey(neighbour);
                         boolean visited = visiteds.contains(neighbour);


                         if(!visited) 
                         {
                             q.add(neighbour);
                         }

                         if(!colored)
                         {
                             colorOf.put(neighbour,!currentColor);
                         }
                         else if(  colorOf.get(neighbour) == currentColor)
                         {
                             return 0;
                         }
                         



                     }
                 }

             }

             }
   



         return 1;
 }


  HashMap<Integer,ArrayList<Integer>>  makeGraph( ArrayList<ArrayList<Integer>> B, int nodeCount)
  {
       HashMap<Integer,ArrayList<Integer>> graph = new   HashMap<Integer,ArrayList<Integer>> ();
     /*  for(int i =0; i<nodeCount;i++)
       {
           graph.add(new ArrayList<Integer>());
       }*/

       for(int i= 0; i<B.size();i++)
       {
          int node =   B.get(i).get(0);
          int neighbour =   B.get(i).get(1);

          if(!graph.containsKey(node))
          {
              graph.put(node,new ArrayList<Integer>());
          }

          if(!graph.containsKey(neighbour))
          {
              graph.put(neighbour,new ArrayList<Integer>());
          }
          ArrayList<Integer> neighbours = graph.get(node);
          ArrayList<Integer> nNeighbours = graph.get(neighbour);

          nNeighbours.add(node);
          neighbours.add(neighbour);

       }

       return graph;
  }


    
}