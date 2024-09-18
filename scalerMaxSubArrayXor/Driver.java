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

        //37,24,17,26,37,10,15,35,7,33
        // integers.add(37);
        // integers.add(24);
        // integers.add(17);
        // integers.add(26);
        // integers.add(37);
        // integers.add(10);
        // integers.add(15);
        // integers.add(35);
        // integers.add(7); 
        // integers.add(33);

        //33 29 18
       // integers.add(33);integers.add(29);integers.add(18);

       //29,13,9,34,32,15,30,9
       //integers= Driver.input("1,2,3,4");//
       integers = Driver.input("29,13,9,34,32,15,30,9");
        
       s.logLn("1-4:"+s.calculateXor(Driver.input("29,13,9,34")));
       s.logLn("5-8:"+s.calculateXor(Driver.input("32,15,30,9")));
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


    public static void print(ArrayList<Integer> rList)
    {
        for (Integer iterable_element : rList) {
            System.out.print(iterable_element+" ");



        }
    }
}
