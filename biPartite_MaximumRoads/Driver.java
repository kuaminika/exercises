package biPartite_MaximumRoads ;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
      SolutionWithLog s = new SolutionWithLog();
      Solution s2 = new Solution();
        
    int cityCOunt = 2;
    String rawInput = "[[2,1]]";
      ArrayList<ArrayList<Integer>> network = Driver.inputStrForMatrix(rawInput);

        int r =  s.solve(cityCOunt,network);

        l.logLn(r+"");


      l.logLn("--------------------------------------------------------------------------");

      rawInput = "[[1,3],[1,4],[3,2],[3,5]]";
      network = Driver.inputStrForMatrix(rawInput);
      cityCOunt = 5;
      r =  s.solve(cityCOunt,network);

        l.logLn(r+"");


        l.logLn("--------------------------------------------------------------------------");
        l.logLn("trying it without log: -");
        l.logLn("--------------------------------------------------------------------------");


        
      rawInput = "[[1,3],[1,4],[3,2],[3,5]]";
      network = Driver.inputStrForMatrix(rawInput);
      cityCOunt = 5;
      r =  s2.solve(cityCOunt,network);

        l.logLn(r+"");


    
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

 
    public static ArrayList<ArrayList<Integer>> inputStrForMatrix(String input)
    {
      input = input.substring(2, input.length() - 2); // Remove the outer "[[ ... ]]"
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

      for (String iterable_element :   input.split("\\],\\[")) {
        
        result.add(  inputInt(iterable_element));
      }

      return result;
    }
 
}