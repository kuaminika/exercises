package MatrixAbsoluteDifference;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
      SolutionWithLog s = new SolutionWithLog();
        //[[10,9,6],[4,2,8],[5,7,5],[9,5,9],[9,3,3],[9,6,10]]
        ArrayList<ArrayList<Integer>> a = Driver.inputStrForMatrix("[[10,9,6],[4,2,8],[5,7,5],[9,5,9],[9,3,3],[9,6,10]]");
       
        
        int r =  s.solve(6,3,a);
//[[4,2,5,5],[2,6,1,1],[1,3,5,8],[7,1,1,3],[3,6,6,9],[4,3,7,6],[5,3,9,9],[1,2,8,9]]
        l.logLn(r+"");

        a = Driver.inputStrForMatrix("[[4,2,5,5],[2,6,1,1],[1,3,5,8],[7,1,1,3],[3,6,6,9],[4,3,7,6],[5,3,9,9],[1,2,8,9]]");

        r =  s.solve(8,4,a);
//[[4,2,5,5],[2,6,1,1],[1,3,5,8],[7,1,1,3],[3,6,6,9],[4,3,7,6],[5,3,9,9],[1,2,8,9]]
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