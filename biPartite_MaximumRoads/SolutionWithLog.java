package biPartite_MaximumRoads ;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class SolutionWithLog {
 
    LogTool  l = new LogTool();
   
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {       

        l.logLn("city count:"+A);
        l.logLn("edges:");
        l.log_matrixLn_int_int(B);

        HashMap<Integer,ArrayList<Integer>> graph = makeGraph(B);

        double m = Math.pow(10,9)+7;

        l.logLn("network:");
        l.log_matrixLn_int_int(graph);
        // doing the BFS
   //     HashSet<Integer> visited = new HashSet<Integer>();
        HashMap<Boolean,HashSet<Integer>> colors = new HashMap<Boolean,HashSet<Integer>>();
        colors.put(true, new HashSet<Integer>());
        colors.put(false, new HashSet<Integer>());


        boolean initialColor = false;
 

        for(int node =1 ; node<=A; node++)
        {
            boolean itsVisited = colors.get(false).contains(node) || colors.get(true).contains(node);
            if(itsVisited) continue;

           if( graph.get(node).size() ==0 )
           {
                colors.get(initialColor).add(node);
                continue;
           }
           doBFS(graph,node,colors,initialColor);
        //    while()



        }

        int trues = colors.get(true).size();
        int falses = colors.get(false).size();
        int edgeCount = B.size();
        double maximumCompleteBiPartiteEdges = (trues%m*falses%m)%m;

        l.logLn(String.format(" trues:%d, falses:%d, edges:%d",trues,falses,edgeCount));
        l.logLn("maximum edge Count in complete bi partite:"+maximumCompleteBiPartiteEdges);

        l.logLn("the difference should be:"+ (maximumCompleteBiPartiteEdges - edgeCount));
        
        int mx =(int) maximumCompleteBiPartiteEdges ;
        return mx- edgeCount;
    }


    void doBFS( HashMap<Integer,ArrayList<Integer>> graph,int node, HashMap<Boolean,HashSet<Integer>> colors  ,boolean initialColor)
    {
          Queue<Integer> q = new LinkedList<Integer>();


          q.add(node);
            colors.get(initialColor).add(node);



          while(!q.isEmpty())
          {
              node = q.poll();
              boolean currentColor = colors.get(false).contains(node)? false :true;


                
            ArrayList<Integer> neighbours = graph.get(node);

            for(int ne : neighbours)
            {
                // check if they the sameColor 
                if(colors.get(currentColor).contains(ne))
                {
                    l.logLn(String.format("there is a contractiction for %d and %d",node,ne));
                }


               if( colors.get(!currentColor).contains(ne) ) continue;// its been visited

               colors.get(!currentColor).add(ne);

               q.add(ne);

            }




          }



    }


    HashMap<Integer,ArrayList<Integer>> makeGraph(ArrayList<ArrayList<Integer>> edges)
    {
        HashMap<Integer,ArrayList<Integer>>  graph = new     HashMap<Integer,ArrayList<Integer>> ();

            for(int i  = 0; i<edges.size();i++)
            {

                int node = edges.get(i).get(0);
                int neighBor = edges.get(i).get(1);


              if(! graph.containsKey(node))
              {
                graph.put(node, new ArrayList<Integer>());
              }


              if(! graph.containsKey(neighBor))
              {
                graph.put(neighBor, new ArrayList<Integer>());
              }


              graph.get(node).add(neighBor);

              graph.get(neighBor).add(node);

            }


            return graph;
    }
     
    
}