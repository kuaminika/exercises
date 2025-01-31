package removeElement;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
        SolutionWithLog s = new SolutionWithLog();
        int[] nums = Driver.getArrayFromInput("0,1,2,2,3,0,4,2");
        // l.logLnArrr_int(nums);
        

        s.l.turnOff();
        int r =  s.solve(nums,2);
        nums = Driver.getArrayFromInput("3,2,2,3");


       
        s.l.turnOff();

        r =  s.solve(nums,3);
        l.logLn(r+"");


        s.l.turnOn();
        nums = Driver.getArrayFromInput("4,2,0,2,2,1,4,4,1,4,3,2");

        r =  s.solve(nums,4);
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


    public static int[] getArrayFromInput(String input)
    { 
      String [] inputStr = input.split(",");
      int n = inputStr.length;
       int[] result = new int[n];

      for(int i = 0;i<n; i++)
      {
         result[i]  = Integer.parseInt(inputStr[i]);
      }

      return result;

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