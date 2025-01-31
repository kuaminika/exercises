package mergeSortedArray;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
      SolutionWithLog s = new SolutionWithLog();
      s.deactivateLog();
        
        ArrayList<Integer> a1 = Driver.inputInt("1,2,3,0,0,0");
        ArrayList<Integer> b2 = Driver.inputInt("2,5,6");
        int []a =  a1.stream().mapToInt(Integer::intValue).toArray();
        int []b =  b2.stream().mapToInt(Integer::intValue).toArray();
        int m = 3;
        int n = 3;
         s.solve(a,m,b,n);

       l.logLnArrr_int(a);
    
      //  s.activateLog();
       a1 = Driver.inputInt("2,0");
       b2 = Driver.inputInt("1");
        a =  a1.stream().mapToInt(Integer::intValue).toArray();
        b =  b2.stream().mapToInt(Integer::intValue).toArray();
        m = 1;
        n = 1;
        s.solve(a,m,b,n);

      l.logLnArrr_int(a);

    // s.activateLog();


      a1 = Driver.inputInt("4,5,6,0,0,0");
      b2 = Driver.inputInt("1,2,3");
       a =  a1.stream().mapToInt(Integer::intValue).toArray();
       b =  b2.stream().mapToInt(Integer::intValue).toArray();
       m = 3;
       n = 3;
       s.solve(a,m,b,n);

     l.logLnArrr_int(a);
     s.activateLog();


     a1 = Driver.inputInt("4,0,0,0,0,0");
     b2 = Driver.inputInt("1,2,3,5,6");
      a =  a1.stream().mapToInt(Integer::intValue).toArray();
      b =  b2.stream().mapToInt(Integer::intValue).toArray();
      m = 1;
      n = 5;
      s.solve(a,m,b,n);

    l.logLnArrr_int(a);


    s.deactivateLog();


    a1 = Driver.inputInt("1,2,4,5,6,0");
    b2 = Driver.inputInt("3");
     a =  a1.stream().mapToInt(Integer::intValue).toArray();
     b =  b2.stream().mapToInt(Integer::intValue).toArray();
     m = 5;
     n = 1;
     s.solve(a,m,b,n);

   l.logLnArrr_int(a);
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
 
    public static ArrayList<Integer> inputInt(String input)
    {
        ArrayList<Integer> integers = new ArrayList<>();
      for (String iterable_element :   input.split(",")) {
        
        integers.add(   Integer.parseInt(iterable_element));
      }

      return integers;
    }

 
 
 
}