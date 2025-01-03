package template;

import java.util.ArrayList;

public class Driver
{
    public static void main(String [] args)
    {

        Solution s = new Solution(); 
        
        int r =  s.solve(9);

        log(r+"");
    
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
   private static void log(String s)
   {
       
       System.out.print(s);
   }
}