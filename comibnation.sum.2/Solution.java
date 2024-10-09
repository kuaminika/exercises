package combination.sum.two;

import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
 

public class Solution {
    LogTool l = new LogTool();
    public ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, int B) {       
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current = new ArrayList<Integer>();
          doIt(A, 0, matrix, 0, B, current, "");

      return matrix;
    }





    public void doIt(ArrayList<Integer> a, int strt, ArrayList<ArrayList<Integer>> matrix, int sum, int k, ArrayList<Integer> current ,String indent)
    {
        Collections.sort(a);

        l.indent = indent;
        int kMinusSum = k- sum;
        l.logLn("starting at k="+k+" k-sum ="+kMinusSum);

        if(kMinusSum == 0)
        {
            l.logLn("will add the following in the matrix");
            l.printIntLIst(current);


            matrix.add(new ArrayList<Integer>(current));
            return;
        }

        int n = a.size();


        for(int i = strt; i<n; i++)
        {
            int newElement = a.get(i);
        
            int newSum = newElement+ sum;
            l.logLn("at i="+i+" a[i]="+newElement+", newSum="+newSum+", k="+k);
            if(i>strt  && newElement == a.get(i-1))
            {
                l.logLn("will continue because this is a repeated element");
                continue;
            }

            if(newSum<= k)
            {
                l.logLn("newsum<=k so we will dig in deeper");
                current.add(newElement);
                int indexItSat = current.size()-1;
                doIt(a, i+1, matrix, newSum, k, current, indent+" ");
                l.logLn("did the digging deeper, this is the current before");
                l.printIntLIst(current);
                current.remove(indexItSat);
                l.logLn("removed current["+indexItSat+"]");
                l.printIntLIst(current);
            }
            l.logLn("loop ends for i="+i);
        }

    }
}


class LogTool {
    private boolean on;


    String indent = "";
    
    public LogTool()
    {
        on = true;
    }
    public void turnOn()
    {
        this.on = true;
    }

    public void turnOff()
    {
        this.on = false;
    }

    public   void printIntLIst(ArrayList<Integer> rList)
    {
        System.out.print(indent+"[");
        for (Integer iterable_element : rList) {
            System.out.print(iterable_element+" ");
        }

        System.out.println("]");
    }
    

    public void log(String str)
    {
        if(!on) return;
        System.out.print(indent+str);
    }


    public void logLn(String str)
    {
        if(!on) return;
        System.out.println(indent+str);
    }


}