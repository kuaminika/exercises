package template;

import java.util.ArrayList;
import java.util.HashMap;
 

public class Solution {
    LogTool l = new LogTool();
    public int solve(  int k) {       
        int r = k;
        int count =0;
        while(r>0)
        {
            int maxCoin = 1;

            while((maxCoin*5)<=r) maxCoin = maxCoin*5;
        
            l.logLn("maxCoin="+maxCoin);
            if( maxCoin == r)
           { count ++;
             break;
            }

            r = r- maxCoin;
            l.logLn("r="+r);
            count++;
        }

      return count;
    }
}


class LogTool {
    private boolean on;


    String indent = "";
    
    public LogTool()
    {
        on = true;
    }
    public void turnOn()
    {
        this.on = true;
    }

    public void turnOff()
    {
        this.on = false;
    }



    public void log(String str)
    {
        if(!on) return;
        System.out.print(indent+str);
    }


    public void logLn(String str)
    {
        if(!on) return;
        System.out.println(indent+str);
    }


}