package palindromePartitioning;

import java.util.ArrayList;

public class Driver
{
    public static void main(String [] args)
    {

      SolutionWithLog u = new SolutionWithLog();
        //Driver.inputInt("1,3,2,3,3");//
        //Driver.inputInt("5,6,1,3,9");//
        ArrayList<Integer> a = Driver.inputInt("1,7,6,2,8,4,4,6,8,2");
        ArrayList<Integer> b = Driver.inputInt("8,11,7,7,10,8,7,5,4,9");
        
        int r =u.solve("bbab");
        //s.solve("JRUSmwWta7kjBpRv04yhmwjLUfkffkaJsy1tL0rKDvmKZsgrA6HTq6Jv6r9oPXuxJYuzyqq56LT0WW6Lp5hABCS5O499WgDst");
        // s.solve("bbab"); // s.solve("ababaa");

        logLn(r+"<-- with  log");
       // r =  s.solve("ababb");

       Solution s2 = new Solution();

      r= s2.solve("bbab");
      logLn(r+"<-- without log");
//JRUSmwWta7kjBpRv04yhmwjLUfkffkaJsy1tL0rKDvmKZsgrA6HTq6Jv6r9oPXuxJYuzyqq56LT0WW6Lp5hABCS5O499WgDst
        //dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg
        
       // r =  s.solve("dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg");

    
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