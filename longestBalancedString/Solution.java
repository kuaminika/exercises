package longestBalanacedString;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import java.util.Arrays;

public class Solution {

 public int solve(final String A) {
    
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
            char currentChar =  A.charAt(i);
            int indexAtTop = s.peek();
        

            if( openings.contains(currentChar))
            {
           //     log("pushed opening:"+i);
                s.push(i);
                continue;
            }
            
            if(indexAtTop<0)
            {
                s.push(i);
                continue;
            }

            char charAtTop =  A.charAt(indexAtTop);
          
            if( matches.containsKey(charAtTop)  &&   currentChar == matches.get(charAtTop))
            {
                int currentIndex = i;
                s.pop();
                
                int indexAtClosing = s.peek();
                int subStrLen  = currentIndex - indexAtClosing;
                maxStrLen = Math.max(maxStrLen,subStrLen);
                continue;
            }
        
           s.push(i);

        }

        return maxStrLen;
    
    }



    
}