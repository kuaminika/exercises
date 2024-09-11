package scalerMaxSubArrayXor;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {


        ArrayList<Integer> ans = new ArrayList<Integer>();

        ArrayList<Integer> prefix = getPrefixXor(A);
        Node dummy = new Node();
        int n = prefix.size();
        int max= 0;
        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 0;i<n;i++  )
        {   
           int prefixXorOfI = prefix.get(i);
           Node maxXorPair = searchBestCandidat(prefixXorOfI,dummy);

          
           insert(prefixXorOfI,i,dummy);
           int currentXor = prefixXorOfI ^ maxXorPair.value;

           if(currentXor<max) continue;

           if( max == currentXor)
           {
              
               int newDiff = Math.abs(maxXorPair.index-i);
               int currentDiff = Math.abs(minIndex-maxIndex);
              
              
               if(currentDiff<newDiff) continue;
           }

           max = currentXor;

           minIndex = Math.min( maxXorPair.index+1,i);
           maxIndex = Math.max( maxXorPair.index+1,i);   
        }


         ans.add(minIndex+1);
         ans.add(maxIndex+1);
        return ans;
    }

  

    private void insert(int a, int index , Node root)
    {
        Node n = root;
        int bitCountInInt= 31; 
        for(int i = bitCountInInt ; i>0;i--)
        {
             int bit = (a>>i) & 1;
             if(bit== 0 )
             {
                 if(n.zero == null)
                    n.zero  = new Node();
                 n = n.zero;
                 continue;
             }

            if(n.one == null)
               n.one = new Node();
             n = n.one;

        }

        n.value = a;
        n.index = index;

       
        
    }

    private void logLn(String s)
    {
        
        System.out.println(s);
    }
    private void log(String s)
    {
        
      //  System.out.print(s);
    }

    private Node searchBestCandidat(int a ,Node root)
    {
       
        Node n = root;
        int bitCountInInt= 31; 
        for(int i = bitCountInInt ; i>0;i--)
        {
            int bit = (a>>i) & 1;

            boolean itsTheEnd = (n.one == null && n.zero == null);

            if(itsTheEnd) return n;// n.value;

            if(  n.one !=null   &&  n.zero != null )
            {
               
                n = bit== 0 ?n.one:n.zero;
                continue;
            }

            // were compromising
            if( n.one !=null   )// implies that zero is null
            {
               
                n = n.one;
                continue;
            }
         
          
            // implies that one is null
            n = n.zero;
           

        
        }
        
       
        return n;// n.value;

    }

    private ArrayList<Integer> getPrefixXor(ArrayList<Integer>A)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();

        Integer prefix = 0;

        for(Integer i: A)
        {
            prefix = prefix ^ i ;
            result.add(prefix);
        }
        return result;
    }




}





 class Node {

    public Node one;
    public Node zero;
    public  int value;
    public int index; 

    public String toString()
    {
        return "["+index+"]="+value;
    }

    

}
