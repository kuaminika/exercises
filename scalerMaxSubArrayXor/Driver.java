package scalerMaxSubArrayXor;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        Solution s = new Solution();

        ArrayList<Integer> integers = new ArrayList<>();
/*
        integers.add(1);
        integers.add(4);
        integers.add(3);
*/

    //    integers = Driver.input("29,13,9,34,32,15,30,9");
        integers = Driver.input("22,4,5,21,22");
        print( s.getPrefixXor(integers));
        logLn("");
     //  s.logLn("1-4:"+s.calculateXor(Driver.input("29,13,9,34")));
     //  s.logLn("5-8:"+s.calculateXor(Driver.input("32,15,30,9")));
     //  print(s.getPrefixXor(integers));
        print(s.solve(integers));
    }
    

    @SuppressWarnings("rawtypes")
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
        for (Integer iterable_element : rList) {
            System.out.print(iterable_element+" ");



        }
    }
}
