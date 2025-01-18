package minimumWeighedCycle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class SolutionWithLog {
 
    LogTool  l = new LogTool();
   
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

     //   l.turnOff();
        HashMap<Integer,ArrayList<DPair>> graph = makeGraph(B);


        int minimumCycle = Integer.MAX_VALUE;
        for(ArrayList<Integer> edge : B)
        {
            int n1 = edge.get(0);
            int n2 = edge.get(1); 
            int w = edge.get(2);

     

            l.log("graph before removal");
            l.log_matrixLn_int_T(graph);
            graph.get(n1).removeIf(i->i.v==n2);
            graph.get(n2).removeIf(i->i.v==n1);

            l.log("graph after removal");
            l.log_matrixLn_int_T(graph);
            // do the djikstra
            l.logLn(String.format("removed edge [%d,%d]", n1,n2));
            int pathLength = doDjikstra(n1,n2,graph);

            if(pathLength != Integer.MAX_VALUE)
                minimumCycle = Math.min(pathLength+w,minimumCycle );
                        
            graph.get(n1).add( new DPair(n2, w));
            graph.get(n2).add( new DPair(n1, w));
        }


        return minimumCycle;
        
    }

    class DPair {
         int v ; int w;
        public DPair(int v, int w)
        {   
            this.v = v;
            this.w = w;

        }

        public String toString()
        {
            return String.format("( d[%d]=%d)", v,w);
        }
    }
    int doDjikstra( int source, int destination, HashMap<Integer,ArrayList<DPair>> graph  )
    {

        int n = graph.size();
        int [] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

       
        PriorityQueue<DPair> q = new PriorityQueue<DPair>(Comparator.comparingInt(p->p.w));

        q.add(new DPair(source,0));

        l.logLn("added node:"+q.peek());

        while(!q.isEmpty()  )
        {
            
            DPair node = q.poll();



            l.logLn("doing node:"+node);
            //get the neighbors
            l.log("neighbors are");
            ArrayList<DPair> neighbors = graph.get(node.v);
            l.logArrListLn(neighbors);
            for(DPair neighbor: neighbors)
            { 
               
                int newDistance = Math.min(dist[node.v]+ neighbor.w, dist[neighbor.v] );
                l.logLn(String.format("New distance for neightor "+ neighbor+" is %d",newDistance));
                if(!(newDistance< dist[neighbor.v]) ) continue;

                dist[neighbor.v]  = newDistance; 

                q.add(neighbor);
            }
        }


        return dist[destination];

    }



    HashMap<Integer,ArrayList<DPair>> makeGraph(ArrayList<ArrayList<Integer>> edges)
    {
        HashMap<Integer,ArrayList<DPair>> graph = new  HashMap<Integer,ArrayList<DPair>>();

        for(ArrayList<Integer> edge : edges)
        {
            int n1 = edge.get(0);
            int n2 = edge.get(1);
            int w = edge.get(2);
            graph.putIfAbsent(n1, new ArrayList<DPair>());
            graph.putIfAbsent(n2, new ArrayList<DPair>());

            graph.get(n1).add(new DPair(n2,w));
            graph.get(n2).add(new DPair(n1,w));
        }
        return graph;
        
    }


     
    
}