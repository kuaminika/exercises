 

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
public class Solution {
    LogTool l = new LogTool();
    public int solve(ArrayList<Integer> A, int B) {
        int n  = A.size();
   
        ArrayList<Integer> prefixOf = new ArrayList<Integer> ();


        prefixOf.add(A.get(0));

        for(int i = 1;i<n;i++)
        {
          int next =    prefixOf.get(i-1)+A.get(i);
          prefixOf.add(next);
        }


        int countOf = getDiferencePairsOF(prefixOf, B);
     

      return countOf;
    } 



    int getDiferencePairsOF(ArrayList<Integer> arr,int k )
    {

        HashMap<Integer,Integer> frequencyOf = new HashMap<Integer,Integer>();

        frequencyOf.put(0,1);
        int count = 0;

        int n =arr.size();


        // we're looking for the pair a & b such that b-a = k
         for(int i = 0; i< n ; i++)
        {
            int b = arr.get(i);

            int a = b- k;

            if(frequencyOf.containsKey(a))
            {
                int frequencyOfA = frequencyOf.get(a);
                count += frequencyOfA;
            }

            // adding frequencyOf b

           int frequencyOfB = (frequencyOf.containsKey(b))? frequencyOf.get(b):0;

           frequencyOf.put(b,frequencyOfB+1);            
        }

        return count;
    }
    public int  countOfDifferencePairsInDistinct(ArrayList<Integer> A,int k)
    {
        Collections.sort(A);
        l.printInt(A);;
        int n = A.size();
        int j = 1;
        int i = 0;
        int diff = 0;
        int count = 0;
        while(j<n)
        {
            int a = A.get(i);
            int b = A.get(j);
            diff = b -a;
            l.logLn("diff:"+diff+"  A[ "+i+"]= "+a+" A["+j+"]="+b+"");
            if(diff< k)
            {
                j++;
                continue;
            }

            if(diff>k)
            {
                i++;
                continue;
            }

            count++;
            j++;            
        }

        return count;
    }



}


class LogTool 
{
    private boolean on;


    String indent = "";
    
    public LogTool()
    {
        on = true;
    }
    public   void printInt(ArrayList<Integer> rList)
    {
        System.out.print("[");
        for (Integer iterable_element : rList) {
            System.out.print(iterable_element+" ");
        }

        System.out.println("]");
    }
    public void turnOn()
    {
        this.on = true;
    }

    public void turnOff()
    {
        this.on = false;
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