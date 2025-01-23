package longestBalanacedString;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
        SolutionWithLog s = new SolutionWithLog();
        
  
        int r =  s.solve("{])]}([]]()()){[([[)[}]{({))}]({(]}][)(]]]}[]{[)(]{)[[]{([]]][}[]{]]][}{]{}([){}[[([");

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