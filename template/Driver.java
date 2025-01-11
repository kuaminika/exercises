package template;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
        Solution s = new Solution();
        
        ArrayList<Integer> a = Driver.inputInt("1,7,6,2,8,4,4,6,8,2");
        ArrayList<Integer> b = Driver.inputInt("8,11,7,7,10,8,7,5,4,9");
        
        int r =  s.solve(a,0);

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

 
 
 
}