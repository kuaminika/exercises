package template;

import java.util.ArrayList;

public class Driver
{
    public static void main(String [] args)
    {

        Solution s = new Solution();
        ArrayList<Integer> a = Driver.inputInt("10,9,2,5,3,7,101,18");
   
        int r =  s.solve(a,0);

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