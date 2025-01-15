package distanceNearestCell;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
      SolutionWithLog s = new SolutionWithLog();
      Solution s1 = new Solution();
        //[[1,1,0,1,1,0],[1,1,1,0,0,0]]
        ArrayList<ArrayList<Integer>> a = Driver.inputStrForMatrix("[[1,1,0,1,1,0],[1,1,1,0,0,0]]");
 
        ArrayList<ArrayList<Integer>> r =  s.solve(a);

        l.log_matrixLn_int_int(r);
        a = Driver.inputStrForMatrix("[[1,1,0,1,1,0],[1,1,1,0,0,0]]");
 
      r =  s1.solve(a);

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

 
 
 
}