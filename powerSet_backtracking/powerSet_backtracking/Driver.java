package powerSet_backtracking;

import java.util.ArrayList;

public class Driver {


    public static void main(String [] args)
    {

        Solution s = new Solution();

        ArrayList<Integer> integers = new ArrayList<>();
        integers = Driver.input("1,2,3");
      //  print(integers);


          ArrayList<ArrayList<Integer>>  powerSet = s.subsets(integers);

        for(ArrayList<Integer> subSet : powerSet)
        {
            print(subSet);
        } 


    }

    public static ArrayList input(String input)
    {
        ArrayList<Integer> integers = new ArrayList<>();
      for (String iterable_element :   input.split(",")) {
        
        integers.add(   Integer.parseInt(iterable_element));
      }

      return integers;
    }


    public static void logLn(String s)
     {
        
        System.out.println(s);
    }
    private static void log(String s)
    {
        
        System.out.print(s);
    }
    public static void print(ArrayList<Integer> rList)
    {
        System.out.print("[");
        for (Integer iterable_element : rList) {
            System.out.print(iterable_element+" ");
        }

        System.out.println("]");
    }
    
    
}