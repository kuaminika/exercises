package cowsAndSnacks;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Arrays;

public class SolutionWithLog {
 
    LogTool  l = new LogTool();
   
    public int solve( int A, ArrayList<ArrayList<Integer>> B) {       

        l.logLn("m = "+B.size());





        int [] dsu_sizes   = new int [A+1];
        Arrays.fill(dsu_sizes,1);

        int [] dsu_parents = new int[A+1];
        for(int i = 0;i<A+1;i++)
        {
            dsu_parents[i]=i;
        }


        int sadPeopleCount = 0;
        for(ArrayList<Integer> twoFavorites : B)
        {

           int choice1 =  twoFavorites.get(0);
           int choice2 =  twoFavorites.get(1);
           boolean theySad =  dsu_union(choice1,choice2 , dsu_parents, dsu_sizes);

           if(!theySad) continue;

           sadPeopleCount++;
        }


        return sadPeopleCount;
    }




    int dsu_find(int x, int [] parentOf)
    {
        int parentX = parentOf[x];
        if(parentX == x) return x;        

        return dsu_find(parentX, parentOf);
    }

    boolean dsu_union(int x, int y, int [] parentOf, int []sizeOf)
    {
        int parentX = dsu_find(x, parentOf);
        int parentY = dsu_find(y, parentOf);
      //  l.logLn(String.format("(%d,%d) =>parentX:%d ,parentY:%d ", x,y,parentX,parentY));
        if(parentX == parentY ) return true;

        if(sizeOf[parentX]>sizeOf[parentY])
        { 
             parentOf[parentY] = parentX;
            sizeOf[parentX]++;
            return false;
        }


        parentOf[parentX] = parentY;
        sizeOf[parentY]++;
        return false;
    }   


     
    
}