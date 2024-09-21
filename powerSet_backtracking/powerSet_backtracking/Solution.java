package powerSet_backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    /**
     * 
     * Given a set of distinct integers A, return all possible subsets.

        NOTE:

        Elements in a subset must be in non-descending order.
        The solution set must not contain duplicate subsets.
        Also, the subsets should be sorted in ascending ( lexicographic ) order.
        The initial list is not necessarily sorted. 
     */

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A)
    {
        int n = A.size();
       Collections.sort(A);


        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentSubSet = new ArrayList<Integer>();

        doBackTrack(0,n,A,powerSet,currentSubSet);

        

        return powerSet;
    }
    

    public ArrayList<Integer> copyOf(ArrayList<Integer> specimen)
    {
        ArrayList<Integer> copy = new ArrayList<Integer>(specimen);
        return copy;
    }

    public void doBackTrack(int index,int n,ArrayList<Integer> set,ArrayList<ArrayList<Integer>> powerSet,ArrayList<Integer> currentSubSet)
    {   
        powerSet.add(copyOf(currentSubSet));

        for(int i = index;i <n ;i++)
        {   
            Integer element = set.get(i);
            currentSubSet.add(element);
            doBackTrack(i+1, n, set, powerSet,currentSubSet);
            currentSubSet.remove(currentSubSet.size()-1);
        }
        

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