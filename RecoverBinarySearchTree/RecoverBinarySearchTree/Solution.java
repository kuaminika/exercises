package RecoverBinarySearchTree;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> recoverTree(TreeNode A) {


       
        InversionTrackingStuff tracker = new InversionTrackingStuff();
        doInOrder(A,tracker,"");

        ArrayList<Integer> result = new ArrayList<Integer>();

      
        result.add(tracker.inv1);
        result.add(tracker.inv2);
        return result;
    }



 
    public void doInOrder(TreeNode A, InversionTrackingStuff tracker,String indent)
    {
        //logLn(indent+"prev:"+prev+",inv1:"+inv1+",inv2:"+inv2);
      
        if(A == null) return;

        
        logLn(indent+"doing node:"+A.val+" [prev:"+tracker.prev+",inv1:"+tracker.inv1+",inv2:"+tracker.inv2+"]");

        logLn(indent+"will do left");
        doInOrder(A.left,tracker,indent+" ");
        logLn(indent+"finish do left");

        logLn(indent+"did left node of ("+A.val+") [prev:"+tracker.prev+",inv1:"+tracker.inv1+",inv2:"+tracker.inv2+"]");
        
        boolean inversionOccurred = tracker.prev != 0 && (tracker.prev> A.val);

        logLn(indent+ "inversion occured:"+inversionOccurred);
        if(inversionOccurred)
        {
            if(tracker.inv1 == 0 )
            {
                tracker.inv1 = tracker.prev;
                tracker.inv2 = A.val;
               
            }
            else
            {
               // tracker.inv1 = tracker.inv2;
                tracker.inv2 = A.val;
            }
        }

        tracker.prev = A.val;
        logLn(indent+"will do right");
        doInOrder(A.right, tracker , indent+" ");
        logLn(indent+"finish do right");
    }



    public   void logLn(String s)
    {

       System.out.println(s);
   }
   private   void log(String s)
   {

       System.out.print(s);
   }
}

class InversionTrackingStuff
{
    int prev =0;
    int inv1 = 0;
    int inv2 = 0;
}
