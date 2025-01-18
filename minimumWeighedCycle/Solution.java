package minimumWeighedCycle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {

   
    public int solve(int A, ArrayList<ArrayList<Integer>> B)  {       

      //  l.turnOff();
        HashMap<Integer,ArrayList<DPair>> graph = makeGraph(B);


        int minimumWeighedCycle = Integer.MAX_VALUE;
        for(ArrayList<Integer> edge: B)
        {
            DPair source = new DPair(edge.get(0), edge.get(2));
            DPair destination = new DPair(edge.get(1), edge.get(2));
            // remove the edge

            graph.get(source.d).removeIf(i->i.d == destination.d);
            graph.get(destination.d).removeIf(i->i.d == source.d);


            int pathLength = doDjikstra(source, destination, graph);
            
            
            if(pathLength != Integer.MAX_VALUE)
                minimumWeighedCycle= Math.min ( minimumWeighedCycle, pathLength+source.w);

            // put the edge back 
            graph.get(source.d).add(destination);
            graph.get(destination.d).add(source);

        }

        
       return minimumWeighedCycle;
    }


    int doDjikstra(DPair source,DPair destination, HashMap<Integer,ArrayList<DPair>>  graph)
    {
        
        int [] dist = new int[graph.size()+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        
        PriorityQueue<DPair> q = new PriorityQueue<DPair>(Comparator.comparingInt(i->i.w));
      
        dist[source.d] = 0;
      
        q.add(new DPair(source.d, 0));
        while(!q.isEmpty())
        {
            DPair node = q.poll();

            //get the neighbors
            ArrayList<DPair> neighbors = graph.get(node.d);

            for(DPair neighbor : neighbors)
            {
                int newD = Math.min(dist[node.d]+neighbor.w, dist[neighbor.d]);

                if(!(newD < dist[neighbor.d])) continue;

              
                dist[neighbor.d] = newD;

                q.add(neighbor);
            }

        }

        return dist[destination.d];
    }


    class DPair{
        int d; 
        int w ; 
        public DPair(int d, int w)
        {
            this.d = d;
            this.w = w;
        }

        public String toString()
        {
            return String.format("( d[%d]=%d)", d,w);
        }
    }

    

    HashMap<Integer,ArrayList<DPair>> makeGraph(ArrayList<ArrayList<Integer>> edges)
    {
        HashMap<Integer,ArrayList<DPair>>  graph = new HashMap<Integer,ArrayList<DPair>> ();

        for(ArrayList<Integer> edge: edges)
        {
           int n1 =  edge.get(0);
           int n2 =  edge.get(1);
           int w = edge.get(2);


           graph.putIfAbsent(n1, new ArrayList<DPair>());
           graph.putIfAbsent(n2, new ArrayList<DPair>());

           graph.get(n1).add(new DPair(n2, w));
           graph.get(n2).add(new DPair(n1, w));
        }

        return graph;
    }



}