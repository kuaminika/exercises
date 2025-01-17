package poisonousgraph;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
        SolutionWithLog s = new SolutionWithLog();
        
        ArrayList<ArrayList<Integer>> a = Driver.inputStrForMatrix("[[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]");//// Driver.inputInt("1,7,6,2,8,4,4,6,8,2");
 
        
        int r =  s.solve(a,4);

        l.logLn(r+"");

        l.logLn("====================================================");
        a = Driver.inputStrForMatrix("[[2,3],[3,1]]");

        r = s.solve(a, 3);
        l.logLn(r+"");


        //[[1,2],[2,3]] -- 23333

        l.logLn("====================================================");
        a = Driver.inputStrForMatrix("[[1,2],[2,3]]");

        r = s.solve(a, 23333);
        l.logLn(r+"");
    
    }


    public static ArrayList<ArrayList<Integer>> inputStrForMatrix(String input)
    {
      input = input.substring(2, input.length() - 2); // Remove the outer "[[ ... ]]"
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

      for (String iterable_element :   input.split("\\],\\[")) {
        
        if(iterable_element.length()==0)
        {
        // result.add(new ArrayList<Integer>());
          continue;

        }
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