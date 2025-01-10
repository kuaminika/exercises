package  batches;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
 
  
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D){       

      HashMap<Integer,ArrayList<Integer>> graph = makeGraph(C, A);
      HashSet<Integer> visiteds = new HashSet<Integer>();
   
      int amountThatPassed = 0;
 
      for(int i=0;i<A;i++)
      { 
         int singleNodeBatch = i+1;
         //making sure its a single-ndoe batch
         if(graph.containsKey(singleNodeBatch)) continue;// its not a singleNodeBAtch
         int batchScore= B.get(i);

         boolean itPassed = batchScore>=D;
       
         if(itPassed )   amountThatPassed++;
      }





      for(int node : graph.keySet())
      {
         if(visiteds.contains(node)) continue;// its visited already so we dont care

         int batchScore = getBatchScoreDFSly(node,graph,visiteds,0,B);
      
         if( batchScore>=D)
          amountThatPassed++;
         //    amountThatPassed = batchScore>=D? (amountThatPassed+1):amountThatPassed;

         
      }
        
       return amountThatPassed;
    }

    int getBatchScoreDFSly(int node, HashMap<Integer,ArrayList<Integer>> graph,HashSet<Integer> visited,int batchScore,ArrayList<Integer> scores)
    {
    

         int score = scores.get(node-1);
         batchScore += score;
         visited.add(node);
         ArrayList<Integer> neighbors = graph.get(node);
 
         for(int neighbor: neighbors)
         {
            if(visited.contains(neighbor)) continue;

            batchScore =  getBatchScoreDFSly(neighbor,graph,visited,batchScore,scores);
         }

         return batchScore;

    }

    HashMap<Integer,ArrayList<Integer>> makeGraph(ArrayList<ArrayList<Integer>> edges,int nodeCount)
    {
      HashMap<Integer,ArrayList<Integer>>  graph = new HashMap<Integer,ArrayList<Integer>> ();
      int n = edges.size();
         for(int i =0;i<n;i++)
         {  

            
           int node =   edges.get(i).get(0);
          int neighbor = edges.get(i).get(1);

            if(!graph.containsKey(node))
            {
               graph.put(node, new ArrayList<Integer>());
            }
            if(!graph.containsKey(neighbor))
            {
               graph.put(neighbor, new ArrayList<Integer>());
            }
            
            graph.get(node).add(neighbor);
            graph.get(neighbor).add(node);


         }


         return graph;
    }
    
}