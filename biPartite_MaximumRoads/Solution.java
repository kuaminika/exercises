package biPartite_MaximumRoads ;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

   
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {       

        double m = Math.pow(10,9)+7;
        HashMap<Boolean,HashSet<Integer>> colorMap = new HashMap<Boolean,HashSet<Integer>>();

        colorMap.put(false, new HashSet<Integer>());
        colorMap.put(true, new HashSet<Integer>());

        HashMap<Integer,ArrayList<Integer>> graph = makeGraph(B);
        boolean initialColor = true;

        for(int node = 1; node<= A; node++)
        {
            boolean visited = colorMap.get(false).contains(node) || colorMap.get(true).contains(node);

            if(visited) continue;

            // check and see if its a stray node
            if(!graph.containsKey(node))
            {
                colorMap.get(initialColor).add(node);
                continue;
            }



            doBFS( graph, node, initialColor, colorMap);
        }    
        
        int trues = colorMap.get(true).size();
        int falses = colorMap.get(false).size();
        int edgeCount = B.size();

        double max = (trues%m * falses%m)%m;
        int maxInt = (int)max;


       return maxInt- edgeCount;
    }


    void doBFS( HashMap<Integer,ArrayList<Integer>> graph, int node, boolean initialColor,  HashMap<Boolean,HashSet<Integer>> colorMap) 
    {

            Queue<Integer> q  = new LinkedList<Integer>();

            q.add(node);

            colorMap.get(initialColor).add(node);


            while(!q.isEmpty())
            {
                node = q.poll();

                boolean currentColor = colorMap.get(true).contains(node);

                ArrayList<Integer> neighbors = graph.get(node);

                for(int ne: neighbors)
                {
                    if(colorMap.get(currentColor).contains(ne)) System.out.println("its broken color is off things like that");

                    if(colorMap.get(!currentColor).contains(ne)) continue;

                    colorMap.get(!currentColor).add(ne);


                    q.add(ne);


                }
            }
    }



    HashMap<Integer,ArrayList<Integer>> makeGraph(ArrayList<ArrayList<Integer>> edges)
    {
        HashMap<Integer,ArrayList<Integer>>  graph = new    HashMap<Integer,ArrayList<Integer>> ();

        for(ArrayList<Integer> edge: edges)
        {
            int n = edge.get(0);
            int ne = edge.get(1);


            if(!graph.containsKey(n))
                graph.put(n, new ArrayList<Integer>());


            if(!graph.containsKey(ne))
                graph.put(ne,new ArrayList<Integer>());

            
            graph.get(ne).add(n);
            graph.get(n).add(ne);

        }

        return graph;
        
    }
    
}