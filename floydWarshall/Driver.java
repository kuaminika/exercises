package floyd_warshall;

import java.util.ArrayList;

 

public class Driver
{
    public static void main(String [] args)
    {

 
    LogTool  l = new LogTool();
    SolutionWithLog s = new SolutionWithLog();
    Solution s1 = new Solution();

        ArrayList<ArrayList<Integer>> a = Driver.inputStrForMatrix("[[0,5,-1,10],[-1,0,3,-1],[-1,-1,0,1],[-1,-1,-1,0]]");
        //
        l.log_matrixLn_int_int(a);

       ArrayList<ArrayList<Integer>> r =  s.solve(a);

         l.log_matrixLn_int_int(r);
         a = Driver.inputStrForMatrix("[[0,5,-1,10],[-1,0,3,-1],[-1,-1,0,1],[-1,-1,-1,0]]");
 
         r= s1.solve(a);

         l.log_matrixLn_int_int(r);

 
    
    }
    public static ArrayList<ArrayList<Integer>> inputStrForMatrix(String input)
    {
      input = input.substring(2, input.length() - 2); // Remove the outer "[[ ... ]]"
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

      for (String iterable_element :   input.split("\\],\\[")) {
        
        result.add(  inputInt(iterable_element));
      }

      return result;
    }
    
    public static ArrayList<String> inputStr(String input)
    {
        ArrayList<String> integers = new ArrayList<>();
      for (String iterable_element :   input.split(",")) {
        
        integers.add(  iterable_element);
      }

      return integers;
    }
 
    public static ArrayList<Integer> inputInt(String input)
    {
        ArrayList<Integer> integers = new ArrayList<>();
      for (String iterable_element :   input.split(",")) {
        
        integers.add(   Integer.parseInt(iterable_element));
      }

      return integers;
    }


    public static void print(ArrayList<String> rList)
    {
        System.out.print("[");
        for (String iterable_element : rList) {
            System.out.print(iterable_element+" ");
        }

        System.out.println("]");
    }
    

    public static void logLn(String s)
    {
       
       System.out.println(s);
   }
 
}