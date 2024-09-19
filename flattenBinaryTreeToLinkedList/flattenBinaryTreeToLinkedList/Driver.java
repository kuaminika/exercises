

package flattenBinaryTreeToLinkedList;
import java.util.List;
import java.util.ArrayList;
public class Driver {

    public static void main(String[] args) {
        Solution s = new Solution();

        ArrayList<Integer> integers = new ArrayList<>();
/*
        integers.add(1);
        integers.add(4);
        integers.add(3);
*/

    //    integers = Driver.input("29,13,9,34,32,15,30,9");
        integers = Driver.input("1,2,3");
        TreeNode t = inputForTree(integers);
        logLn(t.toString());
     
    }
    

    @SuppressWarnings("rawtypes")
    public static ArrayList input(String input)
    {
        ArrayList<Integer> integers = new ArrayList<>();
      for (String iterable_element :   input.split(",")) {
        
        integers.add(   Integer.parseInt(iterable_element));
      }

      return integers;
    }


    

    public static TreeNode inputForTree(ArrayList<Integer> inOrderList)
    {
        if(inOrderList.size()==0) return  null;
        int middleIndex = inOrderList.size()/2;
        logLn("the list size is:"+inOrderList.size()+" middleIndex is:"+middleIndex);
        TreeNode t = new TreeNode(inOrderList.get(middleIndex).intValue());
        
        if(middleIndex>0)
          { 
            
             List<Integer> subLeft = inOrderList.subList(0, middleIndex);
      
              t.left = inputForTree(new ArrayList<>(subLeft));
          }
        if(middleIndex+1 < inOrderList.size())
         {
            logLn("doing right");
            List<Integer> subRight = inOrderList.subList(middleIndex+1, inOrderList.size());
            print(new ArrayList<>(subRight));
            t.right = inputForTree(new ArrayList<>(subRight));
         }


         return t;

    }

    public static void logLn(String s)
     {
        
        System.out.println(s);
    }
    private static void log(String s)
    {
        
        System.out.print(s);
    }
    public static void print(ArrayList<Integer> rList)
    {

        if(rList.size() ==0)    System.out.println(" empty ");
        for (Integer iterable_element : rList) {
            System.out.print(iterable_element+" ");



        }
    }
}