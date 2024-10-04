import java.util.ArrayList;

public class Driver
{
    public static void main(String [] args)
    {

        Solution s = new Solution();
        //Driver.inputInt("1,3,2,3,3");//
        //Driver.inputInt("5,6,1,3,9");//
        ArrayList<Integer> a = Driver.inputInt("1,7,6,2,8,4,4,6,8,2");
        ArrayList<Integer> b = Driver.inputInt("8,11,7,7,10,8,7,5,4,9");
        
        int r =  s.solve(a, b);

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