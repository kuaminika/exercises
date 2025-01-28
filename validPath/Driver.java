package validPath;

import java.util.ArrayList;

import validPath.LogTool;
import validPath.Solution;
import validPath.SolutionWithLog;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
        SolutionWithLog s = new SolutionWithLog();
        //int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F
        int A = 0;
        int B = 91;
        int C = 3;
        int D = 5;

        ArrayList<Integer> E = Driver.inputInt("0,0,0");
        ArrayList<Integer> F = Driver.inputInt("21,20,43");
        
        String r =  s.solve(A, B, C, D, E, F);

        l.logLn(r+"");



         A = 41;
         B = 67;
         C = 5;
         D = 0;

         E = Driver.inputInt("17,16,12,0,40");
         F = Driver.inputInt("52,61,61,25,31");
        
        r =  s.solve(A, B, C, D, E, F);

        l.logLn(r+"");



        
        A = 13;
        B = 14;
        C = 10;
        D = 6;

        E = Driver.inputInt("7,7,6,13,13,0,6,7,8,4");
        F = Driver.inputInt("9,14,4,2,0,10,3,3,13,12");
       
       r =  s.solve(A, B, C, D, E, F);

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