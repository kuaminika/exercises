package RecoverBinarySearchTree;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> recoverTree(TreeNode A) {


       
        InversionTrackingStuff tracker = new InversionTrackingStuff();
        doInOrder(A,tracker,"");

        ArrayList<Integer> result = new ArrayList<Integer>();

      
       
        result.add(Math.min(tracker.inv1,tracker.inv2));
        result.add(Math.max(tracker.inv1,tracker.inv2));
        return result;
    }



 
    public void doInOrder(TreeNode A, InversionTrackingStuff tracker,String indent)
    {
   
      
        if(A == null) return;

        
  
        doInOrder(A.left,tracker,indent+" ");
        
        boolean inversionOccurred = tracker.prev != 0 && (tracker.prev> A.val);

        if(inversionOccurred)
        {
            if(tracker.inv1 == 0 )
            {
                tracker.inv1 = tracker.prev;
                tracker.inv2 = A.val;
               
            }
            else
            {
                tracker.inv2 = A.val;
            }
        }

        tracker.prev = A.val;
        doInOrder(A.right, tracker , indent+" ");

    }




}

class InversionTrackingStuff
{
    int prev =0;
    int inv1 = 0;
    int inv2 = 0;
}
