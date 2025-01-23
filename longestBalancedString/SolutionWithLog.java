package longestBalanacedString;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Arrays;

public class SolutionWithLog {
 
    LogTool  l = new LogTool();
   
    public int solve( String A ) {       

        
     
        Stack<Integer> s = new Stack<Integer>();

   

        HashMap<Character,Character> matches = new  HashMap<Character,Character> ();

        matches.put('[',']');
        matches.put('(',')');
        matches.put('{','}');
        
        HashSet<Character> closings = new HashSet<Character>();
        HashSet<Character> openings = new HashSet<Character>();

        openings.add('[');
        openings.add('{');
        openings.add('(');

        closings.add(']');
        closings.add(')');
        closings.add('}'); 

        s.push(-1);
        int maxStrLen = 0;
        int n = A.length();
        for(int i = 0;i<n;i++)
        {
            l.log("i = "+ i +" ");
            char currentChar =  A.charAt(i);
            l.logLn(currentChar+"");
            int indexAtTop = s.peek();
        
       //     log(String.format("i=%d, currentChar:%c, maxStrLen= %d",i,currentChar,maxStrLen));

            if( openings.contains(currentChar))
            {
                l.logLn("pushed opening:"+i);
                s.push(i);
                continue;
            }
            
            if(indexAtTop<0)
            {
                l.logLn("pushed closing:"+i);
                s.push(i);
                continue;
            }

            char charAtTop =  A.charAt(indexAtTop);
            if(matches.containsKey(charAtTop)  &&  currentChar == matches.get(charAtTop))
            {
                int currentIndex = i;
                s.pop();
                
                int indexAtClosing = s.peek();
                int subStrLen  = currentIndex - indexAtClosing;
                maxStrLen = Math.max(maxStrLen,subStrLen);
                continue;
            }
        
           //     log("pushed closing:"+i);
           s.push(i);
           l.logLn("pushed closing:"+i);

        }

        return maxStrLen;
    
    }




     
    
}