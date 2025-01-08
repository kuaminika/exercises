package palindromeSubstringCount;

import java.util.ArrayList;

import javax.naming.ldap.SortKey;

public class Driver
{
    public static void main(String [] args)
    {
      String str ="yyy";//"yyyyyy";

      SolutionWithLog s = new SolutionWithLog();
       
        //bbeaadcc
        int r =  s.solve(str);
        Solution s1 = new Solution();

        

        logLn(r+"");
        r = s1.solve(str);
        logLn(r+"");
    
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