package sheldonPairOfCities;

import java.util.ArrayList;

public class Driver{
  
    public static void main(String [] args)
    {

      
      LogTool l = new LogTool();
      SolutionWithLog s = new SolutionWithLog();
        
        int a = 4;
        int b = 6;
        int c = 2;
        ArrayList<Integer> d = Driver.inputInt("1,2,3,2,4,3");
        ArrayList<Integer> e = Driver.inputInt("2,3,4,4,1,1");
        ArrayList<Integer> f = Driver.inputInt("4,1,1,1,1,1");
        ArrayList<Integer> g = Driver.inputInt("1,1");
        ArrayList<Integer> h = Driver.inputInt("2,3");
     
        ArrayList<Integer> r =  s.solve(a,b,c,d,e,f,g,h);

        l.logArrListLn_int(r);


         
        a = 15;
        b = 18;
        c = 29;
        d = Driver.inputInt("11,2,2,6,2,8,9,3,14,15,4,14,8,7,8,6,2,12");
        e = Driver.inputInt("2,1,1,2,1,1,7,3,2,13,2,1,6,1,7,1,2,10");
        f = Driver.inputInt("8337,6651,29,7765,3428,5213,6431,2864,3137,4024,8169,5013,7375,3786,4326,6415,8982,6864");
        g = Driver.inputInt("6,2,1,15,12,2,14,10,13,15,15,4,8,7,9,4,15,13,12,5,2,10,1,11,14,7,3,13,12");
        h = Driver.inputInt("5,2,15,13,6,2,8,6,3,13,15,3,1,1,4,4,5,8,1,3,1,10,15,9,2,1,1,10,2");
        
        r =  s.solve(a,b,c,d,e,f,g,h);

        l.logArrListLn_int(r);

        
      Solution  s1 = new Solution();
      r =  s1.solve(a,b,c,d,e,f,g,h);

      l.logArrListLn_int(r);

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