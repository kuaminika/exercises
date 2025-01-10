package template;

import java.util.ArrayList;

public class Driver
{
    public static void main(String [] args)
    {

      SolutionWithLog s = new SolutionWithLog();
        //Driver.inputInt("1,3,2,3,3");//
        //Driver.inputInt("5,6,1,3,9");//
        ArrayList<ArrayList<Integer>> B = new  ArrayList<ArrayList<Integer>>();
     //   ArrayList<Integer> b = Driver.inputInt("8,11,7,7,10,8,7,5,4,9");
        //[[],[],[],[],[],[],[],[],[4,8]]

    /*    B.add( Driver.inputInt("7,8"));
        B.add( Driver.inputInt("1,2"));
        B.add( Driver.inputInt("0,9"));
        B.add( Driver.inputInt("1,3"));
        B.add( Driver.inputInt("6,7"));
        B.add( Driver.inputInt("0,3"));
        B.add( Driver.inputInt("2,5"));
        B.add( Driver.inputInt("3,8"));
        B.add( Driver.inputInt("4,8"));
        int r =  s.solve(10,B);

        log(r+"\n\n\n----------------"); 
        B = new  ArrayList<ArrayList<Integer>>();
        B.add( Driver.inputInt("0,1"));
        B.add( Driver.inputInt("0,2"));
        B.add( Driver.inputInt("1,2"));
          r =  s.solve(10,B);*/
//[[5,6],[1,3],[2,4],[4,5]]

ArrayList<ArrayList<Integer>>  toD =    inputStrForMatrix("[[5,6],[1,3],[2,4],[4,5]]");
//inputStrForMatrix("[[11,68],[4,76],[29,78],[14,59],[2,92],[17,81],[16,48],[20,93],[71,93],[74,78],[19,67],[11,48],[19,71],[0,87],[39,75],[32,72],[52,89],[1,95],[61,77],[34,94],[48,66],[9,39],[21,30],[1,68],[15,76],[22,88],[64,94],[43,51],[22,29],[10,76],[59,78],[25,28],[92,94],[11,52],[28,78],[27,90],[30,71],[15,30],[14,78],[35,68],[32,91],[10,46],[60,79],[11,58],[0,16]]");
    LogTool l = new LogTool();

    int r  = s.solve(96,toD);
     /*   B = new  ArrayList<ArrayList<Integer>>();
      B.add( Driver.inputInt("5,6"));
      B.add( Driver.inputInt("1,3"));
      B.add( Driver.inputInt("2,4"));
      B.add( Driver.inputInt("4,5"));
   int     r =  s.solve(8,B);

*/
        log(r+"");
    }


    public static ArrayList<ArrayList<Integer>> inputStrForMatrix(String input)
    {
      input = input.substring(2, input.length() - 2); // Remove the outer "[[ ... ]]"
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

      for (String iterable_element :   input.split("\\],\\[")) {
        
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