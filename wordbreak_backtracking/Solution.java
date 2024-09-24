import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    
    public int wordBreak(String A, ArrayList<String> B) {

        HashSet<String> wordSet = new HashSet<String> ();
        for(String b : B)
        {
            wordSet.add(b);
        }
        int n = A.length();


        boolean [] dp = new boolean[n+1];
        dp[0] =true;

        for(int i =1;i<n+1;i++)
        {
            for(int j=0;j<i;j++)
            {
            
                String needleString = A.substring(j,i);
                boolean itsInThere = wordSet.contains(needleString);
                if(dp[j] && itsInThere)
                {
                    dp[i]= true;
                    break;
                }

            }
        }

 

        return dp[n]?1:0;
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




class Strie 
{
   public  HashMap<Character,Strie> list = new  HashMap<Character,Strie> ();
   public String value;

   public boolean contains(String word)
   {
       
       Strie currenStrie = this;
       char c =  word.charAt(0);
       int n = word.length();
       if( !currenStrie.list.containsKey(c)) return false;

       
       currenStrie= currenStrie.list.get(c);
       for(int i =1;i<n;i++)
     {
        c =  word.charAt(i);
       if( !currenStrie.list.containsKey(c))
       {

           return  currenStrie.value != null;
         //  currenStrie.list.put(c,new Strie());
       }        
       currenStrie= currenStrie.list.get(c);     
     
     }

     return  currenStrie.value != null;

   }

  /*  public boolean contains(String word)
    {
        
        Strie currenStrie = this;
        char c =  word.charAt(0);
        int n = word.length();
        if( !currenStrie.list.containsKey(c)) return false;

        
        currenStrie= currenStrie.list.get(c);
        for(int i =1;i<n;i++)
      {
         c =  word.charAt(i);
        if( !currenStrie.list.containsKey(c))
        {

            return  false ;
          //  currenStrie.list.put(c,new Strie());
        }        
        currenStrie= currenStrie.list.get(c);     
      
      }

      return  currenStrie.value!=null ;

    }*/



   public void insert(String word)
   {
        Strie currenStrie = this;
        char c =  word.charAt(0);
        if( !currenStrie.list.containsKey(c))
        {
            currenStrie.list.put(c,new Strie());
        }
        currenStrie= currenStrie.list.get(c);

        int n = word.length();
      for(int i =1;i<n;i++)
      {
         c =  word.charAt(i);
        if( !currenStrie.list.containsKey(c))
        {
            currenStrie.list.put(c,new Strie());
        }        
        currenStrie= currenStrie.list.get(c);     
      
      }

      currenStrie.value = word;
   }
   
   
}