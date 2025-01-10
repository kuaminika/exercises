package template;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class SolutionWithLog {

        /**
     * 
     * Given a string A, partition A such that every substring of the partition is a palindrome.

        Return the minimum cuts needed for a palindrome partitioning of A.
     */
    LogTool  l = new LogTool();

    
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {       

      HashMap<Integer,ArrayList<Integer>>  graph = makeGraph(B, A);
      HashMap<Integer,Boolean> colorOf = new HashMap<Integer,Boolean>();
      HashSet<Integer> visiteds = new HashSet<Integer>();
      int startingNode = B.get(0).get(0);


      l.logLn("starting with:"+startingNode);
      Queue<Integer> q = new LinkedList<Integer>();
 
      
      for(int node: graph.keySet())
      {

        if(visiteds.contains(node)) continue;

        q.add(node);
        colorOf.put(node, false);

         while (!q.isEmpty())
         {
            int levelSize = q.size();
   
            while(levelSize>0)
            {
               
               l.logLn("levelSize strt:"+levelSize);
               l.indent=" ";
               levelSize--;
               int current = q.poll();
   
               visiteds.add(current);
               boolean currentColor = colorOf.get(current);
               l.logLn("doing node:"+current+" color:"+currentColor);
              ArrayList<Integer> neighors =  graph.get(current);
               l.log("neighbors:");
               l.logArrListLn_int(neighors);
   
   
               for(int i = 0;i<neighors.size();i++)
               {  
                  int neighbor = neighors.get(i);
   
                  l.log("neighbor:"+neighbor);
                  boolean notVisited = !visiteds.contains(neighbor);
                  l.log("- notVisited:"+notVisited);
   
                  boolean notColored = !colorOf.containsKey(neighbor);
                  l.logLn("- notColored:"+notColored);
   
                  if(notColored)
                  {
                     colorOf.put(neighbor,!currentColor);
                     l.logLn("->I just colored it to:"+colorOf.get(neighbor));
                  }
                  else{
   
                     boolean neighborsColor = colorOf.get(neighbor);
                     l.logLn("neighborsColor:"+neighborsColor+ ", currentColor:"+currentColor);
                     if(neighborsColor == currentColor) return 0;//false
                  }
   
                  if(notVisited)
                  {
                 //   colorOf.put(neighbor,!)
                     q.add(neighbor);
                     l.logLn(" just added to the queue");
                  
                   //  continue;
                  }
   
   
   
   
                  
               }
   
               
               l.indent="";
   
            }
   
            
         }

      }
      

      return 1;
    }


    

    HashMap<Integer,ArrayList<Integer>> makeGraph(ArrayList<ArrayList<Integer>> B, int graphSize)
    {
      HashMap<Integer,ArrayList<Integer>>graph = new  HashMap<Integer,ArrayList<Integer>>();
         // for(int i = 0 ; i<= graphSize;i++)
         //     graph.add(new ArrayList<Integer>());
        int n = B.size();
        for(int i =0; i<n;i++)
        {
            int node = B.get(i).get(0);
            int neighbor = B.get(i).get(1);



            if(!graph.containsKey(node))
            {
               graph.put(node,new ArrayList<Integer>());
            }

            if(!graph.containsKey(neighbor))
            {
               graph.put(neighbor,new ArrayList<Integer>());
            }
            


               ArrayList<Integer> destinationListForNode =     graph.get(node);
               destinationListForNode.add(neighbor);       
 

            destinationListForNode = graph.get(neighbor);
            destinationListForNode.add(node);
            

        }


        l.logLn("The graph looks like this:");

        for(int i: graph.keySet())
        {
          l.log(i+"->");
          l.logArrListLn_int(graph.get(i));
        }

        return graph;

    }
     
    
}