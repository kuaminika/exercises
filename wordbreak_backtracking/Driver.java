import java.util.ArrayList;

public class Driver
{
    public static void main(String [] args)
    {

        Solution s = new Solution();
        //bbbaabba,bbaba,babbab,ab,abaaa,aaa,bbab,abbb,abbaa,ababbbbbbb,aaaa,ababb
        // String A = "aaaaaaabbbbabaabbbaababaabbbbaaababbabbaabbabbbabaaabbbbbbaababbbabbbabbbabababbabbbaabbbabaabbabbbabbbbabbbabababbbbbbabbbbaaabbbbbbaaaaabaabaabaabbaababbbbaaaaababbabbabbabbbbbababbbabaaaaaababbabaaabbaabbbabbbabbaababababaaabbbbbbbaabbaabaababbabbbbbbbbbababbabbaaabaabaabbabbbbaaaabbbbbbabababbbaabbabaabaaabbbabababaabaabaaabbabbabaaabbbaaaaabbbaabbbababbbbabaaaaaaabaabbbbbbbbbbaaabbabababbbbbaababbbbaabbaaababbabaaaabbaababbaabaabbbabbabbbaabbbaaabaaaabbbbaaabbbabababbaabbbbaabbbabbabbbbbaabaabbaabbbbbaaababaabaabbaaababababbabbabbabbbbabaabaabbababababaabbbabbaaabbbbbbabaaababbbbbaabaabaababaababbabbaabbbbbbaabaababbaaaaabbbbbaaabaabbaaabbabbbbbbaabbbbabbaabbaabbaabbbabbabaabbabbabbabbbabbababbbabaabaaababaaaabbaabbbbabaabbbbaabbaaababbbabaaabbbaabbbbaaaababbabbbaaabaabbbbaabbbaaababbbaaaaaaabaabaababbabbbbaaabbbbbaaaabaababaabaaabababbbbabaaaaaabbbabbbaaaabbbbbaaaaaababbaabaaaabbbbaaababbbbaaaaaaababbaababaaabbbaaabbbababaabaa";
        //  ArrayList<String> B = Driver.input("bbbaabba,bbaba,babbab,ab,abaaa,aaa,bbab,abbb,abbaa,ababbbbbbb,aaaa,ababb");
         String A = "aababaaabaaababbbabbbaabababaaabbaabaabbabbaabbbbbbbabbbbabaaabaabaabbaaaaabbabaababbbabbbbbbaaaabbbaaaaaabaaaaaabbbbbbbabbbbbbbbaaabaaababbbaaaabaaaabaaaabbabbbabaabbabbabaaaabbabaaabbabbabbbabbabbaabbbabaabaabbbbbbbaabababbbbbbababbbaabaabbbabababbbbbaaaababbbabaaabaabbaababbbabbbbbaabbaaaaabbbbbaaaaaaaaaaaabbabbbabbaaabaaaaaabaabababaabaaaabaaabbbbbaaabbaabbababbabbbbaabaabaabaaaabbbaababbaabbbbbabaaababbabbbabbbbbabaababbbbbaabbbbabaabbabbababaaaabbbbabbbaaaabaabbbbaaaaababaaabaabbabaababbabbbababaaababbaabbbaaabaabbbaabbbbbbaaabaabbbbbabaaababaaabbbbbbaaaabababaaabbbbbbaabbaaabbbabaabbabababbabaabbaaabbaaabbaabbbbbababbaabbabbb";
        ArrayList<String> B = Driver.input("baaaaaabba,babbaababb,abb,bababaabab,baaa,ab,ab,bb,abbaaaa,bbababa,bbbbbbab,abbaaabba,aaaabbab,abaaab,babab,aabaaab,aabaabbabb,aa,bb,ab,a,a,bbaaab,aba,ba,bbabbaabab,aaabbbbbb,abbaaaabbb,aabaabbaa,bbba,abbabbba,abbbbabb,bbaaba,abbbbaab,bba,bbbbaabba,ababbabaab,baabba,ababbaabb,bbaab,a,bbba,aaaa,aaabbbabba,bab,baaaabaa,ab,aaabbaab,bab,aa,ababababab,aabbaaaba,abbaaba,bbaabaa");
    //     String A = "myinterviewtrainer";
    //    ArrayList<String>  B = Driver.input("trainer,my,interview");
       //String A = "abc";
     //  ArrayList<String>  B = Driver.input("a,bc,ac");
      logLn(  s.wordBreak(A, B)+" <-- has words");
//print(B);

    }

    
    public static ArrayList<String> input(String input)
    {
        ArrayList<String> integers = new ArrayList<>();
      for (String iterable_element :   input.split(",")) {
        
        integers.add(  iterable_element);
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