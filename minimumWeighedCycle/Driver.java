package minimumWeighedCycle;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
      SolutionWithLog s = new SolutionWithLog();
      Solution s1 = new Solution();      
  

        ArrayList<ArrayList<Integer>> edges = Driver.inputStrForMatrix("[[1,2,2],[2,3,3],[3,4,1],[4,1,4],[1,3,15]]");
        int r =  s.solve(4,edges);
        r = s1.solve(4,edges);
       l.logLn(r+" WL");
       r = s1.solve(4,edges);
       l.logLn(r+" NL");

      l.logLn("--------------------------------------------------------------------------------------------------------");
      l.logLn("--------------------------------------------------------------------------------------------------------");
        edges = Driver.inputStrForMatrix("[[1,2,3],[1,3,3],[2,3,3],[4,5,4],[4,6,3],[5,6,1]]");
        r = s.solve(8, edges);
        l.logLn(r+" WL");
        r = s1.solve(8,edges);
        l.logLn(r+" NL");


        
      l.logLn("--------------------------------------------------------------------------------------------------------");
      l.logLn("--------------------------------------------------------------------------------------------------------");
        edges = Driver.inputStrForMatrix("[[1,2,1],[1,5,2],[5,4,3],[4,3,1],[3,2,5],[2,5,8],[5,3,6]]");
        r = s.solve(5, edges);
        l.logLn(r+" WL");
        r = s1.solve(5,edges);
        l.logLn(r+" NL");



        

        
      l.logLn("--------------------------------------------------------------------------------------------------------");
      l.logLn("--------------------------------------------------------------------------------------------------------");
        edges = Driver.inputStrForMatrix("[[1,2,5],[1,3,6],[1,1,4]]");
        r = s.solve(2, edges);
        l.logLn(r+" WL");
        r = s1.solve(2,edges);
        l.logLn(r+" NL");
    
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