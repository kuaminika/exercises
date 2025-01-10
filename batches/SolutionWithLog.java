package batches;


import java.lang.Integer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class SolutionWithLog {

        /**
     * 
     * Given a string A, partition A such that every substring of the partition is a palindrome.

        Return the minimum cuts needed for a palindrome partitioning of A.
     */
    LogTool  l = new LogTool();
    public int solve(int A, ArrayList<Integer> B, ArrayList<ArrayList<Integer>> C, int D) {       

         
      HashMap<Integer,ArrayList<Integer>> map = makeGraph(C,A);
      HashSet<Integer> visiteds = new HashSet<Integer>();


      int passCount = 0;

      l.logLn("checking for single-node batches");
      for(int i=0;i<A;i++)
      {
         int singleNodeBatch = i+1;
         //making sure its a single-ndoe batch
         if(map.containsKey(singleNodeBatch)) continue;// its not a singleNodeBAtch
         int batchScore= B.get(i);
         l.log("single-node batch:"+(i+1));

         boolean itPassed = batchScore>=D;
         l.logLn("batchScore:"+batchScore+",benchmark:"+D + ". it passed:"+itPassed);
         if(itPassed )   passCount++;
      }


      for(int node : map.keySet())
      {
         boolean nodeIsVisited = visiteds.contains(node);

         l.logLn("considering batch with node:"+node);
         l.logLn("node visited:"+nodeIsVisited);
         if(nodeIsVisited) continue;
         int batchScore =     makeDFS(node,map,visiteds,B,0," ");
         boolean itPassed = batchScore>=D;
         l.logLn("batchScore:"+batchScore+",benchmark:"+D + ". it passed:"+itPassed);
         if(itPassed) passCount++;
         l.logLn("itPassed:"+itPassed+" count:"+passCount);
          
      }


      return passCount;
    }
  
    int makeDFS(int node,HashMap<Integer,ArrayList<Integer>> map,HashSet<Integer>  visiteds,ArrayList<Integer> scores,int batchScore, String tabs)
 
    {
      l.logLn("");
      l.logLn("visiting node:"+node);
      String previousIndent = l.indent;
      l.indent+= tabs;
      int score  = scores.get(node-1);

      l.log(String.format("The batchScore is:%d",batchScore));

       l.log(String.format(" -> the score is: %d the new batchSocre = %d+%d =", score,batchScore,score));
      
      batchScore += score;
      l.log(""+batchScore);

      visiteds.add(node);


      ArrayList<Integer> neighbors = map.get(node);


         for(int neighbor: neighbors)
         {
            boolean nodeIsVisited = visiteds.contains(neighbor);

            if(nodeIsVisited) continue;

            batchScore =     makeDFS(neighbor,map,visiteds,scores,batchScore," ");

         }

         
       l.logLn("done visiting node:"+node);
       l.indent= previousIndent;

       return batchScore;

    }
    


    
    HashMap<Integer,ArrayList<Integer>> makeGraph(ArrayList<ArrayList<Integer>> edges, int nodeCount)
    {
      HashMap<Integer,ArrayList<Integer>>  graph = new HashMap<Integer,ArrayList<Integer>> ();

      int n = edges.size();
      for(int i = 0;i<n ; i++){

         ArrayList<Integer> edge = edges.get(i);

         int node1 = edge.get(0);
         int node2 = edge.get(1);

         if(!graph.containsKey(node1))
         {
            graph.put(node1,new ArrayList<Integer>());
         }

         if(!graph.containsKey(node2))
         {
            graph.put(node2,new ArrayList<Integer>());
         }

          graph.get(node1).add(node2);
          graph.get(node2).add(node1);
      }


      return graph;



    }

     
    
}