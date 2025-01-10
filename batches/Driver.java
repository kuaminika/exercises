package batches;

import java.util.ArrayList;

public class Driver
{
    public static void main(String [] args)
    {

      SolutionWithLog s = new SolutionWithLog();
      
      Solution s1 = new Solution();
        // A = 5
        // B = [1, 2, 3, 4, 5]
        // C = [  [1, 5]
        //        [2, 3]  ]
        // D = 6
        ArrayList<Integer> a = Driver.inputInt("1,7,6,2,8,4,4,6,8,2");
        ArrayList<Integer> b = Driver.inputInt("8,11,7,7,10,8,7,5,4,9");

        int studentCount ;
        ArrayList<Integer> scores ;
        ArrayList<ArrayList<Integer>> relations;
        int passingBatchScore ;

        int r;

        studentCount = 5;
        scores = Driver.inputInt("1,2,3,4,5");
        relations = Driver.inputStrForMatrix("[[1,5],[2,3]]");
        passingBatchScore = 6;



         r =  s.solve(studentCount, scores, relations, passingBatchScore);

        logLn(r+"");
        
        r = s1.solve(studentCount, scores, relations, passingBatchScore);
        logLn(r+"<-- without log");



        
        studentCount = 5;
        scores = Driver.inputInt("2,3,10,8,4");
        relations = Driver.inputStrForMatrix("[[1,3],[1,4],[1,5],[2,3],[4,5]]");
        passingBatchScore = 34;



         r =  s.solve(studentCount, scores, relations, passingBatchScore);

         logLn(r+"");

        

        r = s1.solve(studentCount, scores, relations, passingBatchScore);
        
        logLn(r+"<-- without log");


        
        
        studentCount = 14;
        scores = Driver.inputInt("7,5,7,3,9,4,4,6,3,1,4,8,7,6");
        relations = Driver.inputStrForMatrix("[[1,2],[2,6],[2,7],[4,13],[5,8],[5,13],[6,12],[7,10],[10,14],[13,14]]");
        passingBatchScore = 2;



         r =  s.solve(studentCount, scores, relations, passingBatchScore);

         logLn(r+"");

        

         r = s1.solve(studentCount, scores, relations, passingBatchScore);
        
        logLn(r+"<-- without log");



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


    public static ArrayList<ArrayList<Integer>> inputStrForMatrix(String input)
    {
      input = input.substring(2, input.length() - 2); // Remove the outer "[[ ... ]]"
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

      for (String iterable_element :   input.split("\\],\\[")) {
        
        result.add(  inputInt(iterable_element));
      }

      return result;
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