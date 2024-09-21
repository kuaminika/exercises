package powerSet_bitManipulation;

import java.util.ArrayList;

public class Solution {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        int n = A.size();
        int subArrayCount =(int) Math.pow(2, n)  ;


        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();


        for(int num = 0; num < subArrayCount; num++)
        {

            ArrayList<Integer> subArray = new ArrayList<Integer>();
            for(int i = 0; i< n ; i++)
            {
                logLn("num:"+num);
                boolean theIthElementIsInThere = ((num>>i)&1) == 1;
                logLn("the ith bit is :"+i+" is it in there:"+theIthElementIsInThere);
                if(!theIthElementIsInThere) continue;

                Integer c = A.get(i);
                
                logLn("-- > the ith bit is :"+i+" its in there so we add "+c+" to the subset");
                subArray.add(c);              

            }
            logLn("");


            result.add(subArray);



        }



        return result;
    }
    

     public void logLn(String s)
    {
        
        System.out.println(s);
    }
    private void log(String s)
    {
        
        System.out.print(s);
    }
}
