package poisonousgraph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class SolutionWithLog {
 /**
  * 
NOTE> this is a partial solution. its not quite finalized. 

  */
    LogTool  l = new LogTool();
   
    public int solve( ArrayList<ArrayList<Integer>> B,int A) {       

        l.logLn("A:"+A);
        l.log("B:");
        l.log_matrixLn_int_int(B);

        int m = 998244353;

        if(B.isEmpty())
        return (int)powMod(3,A,m);
    

          HashMap<Integer,ArrayList<Integer>>  graph =  makeGraph(B);
         HashMap<Integer, Boolean> colors = new  HashMap<Integer, Boolean> ();
        int [] colorSizes = new int[2];

         boolean currentColor = false;
        // doing BFS

        Queue<Integer> q = new LinkedList<Integer>();
        HashSet<Integer> visiteds = new HashSet<Integer>();
       
        for(int i= 1; i<=A;i++)
        {
            boolean visited = visiteds.contains(i);
            boolean   colored  = colors.containsKey(i);
            if(visited) continue;
            
            if(!colored)
            {
                currentColor=  false;
                colors.put(i,currentColor);
                colorSizes[0]++;
            }

           

            if(!graph.containsKey(i))   continue;             

            q.add(i);
            l.logLn(String.format("%d was added in the q before while", i));

           //doing BFS for real 
           while(!q.isEmpty())
           {
               
               int node = q.poll();
               currentColor = colors.get(node);
               visiteds.add(node);
                l.logLn("doing node:"+node+", color:"+currentColor);
                ArrayList<Integer> neigbors = graph.get(node);
                 l.log(String.format("neighbors of %d:", node));
                 l.logArrListLn_int(neigbors);
                for(int neighbor : neigbors)
                {
                    colored = colors.containsKey(neighbor);
                    l.logLn("neighbor:"+neighbor+" colored:"+ colored);
                    if(colored && currentColor == colors.get(neighbor)) return 0;

                    if(colored && currentColor != colors.get(neighbor) ) continue;
                  
                    boolean newColor =  !currentColor;
                    colors.put(neighbor,newColor);

                    l.logLn(String.format("assigned color:"+newColor+" to neighbor:%d", neighbor));;
                    colorSizes[newColor==false?0:1]++;
                    l.logLnArrr_int(colorSizes);

                    l.logLn("----------");
                }
                 currentColor = !currentColor;
           }
        }


        // calculating the ways
        l.logLnArrr_int(colorSizes);
    
        int n2s = colorSizes[1];

        int sizeOfOddSet = colorSizes[0];
 
       
       int twoExpSizeofOddSet   = (int)  powMod(2,sizeOfOddSet,m);
       int twoExpSizeofEvenSet  = (int)  powMod(2,n2s,m);

       
        l.logLn("sizeOfOddSet:"+sizeOfOddSet);;
        l.logLn("n2s="+ n2s);
        l.logLn("2^n1="+ twoExpSizeofOddSet);
        l.logLn("2^n2="+ twoExpSizeofEvenSet);

        return  (twoExpSizeofOddSet+twoExpSizeofEvenSet);
    }

    public long powMod(int base,int  exponent,int mod)
    {   
        if(base==1) return 1;
        int m = mod;
        long result = 1;
        base = base %m;
        while(exponent>=1)
        {
            result= (result %m * base%m)%m;
            exponent--;
        }


        return result;
    }
    
    HashMap<Integer,ArrayList<Integer>>  makeGraph(  ArrayList<ArrayList<Integer>> edges)
    {
        HashMap<Integer,ArrayList<Integer>>  graph = new  HashMap<Integer,ArrayList<Integer>> ();

        l.log_matrixLn_int_int(edges);

        for(ArrayList<Integer> edge : edges)
        {
            int node = edge.get(0);
            int neighBor = edge.get(1);


            if(!graph.containsKey(node))
            {
                graph.put(node,new ArrayList<Integer>());
            }

            if(!graph.containsKey(neighBor))
            {
                graph.put(neighBor,new ArrayList<Integer>());

            }


            graph.get(node).add(neighBor);
            graph.get(neighBor).add(node);
             
        }

        return graph;
    }


     
    
}